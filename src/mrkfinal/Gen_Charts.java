/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrkfinal;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.Toolkit;
import java.io.File;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author niccher
 */
public class Gen_Charts {
    ResultSet rs=null;
    Connection Conn=null;
    PreparedStatement pst=null;
    Statement smt;
    
    String table_name,std_name;    

    public Gen_Charts() {                
        Conn= (Connection) Recorda.InitDb();
        
        try {
            String sql="SELECT * FROM `tbl_Tests` ORDER BY `Count` DESC LIMIT 1";
            pst= (PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if (rs.next()) {
                table_name=rs.getString("Test");
                System.out.println("Target table is "+table_name);
            }

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e+"\nCurrent Exam Table Error");
            Toolkit.getDefaultToolkit().beep();
            System.out.println("Target error is "+e.getMessage());
        }
    }
    
    public void MakeBar(int std_reg){    
        
        try {
            String sql2="SELECT * FROM "+table_name+" WHERE `Reg_No`='"+std_reg+"' ";
            pst= (PreparedStatement) Conn.prepareStatement(sql2);
            rs=pst.executeQuery();
            if (rs.next()) {
                std_name=rs.getString("Name");
                System.out.println("Target name is "+std_name);
            }
        } catch (Exception e) {
            System.out.println("MakeBar error is "+e.getMessage());
        }
        
        try {
            //String Etha="SELECT `Mathematics`,`English`,`Kiswahili`,`Chemistry`,`Biology`,`Physics`,`Geography`,`CRE`,`History`,`Business`,`Agriculture` FROM "+table_name+" WHERE `Reg_No`='"+std_reg+"' ";
            String Etha="SELECT `Chemistry`,`Biology`,`Physics`,`Geography`,`CRE`,`History`,`Business`,`Agriculture` FROM "+table_name+" WHERE `Reg_No`='"+std_reg+"' ";
            JDBCCategoryDataset jcd=new JDBCCategoryDataset(Recorda.InitDb(),Etha);
            JFreeChart cht=ChartFactory.createBarChart("Performance for "+std_name+" , Reg "+String.valueOf(std_reg), "Subjects","Marks", jcd, PlotOrientation.VERTICAL, true, true, true);
            
            BarRenderer rndr=null;
            
            ChartFrame cf=new ChartFrame("Testing F High School", cht);
            cf.setVisible(true);
            //cf.pack();
            cf.setSize(800, 500);
            
            final CategoryPlot catplot= cht.getCategoryPlot();
            rndr= (BarRenderer)catplot.getRenderer();
            
            DecimalFormat dcfm=new DecimalFormat("##.##");
            
            rndr.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}",dcfm));
            catplot.setRenderer(rndr);
            rndr.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.HALF_ASCENT_CENTER));
            rndr.setItemLabelsVisible(Boolean.TRUE);
            cht.getCategoryPlot().setRenderer(rndr);

            final ChartRenderingInfo cri=new ChartRenderingInfo(new StandardEntityCollection());
            final File chtfile= new File(table_name+"Bar-Std Name.png");
            ChartUtilities.saveChartAsPNG(chtfile, cht, cf.getWidth(), cf.getHeight());
        } catch (Exception e) {
            System.out.println(e+" GraphBarActionPerformed");
        }
    }
    
    public void MakeLine(int std_reg){
        
        try {
            String sql2="SELECT * FROM "+table_name+" WHERE `Reg_No`='"+std_reg+"' ";
            pst= (PreparedStatement) Conn.prepareStatement(sql2);
            rs=pst.executeQuery();
            if (rs.next()) {
                std_name=rs.getString("Name");
                System.out.println("Target name is "+std_name);
            }
        } catch (Exception e) {
            System.out.println("MakeLine error is "+e.getMessage());
        }
        
        try {
            String Etha="SELECT `Mathematics`,`English`,`Kiswahili`,`Chemistry`,`Biology`,`Physics`,`Geography`,`CRE`,`History`,`Business`,`Agriculture` FROM "+table_name+" WHERE `Reg_No`='"+std_reg+"' ";
            JDBCCategoryDataset jcd=new JDBCCategoryDataset(Recorda.InitDb(),Etha);
            JFreeChart cht=ChartFactory.createLineChart("Performance for "+std_name+" , Reg "+String.valueOf(std_reg), "Subjects","Marks", jcd, PlotOrientation.VERTICAL, true, true, true);
            
            BarRenderer rndr=null;
            CategoryPlot catplot =null;
            rndr= new BarRenderer();
            
            ChartFrame cf=new ChartFrame("Testing F High School", cht);
            cf.setVisible(true);
            //cf.pack();
            cf.setSize(800, 500);
            

//            final ChartRenderingInfo cri=new ChartRenderingInfo(new StandardEntityCollection());
//            final File chtfile= new File(table_name+"Line-Std Name.png");
//            ChartUtilities.saveChartAsPNG(chtfile, cht, cf.getWidth(), cf.getHeight());
            
        } catch (Exception e) {
            System.out.println(e+" GraphLineActionPerformed");
        }
    }
    
    public static void main(String[] args) {
        Gen_Charts genc = new Gen_Charts();
        //genc.MakeLine(2);
        genc.MakeBar(2);
    }
}
