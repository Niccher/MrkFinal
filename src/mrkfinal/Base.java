/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrkfinal;

import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
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
public class Base extends javax.swing.JFrame {
    
    public ResultSet rs=null;
    public Connection Conn=null;
    public PreparedStatement pst=null;
    public Statement smt;
    
    String lvv,Mats,Tem,cs;
    String fn,Sn,FmrS,Hob,AsCla,AsDom,Patt,Phot,cLA,dRM,mrt;
    String StdCont,Rsdn,Gnam,Gco,GresCou,AsSr,AsCb,AsCl,tbl;
    String lv,nmm,Fom;        String slSbj,lst,fd,cl,Trrm,ths,Varr,lst2,lst3;
    String fcll, SBJ, Trm, tama, spa;
    int sbjPck,pmp,pmf;
    int chh=0,bioo=0,phys=0,Goeg=0,cree=0,hsty=0,agrc=0,busns=0,mrk;
    int Regg,Kp,Indx,Cnt1,cnt2,Dbrth,Gcon,Rg;
    byte[]Stdimg=null;
    String Mt,En,Kw,Ce,Bl,Ph,Go,Ht,Cr,Al,Bu,TbChs;
    Calendar cc=new GregorianCalendar();
    int ya=cc.get(Calendar.YEAR);
    int mwr=cc.get(Calendar.MONTH)+1;
    int mth,eng,ksw,chm,bio,phy,geo,cre,hist,biz,agr;
    String Tbll, mck,Str,Fm;
    int F1n,F1s,F1e,F1w,F2n,F2s,F2e,F2w,F3n,F3s,F3e,F3w,F4n,F4s,F4e,F4w,Fmm;
    //String tam=null,TY,yer;
    String fg,sg,gi;
    String snmcls,snmstr,snmsbj;
    int hr,lr,hop;
    String cmnt,frgd,sbgd,grd,ClStr,Makk;
    String fromas;
    int jmpmath,jmpeng,jmpkiswa,jmpchem,jmpbio,jmpphy,jmpgeo,jmpcre,jmphist,jmpagr,jmpbus;
    int jmpmathc,jmpengc,jmpkiswac,jmpchemc,jmpbioc,jmpphyc,jmpgeoc,jmpcrec,jmphistc,jmpagrc,jmpbusc;
    String crclas,ctstream,ctsbj,criasc,cridesc;
    int updtstd,Stdupreg;
    String VarUsername;
    
    boolean islogged = false;

    /**
     * Creates new form Base
     */
    public Base() {
        initComponents();
        Conn= Recorda.InitDb();
        this.setIconImage(new ImageIcon(getClass().getResource("/imgs/info.png")).getImage());
        Dimension dim=getToolkit().getScreenSize();
        int jframWidth=this.getSize().width;
        int jframHeight=this.getSize().height;
        int locationX=(dim.width-jframWidth)/2;
        int locationY=(dim.height-jframHeight)/2;
        this.setLocation(locationX, locationY);
        setTitle("Schooled Final");
        //setUndecorated(Boolean.TRUE);
        //setExtendedState(MAXIMIZED_BOTH);
        KillAll();
        Labo(1);
        
        PanLogs.setVisible(true);        
    }
    
    private void KillAll(){
        PanLogs.setVisible(false);
        PanHome.setVisible(false);
        PanStudents.setVisible(false);
        PanReports.setVisible(false);
        PanExams.setVisible(false);
        PanFinance.setVisible(false);
        PanMisc.setVisible(false);
        PanAdmit.setVisible(false);
        PanAdmin.setVisible(false);
        PanTeacher.setVisible(false);
        
        jTabbedPane4.remove(jPanel34);
    }
    
    private void Labo(int ones){
        if(ones==1){
            jLabel14.setVisible(false);
            Homie.setVisible(false);
            Exitt.setVisible(false);
        }else if(ones==2){
            jLabel14.setVisible(true);
            Homie.setVisible(true);
            Exitt.setVisible(true);
        }
    }
       
    private void PopStd(){
        try {
            String sql="SELECT `Name` ,`Surname` ,`Reg_No` ,`KCPE` ,`Birth` ,`Parent` ,`Contact` ,`Residence` ,`Class` FROM  `tbl_Students`";
            pst=(PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while (true) {
                tblAllStudents.setModel(DbUtils.resultSetToTableModel(rs));
                tblAllStd.setModel(DbUtils.resultSetToTableModel(rs));
                break;
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table"+"\nPutta Erro");
            Toolkit.getDefaultToolkit().beep();
        }
        
        try {
            String sql="SELECT `Name` ,`Surname` ,`Reg_No` ,`KCPE` ,`Birth` ,`Parent` ,`Contact` ,`Residence` ,`Class` FROM  `tbl_Students`";
            pst=(PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tblAllStd.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table"+"\nPutta Erro");
            Toolkit.getDefaultToolkit().beep();
        }
        
    }
    
    private void PopReport(){
        try {
            String sql="SELECT Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,History,Business,Agriculture FROM  "+fd+" ";
            pst=(PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            RepoTbl.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table"+"\nPutta Erro");
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private void PopExam(){
        Nm();
        try {
            String sql="SELECT * FROM  "+lst+" ";
            pst=Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tblExamCompare.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            System.out.println(e+" PopExam 1");
            Toolkit.getDefaultToolkit().beep();
        }
        
        try {
            String fch="SELECT * FROM `tbl_Tests` ";
            pst=Conn.prepareStatement(fch);
            rs=pst.executeQuery();
            Ex1Perf.removeAllItems();
            Ex2Perf.removeAllItems();
            while (rs.next()) {
                String exs=rs.getString("Test");
                Ex1Perf.addItem(exs);
                Ex1Perf.setEnabled(Boolean.TRUE);
                Ex2Perf.addItem(exs);
                Ex1Perf.setSelectedItem(lst);
                Ex2Perf.setSelectedItem(lst2);
            }
            
        } catch (Exception e){ 
            System.out.println(e+" PopExam 2");
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private void PopFinace(){
        try {
            String sql="SELECT * FROM  tbl_Fees ";
            pst=Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tblFeeAll.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo PopFinace 1");
            Toolkit.getDefaultToolkit().beep();
        }
        
        try {
            String sql="SELECT Name,Class,Reg_No,Total_Fee,Paid_Fee,Bal_Fee FROM  tbl_Paid ";
            pst=Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tblFeeSearch.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo PopFinace 2");
            Toolkit.getDefaultToolkit().beep();
        }
        
        try {
            String sql="SELECT Name,Class,Reg_No,Total_Fee,Paid_Fee,Bal_Fee FROM  tbl_Paid ";
            pst=Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tblFeeArrears.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo PopFinace 2");
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private void PopTeacher(){
        Nm();
        TeachCurrentExanm.removeAllItems();
        TeachCurrentExanm.addItem( lst);
        TeachCurrentExanm.setSelectedItem(lst);
        
        ExamBay.removeAllItems();
        ExamBay.addItem( lst);
        ExamBay.setSelectedItem(lst);
    }
    
    private void PopAdmin(){
        
        YBx1.removeAllItems();
        Hrange.removeAllItems();
        Lrange.removeAllItems();
        
        for (int i = 2019; i < 2025; i++) {
            String lvv=String.valueOf(i);
            YBx1.addItem(lvv);
        }

        for (int i = 1; i < 100; i++) {
            String lvv=String.valueOf(i);
            Hrange.addItem(lvv);
            Lrange.addItem(lvv);
        }
    }
    
    private void PopFee(){
        try {
            String sql="SELECT * FROM  `tbl_Fees`";
            pst=(PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tblFee.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table"+"\nPutta Erro");
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private void RegNwStd(){
        try {
            String Kret="INSERT INTO `tbl_Students` (`Count`,`Name` ,`Surname` ,`Reg_No` ,`KCPE` ,`Birth` ,`Parent` ,`Contact` ,`Residence` ,`Class` ,`Avatar` ) VALUES (NULL,?,?,?,?,?,?,?,?,?,?)";
            File img=new File(Patt);
            FileInputStream fis=new FileInputStream(img);
            int len=(int)img.length();
            pst=Conn.prepareStatement(Kret);

            pst.setString(1, NwFullName.getText().toString());
            pst.setString(2, NwSurName.getText().toString());
            pst.setInt(3, Integer.parseInt(NwRegNo.getText()));
            pst.setInt(4, Integer.parseInt(NwKCPE.getText()));
            pst.setInt(5, Integer.parseInt(NwBirthYear.getSelectedItem().toString()));
            pst.setString(6, NwGuardian.getText().toString());
            pst.setInt(7, Integer.parseInt(NwContacts.getText()));
            pst.setString(8, NwResidence.getSelectedItem().toString());
            pst.setString(9, NwStdFrm.getSelectedItem().toString());
            pst.setBinaryStream(10,fis, len);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "New Student "+NwFullName.getText().toString()+" Succesfully Inserted");
            
            ClearStd();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex+"\nUnsuccessfull");
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private void CallTeacher(int ones){
        if(ones==1){
            Sett.setVisible(true);
            Senr.setVisible(false);
            Marks.setVisible(false);
        }else if(ones==2){
            Sett.setVisible(false);
            Senr.setVisible(true);
            Marks.setVisible(false);
        }else if(ones==3){
            Sett.setVisible(false);
            Senr.setVisible(false);
            Marks.setVisible(true);
        }
    }
    
    private void PrepNewStd(){
        NwContacts.setColumns(4);
        for (int i = 1995; i < 2010; i++) {
            String lvv=String.valueOf(i);
            NwBirthYear.addItem(lvv);
        }  
    }
    
    private void ClearStd(){
        NwFullName.setText(null);
        NwSurName.setText(null);
        NwRegNo.setText(null);
        NwKCPE.setText(null);
        NwFrmSch.setText(null);
        ImgP.setText(null);
        NwBirthYear.setSelectedItem(null);
        NwGuardian.setText(null);
        NwContacts.setText(null);
        NwResidence.setSelectedItem(null);
        NwStdFrm.setSelectedItem(null);
        
        DpImg.setIcon(null);
    }
    
    private void Hoppa(){
        try {
            String sql="SELECT `Reg_No` FROM `tbl_Students` ORDER BY `Count` DESC LIMIT 1";
            pst= (PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if (rs.next()) {
                hop=rs.getInt("Reg_No")+1;
                NwRegNo.setEnabled(Boolean.FALSE);
                NwRegNo.setText(String.valueOf(hop));
            }
        } catch (Exception e) {
            System.out.println(e+" \n Hoppa Error");
        }
    }
    
    private  void Nm(){
        try {
            String sql="SELECT * FROM `tbl_Tests` ORDER BY `Count` DESC LIMIT 1";
            pst= (PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if (rs.next()) {
                lst=rs.getString("Test");
            }

            String sql2="SELECT * FROM `tbl_Tests` WHERE Count=(SELECT MAX(Count)-1 FROM `tbl_Tests`) ";
            pst= (PreparedStatement) Conn.prepareStatement(sql2);
            rs=pst.executeQuery();
            if (rs.next()) {
                lst2=rs.getString("Test");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nCurrent Exam Table Error");
            Toolkit.getDefaultToolkit().beep();
        }

        eXA.setEnabled(Boolean.FALSE);
        eXA.setText(lst);
    }
    
    private void FinanceSel(String Cla){
        String sql="SELECT * FROM  tbl_Fees WHERE `Class`='"+Cla+"' ";
        try {
            pst=Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tblFeeAll.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table");
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private int FinanceBalance(String form, String reg){
        String cops="SELECT * FROM `tbl_Fees` WHERE `Class`='"+form+"' ";
        int sum=0,paid=0,rem=0;
        try {
            pst=Conn.prepareStatement(cops);
            rs=pst.executeQuery();
            while (rs.next()) {
                sum=sum + rs.getInt("Amount");
            }
            
            feePayAmount.setText(String.valueOf(sum));
            
            System.out.println("Expected amount "+sum+ " Class "+form);
        } catch (Exception e) {
            System.out.println(cops);
            JOptionPane.showMessageDialog(null, e+"\n FinanceBalance 1 error ");
        }
        
        try {
            String sql="SELECT * FROM `tbl_Paid`  WHERE `Reg_No`=? ";
            pst=Conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(reg));
            rs=pst.executeQuery();
            while (rs.next()) {
                paid=paid + rs.getInt("Paid_Fee");
            }
            
            feePayPaid.setText(String.valueOf(paid));
            System.out.println("Paid Amount "+String.valueOf(paid));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\n FinanceExpected 2");
        }
        
        rem=sum-paid;
        
        System.out.println("Balance Amount "+String.valueOf(sum-paid));
        feePayBal.setText(String.valueOf(rem));
        
        return rem;
    }
    
    private int FeePaid(int reg){
        int piad=0;
        String sql="SELECT * FROM  tbl_Paid WHERE `Reg_No`='"+reg+"' ";
        try {
            pst=Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()) {                
                piad=piad+rs.getInt("Paid_Fee");
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo FeePaid");
            Toolkit.getDefaultToolkit().beep();
        }
        return piad;
    }
    
    private void FeePay(int reg, int Amoun){
        
        if (Amoun < 1) {
            JOptionPane.showMessageDialog(this, "Deposits should be over 1 KShs");
        }else{
            
            JOptionPane.showConfirmDialog(this, "Proceed with this","Qusey", JOptionPane.YES_NO_OPTION);
            
            int paynow= FeePaid(reg)+Integer.parseInt(feePayNew.getText());
            int bal=FinanceBalance(feePayClass.getText(), String.valueOf(reg));
            
            String sql="INSERT INTO `tbl_Paid` (Name,Class,Reg_No,Total_Fee,Paid_Fee,Bal_Fee)  VALUES('"+feePayName.getText()+"','"+feePayClass.getText()+"',"+reg+","+Integer.parseInt(feePayAmount.getText())+","+paynow+","+bal+")";
            String sql2="UPDATE `tbl_Paid` SET `Name` ='"+feePayName.getText()+"',`Class` ='"+feePayClass.getText()+"', `Total_Fee` ="+Integer.parseInt(feePayAmount.getText())+", `Paid_Fee` ="+paynow+", `Bal_Fee` ="+bal+" WHERE `Reg_No`="+reg+" ";

            try {
                pst = Conn.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("True Inserted Quiz\n"+sql);
                feePayAmount.setText(null);
            } catch (Exception e) {
                try {
                    pst=Conn.prepareStatement(sql2);
                    pst.execute();

                    System.out.println("True Updated Quiz\n"+sql2);
                    feePayAmount.setText(null);
                } catch (Exception ex) {
                    System.out.println(ex+"\nCaught error Quiz "+lv);
                }
            }
        }
        
        PopFinace();
    }
    
    private void FeeFindUser(int userreg){        
        String cops4= "SELECT * FROM `tbl_Students` WHERE `Reg_No` ='"+userreg+"' ";  
        try {
            pst = (Conn.prepareStatement(cops4));
            rs = pst.executeQuery();
            
            if (rs.first()==Boolean.FALSE) {
                JOptionPane.showMessageDialog(this, "No Such user was found within the database");
                feePayName.setText(null);
                feePayClass.setText(null);
                feePayPaid.setText(null);
            }else{
                while (rs.next()) {
                    feePayName.setText(rs.getString("Name"));
                    feePayClass.setText(rs.getString("Class"));
                }
                FinanceBalance(feePayClass.getText(), (feePayReg.getText().toString()));
                
                feePayPaid.setText(String.valueOf(FeePaid(Integer.parseInt((feePayReg.getText().toString())))));
            }
            
            
        } catch (Exception e) {
            System.out.println(e+"\n FeeFindUser above");
        }
    }
    
    private void Filla(){
        try {
            //String sql="INSERT INTO `"+cs+"` (Name,Reg_No,Class)  SELECT Name,Reg_No,Class FROM tbl_Students WHERE `Class`='"+Mats+"'";
            String sql="INSERT INTO `"+cs+"` (Name,Reg_No,Class)  SELECT Name,Reg_No,Class FROM tbl_Students";
            smt=(Statement) Conn.prepareStatement(sql);
            //smt.executeUpdate(sql);
            pst = Conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\n Filla");
        }
    }
    
    private boolean Clicked(){
        boolean va=false;
        
        try {
            if (!(Cbf3.isSelected() || Cbf4.isSelected() || Cbf1.isSelected() || Cbf2.isSelected() )) {
                //JOptionPane.showMessageDialog(null, "Check A Class AND A Term To Proceed");
            }
            va=false;
        } catch (Exception e) {
            va=true;
        }
        
        return va;
    }
    
    private void FeeObjectIns(String ha){
        try {
            String sql="INSERT INTO `tbl_Fees` (Count,Object_Name,Class,Amount,Comment)  VALUES(NULL,?,?,?,?)";
            pst = Conn.prepareStatement(sql);
            pst.setString(1, FeeObject.getText().toString());
            pst.setString(2, ha);
            pst.setInt(3, Integer.parseInt(FeeAmount.getText().toString()));
            pst.setString(4, FeeComment.getText().toString());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage()+ "\t FeeObjectAddActionPerformed 2");
        }
    }
    
    private boolean Logme(){
        
        String Usr,pwd,lvl;
        Usr=PanLogUsername.getText().toString();
        pwd=PanLogUsername.getText().toString();
        lvl=PanLogLevel.getSelectedItem().toString();
        
        islogged=false;
        
        String sav="SELECT * FROM `tbl_Staff` WHERE `Name`= '"+Usr+"' AND `PassPhrase`= '"+pwd+"' AND `Type`= '"+lvl+"' ";
               
        try {
            pst= Conn.prepareStatement(sav);
            rs=pst.executeQuery();
            if (rs.next()) {
                VarUsername=Usr;
                jLabel14.setText("Logged In As "+VarUsername);
                islogged=true;
                if (PanLogLevel.getSelectedIndex()==0) {
                    //Teacher
                    HmFee.setEnabled(false);
                    HmAdmin.setEnabled(false);
                    //HmMails.setEnabled(false);
                                      
                    KillAll();
                    Labo(2);
                    PanHome.setVisible(true);
                }
                if (PanLogLevel.getSelectedIndex()==1) {
                    //Admin
                    KillAll();
                    Labo(2);
                    PanHome.setVisible(true);
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Wrong Details provided", "Hehe Nigga", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            PanLogPassword.setText(null);
            islogged=false;
            JOptionPane.showMessageDialog(null, "Invalid Credentials");
        }
        
        return islogged;
    }
     
     
    //*-*-*-*-*-
    private void Mk(){
        StrNxt.setEnabled(Boolean.FALSE);
        MarkUp();
        Inst();
        Frez();
    }
    
    private void IkiaP2() {
        try {
            lv="UPDATE `tbl_Placer` SET "+slSbj+"=1 WHERE `Reg_No`=?";
            pst=(PreparedStatement) Conn.prepareStatement(lv);
            pst.setInt(1, Integer.parseInt(NwRegNo.getText()));
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nError Updating Tbl Place "+slSbj);
        }
    }

    private void Inst(){
        int tt=cc.get(Calendar.YEAR);
        
        for (int i = 2015; i < 2025; i++) {
            lvv=String.valueOf(i);
            //YBx.addItem(lvv);
        }
        
        Cbf1.setEnabled(false);
        Cbf2.setEnabled(false);
        Cbf3.setEnabled(false);
        Cbf4.setEnabled(false);
        
    }
    
    private  void Setta(Double x,String j,int p){
        Nm();
        //Makr();
        String sqll="UPDATE `"+lst+"` SET "+j+"="+x+" WHERE Reg_No="+p+"";
        try {
            pst=(PreparedStatement) Conn.prepareStatement(sqll);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex+" +++Setta Error");
        }
    }
    
    private  void MarkUp(){
        for (int i = 2016; i < 2025; i++) {
            lvv=String.valueOf(i);
            YBx1.addItem(lvv);
        }
        Cbf5.setSelected(Boolean.TRUE);
        Cbf6.setSelected(Boolean.TRUE);
        Cbf7.setSelected(Boolean.TRUE);
        Cbf8.setSelected(Boolean.TRUE);
        Cbf5.setEnabled(Boolean.FALSE);
        Cbf6.setEnabled(Boolean.FALSE);
        Cbf7.setEnabled(Boolean.FALSE);
        Cbf8.setEnabled(Boolean.FALSE);
    }
    
    private void Frez(){        
        try {
            String sql="SELECT `Test` FROM `tbl_Tests` ";
            pst= (PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()) {
                String elm=rs.getString("Test");
                    String bd = "_";
                    String gd = "  ";
                    Pattern pt1 = Pattern.compile(bd);
                    Matcher m1 = pt1.matcher(elm); 
                    //elm = m1.replaceAll(gd);    
                Ex1Perf.addItem(elm);
                Ex2Perf.addItem(elm);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nCurrent Exam Table Error");
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private void Comp(){
        try {
            String sql="SELECT * FROM `"+TbChs+"` ORDER BY `Count` DESC LIMIT 1";
            pst= (PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if (rs.next()) {
                //Mt,En,Kw,Ce,Bl,Ph,Go,Ht,Cr,Al,Bu;
                Mt=rs.getString("Mathematics");
                En=rs.getString("English");
                Kw=rs.getString("Kiswahili");
                Ce=rs.getString("Chemistry");
                Bl=rs.getString("Biology");
                Ph=rs.getString("Physics");
                Go=rs.getString("Geography");
                Ht=rs.getString("History");
                Cr=rs.getString("CRE");
                Al=rs.getString("Agriculture");
                Bu=rs.getString("Business");
                //JOptionPane.showMessageDialog(null, Mt+En+Kw+Ce+Bl+Ph+Go+Ht+Cr+Al+Bu);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nMarks Parse Error");
            Toolkit.getDefaultToolkit().beep();
        }  
    }
    
    private void Setta(){        
        if (mwr<5) {
            Trm="Term 1";
            tama="Term1";
        }
        if (mwr<9 && mwr>4) {
            Trm="Term 2";
            tama="Term2";
        }
        if (mwr>8) {
            Trm="Term 3";
            tama="Term3";
        }
        
        spa=Trm+"-"+ths;
    }
    
    private void rEDA(){
        try {
            FileWriter fw=new FileWriter(lst+".csv");
            String sql="SELECT * FROM `"+lst+"`";
            Statement stmt=(Statement) Conn.createStatement();
            rs=stmt.executeQuery(sql);
            String lista="Count,Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,History,CRE,Business,Agriculture";
            //fw.append(lista+"\n");
            while (rs.next()) {                
                //fw.append(rs.getString(0));
                //fw.append(",");
                fw.append(rs.getString(1));
                fw.append(",");
                fw.append(rs.getString(2));
                fw.append(",");
                fw.append(rs.getString(3));
                fw.append(",");
                fw.append(rs.getString(4));;
                fw.append(",");
                fw.append(rs.getString(5));
                fw.append(",");
                fw.append(rs.getString(6));
                fw.append(",");
                fw.append(rs.getString(7));
                fw.append(",");
                fw.append(rs.getString(8));
                fw.append(",");
                fw.append(rs.getString(9));
                fw.append(",");
                fw.append(rs.getString(10));
                fw.append(",");
                fw.append(rs.getString(11));
                fw.append(",");
                fw.append(rs.getString(12));
                fw.append(",");
                fw.append(rs.getString(13));
                fw.append(",");
                fw.append(rs.getString(14));;
                fw.append(",");
                fw.append(rs.getString(15));
                //fw.append(",");
                fw.append("\n");
            }
            fw.flush();
            fw.close();
            JOptionPane.showMessageDialog(null, "Succesfully Parsed");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNigga");
        }
    }
    
    private void Greda(){
        if (FormGrad.getSelectedIndex()==0) {
            frgd="Form 1";
        }
        if (FormGrad.getSelectedIndex()==1) {
            frgd="Form 2";
        }
        if (FormGrad.getSelectedIndex()==2) {
            frgd="Form 3";
        }
        if (FormGrad.getSelectedIndex()==3) {
            frgd="Form 4";
        }
        
        if (SubGrad.getSelectedIndex()==0) {
            sbgd="";
        }
        if (SubGrad.getSelectedIndex()==1) {
            sbgd="Mathematics";
        }
        if (SubGrad.getSelectedIndex()==2) {
            sbgd="English";
        }
        if (SubGrad.getSelectedIndex()==3) {
            sbgd="Kiswahili";
        }
        if (SubGrad.getSelectedIndex()==4) {
            sbgd="Chemistry";
        }
        if (SubGrad.getSelectedIndex()==5) {
            sbgd="Biology";
        }
        if (SubGrad.getSelectedIndex()==6) {
            sbgd="Physics";
        }
        if (SubGrad.getSelectedIndex()==7) {
            sbgd="Geography";
        }
        if (SubGrad.getSelectedIndex()==8) {
            sbgd="History";
        }
        if (SubGrad.getSelectedIndex()==9) {
            sbgd="CRE";
        }
        if (SubGrad.getSelectedIndex()==10) {
            sbgd="Agriculture";
        }
        if (SubGrad.getSelectedIndex()==11) {
            sbgd="Business";
        }
        
        if (GradIt.getSelectedIndex()==0) {
            grd="";
        }
        if (GradIt.getSelectedIndex()==1) {
            grd="A";
        }
        if (GradIt.getSelectedIndex()==2) {
            grd="A-";
        }
        if (GradIt.getSelectedIndex()==3) {
            grd="B+";
        }
        if (GradIt.getSelectedIndex()==4) {
            grd="B";
        }
        if (GradIt.getSelectedIndex()==5) {
            grd="B-";
        }
        if (GradIt.getSelectedIndex()==6) {
            grd="C+";
        }
        if (GradIt.getSelectedIndex()==7) {
            grd="C";
        }
        if (GradIt.getSelectedIndex()==8) {
            grd="C-";
        }
        if (GradIt.getSelectedIndex()==9) {
            grd="D+";
        }
        if (GradIt.getSelectedIndex()==10) {
            grd="D";
        }
        if (GradIt.getSelectedIndex()==11) {
            grd="D-";
        }
        if (GradIt.getSelectedIndex()==12) {
            grd="E";
        }
        
    }
    
    private void SenrAd(){
        if (FrmSenrAdd.getSelectedIndex()==0) {
            snmcls="Form 3";
        }
        if (FrmSenrAdd.getSelectedIndex()==1) {
            snmcls="Form 4";
        }
        
        if (SbjSenrChus.getSelectedIndex()==1) {
            snmsbj="`Mathematics`,`English`,`Kiswahili`";
        }
        if (SbjSenrChus.getSelectedIndex()==2) {
            snmsbj="Chemistry";
        }
        if (SbjSenrChus.getSelectedIndex()==3) {
            snmsbj="Biology";
        }
        if (SbjSenrChus.getSelectedIndex()==4) {
            snmsbj="Physics";
        }
        if (SbjSenrChus.getSelectedIndex()==5) {
            snmsbj="Geography";
        }
        if (SbjSenrChus.getSelectedIndex()==6) {
            snmsbj="CRE";
        }
        if (SbjSenrChus.getSelectedIndex()==7) {
            snmsbj="History";
        }
        if (SbjSenrChus.getSelectedIndex()==8) {
            snmsbj="Agriculture";
        }
        if (SbjSenrChus.getSelectedIndex()==9) {
            snmsbj="Business";
        }
    }
    
    private void Str(){
        int Nr,St,Ws,Es;
        try {
                String sql="SELECT * FROM `tbl_ClassList` WHERE `Class`='"+ClStr+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                while (rs.next()) {
                    Nr=rs.getInt("North");
                    St=rs.getInt("South");
                    Ws=rs.getInt("West");
                    Es=rs.getInt("East");
                    if(Nr ==1){
                        NwStdFrmSrm.addItem("North");
                    }
                    if(St ==1){
                        NwStdFrmSrm.addItem("South");
                    }
                    if(Ws ==1){
                        NwStdFrmSrm.addItem("West");
                    }
                    if(Es ==1){
                        NwStdFrmSrm.addItem("East");
                    }   
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nStr Error");
            }
    }
    
    private void StrNx( String cl){
        try {
            String sql="SELECT * FROM `"+lst+"` WHERE `Class`='"+cl+"' ";
            pst=Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Leva.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            System.out.println(e+"\n StrNx");
        }
    }
    
    private void Chus(){
        int Nr,St,Ws,Es;
            try {
                String sql="SELECT * FROM `tbl_ClassList` WHERE `Class`='"+ClStr+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                while (rs.next()) {
                    Nr=rs.getInt("North");
                    St=rs.getInt("South");
                    Ws=rs.getInt("West");
                    Es=rs.getInt("East");
                    StrmSenrAdd.addItem("-All-");
                    if(Nr ==1){
                        StrmSenrAdd.addItem("North");
                    }
                    if(St ==1){
                        StrmSenrAdd.addItem("South");
                    }
                    if(Ws ==1){
                        StrmSenrAdd.addItem("West");
                    }
                    if(Es ==1){
                        StrmSenrAdd.addItem("East");
                    }   
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nChus");
            }
    }
    
    private void Makeit(){
        String fdsa=null;
        if (RepoClas.getSelectedIndex()==2) {
            fdsa="Form 3";
        }
        if (RepoClas.getSelectedIndex()==3) {
            fdsa="Form 4";
        }
        try {
            String cops="SELECT Chemistry,Biology,Physics,Geography,CRE,Business,Agriculture FROM `tbl_Placer` WHERE `Class`='"+fdsa+"' ";
            pst=Conn.prepareStatement(cops);
            rs=pst.executeQuery();
            if (rs.next()) {
                int c1,b2,p3,g4,cr5,b6,a7;
                c1=rs.getInt("Chemistry");
                b2=rs.getInt("Biology");
                p3=rs.getInt("Physics");
                g4=rs.getInt("Geography");
                cr5=rs.getInt("CRE");
                JOptionPane.showMessageDialog(null, "Chemistry"+c1+"\nBiology"+b2+"\nPhysics"+p3+"\nGeography"+g4+"\nCRE"+cr5);
            }
        } catch (Exception e) {
            System.out.println(e+"\n Makeit");
        }
    }
    
    private void Summ(int stdjmpreg, int stdjmpcls){
        while (rootPaneCheckingEnabled) {            
            
        }
        if (Classe.getSelectedIndex()==0 || Classe.getSelectedIndex()==1) {
            try {
                String cops="SELECT `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture` FROM `"+lst+"` WHERE `Reg_No`='"+stdjmpreg+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(cops);
                rs=pst.executeQuery();
                if (rs.next()) {
                    jmpmath=rs.getInt("Mathematics");
                    jmpeng=rs.getInt("English");
                    jmpkiswa=rs.getInt("Kiswahili");
                    jmpchem=rs.getInt("Chemistry");
                    jmpbio=rs.getInt("Biology");
                    jmpphy=rs.getInt("Physics");
                    jmpgeo=rs.getInt("Geography");
                    jmpcre=rs.getInt("CRE");
                    jmphist=rs.getInt("History");
                    jmpbus=rs.getInt("Business");
                    jmpagr=rs.getInt("Agriculture");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nSUmm 1.2 ERROR");
            }
            
            try {
                String cops="SELECT `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture` FROM `tbl_MarkP` WHERE `Reg_No`='"+stdjmpcls+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(cops);
                rs=pst.executeQuery();
                if (rs.next()) {
                    jmpmathc=rs.getInt("Mathematics");
                    jmpengc=rs.getInt("English");
                    jmpkiswac=rs.getInt("Kiswahili");
                    jmpchemc=rs.getInt("Chemistry");
                    jmpbioc=rs.getInt("Biology");
                    jmpphyc=rs.getInt("Physics");
                    jmpgeoc=rs.getInt("Geography");
                    jmpcrec=rs.getInt("CRE");
                    jmphistc=rs.getInt("History");
                    jmpbusc=rs.getInt("Business");
                    jmpagrc=rs.getInt("Agriculture");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nSUmm 1.2 Compare");
            }
            int stdpass=1;
            if (jmpmath > jmpagrc || jmpmath == jmpagrc ) {
                stdpass=2;
            }
            else if (jmpeng > jmpengc || jmpengc == jmpengc ) {
                stdpass=2;
            }
            else if (jmpkiswa > jmpkiswac || jmpkiswa == jmpkiswac ) {
                stdpass=2;
            }
            else if (jmpchem > jmpchemc || jmpchem == jmpchemc ) {
                stdpass=2;
            }
            else if (jmpbio > jmpbioc || jmpbio == jmpbioc ) {
                stdpass=2;
            }
            else if (jmpphy > jmpphyc || jmpphy == jmpphyc ) {
                stdpass=2;
            }
            else if (jmpgeo > jmpgeoc || jmpgeo == jmpgeoc ) {
                stdpass=2;
            }
            else if (jmpcre > jmpcrec || jmpcre == jmpcrec ) {
                stdpass=2;
            }
            else if (jmphist > jmphistc || jmphist == jmphistc ) {
                stdpass=2;
            }
            else if (jmpagr > jmpagrc || jmpagr == jmpagrc ) {
                stdpass=2;
            }
            else if (jmpbus > jmpbusc || jmpbus == jmpbusc ) {
                stdpass=2;
            }
            else{
                stdpass=3;
            }
            if (stdpass==2) {
                //Exec pass for Student
            }else{
                //Exec Fail for Student
            }
        }else if (Classe.getSelectedIndex()==2) {
            
        }
        
    }
    
    private void InsBasic(int stdreg,Double stdscor,String stdsbjs){
        Nm();
        String sqll="UPDATE `"+lst+"` SET "+stdsbjs+"="+stdscor+" WHERE Reg_No="+stdreg+"";
        try {
            pst=Conn.prepareStatement(sqll);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex+" InsBasic");
        }
    }
    
    private void PopAnaly(){
        int Nr,St,Ws,Es;
        try {
                String sql="SELECT * FROM `tbl_ClassList` WHERE `Class`='"+crclas+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                while (rs.next()) {
                    Nr=rs.getInt("North");
                    St=rs.getInt("South");
                    Ws=rs.getInt("West");
                    Es=rs.getInt("East");
                    CritStream.addItem("All");
                    if(Nr ==1){
                        CritStream.addItem("North");
                    }
                    if(St ==1){
                        CritStream.addItem("South");
                    }
                    if(Ws ==1){
                        CritStream.addItem("West");
                    }
                    if(Es ==1){
                        CritStream.addItem("East");
                    }   
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nStr Error 22");
            }
    }
    
    private void FeeBalFindBy(String name, int reg){
        String cops4= "SELECT * FROM `tbl_Paid` WHERE `Reg_No` = '"+reg+"' "; 
        String cops5= "SELECT * FROM `tbl_Paid` WHERE `Name` LIKE '%"+name+"%' "; 
        
        if (reg<1) {
            try {
                pst=(PreparedStatement) Conn.prepareStatement(cops5);
                rs=pst.executeQuery();
                while (true) {
                    tblFeeArrears.setModel(DbUtils.resultSetToTableModel(rs));
                    break;
                }

            } catch (Exception ex) {
                System.out.println("FeeBalFindByName \n"+ex+"\n***");
            }
            
        }else{
            try {
                pst=(PreparedStatement) Conn.prepareStatement(cops4);
                rs=pst.executeQuery();
                while (true) {
                    tblFeeArrears.setModel(DbUtils.resultSetToTableModel(rs));
                    break;
                }

            } catch (Exception e) {
                System.out.println("FeeBalFindByReg \n"+e+"\n***");
            }
            }        
    }
    //*-*-*-*-*-

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        All = new javax.swing.JPanel();
        PanLogs = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PanLogUsername = new javax.swing.JTextField();
        PanLogPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        PanLogLevel = new javax.swing.JComboBox<>();
        BtnLogin = new javax.swing.JButton();
        PanHome = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        HmNewStudent = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        HmFee = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        HmExam = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        HmTeacher = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        HmStudents = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        HmReports = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        HmAdmin = new javax.swing.JButton();
        PanStudents = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllStudents = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAllStd = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        StudentFindType = new javax.swing.JComboBox<>();
        StudentFind = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        PanReports = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        RepoClas = new javax.swing.JComboBox<>();
        RepoEX = new javax.swing.JComboBox<>();
        jPanel46 = new javax.swing.JPanel();
        GraphBar = new javax.swing.JRadioButton();
        GraphLine = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        RepoTbl = new javax.swing.JTable();
        VwCred = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        SyncRepo = new javax.swing.JButton();
        WannaBe = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        PanExams = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblExamCompare = new javax.swing.JTable();
        jPanel49 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        FltPrf = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        Ex2Perf = new javax.swing.JComboBox<>();
        Clss = new javax.swing.JComboBox<>();
        ExamSubject = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        Ex1Perf = new javax.swing.JComboBox<>();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        CritClass = new javax.swing.JComboBox<>();
        CritStream = new javax.swing.JComboBox<>();
        CritSubject = new javax.swing.JComboBox<>();
        CritAscend = new javax.swing.JRadioButton();
        CritDesc = new javax.swing.JRadioButton();
        AnalyseExam = new javax.swing.JButton();
        CritMosImp = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbl_Analyse = new javax.swing.JTable();
        PanFinance = new javax.swing.JPanel();
        feeTab = new javax.swing.JTabbedPane();
        feeTabStatement = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblFeeAll = new javax.swing.JTable();
        FinanceF1 = new javax.swing.JRadioButton();
        FinanceF2 = new javax.swing.JRadioButton();
        FinanceF3 = new javax.swing.JRadioButton();
        FinanceF4 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        feeArrears = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        FinanceArrearsfindbyname = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        FinanceArrearsfindbyreg = new javax.swing.JTextField();
        feePrintArrears = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblFeeArrears = new javax.swing.JTable();
        feeTabDeposit = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        FeeBalanceBelow = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        FeePaidAbove = new javax.swing.JTextField();
        FeeDepositFind = new javax.swing.JButton();
        feePrintDeposits = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        feePayName = new javax.swing.JTextField();
        feePayReg = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        feePayAmount = new javax.swing.JTextField();
        feePayClass = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        feePayBal = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        feePayPaid = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        feePayNew = new javax.swing.JTextField();
        feeDepositPay = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFeeSearch = new javax.swing.JTable();
        PanMisc = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanAdmit = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        NwRegNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        RegAsBtn = new javax.swing.JButton();
        NwStdFrmSrm = new javax.swing.JComboBox<>();
        DpImgS = new javax.swing.JDesktopPane();
        DpImg = new javax.swing.JLabel();
        NwStdImg = new javax.swing.JButton();
        ImgP = new javax.swing.JTextField();
        NwStdFrm = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        NwContacts = new javax.swing.JTextField();
        NwGuardian = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        NwResidence = new javax.swing.JComboBox<>();
        Ext = new javax.swing.JButton();
        NwStdReg = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        NwFrmSch = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        NwKCPE = new javax.swing.JTextField();
        NwFullName = new javax.swing.JTextField();
        NwSurName = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        NwBirthYear = new javax.swing.JComboBox<>();
        PanTeacher = new javax.swing.JPanel();
        Sett = new javax.swing.JPanel();
        Nxt = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        Cbf1 = new javax.swing.JRadioButton();
        Cbf2 = new javax.swing.JRadioButton();
        Cbf3 = new javax.swing.JRadioButton();
        Cbf4 = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        TeachCurrentExanm = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        Senr = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        FrmSenrAdd = new javax.swing.JComboBox<>();
        StrmSenrAdd = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        SbjSenrChus = new javax.swing.JComboBox<>();
        SncSenr = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSnrAdd = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblSenrMarkList = new javax.swing.JTable();
        InsrtSenr = new javax.swing.JButton();
        BacSett = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        ExamBay = new javax.swing.JComboBox<>();
        Marks = new javax.swing.JPanel();
        Pg0 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblLowerMarks = new javax.swing.JTable();
        Ada = new javax.swing.JButton();
        Rsh = new javax.swing.JButton();
        Bcer = new javax.swing.JButton();
        Graphyy = new javax.swing.JButton();
        PanAdmin = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel20 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        YBx1 = new javax.swing.JComboBox<>();
        ExxamTY1 = new javax.swing.JComboBox<>();
        Tr4 = new javax.swing.JRadioButton();
        Tr5 = new javax.swing.JRadioButton();
        Tr6 = new javax.swing.JRadioButton();
        Cbf5 = new javax.swing.JCheckBox();
        Cbf6 = new javax.swing.JCheckBox();
        Cbf7 = new javax.swing.JCheckBox();
        Cbf8 = new javax.swing.JCheckBox();
        RstCont = new javax.swing.JButton();
        SetCont = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        Classe = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        ComBin = new javax.swing.JComboBox<>();
        TrnCls = new javax.swing.JButton();
        eXA = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        StrNxt = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        Leva = new javax.swing.JTable();
        jPanel34 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        SCls = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel41 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        FormGrad = new javax.swing.JComboBox<>();
        jLabel74 = new javax.swing.JLabel();
        SubGrad = new javax.swing.JComboBox<>();
        jLabel75 = new javax.swing.JLabel();
        GradIt = new javax.swing.JComboBox<>();
        jPanel42 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        Hrange = new javax.swing.JComboBox<>();
        jLabel77 = new javax.swing.JLabel();
        Lrange = new javax.swing.JComboBox<>();
        jPanel44 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        CommBox = new javax.swing.JTextArea();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        GraBox = new javax.swing.JTextArea();
        GrdSett = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblFee = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        FeeObject = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        FeeAmount = new javax.swing.JTextField();
        FeeObjectAdd = new javax.swing.JButton();
        FeeObjectEdit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        FeeComment = new javax.swing.JTextArea();
        FeeObjectDelete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        FeeClass = new javax.swing.JComboBox<>();
        Head = new javax.swing.JPanel();
        MnAddStd = new javax.swing.JLabel();
        MnStd = new javax.swing.JLabel();
        MnExams = new javax.swing.JLabel();
        MnGraphs = new javax.swing.JLabel();
        MnCharts = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Exitt = new javax.swing.JLabel();
        Homie = new javax.swing.JLabel();
        Tail = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mnStudents = new javax.swing.JMenu();
        mnStaff = new javax.swing.JMenu();
        mnReports = new javax.swing.JMenu();
        mnMisc = new javax.swing.JMenu();
        mnHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1050, 650));

        All.setMinimumSize(new java.awt.Dimension(1050, 580));
        All.setName(""); // NOI18N
        All.setPreferredSize(new java.awt.Dimension(1050, 580));

        PanLogs.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Log-in to Proceed"));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Username");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Password");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        PanLogUsername.setToolTipText("");

        PanLogPassword.setToolTipText("");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Proceed As");

        PanLogLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teacher", "Admin" }));

        BtnLogin.setText("Login");
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanLogPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanLogUsername)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanLogLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 92, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnLogin)
                .addGap(118, 118, 118))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanLogUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanLogPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PanLogLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(BtnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanLogsLayout = new javax.swing.GroupLayout(PanLogs);
        PanLogs.setLayout(PanLogsLayout);
        PanLogsLayout.setHorizontalGroup(
            PanLogsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanLogsLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        PanLogsLayout.setVerticalGroup(
            PanLogsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanLogsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanHome.setBackground(new java.awt.Color(204, 204, 204));

        jPanel6.setMinimumSize(new java.awt.Dimension(165, 175));
        jPanel6.setName(""); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(165, 175));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("New Student");
        jLabel30.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        HmNewStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/user-new-31.png"))); // NOI18N
        HmNewStudent.setToolTipText("Admit New Student");
        HmNewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmNewStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HmNewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HmNewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel30)
                .addContainerGap())
        );

        HmFee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/emblem-money.png"))); // NOI18N
        HmFee.setToolTipText("Fee");
        HmFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmFeeActionPerformed(evt);
            }
        });

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Fee");
        jLabel56.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel56.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HmFee, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HmFee, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel56)
                .addContainerGap())
        );

        jPanel10.setMinimumSize(new java.awt.Dimension(165, 175));
        jPanel10.setName(""); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(165, 175));

        HmExam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/kate.png"))); // NOI18N
        HmExam.setToolTipText("Exams");
        HmExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmExamActionPerformed(evt);
            }
        });

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Exams");
        jLabel52.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel52.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(HmExam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HmExam, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel52)
                .addContainerGap())
        );

        jPanel23.setMinimumSize(new java.awt.Dimension(165, 175));
        jPanel23.setName(""); // NOI18N
        jPanel23.setPreferredSize(new java.awt.Dimension(165, 175));

        HmTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/identity.png"))); // NOI18N
        HmTeacher.setToolTipText("Staff Users");
        HmTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmTeacherActionPerformed(evt);
            }
        });

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Teacher");
        jLabel31.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HmTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HmTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel31)
                .addContainerGap())
        );

        jPanel27.setMinimumSize(new java.awt.Dimension(165, 175));
        jPanel27.setName(""); // NOI18N
        jPanel27.setPreferredSize(new java.awt.Dimension(165, 175));

        HmStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/system-users-4.png"))); // NOI18N
        HmStudents.setToolTipText("All Students");
        HmStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmStudentsActionPerformed(evt);
            }
        });

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Students");
        jLabel51.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel51.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(HmStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HmStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel51)
                .addContainerGap())
        );

        jPanel28.setMinimumSize(new java.awt.Dimension(165, 175));
        jPanel28.setName(""); // NOI18N
        jPanel28.setPreferredSize(new java.awt.Dimension(165, 175));

        HmReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/office-chart-area-stacked1.png"))); // NOI18N
        HmReports.setToolTipText("Reports and Transcripts");
        HmReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmReportsActionPerformed(evt);
            }
        });

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Reports");
        jLabel55.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel55.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HmReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HmReports, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel55)
                .addContainerGap())
        );

        jPanel32.setMinimumSize(new java.awt.Dimension(165, 175));
        jPanel32.setName(""); // NOI18N
        jPanel32.setPreferredSize(new java.awt.Dimension(165, 175));

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Admin");
        jLabel59.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel59.setName(""); // NOI18N
        jLabel59.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        HmAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/system-users-3.png"))); // NOI18N
        HmAdmin.setToolTipText("Administrator");
        HmAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HmAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HmAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel59)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(57, 57, 57)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 171, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout PanHomeLayout = new javax.swing.GroupLayout(PanHome);
        PanHome.setLayout(PanHomeLayout);
        PanHomeLayout.setHorizontalGroup(
            PanHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanHomeLayout.setVerticalGroup(
            PanHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanStudents.setBackground(new java.awt.Color(204, 204, 204));

        tblAllStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblAllStudents);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("All Students", jPanel3);

        tblAllStd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblAllStd);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Search By"));

        StudentFindType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Class", "Reg No" }));
        StudentFindType.setToolTipText("");

        StudentFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                StudentFindKeyTyped(evt);
            }
        });

        jButton2.setText("Print");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(StudentFindType, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StudentFind, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton2)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentFindType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StudentFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Students", jPanel5);

        javax.swing.GroupLayout PanStudentsLayout = new javax.swing.GroupLayout(PanStudents);
        PanStudents.setLayout(PanStudentsLayout);
        PanStudentsLayout.setHorizontalGroup(
            PanStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        PanStudentsLayout.setVerticalGroup(
            PanStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        PanReports.setBackground(new java.awt.Color(204, 204, 204));

        jPanel26.setMinimumSize(new java.awt.Dimension(933, 410));
        jPanel26.setName(""); // NOI18N

        jLabel53.setText("Class");

        RepoClas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));

        RepoEX.setEnabled(false);

        jPanel46.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup8.add(GraphBar);
        GraphBar.setText("Bar");
        GraphBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphBarActionPerformed(evt);
            }
        });

        buttonGroup8.add(GraphLine);
        GraphLine.setText("Line");
        GraphLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphLineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GraphBar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GraphLine)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GraphBar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GraphLine, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        RepoTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        RepoTbl.setMinimumSize(new java.awt.Dimension(300, 64));
        RepoTbl.setName(""); // NOI18N
        jScrollPane5.setViewportView(RepoTbl);

        VwCred.setText("Class View");
        VwCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VwCredActionPerformed(evt);
            }
        });

        jLabel68.setText("Exam ");

        SyncRepo.setText("Load");
        SyncRepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SyncRepoActionPerformed(evt);
            }
        });

        WannaBe.setText("Result Sheet");
        WannaBe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WannaBeActionPerformed(evt);
            }
        });

        jButton3.setText("Generate");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RepoClas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(SyncRepo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(WannaBe, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addComponent(RepoEX, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(VwCred, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addComponent(jScrollPane5)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(RepoClas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68)
                    .addComponent(RepoEX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(VwCred)
                        .addComponent(WannaBe)
                        .addComponent(jButton3))
                    .addComponent(SyncRepo)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanReportsLayout = new javax.swing.GroupLayout(PanReports);
        PanReports.setLayout(PanReportsLayout);
        PanReportsLayout.setHorizontalGroup(
            PanReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanReportsLayout.setVerticalGroup(
            PanReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PanExams.setBackground(new java.awt.Color(204, 204, 204));
        PanExams.setToolTipText("");

        jPanel30.setMinimumSize(new java.awt.Dimension(967, 553));
        jPanel30.setName(""); // NOI18N

        tblExamCompare.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tblExamCompare);

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder("Set Constraints"));

        jLabel83.setText("Exam 1");

        jLabel44.setText("Filter");

        FltPrf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compare", "Highest" }));
        FltPrf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FltPrfActionPerformed(evt);
            }
        });

        jLabel43.setText("Subject");

        jLabel42.setText("Class");

        Ex2Perf.setName(""); // NOI18N

        Clss.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));
        Clss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClssActionPerformed(evt);
            }
        });

        ExamSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mathematics", "English", "Kiswahili", "Chemistry", "Biology", "Physics", "Geography", "History", "CRE", "Agriculture", "Business" }));
        ExamSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExamSubjectActionPerformed(evt);
            }
        });

        jLabel84.setText("Exam 2");

        Ex1Perf.setEditable(true);
        Ex1Perf.setToolTipText("");
        Ex1Perf.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Clss, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ExamSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Ex1Perf, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(417, 417, 417))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel84)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Ex2Perf, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FltPrf, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(Clss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ex1Perf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43)
                        .addComponent(ExamSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FltPrf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44))
                    .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Ex2Perf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel84)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1045, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Comparisons", jPanel29);

        jPanel47.setMinimumSize(new java.awt.Dimension(967, 553));
        jPanel47.setName(""); // NOI18N

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder("Criteria"));

        CritClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));
        CritClass.setToolTipText("");
        CritClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CritClassActionPerformed(evt);
            }
        });

        CritStream.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stream" }));
        CritStream.setEnabled(false);

        CritSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subjects", "Mathematics", "English", "Kiswahili", "Chemistry", "BIology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business Studies" }));

        buttonGroup6.add(CritAscend);
        CritAscend.setText("Ascending");
        CritAscend.setToolTipText("Criteria");

        buttonGroup6.add(CritDesc);
        CritDesc.setText("Descending");
        CritDesc.setToolTipText("Criteria");

        AnalyseExam.setText("Process");
        AnalyseExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalyseExamActionPerformed(evt);
            }
        });

        buttonGroup6.add(CritMosImp);
        CritMosImp.setText("Most Improved");
        CritMosImp.setToolTipText("Criteria");

        jButton1.setText("Print");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CritSubject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CritAscend)
                            .addComponent(CritDesc)
                            .addGroup(jPanel48Layout.createSequentialGroup()
                                .addComponent(CritClass, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CritStream, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CritMosImp))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AnalyseExam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CritClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CritStream, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(CritSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CritAscend)
                .addGap(18, 18, 18)
                .addComponent(CritDesc)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CritMosImp)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(AnalyseExam)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        tbl_Analyse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane12.setViewportView(tbl_Analyse);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane12)
        );

        jTabbedPane5.addTab("Sorting", jPanel47);

        javax.swing.GroupLayout PanExamsLayout = new javax.swing.GroupLayout(PanExams);
        PanExams.setLayout(PanExamsLayout);
        PanExamsLayout.setHorizontalGroup(
            PanExamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        PanExamsLayout.setVerticalGroup(
            PanExamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );

        PanFinance.setBackground(new java.awt.Color(204, 204, 204));

        feeTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feeTabMouseClicked(evt);
            }
        });

        tblFeeAll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane16.setViewportView(tblFeeAll);

        buttonGroup1.add(FinanceF1);
        FinanceF1.setText("Form 1");
        FinanceF1.setToolTipText("Class");
        FinanceF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinanceF1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(FinanceF2);
        FinanceF2.setText("Form 2");
        FinanceF2.setToolTipText("Class");
        FinanceF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinanceF2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(FinanceF3);
        FinanceF3.setText("Form 3");
        FinanceF3.setToolTipText("Class");
        FinanceF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinanceF3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(FinanceF4);
        FinanceF4.setText("Form 4");
        FinanceF4.setToolTipText("Class");
        FinanceF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinanceF4ActionPerformed(evt);
            }
        });

        jLabel12.setText("Class");

        javax.swing.GroupLayout feeTabStatementLayout = new javax.swing.GroupLayout(feeTabStatement);
        feeTabStatement.setLayout(feeTabStatementLayout);
        feeTabStatementLayout.setHorizontalGroup(
            feeTabStatementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
            .addGroup(feeTabStatementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(FinanceF1)
                .addGap(18, 18, 18)
                .addComponent(FinanceF2)
                .addGap(18, 18, 18)
                .addComponent(FinanceF3)
                .addGap(18, 18, 18)
                .addComponent(FinanceF4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        feeTabStatementLayout.setVerticalGroup(
            feeTabStatementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feeTabStatementLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(feeTabStatementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FinanceF1)
                    .addComponent(FinanceF2)
                    .addComponent(FinanceF3)
                    .addComponent(FinanceF4)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
        );

        feeTab.addTab("Fee Statement", feeTabStatement);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Sort By"));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Class", "Form 1", "Form 2", "Form 3", "Form 4" }));

        jLabel13.setText("Name");

        FinanceArrearsfindbyname.setToolTipText("");
        FinanceArrearsfindbyname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FinanceArrearsfindbynameKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FinanceArrearsfindbynameKeyReleased(evt);
            }
        });

        jLabel18.setText("Class");

        jLabel54.setText("Reg No.");

        FinanceArrearsfindbyreg.setToolTipText("");
        FinanceArrearsfindbyreg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FinanceArrearsfindbyregKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FinanceArrearsfindbyregKeyReleased(evt);
            }
        });

        feePrintArrears.setText("Print Table");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel13)
                .addGap(4, 4, 4)
                .addComponent(FinanceArrearsfindbyname, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel54)
                .addGap(2, 2, 2)
                .addComponent(FinanceArrearsfindbyreg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(feePrintArrears)
                .addGap(27, 27, 27))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(FinanceArrearsfindbyname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel54)
                        .addComponent(FinanceArrearsfindbyreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(feePrintArrears))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        tblFeeArrears.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane18.setViewportView(tblFeeArrears);

        javax.swing.GroupLayout feeArrearsLayout = new javax.swing.GroupLayout(feeArrears);
        feeArrears.setLayout(feeArrearsLayout);
        feeArrearsLayout.setHorizontalGroup(
            feeArrearsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feeArrearsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(feeArrearsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        feeArrearsLayout.setVerticalGroup(
            feeArrearsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feeArrearsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );

        feeTab.addTab("Arrears", feeArrears);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Search By"));

        jLabel16.setText("Class");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));

        jLabel20.setText("Balance Below");

        FeeBalanceBelow.setToolTipText("");
        FeeBalanceBelow.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FeeBalanceBelowKeyTyped(evt);
            }
        });

        jLabel21.setText("Paid Above");

        FeePaidAbove.setToolTipText("");
        FeePaidAbove.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FeePaidAboveKeyTyped(evt);
            }
        });

        FeeDepositFind.setText("Search");
        FeeDepositFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeeDepositFindActionPerformed(evt);
            }
        });

        feePrintDeposits.setText("Print");

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("Make Payment"));

        jLabel57.setText("Name");

        jLabel58.setText("Reg Number");

        feePayName.setToolTipText("");
        feePayName.setEnabled(false);

        feePayReg.setToolTipText("");
        feePayReg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                feePayRegKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                feePayRegKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                feePayRegKeyReleased(evt);
            }
        });

        jLabel60.setText("Class");

        jLabel61.setText("Amount");

        feePayAmount.setToolTipText("");
        feePayAmount.setEnabled(false);

        feePayClass.setToolTipText("");
        feePayClass.setEnabled(false);

        jLabel62.setText("Balance");

        feePayBal.setToolTipText("");
        feePayBal.setEnabled(false);

        jLabel63.setText("Paid");

        feePayPaid.setToolTipText("");
        feePayPaid.setEnabled(false);
        feePayPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feePayPaidPayPaidActionPerformed(evt);
            }
        });

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("New Payment");

        feePayNew.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        feePayNew.setToolTipText("");
        feePayNew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                feePayNewKeyTyped(evt);
            }
        });

        feeDepositPay.setText("Pay");
        feeDepositPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeDepositPayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(feePayNew, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel61)
                                    .addComponent(jLabel62)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel57))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(feePayName)
                                    .addComponent(feePayPaid)
                                    .addComponent(feePayBal)
                                    .addComponent(feePayAmount)
                                    .addComponent(feePayClass, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(feePayReg))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(0, 128, Short.MAX_VALUE)
                .addComponent(feeDepositPay)
                .addGap(86, 86, 86))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(feePayName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(feePayReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(feePayClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(feePayAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(feePayBal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel63)
                    .addComponent(feePayPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(feePayNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feeDepositPay)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(FeeDepositFind)
                .addGap(50, 50, 50)
                .addComponent(feePrintDeposits)
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(43, 43, 43)
                        .addComponent(FeePaidAbove))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FeeBalanceBelow))))
                .addContainerGap())
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(FeeBalanceBelow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(FeePaidAbove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FeeDepositFind)
                    .addComponent(feePrintDeposits))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblFeeSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblFeeSearch);

        javax.swing.GroupLayout feeTabDepositLayout = new javax.swing.GroupLayout(feeTabDeposit);
        feeTabDeposit.setLayout(feeTabDepositLayout);
        feeTabDepositLayout.setHorizontalGroup(
            feeTabDepositLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feeTabDepositLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE))
        );
        feeTabDepositLayout.setVerticalGroup(
            feeTabDepositLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
            .addGroup(feeTabDepositLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        feeTab.addTab("Deposits", feeTabDeposit);

        javax.swing.GroupLayout PanFinanceLayout = new javax.swing.GroupLayout(PanFinance);
        PanFinance.setLayout(PanFinanceLayout);
        PanFinanceLayout.setHorizontalGroup(
            PanFinanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(feeTab)
        );
        PanFinanceLayout.setVerticalGroup(
            PanFinanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(feeTab, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        PanMisc.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("misc");

        javax.swing.GroupLayout PanMiscLayout = new javax.swing.GroupLayout(PanMisc);
        PanMisc.setLayout(PanMiscLayout);
        PanMiscLayout.setHorizontalGroup(
            PanMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanMiscLayout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel1)
                .addContainerGap(567, Short.MAX_VALUE))
        );
        PanMiscLayout.setVerticalGroup(
            PanMiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanMiscLayout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(277, 277, 277))
        );

        PanAdmit.setBackground(new java.awt.Color(204, 204, 204));

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Assign Details"));

        jLabel10.setText("Assign Reg No");

        NwRegNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NwRegNoKeyTyped(evt);
            }
        });

        jLabel11.setText("Assign Form");

        RegAsBtn.setText("Re-Assign");
        RegAsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegAsBtnActionPerformed(evt);
            }
        });

        NwStdFrmSrm.setName(""); // NOI18N

        DpImgS.setLayer(DpImg, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DpImgSLayout = new javax.swing.GroupLayout(DpImgS);
        DpImgS.setLayout(DpImgSLayout);
        DpImgSLayout.setHorizontalGroup(
            DpImgSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DpImgSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DpImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DpImgSLayout.setVerticalGroup(
            DpImgSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DpImgSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DpImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        NwStdImg.setText("...");
        NwStdImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NwStdImgActionPerformed(evt);
            }
        });

        NwStdFrm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));
        NwStdFrm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NwStdFrmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImgP)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(DpImgS)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NwStdImg, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(NwRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(RegAsBtn))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(NwStdFrm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(NwStdFrmSrm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 195, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(NwRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegAsBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(NwStdFrmSrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NwStdFrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(DpImgS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImgP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NwStdImg)))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Guardian Details"));

        NwContacts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NwContactsKeyTyped(evt);
            }
        });

        jLabel15.setText("Contacts");

        jLabel17.setText("Guardian");

        jLabel19.setText("Residence");

        NwResidence.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kiambu", "Murang'a", "Nairobi", "Nyeri", "Nyandarua", "Nakuru", "Laikipia" }));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)
                            .addComponent(NwContacts, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(NwGuardian, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(NwResidence, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(NwGuardian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(NwContacts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(NwResidence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Ext.setText("View");
        Ext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtActionPerformed(evt);
            }
        });

        NwStdReg.setText("Add Student");
        NwStdReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NwStdRegActionPerformed(evt);
            }
        });

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Student Details"));

        jLabel22.setText("Full Name");

        jLabel23.setText("Surname");

        jLabel25.setText("Former Sch.");

        jLabel26.setText("KCPE Marks");

        NwKCPE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NwKCPEKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NwKCPEKeyReleased(evt);
            }
        });

        jLabel28.setText("Birth");

        NwBirthYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NwBirthYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NwFrmSch, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NwSurName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NwKCPE, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(NwFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(NwBirthYear, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(NwFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(NwSurName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(NwFrmSch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(NwKCPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(NwBirthYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NwStdReg)
                .addGap(34, 34, 34)
                .addComponent(Ext)
                .addGap(277, 277, 277))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ext)
                    .addComponent(NwStdReg))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanAdmitLayout = new javax.swing.GroupLayout(PanAdmit);
        PanAdmit.setLayout(PanAdmitLayout);
        PanAdmitLayout.setHorizontalGroup(
            PanAdmitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanAdmitLayout.setVerticalGroup(
            PanAdmitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PanTeacher.setBackground(new java.awt.Color(204, 204, 204));
        PanTeacher.setToolTipText("");

        Sett.setMinimumSize(new java.awt.Dimension(967, 594));
        Sett.setName(""); // NOI18N

        Nxt.setText("Next ->");
        Nxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NxtActionPerformed(evt);
            }
        });

        jLabel32.setText("Classes");

        buttonGroup5.add(Cbf1);
        Cbf1.setText("Form 1");

        buttonGroup5.add(Cbf2);
        Cbf2.setText("Form 2");

        buttonGroup5.add(Cbf3);
        Cbf3.setText("Form 3");

        buttonGroup5.add(Cbf4);
        Cbf4.setText("Form 4");

        jLabel27.setText("Exam");

        TeachCurrentExanm.setEnabled(false);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Select A Class To Populate the Marks Student got");

        javax.swing.GroupLayout SettLayout = new javax.swing.GroupLayout(Sett);
        Sett.setLayout(SettLayout);
        SettLayout.setHorizontalGroup(
            SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettLayout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(Nxt, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SettLayout.createSequentialGroup()
                        .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(SettLayout.createSequentialGroup()
                                .addComponent(Cbf1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Cbf2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Cbf3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Cbf4))
                            .addComponent(TeachCurrentExanm, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(304, Short.MAX_VALUE))
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SettLayout.setVerticalGroup(
            SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TeachCurrentExanm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbf1)
                    .addComponent(Cbf2)
                    .addComponent(Cbf3)
                    .addComponent(Cbf4))
                .addGap(69, 69, 69)
                .addComponent(Nxt)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        Senr.setToolTipText("");
        Senr.setPreferredSize(new java.awt.Dimension(967, 594));

        jLabel79.setText("Form");

        jLabel80.setText("Stream");
        jLabel80.setEnabled(false);

        FrmSenrAdd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 3", "Form 4" }));
        FrmSenrAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrmSenrAddActionPerformed(evt);
            }
        });

        StrmSenrAdd.setEnabled(false);

        jLabel81.setText("Subject");

        SbjSenrChus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Subject--", "Math.Eng.Kiswa", "Chemistry", "Biology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business" }));
        SbjSenrChus.setToolTipText("");
        SbjSenrChus.setName(""); // NOI18N

        SncSenr.setText("Sync");
        SncSenr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SncSenrActionPerformed(evt);
            }
        });

        tblSnrAdd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(tblSnrAdd);

        tblSenrMarkList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(tblSenrMarkList);

        InsrtSenr.setText("Add");
        InsrtSenr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsrtSenrActionPerformed(evt);
            }
        });

        BacSett.setText("Back");
        BacSett.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BacSettActionPerformed(evt);
            }
        });

        jLabel82.setText("Exam");

        ExamBay.setEnabled(false);
        ExamBay.setName(""); // NOI18N

        javax.swing.GroupLayout SenrLayout = new javax.swing.GroupLayout(Senr);
        Senr.setLayout(SenrLayout);
        SenrLayout.setHorizontalGroup(
            SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SenrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SenrLayout.createSequentialGroup()
                        .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(SenrLayout.createSequentialGroup()
                                .addComponent(jLabel79)
                                .addGap(29, 29, 29)
                                .addComponent(FrmSenrAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel80))
                            .addGroup(SenrLayout.createSequentialGroup()
                                .addComponent(jLabel81)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SbjSenrChus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)))
                        .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SncSenr)
                            .addGroup(SenrLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(StrmSenrAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel82)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ExamBay, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(142, Short.MAX_VALUE))
                    .addGroup(SenrLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BacSett)
                            .addComponent(InsrtSenr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE))))
        );
        SenrLayout.setVerticalGroup(
            SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SenrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(FrmSenrAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80)
                    .addComponent(StrmSenrAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82)
                    .addComponent(ExamBay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SenrLayout.createSequentialGroup()
                        .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(SbjSenrChus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SncSenr))
                        .addGroup(SenrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SenrLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SenrLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(InsrtSenr)
                                .addGap(39, 39, 39)
                                .addComponent(BacSett)
                                .addGap(23, 23, 23))))
                    .addComponent(jScrollPane10))
                .addContainerGap())
        );

        Marks.setToolTipText("");
        Marks.setMinimumSize(new java.awt.Dimension(967, 594));

        Pg0.setBackground(new java.awt.Color(204, 204, 204));
        Pg0.setMinimumSize(new java.awt.Dimension(1000, 392));

        jScrollPane9.setPreferredSize(new java.awt.Dimension(1238, 468));

        tblLowerMarks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(tblLowerMarks);

        Ada.setText("Commit Changes");
        Ada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdaActionPerformed(evt);
            }
        });

        Rsh.setText("Refresh");
        Rsh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RshActionPerformed(evt);
            }
        });

        Bcer.setText("Back");
        Bcer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcerActionPerformed(evt);
            }
        });

        Graphyy.setText("View Graphs");
        Graphyy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphyyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Pg0Layout = new javax.swing.GroupLayout(Pg0);
        Pg0.setLayout(Pg0Layout);
        Pg0Layout.setHorizontalGroup(
            Pg0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(Pg0Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(Ada)
                .addGap(27, 27, 27)
                .addComponent(Rsh)
                .addGap(18, 18, 18)
                .addComponent(Bcer)
                .addGap(18, 18, 18)
                .addComponent(Graphyy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pg0Layout.setVerticalGroup(
            Pg0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pg0Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pg0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ada)
                    .addComponent(Rsh)
                    .addComponent(Bcer)
                    .addComponent(Graphyy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MarksLayout = new javax.swing.GroupLayout(Marks);
        Marks.setLayout(MarksLayout);
        MarksLayout.setHorizontalGroup(
            MarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pg0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MarksLayout.setVerticalGroup(
            MarksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pg0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanTeacherLayout = new javax.swing.GroupLayout(PanTeacher);
        PanTeacher.setLayout(PanTeacherLayout);
        PanTeacherLayout.setHorizontalGroup(
            PanTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
            .addGroup(PanTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Marks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Senr, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE))
            .addGroup(PanTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Sett, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanTeacherLayout.setVerticalGroup(
            PanTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(PanTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Marks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Senr, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE))
            .addGroup(PanTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Sett, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanAdmin.setBackground(new java.awt.Color(204, 204, 204));

        jTabbedPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane4MouseClicked(evt);
            }
        });

        jLabel34.setText("Classes");

        jLabel38.setText("Term");

        jLabel35.setText("Exam Type");

        jLabel36.setText("Year");

        ExxamTY1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CATS", "Mid_Term", "End_Term" }));

        buttonGroup2.add(Tr4);
        Tr4.setText("Term 1");
        Tr4.setToolTipText("Term Of Interest");

        buttonGroup2.add(Tr5);
        Tr5.setText("Term 2");
        Tr5.setToolTipText("Term Of Interest");

        buttonGroup2.add(Tr6);
        Tr6.setText("Term 3");
        Tr6.setToolTipText("Term Of Interest");

        Cbf5.setSelected(true);
        Cbf5.setText("Form 1");
        Cbf5.setEnabled(false);

        Cbf6.setSelected(true);
        Cbf6.setText("Form 2");
        Cbf6.setEnabled(false);

        Cbf7.setSelected(true);
        Cbf7.setText("Form 3");
        Cbf7.setEnabled(false);

        Cbf8.setSelected(true);
        Cbf8.setText("Form 4");
        Cbf8.setEnabled(false);

        RstCont.setText("Reset");
        RstCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RstContActionPerformed(evt);
            }
        });

        SetCont.setText("Set");
        SetCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetContActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("LM Sans 10", 1, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Exams and Tests Allocation Section");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ExxamTY1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YBx1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(Cbf5)
                                .addGap(18, 18, 18)
                                .addComponent(Cbf6)
                                .addGap(18, 18, 18)
                                .addComponent(Cbf7)
                                .addGap(18, 18, 18)
                                .addComponent(Cbf8))
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(Tr4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(Tr5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Tr6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel38)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(SetCont)
                        .addGap(41, 41, 41)
                        .addComponent(RstCont)))
                .addContainerGap(541, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YBx1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExxamTY1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(Tr4)
                    .addComponent(Tr5)
                    .addComponent(Tr6))
                .addGap(23, 23, 23)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbf5)
                    .addComponent(Cbf6)
                    .addComponent(Cbf7)
                    .addComponent(Cbf8))
                .addGap(76, 76, 76)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RstCont)
                    .addComponent(SetCont))
                .addContainerGap(263, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Add Tables", jPanel20);

        Classe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3" }));
        Classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClasseActionPerformed(evt);
            }
        });

        jLabel39.setText("Form");

        jLabel40.setText("Action");

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Select Student To Transfer To Next Class");
        jLabel41.setToolTipText("All Student Carried to Next are Above Passmark");

        ComBin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proceed", "Repeat", "Default" }));
        ComBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComBinActionPerformed(evt);
            }
        });

        TrnCls.setText("Affirm");
        TrnCls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrnClsActionPerformed(evt);
            }
        });

        eXA.setEditable(false);

        jLabel86.setText("Stream");
        jLabel86.setEnabled(false);

        StrNxt.setEnabled(false);
        StrNxt.setName(""); // NOI18N
        StrNxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StrNxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Classe, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StrNxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComBin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eXA, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TrnCls)
                .addContainerGap())
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(ComBin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eXA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TrnCls)
                    .addComponent(jLabel86)
                    .addComponent(StrNxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Leva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(Leva);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Transfers", jPanel21);

        jPanel34.setEnabled(false);
        jPanel34.setRequestFocusEnabled(false);
        jPanel34.setVerifyInputWhenFocusTarget(false);

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder("Class Streams"));

        jLabel45.setText("Add Classes To Interact With");

        SCls.setText("Set Classes");
        SCls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SClsActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(jTable2);

        jLabel8.setText("Stream Name");

        jRadioButton1.setText("Form 1");

        jRadioButton2.setText("Form 2");

        jRadioButton3.setText("Form 3");

        jRadioButton4.setText("Form 4");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45)
                .addGap(93, 93, 93)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(SCls, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(55, 55, 55))
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(SCls)
                .addContainerGap(331, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Streams", jPanel35);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6)
        );

        jTabbedPane4.addTab("Variables", jPanel34);

        jLabel73.setText("Form");

        FormGrad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));

        jLabel74.setText("SubJect");

        SubGrad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Subjects", "Mathematics", "English", "Kiswahili", "Chemistry", "Biology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business" }));
        SubGrad.setEnabled(false);

        jLabel75.setText("Grade");

        GradIt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "E" }));

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder("Grade Range"));

        jLabel76.setText("Highest Range");

        jLabel77.setText("Lowest Amount");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Hrange, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(Lrange, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jLabel77)
                    .addComponent(Hrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder("Grade Comment"));

        jLabel78.setText("Comment");

        CommBox.setColumns(20);
        CommBox.setRows(5);
        jScrollPane7.setViewportView(CommBox);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder("Grading Report"));

        GraBox.setColumns(20);
        GraBox.setRows(5);
        GraBox.setEnabled(false);
        jScrollPane11.setViewportView(GraBox);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11)
        );

        GrdSett.setText("Submit");
        GrdSett.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrdSettActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addGap(26, 26, 26)
                        .addComponent(FormGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel74)
                        .addGap(31, 31, 31)
                        .addComponent(SubGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                        .addComponent(GrdSett)
                        .addGap(88, 88, 88)))
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(GradIt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 321, Short.MAX_VALUE))
                    .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(FormGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(SubGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75)
                    .addComponent(GradIt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(GrdSett)
                        .addContainerGap(214, Short.MAX_VALUE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jTabbedPane4.addTab("Grading", jPanel41);

        tblFee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblFee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFeeMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tblFee);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Object Name");

        FeeObject.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Object Fee");

        FeeAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FeeAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FeeAmountKeyTyped(evt);
            }
        });

        FeeObjectAdd.setText("Add");
        FeeObjectAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeeObjectAddActionPerformed(evt);
            }
        });

        FeeObjectEdit.setText("Edit");
        FeeObjectEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeeObjectEditActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Comment");

        FeeComment.setColumns(20);
        FeeComment.setRows(5);
        jScrollPane14.setViewportView(FeeComment);

        FeeObjectDelete.setText("Delete");
        FeeObjectDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeeObjectDeleteActionPerformed(evt);
            }
        });

        jLabel9.setText("Class");

        FeeClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Form 1", "Form 2", "Form 3", "Form 4", "All" }));
        FeeClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeeClassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FeeObject)
            .addComponent(FeeAmount)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(FeeObjectEdit)
                                .addGap(18, 18, 18)
                                .addComponent(FeeObjectAdd)
                                .addGap(18, 18, 18)
                                .addComponent(FeeObjectDelete))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FeeClass, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FeeObject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FeeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(FeeClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FeeObjectAdd)
                    .addComponent(FeeObjectEdit)
                    .addComponent(FeeObjectDelete))
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Fee Statement", jPanel7);

        javax.swing.GroupLayout PanAdminLayout = new javax.swing.GroupLayout(PanAdmin);
        PanAdmin.setLayout(PanAdminLayout);
        PanAdminLayout.setHorizontalGroup(
            PanAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        PanAdminLayout.setVerticalGroup(
            PanAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout AllLayout = new javax.swing.GroupLayout(All);
        All.setLayout(AllLayout);
        AllLayout.setHorizontalGroup(
            AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanLogs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanStudents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanExams, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanFinance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanMisc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanAdmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AllLayout.setVerticalGroup(
            AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanLogs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanStudents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanExams, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanFinance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanMisc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanAdmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(All, java.awt.BorderLayout.CENTER);

        Head.setBackground(new java.awt.Color(204, 204, 204));
        Head.setMinimumSize(new java.awt.Dimension(1050, 40));
        Head.setName(""); // NOI18N
        Head.setPreferredSize(new java.awt.Dimension(1050, 40));

        MnAddStd.setBackground(new java.awt.Color(255, 102, 102));
        MnAddStd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/user-new-3.png"))); // NOI18N
        MnAddStd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MnAddStdMouseClicked(evt);
            }
        });

        MnStd.setBackground(new java.awt.Color(255, 102, 102));
        MnStd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/family.png"))); // NOI18N
        MnStd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MnStdMouseClicked(evt);
            }
        });

        MnExams.setBackground(new java.awt.Color(255, 102, 102));
        MnExams.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/mail-new.png"))); // NOI18N
        MnExams.setToolTipText("");
        MnExams.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MnExamsMouseClicked(evt);
            }
        });

        MnGraphs.setBackground(new java.awt.Color(255, 102, 102));
        MnGraphs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/office-chart-area-percentage.png"))); // NOI18N
        MnGraphs.setToolTipText("Reports");
        MnGraphs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MnGraphsMouseClicked(evt);
            }
        });

        MnCharts.setBackground(new java.awt.Color(255, 102, 102));
        MnCharts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/office-chart-pie.png"))); // NOI18N
        MnCharts.setToolTipText("Charts");
        MnCharts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MnChartsMouseClicked(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 102, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Logged In As -> Name()");

        Exitt.setBackground(new java.awt.Color(255, 102, 102));
        Exitt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/system-log-out-3.png"))); // NOI18N
        Exitt.setToolTipText("Log Out");
        Exitt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExittMouseClicked(evt);
            }
        });

        Homie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/go-home-4.png"))); // NOI18N
        Homie.setToolTipText("Home");
        Homie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomieMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout HeadLayout = new javax.swing.GroupLayout(Head);
        Head.setLayout(HeadLayout);
        HeadLayout.setHorizontalGroup(
            HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MnAddStd)
                .addGap(18, 18, 18)
                .addComponent(MnStd)
                .addGap(18, 18, 18)
                .addComponent(MnExams)
                .addGap(18, 18, 18)
                .addComponent(MnGraphs)
                .addGap(18, 18, 18)
                .addComponent(MnCharts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 531, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Homie)
                .addGap(18, 18, 18)
                .addComponent(Exitt))
        );
        HeadLayout.setVerticalGroup(
            HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MnAddStd, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(MnStd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MnExams, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MnGraphs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Exitt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Homie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MnCharts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(Head, java.awt.BorderLayout.PAGE_START);

        Tail.setBackground(new java.awt.Color(204, 204, 204));
        Tail.setMinimumSize(new java.awt.Dimension(1050, 30));
        Tail.setName(""); // NOI18N
        Tail.setPreferredSize(new java.awt.Dimension(1050, 30));

        javax.swing.GroupLayout TailLayout = new javax.swing.GroupLayout(Tail);
        Tail.setLayout(TailLayout);
        TailLayout.setHorizontalGroup(
            TailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        TailLayout.setVerticalGroup(
            TailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(Tail, java.awt.BorderLayout.PAGE_END);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        mnStudents.setText("Students");
        jMenuBar1.add(mnStudents);

        mnStaff.setText("Staff");
        jMenuBar1.add(mnStaff);

        mnReports.setText("Reports");
        jMenuBar1.add(mnReports);

        mnMisc.setText("Others");
        jMenuBar1.add(mnMisc);

        mnHelp.setText("Help");
        jMenuBar1.add(mnHelp);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
        // TODO add your handling code here:  
        KillAll();
        Labo(2);
        PanHome.setVisible(true);
        //Logme();

    }//GEN-LAST:event_BtnLoginActionPerformed

    private void HmNewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmNewStudentActionPerformed
        // TODO add your handling code here:
        KillAll();
        PrepNewStd();
        Hoppa();
        PanAdmit.setVisible(true);
    }//GEN-LAST:event_HmNewStudentActionPerformed

    private void HmTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmTeacherActionPerformed
        // TODO add your handling code here:
        KillAll();
        CallTeacher(1);
        PopTeacher();
        PanTeacher.setVisible(true);
    }//GEN-LAST:event_HmTeacherActionPerformed

    private void HmStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmStudentsActionPerformed
        // TODO add your handling code here:
        KillAll();
        PopStd();
        PanStudents.setVisible(true);
    }//GEN-LAST:event_HmStudentsActionPerformed

    private void HmExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmExamActionPerformed
        // TODO add your handling code here:
        KillAll();
        PopExam();
        PanExams.setVisible(true);
    }//GEN-LAST:event_HmExamActionPerformed

    private void HmReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmReportsActionPerformed
        // TODO add your handling code here:
        KillAll();
        PanReports.setVisible(true);
        Nm();
        RepoEX.removeAllItems();
        RepoEX.addItem(lst);
        RepoEX.setSelectedItem(lst);
    }//GEN-LAST:event_HmReportsActionPerformed

    private void HmFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmFeeActionPerformed
        // TODO add your handling code here:
        KillAll();
        PopFinace();
        PanFinance.setVisible(true);
    }//GEN-LAST:event_HmFeeActionPerformed

    private void HmAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmAdminActionPerformed
        // TODO add your handling code here:
        KillAll();
        PopFee();
        PopAdmin();
        PanAdmin.setVisible(true);
    }//GEN-LAST:event_HmAdminActionPerformed

    private void ExittMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExittMouseClicked
        // TODO add your handling code here:
        KillAll();
        Labo(1);
        PanLogs.setVisible(true);
        
        islogged=false;
        
        VarUsername=null;
        
        PanLogUsername.setText(null);
        PanLogPassword.setText(null);
        
    }//GEN-LAST:event_ExittMouseClicked

    private void HomieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomieMouseClicked
        // TODO add your handling code here:
        KillAll();
        PanHome.setVisible(true);
    }//GEN-LAST:event_HomieMouseClicked

    private void MnAddStdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnAddStdMouseClicked
        // TODO add your handling code here:
        if (islogged) {
            KillAll();
            PanAdmit.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Log in first to access this resource","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_MnAddStdMouseClicked

    private void MnStdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnStdMouseClicked
        // TODO add your handling code here:
        if (islogged) {
            KillAll();
            PanStudents.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Log in first to access this resource","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_MnStdMouseClicked

    private void MnExamsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnExamsMouseClicked
        // TODO add your handling code here:
        if (islogged) {
            KillAll();
            PanMisc.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Log in first to access this resource","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_MnExamsMouseClicked

    private void MnGraphsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnGraphsMouseClicked
        // TODO add your handling code here:
        if (islogged) {
            KillAll();
            PanReports.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Log in first to access this resource","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_MnGraphsMouseClicked

    private void MnChartsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnChartsMouseClicked
        // TODO add your handling code here:
        if (islogged) {
            KillAll();
            PanReports.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Log in first to access this resource","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_MnChartsMouseClicked

    private void NwKCPEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NwKCPEKeyTyped
        // TODO add your handling code here:
        char cc=evt.getKeyChar();
        if(!(Character.isDigit(cc) || cc==KeyEvent.VK_BACK_SPACE || cc==KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_NwKCPEKeyTyped

    private void NwKCPEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NwKCPEKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NwKCPEKeyReleased

    private void NwBirthYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NwBirthYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NwBirthYearActionPerformed

    private void NwRegNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NwRegNoKeyTyped
        // TODO add your handling code here:
        char cc=evt.getKeyChar();
        if(!(Character.isDigit(cc) || cc==KeyEvent.VK_BACK_SPACE || cc==KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_NwRegNoKeyTyped

    private void RegAsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegAsBtnActionPerformed
        // TODO add your handling code here:
        Hoppa();
    }//GEN-LAST:event_RegAsBtnActionPerformed

    private void NwStdImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NwStdImgActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser prip=new JFileChooser();
            FileFilter flft=new FileNameExtensionFilter("Images Only", new String []{"jpg","png","jpeg"});

            prip.setFileFilter(flft);
            prip.addChoosableFileFilter(flft);
            int rtn=prip.showOpenDialog(null);

            if (rtn==JFileChooser.APPROVE_OPTION) {
                File f= new File(prip.getSelectedFile().getAbsolutePath());//prip.getSelectedFile();
                Patt=f.getAbsolutePath();
                ImgP.setText(Patt);

                ImageIcon stV=new ImageIcon(Patt);
                Image Sd=stV.getImage().getScaledInstance(DpImg.getWidth(),DpImg.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon im=new ImageIcon(Sd);
                DpImg.setIcon(im);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Null or Invalid 'Image' File");
        }
    }//GEN-LAST:event_NwStdImgActionPerformed

    private void NwStdFrmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NwStdFrmActionPerformed
        // TODO add your handling code here:
        if (NwStdFrm.getSelectedIndex()==0) {
            ClStr="Form 1";
            NwStdFrmSrm.removeAllItems();
            Str();
        }
        if (NwStdFrm.getSelectedIndex()==1) {
            ClStr="Form 2";
            NwStdFrmSrm.removeAllItems();
            Str();
        }
        if (NwStdFrm.getSelectedIndex()==2) {
            ClStr="Form 3";
            NwStdFrmSrm.removeAllItems();
            Str();
        }
        if (NwStdFrm.getSelectedIndex()==3) {
            ClStr="Form 4";
            NwStdFrmSrm.removeAllItems();
            Str();
        }
    }//GEN-LAST:event_NwStdFrmActionPerformed

    private void NwContactsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NwContactsKeyTyped
        // TODO add your handling code here:
        char cc=evt.getKeyChar();
        if(!(Character.isDigit(cc) || cc==KeyEvent.VK_BACK_SPACE || cc==KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_NwContactsKeyTyped

    private void NwStdRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NwStdRegActionPerformed
        // TODO add your handling code here:
        RegNwStd();
    }//GEN-LAST:event_NwStdRegActionPerformed

    private void ExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtActionPerformed
        // TODO add your handling code here:
        KillAll();
        PopStd();
        PanStudents.setVisible(true);
    }//GEN-LAST:event_ExtActionPerformed

    private void GraphBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphBarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tts=(DefaultTableModel) RepoTbl.getModel();
        int reg=Integer.parseInt(RepoTbl.getValueAt(RepoTbl.getSelectedRow(), 1).toString()) ;
        Gen_Charts genc= new Gen_Charts();
        genc.MakeBar(reg);
    }//GEN-LAST:event_GraphBarActionPerformed

    private void GraphLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphLineActionPerformed
        // TODO add your handling code here:
        Nm();
        DefaultTableModel tts=(DefaultTableModel) RepoTbl.getModel();
        int reg=Integer.parseInt(RepoTbl.getValueAt(RepoTbl.getSelectedRow(), 1).toString()) ;
        Gen_Charts genc= new Gen_Charts();
        genc.MakeLine(reg);
    }//GEN-LAST:event_GraphLineActionPerformed

    private void VwCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VwCredActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, lst);
        Nm();
        String csa=null,sq=null;
        if (RepoClas.getSelectedIndex()==0) {
            csa="Form 1";
        }
        if (RepoClas.getSelectedIndex()==1) {
            csa="Form 2";
        }
        if (RepoClas.getSelectedIndex()==02) {
            csa="Form 3";
        }
        if (RepoClas.getSelectedIndex()==03) {
            csa="Form 4";
        }
        try {
            String locc="/media/niccher/Bookies/Ap/Coding Theory/3/MrkFinal/src/mrkfinal/ClassAll.jrxml";
            JasperDesign jd=JRXmlLoader.load(locc);
            //lst="Name Class Reg_No Mathematics English Kiswahili Chemistry Biology Physics Geography History CRE Business Agriculture";
            sq="SELECT Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,History,CRE,Business,Agriculture FROM "+lst+" WHERE Class="+csa+" ";
            JRDesignQuery nq=new JRDesignQuery();
            nq.setText(sq);
            jd.setQuery(nq);
            JasperReport jas=JasperCompileManager.compileReport(jd);
            JasperPrint jprn=JasperFillManager.fillReport(jas, null, Conn);
            JasperViewer.viewReport(jprn,Boolean.FALSE);
        } catch (Exception e) {
            System.out.println(e+" \nVwCredActionPerformed");
        }
    }//GEN-LAST:event_VwCredActionPerformed

    private void SyncRepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SyncRepoActionPerformed
        // TODO add your handling code here:
        String et,fll,trm;
        
        Nm();
        
        Tbll=lst;
        String pc=null;
        RepoEX.addItem(lst);

        if (RepoClas.getSelectedIndex()==0) {
            pc="Form 1";
        }
        if (RepoClas.getSelectedIndex()==1) {
            pc="Form 2";
        }
        if (RepoClas.getSelectedIndex()==2) {
            pc="Form 3";
        }
        if (RepoClas.getSelectedIndex()==3) {
            pc="Form 4";
        }


        if (pc=="Form 3" || pc=="Form 4") {
            try {
                Makeit();
                String cops="SELECT Name,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,History,Business,Agriculture FROM "+Tbll+" WHERE (`Class`='"+pc+"' )";
                pst=Conn.prepareStatement(cops);
                rs=pst.executeQuery();
                RepoTbl.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e+" SyncRepoActionPerformed 1");
            }

        }else{
            try {
                String cops="SELECT Name,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,History,Business,Agriculture FROM "+Tbll+" WHERE (`Class`='"+pc+"' )";
                pst=Conn.prepareStatement(cops);
                rs=pst.executeQuery();
                RepoTbl.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e+" SyncRepoActionPerformed 2");
            }
        }
    }//GEN-LAST:event_SyncRepoActionPerformed

    private void WannaBeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WannaBeActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tts=(DefaultTableModel) RepoTbl.getModel();
        int reg=Integer.parseInt(RepoTbl.getValueAt(RepoTbl.getSelectedRow(), 1).toString()) ;
        String stfnam=(RepoTbl.getValueAt(RepoTbl.getSelectedRow(), 0).toString()) ;
        try {
            String locc="/media/niccher/Bookies/Ap/Coding Theory/3/MrkFinal/src/mrkfinal/StudentSlip.jrxml";
            JasperDesign jd=JRXmlLoader.load(locc);
            //lst="Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,History,CRE,Business,Agriculture";
            String sq="SELECT * FROM "+lst+", tbl_Students, tbl_Tests WHERE "+lst+".`Reg_No`="+reg+" AND tbl_Students.`Reg_No`="+reg+" AND tbl_Tests.`Count` = ( SELECT MAX(`Count`) FROM `tbl_Tests`) ";
            //System.out.println(" Query "+ sq);
            JRDesignQuery nq=new JRDesignQuery();
            nq.setText(sq);
            jd.setQuery(nq);//
            JasperReport jas=JasperCompileManager.compileReport(jd);
            JasperPrint jprn=JasperFillManager.fillReport(jas, null, Conn);
            JasperViewer.viewReport(jprn,Boolean.FALSE);

            String jrpdf="/media/niccher/Bookies/Ap/Coding Theory/3/MrkFinal/"+stfnam+".pdf";
            JRExporter exp=new JRPdfExporter();
            exp.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, jrpdf);
            exp.setParameter(JRExporterParameter.JASPER_PRINT, jprn);
            exp.exportReport();
        } catch (Exception e) {
            System.out.println(e+" WannaBe");
        }
    }//GEN-LAST:event_WannaBeActionPerformed

    private void RstContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RstContActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RstContActionPerformed

    private void SetContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetContActionPerformed
        // TODO add your handling code here:        
        if (Tr4.isSelected()) {
            Tem="Term1";
        }
        else if (Tr5.isSelected()) {
            Tem="Term2";
        }
        else if (Tr6.isSelected()) {
            Tem="Term3";
        }
        
        int t=Integer.parseInt((String) YBx1.getSelectedItem());
        String tty1=((String) ExxamTY1.getSelectedItem().toString());

            cs=t+"_"+tty1+"_"+Tem;
            try{
                String Std="CREATE TABLE IF NOT EXISTS `"+cs+"` (`Count` int(3) NOT NULL AUTO_INCREMENT,`Name` varchar(50) NOT NULL,`Class` VARCHAR(8) NOT NULL,"
                + "`Reg_No` int(10) NOT NULL,`Mathematics` float NOT NULL DEFAULT '0',`English` float NOT NULL DEFAULT '0',"
                + "`Kiswahili` float NOT NULL DEFAULT '0',`Chemistry` float NOT NULL DEFAULT '0',`Biology` float NOT NULL DEFAULT '0',"
                + "`Physics` float NOT NULL DEFAULT '0',`Geography` float NOT NULL DEFAULT '0',`History` float NOT NULL DEFAULT '0',"
                + "`CRE` float NOT NULL DEFAULT '0',`Business` float NOT NULL DEFAULT '0',`Agriculture` float NOT NULL DEFAULT '0',"
                + "PRIMARY KEY (Reg_No),UNIQUE (`Count`) )";

                PreparedStatement pst1 = Conn.prepareStatement(Std);
                pst1.execute();

                Filla();

                JOptionPane.showMessageDialog(null,cs+" Table Building Sucesfull");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex+"\n SetContActionPerformed");
                //F1Log.setText("Failed");
            }

        try {
            String Puz4="INSERT INTO `tbl_Tests` (`Count`, `Test`) VALUES (NULL, '"+cs+"' )";
            PreparedStatement pstf4 = (PreparedStatement) Conn.prepareStatement(Puz4);
            pstf4.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e+"\n SetContActionPerformed 2 ");
        }
    }//GEN-LAST:event_SetContActionPerformed

    private void ClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClasseActionPerformed
        // TODO add your handling code here:
        Nm();
        if (Classe.getSelectedIndex()==0) {
            StrNx("Form 1");
        }
        if (Classe.getSelectedIndex()==1) {
            StrNx("Form 2");
        }
        if (Classe.getSelectedIndex()==2) {
            StrNx("Form 3");
        }
    }//GEN-LAST:event_ClasseActionPerformed

    private void ComBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComBinActionPerformed
        // TODO add your handling code here:
        Nm();
        
        int Mathpass=0,Engpass=0,Kiswapass=0,Chempass=0,Biopass=0,Phypass=0,Histpass=0,Geopass=0,CREpass=0,Agricpass=0,Buspass=0;
        int Mathfail=0,Engfail=0,Kiswafail=0,Chemfail=0,Biofail=0,Phyfail=0,Histfail=0,Geofail=0,CREfail=0,Agricfail=0,Busfail=0;
        String TrmSdy=null,EmTy=null;
        int Yer=cc.get(Calendar.YEAR);

        if (Classe.getSelectedIndex()==0) {
            tbl="Form 1";
        }if(Classe.getSelectedIndex()==1){
            tbl="Form 2";
        }if(Classe.getSelectedIndex()==2){
            tbl="Form 3";
        }if(Classe.getSelectedIndex()==3){
            tbl="Form 4";
        }

        if (eXA.getText().contains("Term1")) {
            TrmSdy="Term 1";
        }
        if (eXA.getText().contains("Term2")) {
            TrmSdy="Term 2";
        }
        if (eXA.getText().contains("Term3")) {
            TrmSdy="Term 3";
        }

        if (eXA.getText().contains("CATS")) {
            EmTy="CATS";
        }
        if (eXA.getText().contains("Mid")) {
            EmTy="Mid";
        }
        if (eXA.getText().contains("End")) {
            EmTy="End";
        }
        
        if(ComBin.getSelectedIndex()==0) {
            try {
                String sav="SELECT * FROM `tbl_MarkP`  WHERE `Year`= '"+Yer+"' AND `Term`='"+TrmSdy+"' AND `EXAM`= '"+EmTy+"'";
                pst=(PreparedStatement) Conn.prepareStatement(sav);
                rs=pst.executeQuery();
                if (rs.next()) {
                    Mathpass=rs.getInt("Mathematics");
                    Engpass=rs.getInt("English");
                    Kiswapass=rs.getInt("Kiswahili");
                    Chempass=rs.getInt("Chemistry");
                    Biopass=rs.getInt("Biology");
                    Phypass=rs.getInt("Physics");
                    Histpass=rs.getInt("History");
                    Geopass=rs.getInt("Geography");
                    CREpass=rs.getInt("CRE");
                    Agricpass=rs.getInt("Agriculture");
                    Buspass=rs.getInt("Business");
                }

                    String Sq="SELECT `Name`,`Reg_No`,`Mathematics`,`English`,`Kiswahili`,`Chemistry`,`Biology`,`Physics`,`History`,`Geography`,`CRE`,`Agriculture`,`Business` FROM `"+lst+"` WHERE `Class`='"+tbl+"' AND `Mathematics`>='"+Mathpass+"' AND `English`>='"+Engpass+"' AND `Kiswahili`>='"+Kiswapass+"' AND `Chemistry`>='"+Chempass+"' AND `Biology` >='"+Biopass+"' AND `Physics`>='"+Phypass+"' AND `History`>='"+Histpass+"' AND `Geography`>='"+Geopass+"' AND `CRE`>='"+CREpass+"' AND `Agriculture`>='"+Agricpass+"' AND `Business`>='"+Buspass+"' ";
                    pst=Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                    
            } catch (Exception e) {
                System.out.println(e+ "\n ComBinActionPerformed 1 Pass  table"+tbl);
            }
        }
        
        if(ComBin.getSelectedIndex()==1) {
            try {
                String sav="SELECT * FROM `tbl_MarkF`  WHERE `Year`= '"+Yer+"' AND `Term`='"+TrmSdy+"' AND `EXAM`= '"+EmTy+"'";
                pst=Conn.prepareStatement(sav);
                rs=pst.executeQuery();
                if (rs.next()) {
                    Mathfail=rs.getInt("Mathematics");
                    Engfail=rs.getInt("English");
                    Kiswafail=rs.getInt("Kiswahili");
                    Chemfail=rs.getInt("Chemistry");
                    Biofail=rs.getInt("Biology");
                    Phyfail=rs.getInt("Physics");
                    Histfail=rs.getInt("History");
                    Geofail=rs.getInt("Geography");
                    CREfail=rs.getInt("CRE");
                    Agricfail=rs.getInt("Agriculture");
                    Busfail=rs.getInt("Business");
                }

                    String Sq="SELECT `Name`,`Reg_No`,`Mathematics`,`English`,`Kiswahili`,`Chemistry`,`Biology`,`Physics`,`History`,`Geography`,`CRE`,`Agriculture`,`Business` FROM `"+lst+"` WHERE `Class`='"+tbl+"' AND `Mathematics`<='"+Mathfail+"' AND `English`<='"+Engfail+"' AND `Kiswahili`<='"+Kiswafail+"' AND `Chemistry`<='"+Chemfail+"' AND `Biology` <='"+Biofail+"' AND `Physics`<='"+Phyfail+"' AND `History`<='"+Histfail+"' AND `Geography`<='"+Geofail+"' AND `CRE`<='"+CREfail+"' AND `Agriculture`<='"+Agricfail+"' AND `Business`<='"+Busfail+"' ";
                    pst=Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                    
            } catch (Exception e) {
                System.out.println(e+ "\n ComBinActionPerformed 2 Fail  table"+tbl);
            }
        }
        
        if (ComBin.getSelectedIndex()==3 ) {
            try {
                String Sq="SELECT Name,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,History,Geography,CRE,Agriculture,Business FROM `"+lst+"` WHERE `Class`='"+tbl+"' ";
                pst=Conn.prepareStatement(Sq);
                rs=pst.executeQuery();
                Leva.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e+ "\n ComBinActionPerformed 3 Passed All  table"+tbl);
            }
        }
    }//GEN-LAST:event_ComBinActionPerformed

    private void TrnClsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrnClsActionPerformed
        // TODO add your handling code here:
        int aigana=Leva.getSelectedRowCount(),ndari=0,regpass=0;
        String newcls=null;
        if (Classe.getSelectedIndex()==0){
            newcls="Form 2";
        }
        if (Classe.getSelectedIndex()==1){
            newcls="Form 3";
        }
        if (Classe.getSelectedIndex()==2){
            newcls="Form 4";
        }
        if (Leva.getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(null, "Atleast a Single Selection"+aigana);
        }else{
            int[] ro=Leva.getSelectedRows();
            for (int i =0; i < (aigana+0); i++) {
                String cc0=Leva.getModel().getValueAt(ro[i], 1).toString();
                try {
                    String cc=Leva.getModel().getValueAt(ro[i], 3).toString();
                    String norol="UPDATE `tbl_Students` SET `CLASS`='"+newcls+"' WHERE `Reg_No`=' "+cc+" '";
                    pst=(PreparedStatement) Conn.prepareStatement(norol);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, ro[i]+" Students Succesfully Proceeded to "+newcls);

                } catch (Exception e) {
                    System.out.println(e+" \n  TrnClsActionPerformed");
                }
            }
        }
        /*int cl =JOptionPane.showConfirmDialog(this,"Transfer To Next Level","Proceed", JOptionPane.YES_NO_OPTION);
        if (cl==JOptionPane.YES_OPTION) {
            Rugia();
            if (ComBin.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(null, "Pass to "+fromas);
                //Update stm
            } else if (ComBin.getSelectedIndex()==1){
                JOptionPane.showMessageDialog(null, "Repeated in "+fromas);
            }
        }
        if (cl==JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Failed");
            //remove(cl);
        }*/
    }//GEN-LAST:event_TrnClsActionPerformed

    private void SClsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SClsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SClsActionPerformed

    private void GrdSettActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrdSettActionPerformed
        // TODO add your handling code here:
        Nm();
        hr=Integer.parseInt(Hrange.getSelectedItem().toString());
        lr=Integer.parseInt(Lrange.getSelectedItem().toString());
        cmnt=CommBox.getText();
        Greda();
        String emh="Class ->"+frgd+"\nExam "+lst+"\nGrade Level ->"+grd+"\nSubject ->"+sbgd+"  Range ->"+hr+"<-->"+lr+"\nComment ->"+cmnt+"\n";
        try {
            String sql="INSERT INTO `tbl_Grades` (`Count`,`Class`,`Test`,`Grade`,`Best`,`Least`,`Comment`) VALUES (NULL,'"+frgd+"','"+lst+"','"+grd+"','"+hr+"','"+lr+"','"+cmnt+"')";
            pst = (PreparedStatement) Conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nTable Error");
        }
        GraBox.append(emh);
    }//GEN-LAST:event_GrdSettActionPerformed

    private void jTabbedPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane4MouseClicked

    private void NxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NxtActionPerformed
        // TODO add your handling code here:
        String Cls=null;
        if (Cbf1.isSelected()) {
            Cls="Form 1";
        }
        if (Cbf2.isSelected()) {
            Cls="Form 2";
        }
        if (Cbf3.isSelected()) {
            Cls="Form 3";
        }
        if (Cbf4.isSelected()) {
            Cls="Form 4";
        }
          
        if ( !(Cbf3.isSelected() || Cbf4.isSelected() || Cbf1.isSelected() || Cbf2.isSelected() )) {            
            JOptionPane.showMessageDialog(null, "Select A Class So As To Proceed");
        }
        
        if (Cbf3.isSelected() || Cbf4.isSelected()) {            
            Sett.setVisible(Boolean.FALSE);
            Senr.setVisible(Boolean.TRUE);
            Marks.setVisible(Boolean.FALSE);
        }
        else if (Cbf1.isSelected() || Cbf2.isSelected()) {
            try {
                String sql="SELECT Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,History,Business,Agriculture FROM  "+lst+" WHERE `Class`='"+Cls+"' ";
                pst=Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tblLowerMarks.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e) {
                System.out.println(e+"\n Teacher Init Error 1");
                Toolkit.getDefaultToolkit().beep();
            }
            
            Sett.setVisible(Boolean.FALSE);
            Senr.setVisible(Boolean.FALSE);
            Marks.setVisible(Boolean.TRUE);
        }
    }//GEN-LAST:event_NxtActionPerformed

    private void FrmSenrAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrmSenrAddActionPerformed
        // TODO add your handling code here:
        if (FrmSenrAdd.getSelectedIndex()==0) {
            ClStr="Form 3";
            StrmSenrAdd.removeAllItems();
            Chus();
        }
        if (FrmSenrAdd.getSelectedIndex()==1) {
            ClStr="Form 4";
            StrmSenrAdd.removeAllItems();
            Chus();
        }
    }//GEN-LAST:event_FrmSenrAddActionPerformed

    private void SncSenrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SncSenrActionPerformed
        // TODO add your handling code here:
        SenrAd();
        Nm();
        if (SbjSenrChus.getSelectedIndex()==1) {
            try {
                String sql="SELECT `Name`,`Reg_No`,"+snmsbj+" FROM "+lst+" WHERE `Class`='"+snmcls+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tblSnrAdd.setModel(DbUtils.resultSetToTableModel(rs));
                tblSnrAdd.setVisible(Boolean.TRUE);
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nNo Such Table 1");
            }

        }
        else if (SbjSenrChus.getSelectedIndex()>1) {
            //if (StrmSenrAdd.getSelectedIndex()==0) {
                try {
                    String sql="SELECT ("+lst+".Name),("+lst+".Class),("+lst+".Reg_No),("+lst+"."+snmsbj+") FROM "+lst+",`tbl_Placer`  WHERE ( "+lst+".Reg_No=`tbl_Placer`.Reg_No AND `tbl_Placer`."+snmsbj+"=1 AND `tbl_Placer`.`Class`='"+snmcls+"' )";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    tblSnrAdd.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e) {
                    System.out.println(e+" SncSenrActionPerformed");
                }
            /*} else {
                try {
                    String sql="SELECT ("+lst+".Name), ("+lst+".Class), ("+lst+".Reg_No), ("+lst+"."+snmsbj+") FROM "+lst+",`tbl_Placer`  WHERE ( "+lst+".Reg_No=`tbl_Placer`.Reg_No AND `tbl_Placer`."+snmsbj+"=1 AND `tbl_Placer`.`Class`= '"+snmcls+"' )";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    tblSnrAdd.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\nNo Such Table");
                }
            }*/
        }
        //JOptionPane.showMessageDialog(null, "Class ->"+snmcls+"\n"+"Stream ->"+snmstr+"\n"+"Subjech Choosen ->"+snmsbj);
    }//GEN-LAST:event_SncSenrActionPerformed

    private void InsrtSenrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsrtSenrActionPerformed
        // TODO add your handling code here:
        Nm();
        DefaultTableModel tts1=(DefaultTableModel) tblSnrAdd.getModel();
        if (SbjSenrChus.getSelectedIndex()==1) {
            try {
                for(int i=0; i<tblSnrAdd.getRowCount(); i++){
                    String num=("Mathematics");//(int stdreg,int stdscor,String stdsbj)
                    Double kk=Double.valueOf(tblSnrAdd.getValueAt(i, 2).toString()) ;
                    int reg=Integer.parseInt(tblSnrAdd.getValueAt(i, 1).toString()) ;
                    InsBasic(reg,kk,num);
                }//JOptionPane.showMessageDialog(null, "Subject ->"+snmsbj+"Added ->"+kk+"\n"+"Reg No ->"+reg);
                for(int i=0; i<tblSnrAdd.getRowCount(); i++){
                    String num=("English");
                    Double kk=Double.valueOf(tblSnrAdd.getValueAt(i, 3).toString()) ;
                    int reg=Integer.parseInt(tblSnrAdd.getValueAt(i, 1).toString()) ;
                    InsBasic(reg,kk,num);
                }
                for(int i=0; i<tblSnrAdd.getRowCount(); i++){
                    String num=("Kiswahili");
                    Double kk=Double.valueOf(tblSnrAdd.getValueAt(i, 4).toString()) ;
                    int reg=Integer.parseInt(tblSnrAdd.getValueAt(i, 1).toString()) ;
                    InsBasic(reg,kk,num);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nSome Errors ");
            }

            try {
                String sql="SELECT `Name`,`Reg_No`,`Mathematics`,`English`,`Kiswahili` FROM `"+lst+"` WHERE `Class`='"+snmcls+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tblSenrMarkList.setModel(DbUtils.resultSetToTableModel(rs));
                tblSenrMarkList.setVisible(Boolean.TRUE);
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nRendering Errors");
            }

        }
        if (SbjSenrChus.getSelectedIndex()>1) {
            try {
                for(int i=0; i<tblSnrAdd.getRowCount(); i++){
                    String SB=snmsbj;
                    float kk=Integer.parseInt(tblSnrAdd.getValueAt(i, 3).toString()) ;
                    int reg=Integer.parseInt(tblSnrAdd.getValueAt(i, 2).toString()) ;
                    String sqll="UPDATE `"+lst+"` SET "+SB+"="+kk+" WHERE Reg_No="+reg+"";
                    try {
                        pst=(PreparedStatement) Conn.prepareStatement(sqll);
                        pst.execute();
                        Toolkit.getDefaultToolkit().beep();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex+"\nUpadate Error");
                    }
                }//JOptionPane.showMessageDialog(null, "Subject ->"+snmsbj+"Added ->"+kk+"\n"+"Reg No ->"+reg);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nSome Errors ");
            }
            /*try {
                String sql="SELECT `Name`,`Reg_No`,`"+snmsbj+"` FROM `"+lst+"` WHERE `Class`='"+snmcls+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                SenrConfTbl.setModel(DbUtils.resultSetToTableModel(rs));
                SenrConfTbl.setVisible(Boolean.TRUE);
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nNo Such Table");
            }*/
            try {
                String sql="SELECT COALESCE("+lst+".Name) AS Name,COALESCE("+lst+".Class) AS Class,COALESCE("+lst+".Reg_No) AS Reg_No,("+lst+"."+snmsbj+") FROM "+lst+",`tbl_Placer`  WHERE ( "+lst+".Reg_No=`tbl_Placer`.Reg_No AND `tbl_Placer`."+snmsbj+"=1 AND `tbl_Placer`.`Class`= '"+snmcls+"' )";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tblSenrMarkList.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nAlternate Selection Failed");
            }
        }

    }//GEN-LAST:event_InsrtSenrActionPerformed

    private void BacSettActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BacSettActionPerformed
        // TODO add your handling code here:
        Pg0.setVisible(Boolean.FALSE);
        Sett.setVisible(Boolean.TRUE);
        Senr.setVisible(Boolean.FALSE);
    }//GEN-LAST:event_BacSettActionPerformed

    private void CritClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CritClassActionPerformed
        // TODO add your handling code here:
        if (CritClass.getSelectedIndex()==1) {
            crclas="Form 1";
            CritStream.removeAllItems();
            PopAnaly();
        }
        if (CritClass.getSelectedIndex()==2) {
            crclas="Form 2";
            CritStream.removeAllItems();
            PopAnaly();
        }
        if (CritClass.getSelectedIndex()==3) {
            crclas="Form 3";
            CritStream.removeAllItems();
            PopAnaly();
        }
        if (CritClass.getSelectedIndex()==4) {
            crclas="Form 4";
            CritStream.removeAllItems();
            PopAnaly();
        }
    }//GEN-LAST:event_CritClassActionPerformed

    private void AnalyseExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalyseExamActionPerformed
        // TODO add your handling code here:
        Nm();
        if (CritSubject.getSelectedIndex()>0) {
            ctsbj=CritSubject.getSelectedItem().toString();
        }else{
            JOptionPane.showMessageDialog(null, "Select atleast one subject");
        }
        
        if (CritAscend.isSelected()) {
            try {
                String sql="SELECT Name,Reg_No,"+ctsbj+" FROM "+lst+"  WHERE `Class`='"+crclas+"' ORDER BY "+ctsbj+" ASC";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tbl_Analyse.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e+" AnalyseExamActionPerformed Asc");
            }
        }

        if (CritDesc.isSelected()) {
            try {
                String sql="SELECT ("+lst+".Name),("+lst+".Reg_No),("+lst+"."+ctsbj+") FROM "+lst+"  WHERE `Class`='"+crclas+"' ORDER BY ("+lst+"."+ctsbj+") DESC";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tbl_Analyse.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e+" AnalyseExamActionPerformed Desc");
            }
        }

        if (CritMosImp.isSelected()) {
            try {
                String sql="SELECT ("+lst+".Name),("+lst+".Reg_No),("+lst+"."+ctsbj+"),("+lst2+"."+ctsbj+"),("+lst+"."+ctsbj+")-("+lst+"."+ctsbj+") AS Increment FROM "+lst+","+lst2+"  WHERE ("+lst+".Reg_No="+lst2+".Reg_No AND "+lst+".`Class`='"+crclas+"' AND "+lst2+".`Class`='"+crclas+"' ) ";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tbl_Analyse.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e+" AnalyseExamActionPerformed Most Imp");
            }
        }

        try {
            //String sql="SELECT ("+lst+".Name),("+lst+".Reg_No),("+lst+"."+ctsbj+") FROM "+lst+","+lst2+"  WHERE ( "+lst+".Reg_No=`tbl_Placer`.Reg_No AND `tbl_Placer`."+snmsbj+"=1 AND `tbl_Placer`.`Class`='"+snmcls+"' )";
            //String sql="SELECT COALESCE("+lst+".Name) AS Name,COALESCE("+lst+".Class) AS Class,COALESCE("+lst+".Reg_No) AS Reg_No,("+lst+"."+snmsbj+") FROM "+lst+",`tbl_Placer`  WHERE ( "+lst+".Reg_No=`tbl_Placer`.Reg_No AND `tbl_Placer`."+snmsbj+"=1 AND `tbl_Placer`.`Class`= '"+snmcls+"' AND `"+lst+"`.`Stream`= '"+snmstr+"')";
        } catch (Exception e) {
        }
    }//GEN-LAST:event_AnalyseExamActionPerformed

    private void FltPrfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FltPrfActionPerformed
        // TODO add your handling code here:
        Nm();
        
        String ExamClass="nill",ExamSubject,Exam1,Exam2,nom,nom2;
        
        if (Clss.getSelectedIndex()==0) {
            ExamClass="Form 1";
        } else if (Clss.getSelectedIndex()==0) {
            ExamClass="Form 2";
        }
        else if (Clss.getSelectedIndex()==0) {
            ExamClass="Form 3";
        }
        else if (Clss.getSelectedIndex()==0) {
            ExamClass="Form 4";
        }
        
        ExamSubject=this.ExamSubject.getSelectedItem().toString();
        Exam1=this.Ex1Perf.getSelectedItem().toString();
        Exam2=this.Ex2Perf.getSelectedItem().toString();
        
        System.out.println("table_now ->"+Exam2);
        System.out.println("table_old ->"+Exam1);
        
        nom=ExamSubject+Exam2; nom2=ExamSubject+Exam1;

        if (FltPrf.getSelectedIndex()==0) {
            Ex2Perf.setEnabled(Boolean.TRUE);
            try {
                //String sql="SELECT COALESCE("+Exam2+".Name) as Name,COALESCE("+Exam2+".Class) as Class,COALESCE("+Exam2+".Reg_No) as Reg_No,"+Exam2+"."+tsbj+","+Exam1+"."+tsbj+" FROM "+Exam2+","+Exam1+" WHERE ( "+Exam2+".Reg_No="+Exam1+".Reg_No AND "+Exam2+".Class='"+sb+"')";
                String sql="SELECT COALESCE("+Exam2+".Name) as Name,COALESCE("+Exam2+".Reg_No) as Reg_No,("+Exam2+"."+ExamSubject+")AS "+nom+",("+Exam1+"."+ExamSubject+")AS "+nom2+",("+Exam2+"."+ExamSubject+"-"+Exam1+"."+ExamSubject+") AS VAP FROM "+Exam2+","+Exam1+"  WHERE ( "+Exam2+".Reg_No="+Exam1+".Reg_No AND "+Exam2+".Class='"+ExamClass+"')";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tblExamCompare.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e+" FltPrfActionPerformed 1");
            }
        }

        if (FltPrf.getSelectedIndex()==1) {
            Ex2Perf.setEnabled(Boolean.FALSE);
            try {
                String sql="SELECT `Name`,`Reg_No`,`"+ExamSubject+"` FROM "+Exam1+"  WHERE `Class`='"+ExamClass+"' ORDER BY `"+ExamSubject+"` DESC";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tblExamCompare.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e+" FltPrfActionPerformed 2");
            }
        }
    }//GEN-LAST:event_FltPrfActionPerformed

    private void ClssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClssActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClssActionPerformed

    private void AdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tts=(DefaultTableModel) tblLowerMarks.getModel();
        try {
            for(int i=0; i<tblLowerMarks.getRowCount(); i++){
                String num=("Mathematics");
                Double kk=Double.valueOf(tblLowerMarks.getValueAt(i, 3).toString()) ;
                int reg=Integer.parseInt(tblLowerMarks.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<tblLowerMarks.getRowCount(); i++){
                String num=("English");
                Double kk=Double.valueOf(tblLowerMarks.getValueAt(i, 4).toString()) ;
                int reg=Integer.parseInt(tblLowerMarks.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<tblLowerMarks.getRowCount(); i++){
                String num=("Kiswahili");
                Double kk=Double.valueOf(tblLowerMarks.getValueAt(i, 5).toString()) ;
                int reg=Integer.parseInt(tblLowerMarks.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<tblLowerMarks.getRowCount(); i++){
                String num=("Chemistry");
                Double kk=Double.valueOf(tblLowerMarks.getValueAt(i, 6).toString()) ;
                int reg=Integer.parseInt(tblLowerMarks.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<tblLowerMarks.getRowCount(); i++){
                String num=("Biology");
                Double kk=Double.valueOf(tblLowerMarks.getValueAt(i, 7).toString()) ;
                int reg=Integer.parseInt(tblLowerMarks.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<tblLowerMarks.getRowCount(); i++){
                String num=("Physics");
                Double kk=Double.valueOf(tblLowerMarks.getValueAt(i, 8).toString()) ;
                int reg=Integer.parseInt(tblLowerMarks.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<tblLowerMarks.getRowCount(); i++){
                String num=("Geography");
                Double kk=Double.valueOf(tblLowerMarks.getValueAt(i, 9).toString()) ;
                int reg=Integer.parseInt(tblLowerMarks.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<tblLowerMarks.getRowCount(); i++){
                String num=("History");
                //float kk=Integer.parseInt(Tsta.getValueAt(i, 10).toString()) ;
                Double kk=Double.valueOf(tblLowerMarks.getValueAt(i, 10).toString()) ;
                int reg=Integer.parseInt(tblLowerMarks.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<tblLowerMarks.getRowCount(); i++){
                String num=("CRE");
                Double kk=Double.valueOf(tblLowerMarks.getValueAt(i, 11).toString()) ;
                int reg=Integer.parseInt(tblLowerMarks.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<tblLowerMarks.getRowCount(); i++){
                String num=("Business");
                Double kk=Double.valueOf(tblLowerMarks.getValueAt(i, 12).toString()) ;
                int reg=Integer.parseInt(tblLowerMarks.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<tblLowerMarks.getRowCount(); i++){
                String num=("Agriculture");
                Double kk=Double.valueOf(tblLowerMarks.getValueAt(i, 13).toString()) ;
                int reg=Integer.parseInt(tblLowerMarks.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            JOptionPane.showMessageDialog(null, "Done");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"Nigga");
        }
    }//GEN-LAST:event_AdaActionPerformed

    private void RshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RshActionPerformed
        // TODO add your handling code here:
        String cla=null;
        
        if (Cbf1.isSelected()) {
            cla="Form 1";
        }
        if (Cbf2.isSelected()) {
            cla="Form 2";
        }
        
        String sql="SELECT Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,History,Business,Agriculture FROM  "+lst+" WHERE `Class`='"+cla+"' ";
        try {
            pst=Conn.prepareStatement(sql);
            rs=pst.executeQuery();
        }catch (Exception e) {
            System.out.println(e+"\n PopTeacher \n Query "+sql);
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_RshActionPerformed

    private void BcerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcerActionPerformed
        // TODO add your handling code here:
        Marks.setVisible(Boolean.FALSE);
        Sett.setVisible(Boolean.TRUE);
        Senr.setVisible(Boolean.FALSE);
    }//GEN-LAST:event_BcerActionPerformed

    private void GraphyyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphyyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GraphyyActionPerformed

    private void FeeObjectAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeeObjectAddActionPerformed
        // TODO add your handling code here:
        
        if (FeeObject.getText().equals("") ||  FeeComment.getText().equals("") ||  FeeAmount.getText().equals("")  ) {
            JOptionPane.showMessageDialog(this, "Fill all fields", "Unexpected Input",JOptionPane.ERROR_MESSAGE);
        }else{
            if (FeeClass.getSelectedItem().toString()=="All") {
                FeeObjectIns("Form 1");
                FeeObjectIns("Form 2");
                FeeObjectIns("Form 3");
                FeeObjectIns("Form 4");

                FeeObject.setText("");
                FeeClass.setSelectedIndex(0);
                FeeComment.setText("");
                FeeAmount.setText("");
            } else if (FeeClass.getSelectedItem().toString()=="Select")  {
                JOptionPane.showMessageDialog(this, "Assign a valid class", "Unexpected Input",JOptionPane.ERROR_MESSAGE); 
            } else {
                try {
                    String sql="INSERT INTO `tbl_Fees` (Count,Object_Name,Class,Amount,Comment)  VALUES(NULL,?,?,?,?)";
                    pst = Conn.prepareStatement(sql);
                    pst.setString(1, FeeObject.getText().toString());
                    pst.setString(2, FeeClass.getSelectedItem().toString());
                    pst.setInt(3, Integer.parseInt(FeeAmount.getText().toString()));
                    pst.setString(4, FeeComment.getText().toString());
                    pst.executeUpdate();

                    FeeObject.setText("");
                    FeeClass.setSelectedIndex(0);
                    FeeComment.setText("");
                    FeeAmount.setText("");
                } catch (Exception e) {
                    System.out.println(e.getMessage()+ "\t FeeObjectAddActionPerformed");
                }
            }
        }
        
        PopFee();
    }//GEN-LAST:event_FeeObjectAddActionPerformed

    private void FeeObjectEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeeObjectEditActionPerformed
        // TODO add your handling code here:
        int reg=Integer.parseInt(tblFee.getValueAt(tblFee.getSelectedRow(), 0).toString());
        
        String Obj =FeeObject.getText().toString();
        int amnt =Integer.parseInt(FeeAmount.getText().toString());
        String Classe=FeeClass.getSelectedItem().toString();
        String Comm =FeeComment.getText().toString();
        
        if (FeeObject.getText().equals("") ||  FeeComment.getText().equals("") ||  FeeAmount.getText().equals("")  ) {
            JOptionPane.showMessageDialog(this, "Fill all fields", "Unexpected Input",JOptionPane.ERROR_MESSAGE);
        }else{
            if (FeeClass.getSelectedItem().toString()=="All") {
                String cla="Form ";

                for (int i = 0; i < 4; i++) {
                    lv="UPDATE `tbl_Fees` SET `Object_Name` ='"+Obj+"',`Class` ='"+cla+i+"', `Amount` ="+amnt+", `Comment` ='"+Comm+"' WHERE `Count`='"+reg+"' ";
                    try {
                        pst=Conn.prepareStatement(lv);
                        pst.execute();

                        FeeObject.setText("");
                        FeeClass.setSelectedIndex(0);
                        FeeComment.setText("");
                        FeeAmount.setText("");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e+"\nFee Permute update");
                    }
                }

            } else if (FeeClass.getSelectedItem().toString()=="Select")  {
                JOptionPane.showMessageDialog(this, "Assign a valid class", "Unexpected Input",JOptionPane.ERROR_MESSAGE); 
            } else {
                lv="UPDATE `tbl_Fees` SET `Object_Name` ='"+Obj+"',`Class` ='"+Classe+"', `Amount` ="+amnt+", `Comment` ='"+Comm+"' WHERE `Count`='"+reg+"' ";
                try {
                    pst=Conn.prepareStatement(lv);
                    pst.execute();

                    FeeObject.setText("");
                    FeeClass.setSelectedIndex(0);
                    FeeComment.setText("");
                    FeeAmount.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\nObject Update Error");
                }
            }
        }
        
        FeeObject.setText("");
        FeeClass.setSelectedIndex(0);
        FeeComment.setText("");
        FeeAmount.setText("");
        
        PopFee();
    }//GEN-LAST:event_FeeObjectEditActionPerformed

    private void FeeAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FeeAmountKeyTyped
        // TODO add your handling code here:
        char cc=evt.getKeyChar();
        if(!(Character.isDigit(cc) || cc==KeyEvent.VK_BACK_SPACE || cc==KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_FeeAmountKeyTyped

    private void tblFeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFeeMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tts=(DefaultTableModel) tblFee.getModel();
        
        int reg=Integer.parseInt(tblFee.getValueAt(tblFee.getSelectedRow(), 0).toString());
        String got=(tblFee.getValueAt(tblFee.getSelectedRow(), 2).toString());
        
        FeeObject.setText((tblFee.getValueAt(tblFee.getSelectedRow(), 1).toString()));
        FeeClass.setSelectedItem(got);
        FeeAmount.setText((tblFee.getValueAt(tblFee.getSelectedRow(), 3).toString()));
        FeeComment.setText((tblFee.getValueAt(tblFee.getSelectedRow(), 4).toString()));
    }//GEN-LAST:event_tblFeeMouseClicked

    private void StudentFindKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StudentFindKeyTyped
        // TODO add your handling code here:
        String Varr="";
        if (StudentFindType.getSelectedIndex()==0) {
            Varr="Name";
        }else if (StudentFindType.getSelectedIndex()==1) {
            Varr="Class";
        }else if (StudentFindType.getSelectedIndex()==2) {
            Varr="Reg_No";
        }

        String vl=StudentFind.getText().toString();
        try {               
            String Lv="SELECT  `Name` ,`Surname` ,`Reg_No` ,`KCPE` ,`Birth` ,`Parent` ,`Contact` ,`Residence` ,`Class`  FROM `tbl_Students`  WHERE `"+Varr+"` LIKE '%"+vl+"%' ";
            pst=Conn.prepareStatement(Lv);
            rs=pst.executeQuery();
            tblAllStd.setModel(DbUtils.resultSetToTableModel(rs));  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\n StudentFindKey");
            getToolkit().beep();
        }
    }//GEN-LAST:event_StudentFindKeyTyped

    private void ExamSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExamSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExamSubjectActionPerformed

    private void FeeObjectDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeeObjectDeleteActionPerformed
        // TODO add your handling code here:
        int reg=Integer.parseInt(tblFee.getValueAt(tblFee.getSelectedRow(), 0).toString());
        try {
            String sav="DELETE FROM `tbl_Fees` WHERE `Count`= ' "+reg+" '";
            pst=(PreparedStatement) Conn.prepareStatement(sav);
            pst.execute();
            
            FeeObject.setText("");
            FeeClass.setSelectedIndex(0);
            FeeComment.setText("");
            FeeAmount.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        PopFee();
    }//GEN-LAST:event_FeeObjectDeleteActionPerformed

    private void FinanceF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinanceF1ActionPerformed
        // TODO add your handling code here:
        if (FinanceF1.isSelected()==true) {
            FinanceSel("Form 1");
        }
    }//GEN-LAST:event_FinanceF1ActionPerformed

    private void FinanceF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinanceF2ActionPerformed
        // TODO add your handling code here:
        if (FinanceF2.isSelected()==true) {
            FinanceSel("Form 2");
        }
    }//GEN-LAST:event_FinanceF2ActionPerformed

    private void FinanceF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinanceF3ActionPerformed
        // TODO add your handling code here:
        if (FinanceF3.isSelected()==true) {
            FinanceSel("Form 3");
        }
    }//GEN-LAST:event_FinanceF3ActionPerformed

    private void FinanceF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinanceF4ActionPerformed
        // TODO add your handling code here:
        if (FinanceF4.isSelected()==true) {
            FinanceSel("Form 4");
        }
    }//GEN-LAST:event_FinanceF4ActionPerformed

    private void FeeBalanceBelowKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FeeBalanceBelowKeyTyped
        // TODO add your handling code here:
        char cc=evt.getKeyChar();
        if(!(Character.isDigit(cc) || cc==KeyEvent.VK_BACK_SPACE || cc==KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
        
        FeePaidAbove.setText(null);
    }//GEN-LAST:event_FeeBalanceBelowKeyTyped

    private void FeePaidAboveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FeePaidAboveKeyTyped
        // TODO add your handling code here:
        char cc=evt.getKeyChar();
        if(!(Character.isDigit(cc) || cc==KeyEvent.VK_BACK_SPACE || cc==KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
        
        FeeBalanceBelow.setText(null);
    }//GEN-LAST:event_FeePaidAboveKeyTyped

    private void StrNxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StrNxtActionPerformed
        // TODO add your handling code here:
        if (StrNxt.getSelectedIndex()==0) {
            try {
                String sql="SELECT * FROM `tbl_ClassList` WHERE `Class`='"+ClStr+"' ";
                //pst=(PreparedStatement) Conn.prepareStatement(sql);
                //rs=pst.executeQuery();
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nStr Error 22");
            }
        }
    }//GEN-LAST:event_StrNxtActionPerformed

    private void FeeDepositFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeeDepositFindActionPerformed
        // TODO add your handling code here:   
        try {
            if (Integer.parseInt(FeeBalanceBelow.getText()) > 0) {
            String sql="SELECT `Name`,`Class`,`Reg_No`,`Total_Fee`,`Paid_Fee`,`Bal_Fee` FROM `tbl_Paid` WHERE `Bal_Fee` > '"+Integer.parseInt(FeeBalanceBelow.getText())+"' ";
            try {
                pst=Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tblFeeSearch.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e) {
                System.out.println(e+"\nFeeDepositFindActionPerformed 1\nQuery is "+sql);
            }
        }
        } catch (Exception ex) {
            if ( Integer.parseInt(FeePaidAbove.getText()) > 0) {
                String sql="SELECT `Name`,`Class`,`Reg_No`,`Total_Fee`,`Paid_Fee`,`Bal_Fee` FROM `tbl_Paid` WHERE `Paid_Fee` > '"+Integer.parseInt(FeePaidAbove.getText())+"' ";
                try {
                    pst=Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    tblFeeSearch.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e) {
                    System.out.println(e+"\nFeeDepositFindActionPerformed 2\n Query"+sql);
                }
            }
        }
        
    }//GEN-LAST:event_FeeDepositFindActionPerformed

    private void FeeClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeeClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FeeClassActionPerformed

    private void feeTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_feeTabMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_feeTabMouseClicked

    private void feePayPaidPayPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feePayPaidPayPaidActionPerformed
        // TODO add your handling code here:
        //FeeFindUser();
    }//GEN-LAST:event_feePayPaidPayPaidActionPerformed

    private void feeDepositPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeDepositPayActionPerformed
        // TODO add your handling code here:
        if (feePayReg.getText().toString().trim().equals("") || feePayNew.getText().toString().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Missing a Registration number or an Amount to pay", "Unexpected Input",JOptionPane.ERROR_MESSAGE); 
        } else {
            FeePay(Integer.parseInt(feePayReg.getText()), Integer.parseInt(feePayNew.getText()));
            FeeFindUser(Integer.parseInt(feePayReg.getText()));
        }
    }//GEN-LAST:event_feeDepositPayActionPerformed

    private void feePayRegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feePayRegKeyTyped
        // TODO add your handling code here:
        char cc=evt.getKeyChar();
        if(!(Character.isDigit(cc) || cc==KeyEvent.VK_BACK_SPACE || cc==KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_feePayRegKeyTyped

    private void feePayNewKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feePayNewKeyTyped
        // TODO add your handling code here:
        char cc=evt.getKeyChar();
        if(!(Character.isDigit(cc) || cc==KeyEvent.VK_BACK_SPACE || cc==KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_feePayNewKeyTyped

    private void feePayRegKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feePayRegKeyPressed
        // TODO add your handling code here
    }//GEN-LAST:event_feePayRegKeyPressed

    private void feePayRegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feePayRegKeyReleased
        // TODO add your handling code here:
        //int me=Integer.parseInt(feePayReg.getText().toString().trim());
        if (feePayReg.getText().toString().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Registration number", "Unexpected Input",JOptionPane.ERROR_MESSAGE); 
        } else {
            FeeFindUser(Integer.parseInt(feePayReg.getText()));
        }
    }//GEN-LAST:event_feePayRegKeyReleased

    private void FinanceArrearsfindbynameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FinanceArrearsfindbynameKeyReleased
        // TODO add your handling code here:
        int reg;
        if (FinanceArrearsfindbyreg.getText().toString().trim().equals("")) {
            reg=0;
        }else{
            reg=Integer.parseInt(FinanceArrearsfindbyreg.getText());
        }
        System.out.println("Name. Reg no "+reg+""+FinanceArrearsfindbyname.getText().toString());
        FeeBalFindBy(FinanceArrearsfindbyname.getText().toString(), reg);
    }//GEN-LAST:event_FinanceArrearsfindbynameKeyReleased

    private void FinanceArrearsfindbyregKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FinanceArrearsfindbyregKeyReleased
        // TODO add your handling code here:
        int reg;
        if (FinanceArrearsfindbyreg.getText().toString().trim().equals("")) {
            reg=0;
        }else{
            reg=Integer.parseInt(FinanceArrearsfindbyreg.getText());
        }
        System.out.println("Reg. Reg no "+reg+""+FinanceArrearsfindbyname.getText().toString());
        FeeBalFindBy(FinanceArrearsfindbyname.getText().toString(), reg);
    }//GEN-LAST:event_FinanceArrearsfindbyregKeyReleased

    private void FinanceArrearsfindbynameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FinanceArrearsfindbynameKeyTyped
        // TODO add your handling code here:
        FinanceArrearsfindbyreg.setText(null);
    }//GEN-LAST:event_FinanceArrearsfindbynameKeyTyped

    private void FinanceArrearsfindbyregKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FinanceArrearsfindbyregKeyTyped
        // TODO add your handling code here:
        char cc=evt.getKeyChar();
        if(!(Character.isDigit(cc) || cc==KeyEvent.VK_BACK_SPACE || cc==KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
        
        FinanceArrearsfindbyname.setText(null);
    }//GEN-LAST:event_FinanceArrearsfindbyregKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Base().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ada;
    private javax.swing.JPanel All;
    private javax.swing.JButton AnalyseExam;
    private javax.swing.JButton BacSett;
    private javax.swing.JButton Bcer;
    private javax.swing.JButton BtnLogin;
    private javax.swing.JRadioButton Cbf1;
    private javax.swing.JRadioButton Cbf2;
    private javax.swing.JRadioButton Cbf3;
    private javax.swing.JRadioButton Cbf4;
    private javax.swing.JCheckBox Cbf5;
    private javax.swing.JCheckBox Cbf6;
    private javax.swing.JCheckBox Cbf7;
    private javax.swing.JCheckBox Cbf8;
    private javax.swing.JComboBox<String> Classe;
    private javax.swing.JComboBox<String> Clss;
    private javax.swing.JComboBox<String> ComBin;
    private javax.swing.JTextArea CommBox;
    private javax.swing.JRadioButton CritAscend;
    private javax.swing.JComboBox<String> CritClass;
    private javax.swing.JRadioButton CritDesc;
    private javax.swing.JRadioButton CritMosImp;
    private javax.swing.JComboBox<String> CritStream;
    private javax.swing.JComboBox<String> CritSubject;
    private javax.swing.JLabel DpImg;
    private javax.swing.JDesktopPane DpImgS;
    private javax.swing.JComboBox<String> Ex1Perf;
    private javax.swing.JComboBox<String> Ex2Perf;
    private javax.swing.JComboBox<String> ExamBay;
    private javax.swing.JComboBox<String> ExamSubject;
    private javax.swing.JLabel Exitt;
    private javax.swing.JButton Ext;
    private javax.swing.JComboBox<String> ExxamTY1;
    private javax.swing.JTextField FeeAmount;
    private javax.swing.JTextField FeeBalanceBelow;
    private javax.swing.JComboBox<String> FeeClass;
    private javax.swing.JTextArea FeeComment;
    private javax.swing.JButton FeeDepositFind;
    private javax.swing.JTextField FeeObject;
    private javax.swing.JButton FeeObjectAdd;
    private javax.swing.JButton FeeObjectDelete;
    private javax.swing.JButton FeeObjectEdit;
    private javax.swing.JTextField FeePaidAbove;
    private javax.swing.JTextField FinanceArrearsfindbyname;
    private javax.swing.JTextField FinanceArrearsfindbyreg;
    private javax.swing.JRadioButton FinanceF1;
    private javax.swing.JRadioButton FinanceF2;
    private javax.swing.JRadioButton FinanceF3;
    private javax.swing.JRadioButton FinanceF4;
    private javax.swing.JComboBox<String> FltPrf;
    private javax.swing.JComboBox<String> FormGrad;
    private javax.swing.JComboBox<String> FrmSenrAdd;
    private javax.swing.JTextArea GraBox;
    private javax.swing.JComboBox<String> GradIt;
    private javax.swing.JRadioButton GraphBar;
    private javax.swing.JRadioButton GraphLine;
    private javax.swing.JButton Graphyy;
    private javax.swing.JButton GrdSett;
    private javax.swing.JPanel Head;
    private javax.swing.JButton HmAdmin;
    private javax.swing.JButton HmExam;
    private javax.swing.JButton HmFee;
    private javax.swing.JButton HmNewStudent;
    private javax.swing.JButton HmReports;
    private javax.swing.JButton HmStudents;
    private javax.swing.JButton HmTeacher;
    private javax.swing.JLabel Homie;
    private javax.swing.JComboBox<String> Hrange;
    private javax.swing.JTextField ImgP;
    private javax.swing.JButton InsrtSenr;
    private javax.swing.JTable Leva;
    private javax.swing.JComboBox<String> Lrange;
    private javax.swing.JPanel Marks;
    private javax.swing.JLabel MnAddStd;
    private javax.swing.JLabel MnCharts;
    private javax.swing.JLabel MnExams;
    private javax.swing.JLabel MnGraphs;
    private javax.swing.JLabel MnStd;
    private javax.swing.JComboBox<String> NwBirthYear;
    private javax.swing.JTextField NwContacts;
    private javax.swing.JTextField NwFrmSch;
    private javax.swing.JTextField NwFullName;
    private javax.swing.JTextField NwGuardian;
    private javax.swing.JTextField NwKCPE;
    private javax.swing.JTextField NwRegNo;
    private javax.swing.JComboBox<String> NwResidence;
    private javax.swing.JComboBox<String> NwStdFrm;
    private javax.swing.JComboBox<String> NwStdFrmSrm;
    private javax.swing.JButton NwStdImg;
    private javax.swing.JButton NwStdReg;
    private javax.swing.JTextField NwSurName;
    private javax.swing.JButton Nxt;
    private javax.swing.JPanel PanAdmin;
    private javax.swing.JPanel PanAdmit;
    private javax.swing.JPanel PanExams;
    private javax.swing.JPanel PanFinance;
    private javax.swing.JPanel PanHome;
    private javax.swing.JComboBox<String> PanLogLevel;
    private javax.swing.JPasswordField PanLogPassword;
    private javax.swing.JTextField PanLogUsername;
    private javax.swing.JPanel PanLogs;
    private javax.swing.JPanel PanMisc;
    private javax.swing.JPanel PanReports;
    private javax.swing.JPanel PanStudents;
    private javax.swing.JPanel PanTeacher;
    private javax.swing.JPanel Pg0;
    private javax.swing.JButton RegAsBtn;
    private javax.swing.JComboBox<String> RepoClas;
    private javax.swing.JComboBox<String> RepoEX;
    private javax.swing.JTable RepoTbl;
    private javax.swing.JButton Rsh;
    private javax.swing.JButton RstCont;
    private javax.swing.JButton SCls;
    private javax.swing.JComboBox<String> SbjSenrChus;
    private javax.swing.JPanel Senr;
    private javax.swing.JButton SetCont;
    private javax.swing.JPanel Sett;
    private javax.swing.JButton SncSenr;
    private javax.swing.JComboBox<String> StrNxt;
    private javax.swing.JComboBox<String> StrmSenrAdd;
    private javax.swing.JTextField StudentFind;
    private javax.swing.JComboBox<String> StudentFindType;
    private javax.swing.JComboBox<String> SubGrad;
    private javax.swing.JButton SyncRepo;
    private javax.swing.JPanel Tail;
    private javax.swing.JComboBox<String> TeachCurrentExanm;
    private javax.swing.JRadioButton Tr4;
    private javax.swing.JRadioButton Tr5;
    private javax.swing.JRadioButton Tr6;
    private javax.swing.JButton TrnCls;
    private javax.swing.JButton VwCred;
    private javax.swing.JButton WannaBe;
    private javax.swing.JComboBox<String> YBx1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.JTextField eXA;
    private javax.swing.JPanel feeArrears;
    private javax.swing.JButton feeDepositPay;
    private javax.swing.JTextField feePayAmount;
    private javax.swing.JTextField feePayBal;
    private javax.swing.JTextField feePayClass;
    private javax.swing.JTextField feePayName;
    private javax.swing.JTextField feePayNew;
    private javax.swing.JTextField feePayPaid;
    private javax.swing.JTextField feePayReg;
    private javax.swing.JButton feePrintArrears;
    private javax.swing.JButton feePrintDeposits;
    private javax.swing.JTabbedPane feeTab;
    private javax.swing.JPanel feeTabDeposit;
    private javax.swing.JPanel feeTabStatement;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JMenu mnHelp;
    private javax.swing.JMenu mnMisc;
    private javax.swing.JMenu mnReports;
    private javax.swing.JMenu mnStaff;
    private javax.swing.JMenu mnStudents;
    private javax.swing.JTable tblAllStd;
    private javax.swing.JTable tblAllStudents;
    private javax.swing.JTable tblExamCompare;
    private javax.swing.JTable tblFee;
    private javax.swing.JTable tblFeeAll;
    private javax.swing.JTable tblFeeArrears;
    private javax.swing.JTable tblFeeSearch;
    private javax.swing.JTable tblLowerMarks;
    private javax.swing.JTable tblSenrMarkList;
    private javax.swing.JTable tblSnrAdd;
    private javax.swing.JTable tbl_Analyse;
    // End of variables declaration//GEN-END:variables
}
