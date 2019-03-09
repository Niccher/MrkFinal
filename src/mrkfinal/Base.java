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
    
    ResultSet rs=null;
    Connection Conn=null;
    PreparedStatement pst=null;
    Statement smt;
    
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
            //Tsta.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table"+"\nPutta Erro");
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private void PopExam(){
        try {
            String sql="SELECT * FROM  "+lst+" ";
            pst=Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tblExamCompare.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table"+"\nPutta Erro");
            Toolkit.getDefaultToolkit().beep();
        }
        
        try {
            String fch="SELECT * FROM `tbl_Tests` WHERE `Count`= >1 ";
            pst=Conn.prepareStatement(fch);
            rs=pst.executeQuery();
            if (rs.next()) {
                String exs=rs.getString("Test");
                Ex1Perf.addItem(exs);
                Ex1Perf.addItem(exs);
            }
        } catch (Exception e) {
        }
    }
    
    private void PopFinace(){
        try {
            String sql="SELECT Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,History,Business,Agriculture FROM  "+fd+" ";
            pst=(PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //Tsta.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table"+"\nPutta Erro");
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private void PopTeacher(){
        try {
            String sql="SELECT Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,History,Business,Agriculture FROM  "+fd+" ";
            pst=(PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            //Tsta.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table"+"\nPutta Erro");
            Toolkit.getDefaultToolkit().beep();
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
            pst= (PreparedStatement) Conn.prepareStatement(Kret);

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
            JOptionPane.showMessageDialog(null, ex+"\nThink Big");
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
        //clear fields  
    }
    
    private  void Nm(){
        try {
            String sql="SELECT `Test` FROM `tbl_Tests` ORDER BY `Count` DESC LIMIT 1";
            pst= (PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if (rs.next()) {
                lst=rs.getString("Test");
            }

            String sql2="SELECT `Test` FROM `tbl_Tests` WHERE Count=(SELECT MAX(Count)-1 FROM `tbl_Tests`) ";
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
     
    
    
     
    //*-*-*-*-*-
    private void Mk(){
        StrNxt.setEnabled(Boolean.FALSE);
        MarkUp();
        Droop();
        Inst();
        Lopa();
        Frez();
        Desp();
        Cou();
        IinCon();
        Star();
        Slepa();
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
        }
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

    private void Cutta(){
        if (NWstdStChm.isSelected()) {
            chh=chh+1;
            slSbj="Chemistry";
            IkiaP2();
        }
        if (NWstdStBio.isSelected()) {
            bioo=bioo+1;
            slSbj="Biology ";
            IkiaP2();
        }
        if (NWstdStPhy.isSelected()) {
            phys=phys+1;
            slSbj="Physics ";
            IkiaP2();;
        }
        if (NWstdStGeo.isSelected()) {
            Goeg=Goeg+1;
            slSbj="Geography ";
            IkiaP2();
        }
        if (NWstdStCRE.isSelected()) {
            cree=cree+1;
            slSbj="CRE ";
            IkiaP2();
        }
        if (NWstdStHist.isSelected()) {
            hsty=hsty+1;
            slSbj="History ";
            IkiaP2();
        }
        if (NWstdStAgr.isSelected()) {
            agrc=agrc+1;
            slSbj="Agriculture ";
            IkiaP2();
        }
        if (NWstdStBus.isSelected()) {
            busns=busns+1;
            slSbj="Business";
            IkiaP2();
        }
    }
    
    private void Inst(){
        int tt=cc.get(Calendar.YEAR);
        
        for (int i = 2015; i < 2025; i++) {
            lvv=String.valueOf(i);
            //YBx.addItem(lvv);
            YBx.addItem(String.valueOf(tt));
        }
        
        YBx.setEnabled(Boolean.FALSE);
        Cbf1.setEnabled(false);
        Cbf2.setEnabled(false);
        Cbf3.setEnabled(false);
        Cbf4.setEnabled(false);
        
    }
    
    private void Star(){
        Nm();        
        //2017_End_Term_Term2
        String Lst1=lst;
        
        try {
            String Gtt="CAT";
            String Gtt1="Mid";
            String Gtt2="End";

            String Gtt3="Term1";
            String Gtt4="Term2";
            String Gtt5="Term3";

                Pattern r = Pattern.compile(Gtt);
                Pattern r1 = Pattern.compile(Gtt1);
                Pattern r2 = Pattern.compile(Gtt2);

                Pattern r3 = Pattern.compile(Gtt3);
                Pattern r4 = Pattern.compile(Gtt4);
                Pattern r5 = Pattern.compile(Gtt5);

                Matcher m = r.matcher(Lst1);
                Matcher m1 = r1.matcher(Lst1);
                Matcher m2 = r2.matcher(Lst1);

                Matcher m3 = r3.matcher(Lst1);
                Matcher m4 = r4.matcher(Lst1);
                Matcher m5 = r5.matcher(Lst1);

                if (m.find( )) {
                   ExxamTY.setSelectedIndex(0);
                   RepoEX.setSelectedIndex(0);
                   RepoEX1.setSelectedIndex(2);
                } 
                else if (m1.find( )) {
                   ExxamTY.setSelectedIndex(1);
                   RepoEX.setSelectedIndex(1);
                   RepoEX1.setSelectedIndex(1);
                }
                else if (m2.find( )) {
                   ExxamTY.setSelectedIndex(2);
                   RepoEX.setSelectedIndex(2);
                   RepoEX1.setSelectedIndex(2);
                }
                else {
                   ExxamTY.setSelectedIndex(3);
                }

                if (m3.find( )) {
                   Tr1.setSelected(Boolean.TRUE);
                   RepoTrm1.setSelected(true);
                   RepoTrm4.setSelected(true);
                } 
                else if (m4.find( )) {
                   Tr2.setSelected(Boolean.TRUE);
                   RepoTrm2.setSelected(true);
                   RepoTrm5.setSelected(true);
                }
                else if (m5.find( )) {
                   Tr3.setSelected(Boolean.TRUE);
                   RepoTrm3.setSelected(true);
                   RepoTrm6.setSelected(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "NO Valid Table");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"Tables Mismatch");
        }
            ExxamTY.setEnabled(Boolean.FALSE);
            Tr1.setEnabled(Boolean.FALSE);
            Tr2.setEnabled(Boolean.FALSE);
            Tr3.setEnabled(Boolean.FALSE);
            RepoTrm3.setEnabled(Boolean.FALSE);
            RepoTrm2.setEnabled(Boolean.FALSE);
            RepoTrm1.setEnabled(Boolean.FALSE);
            RepoTrm4.setEnabled(Boolean.FALSE);
            RepoTrm5.setEnabled(Boolean.FALSE);
            RepoTrm6.setEnabled(Boolean.FALSE);
            RepoEX.setEnabled(false);
            RepoEX1.setEnabled(false);
    }
    
    private void Maka(){
        int tt=cc.get(Calendar.YEAR);
        String yer=String.valueOf(tt);
        String TY=ExxamTY.getSelectedItem().toString();
        String tam=null;
        if (Tr1.isSelected()) {
            tam="Term1";
        }
        if (Tr2.isSelected()) {
            tam="Term2";
        }
        if (Tr3.isSelected()) {
            tam="Term3";
        }
        
        fd=yer+"_"+TY+"_"+tam;
    }
    
    private void Putta(){
        Maka();
        String Cls=null;
        if (Cbf1.isSelected()) {
            Cls="Form1";
        }
        if (Cbf2.isSelected()) {
            Cls="Form2";
        }
        if (Cbf3.isSelected()) {
            Cls="Form3";
        }
        if (Cbf4.isSelected()) {
            Cls="Form4";
        }
        //JOptionPane.showMessageDialog(null, fd+"---Am The Table");
        try {
            String sql="SELECT Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,History,Business,Agriculture FROM  "+fd+" WHERE `Class`='"+Cls+"' ";
            pst=(PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Tsta.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table"+"\nPutta Erro");
            Toolkit.getDefaultToolkit().beep();
        }
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
        F1Log.setText(null);
        F4Log.setText(null);
        F3Log.setText(null);
        F2Log.setText(null);
    }
    
    private void Droop(){
        if (Cbf5.isSelected()) {
            Mats="Form1";
        }else if (Cbf6.isSelected()) {
            Mats="Form2";
        }else if (Cbf7.isSelected()) {
            Mats="Form3";
        }else if (Cbf8.isSelected()) {
            Mats="Form4";
        }
    }
    
    private void Conf(){
        if (Tr4.isSelected()) {
            Tem="Term1";
        }
        else if (Tr5.isSelected()) {
            Tem="Term2";
        }
        else if (Tr6.isSelected()) {
            Tem="Term3";
        }
    }
    
    private void Filla(){
        try {
            //String sql="INSERT INTO `"+cs+"` (Name,Reg_No,Class)  SELECT Name,Reg_No,Class FROM tbl_Students WHERE `Class`='"+Mats+"'";
            String sql="INSERT INTO `"+cs+"` (Name,Reg_No,Class,Stream)  SELECT Name,Reg_No,Class,Stream FROM tbl_Students";
            smt=(Statement) Conn.prepareStatement(sql);
            //smt.executeUpdate(sql);
            pst = (PreparedStatement) Conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nTable Already Exists");
        }
    }
    
    private void Lasta(){
        try {
            String sql="SELECT `Test` FROM `tbl_Tests` ORDER BY `Count` DESC LIMIT 1";
            pst= (PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if (rs.next()) {
                lst=rs.getString("Test");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nCurrent Exam Table Error");
            Toolkit.getDefaultToolkit().beep();
        }
        
        //cl=Classe.getSelectedItem().toString();
        cl=ClassLv.getSelectedItem().toString();
        
        if (cl=="Form 1") {
            tbl="Form1";
        }else if(cl=="Form 2"){
            tbl="Form2";
        }else if(cl=="Form 3"){
            tbl="Form3";
        }else if(cl=="Form 4"){
            tbl="Form4";
        }
    }
    
    private void Frez(){
        Trmm();
        Finda();
        ExamType.setEnabled(Boolean.FALSE);
        Terma.setEnabled(Boolean.FALSE);
        
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
    
    private void Trmm(){
        int mnt=cc.get(Calendar.MONTH)+1;
        if(mnt<5){
            Trrm="Term One";
            Terma.setSelectedIndex(00);
        }
        if(mnt>4 &&mnt<9){
            Trrm="Term Two";
            Terma.setSelectedIndex(01);
        }
        if(mnt>8 ){
            Trrm="Term Three";
            Terma.setSelectedIndex(02);
        }
    }
    
    private void Finda(){
        Lasta();
        String Lst1=lst;
        String Gtt="CAT";
        String Gtt1="Mid";
        String Gtt2="End";
        
            Pattern r = Pattern.compile(Gtt);
            Pattern r1 = Pattern.compile(Gtt1);
            Pattern r2 = Pattern.compile(Gtt2);
            
            Matcher m = r.matcher(Lst1);
            Matcher m1 = r1.matcher(Lst1);
            Matcher m2 = r2.matcher(Lst1);
            
            if (m.find( )) {
               ExamType.setSelectedIndex(0);
            } 
            else if (m1.find( )) {
               ExamType.setSelectedIndex(1);
            }
            else if (m2.find( )) {
               ExamType.setSelectedIndex(2);
            }
            else{
                JOptionPane.showMessageDialog(null, "Corrupted Search");
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
        Tabler();   
    }
    
    private void Tabler(){
        int cur=SbjBox.getSelectedIndex();
        //Mt,En,Kw,Ce,Bl,Ph,Go,Ht,Cr,Al,Bu;
        if (cur==1) {
            mrk=Integer.valueOf(Mt);
        }
        if (cur==2) {
            mrk=Integer.valueOf(En);
        }
        if (cur==3) {
            mrk=Integer.valueOf(Kw);
        }
        if (cur==4) {
            mrk=Integer.valueOf(Ce);
        }
        if (cur==5) {
            mrk=Integer.valueOf(Bl);
        }
        if (cur==6) {
            mrk=Integer.valueOf(Ph);
        }
        if (cur==7) {
            mrk=Integer.valueOf(Go);
        }
        if (cur==8) {
            mrk=Integer.valueOf(Ht);
        }
        if (cur==9) {
            mrk=Integer.valueOf(Cr);
        }
        if (cur==10) {
            mrk=Integer.valueOf(Al);
        }
        if (cur==11) {
            mrk=Integer.valueOf(Bu);
        }
        //JOptionPane.showMessageDialog(null, Mt+En+Kw+Ce+Bl+Ph+Go+Ht+Cr+Al+Bu+"\n"+mrk);
        
    }
    
    private void Searc(){
        if (SrchConst.getSelectedIndex()==0) {
            Varr="Reg_No";
        }else if (SrchConst.getSelectedIndex()==1) {
            Varr="Name";
        }else if (SrchConst.getSelectedIndex()==2) {
            Varr="Class";
        }
        //String Crt=SrchConst.getSelectedItem().toString();
        //String Crt=Varr;
        String vl=ConsBox.getText().toString();
        try {               
                String Lv="SELECT  Name,Surname,Reg_No,KCPE,Class,Dorm,Parent,Residence,Contact  FROM `tbl_Students`  WHERE `"+Varr+"` LIKE '%"+vl+"%' ";
                pst=(PreparedStatement) Conn.prepareStatement(Lv);
                rs=pst.executeQuery();
                //while(rs.next()) { 
                    /*pst=conn.prepareStatement(Lv);
                    rs=pst.executeQuery();*/
                    ClVwTY.setModel(DbUtils.resultSetToTableModel(rs));
            //}   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\n");
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
    
    private void Desp(){
        try {
                String sql="SELECT `Test` FROM `tbl_Tests` ORDER BY `Count` DESC LIMIT 1 ";
                pst= (PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if (rs.next()) {
                    lst=rs.getString("Test");
                    TvwLst.addItem(lst);
                    GenTbl.addItem(lst);
                    uPtBL.addItem(lst);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nCurrent Exam Table Error");
                Toolkit.getDefaultToolkit().beep();
            }
        
        jLabel3.setEnabled(Boolean.FALSE);
        OtCom.setEnabled(Boolean.FALSE);
        //Classe.setEnabled(Boolean.FALSE);
        OtCom.setText(null);
        
        Trm1.setEnabled(Boolean.FALSE);
        Trm2.setEnabled(Boolean.FALSE);
        Trm3.setEnabled(Boolean.FALSE);
        Cts.setEnabled(Boolean.FALSE);
        Mts.setEnabled(Boolean.FALSE);
        Ets.setEnabled(Boolean.FALSE);
        
        GenTvw.setEnabled(Boolean.FALSE);
        TvwLst.setEnabled(Boolean.FALSE);
        ConnecView.setEnabled(false);
        uPtBL.setEnabled(Boolean.FALSE);
        GenTbl.setEnabled(Boolean.FALSE);
        jLabel3.setEnabled(true);
        RegAsBtn.setEnabled(Boolean.TRUE);
    }
    
    private void IinCon (){
        Integer ki=ConnecView.getSelectedIndex();
        new Thread(new Runnable(){
            public void run(){
                Socket ss=new Socket();
                InetSocketAddress add=new InetSocketAddress("www.google.com",80);
                try {
                    ss.connect(add,8080);
                    ConnecView.setSelectedIndex(0);
                } catch (Exception e) {
                    ConnecView.setSelectedIndex(1);
                }
            }
        }).start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        
    }
    
    private void rEDA(){
        String Tbb=TvwLst.getSelectedItem().toString();
        try {
            FileWriter fw=new FileWriter(lst+".csv");
            String sql="SELECT * FROM `"+Tbb+"`";
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
    
    private void Cou(){
        for (int i = 0; i < 31; i++) {
            int fct=i;
            ClassCatFM1.addItem(String.valueOf(fct));
            ClassCatPm1.addItem(String.valueOf(fct));
        }
        for (int i = 0; i < 101; i++) {
            int fct=i;
            ClassMidFM1.addItem(String.valueOf(fct));
            ClassMidPM1.addItem(String.valueOf(fct));
            
            ClassEndFM1.addItem(String.valueOf(fct));
            ClassEndPM1.addItem(String.valueOf(fct));
            Hrange.addItem(String.valueOf(i));
            Lrange.addItem(String.valueOf(i));
        }
        //ClassCatPm1
    }
    
    private void Slepa(){
        if(AddF1.isSelected()){
            AddF1N.setEnabled(true);
            AddF1S.setEnabled(true);
            AddF1W.setEnabled(true);
            AddF1E.setEnabled(true);
        }else{
            AddF1N.setEnabled(false);
            AddF1S.setEnabled(false);
            AddF1W.setEnabled(false);
            AddF1E.setEnabled(false);
        }
        
        if(AddF2.isSelected()){
            AddF2N.setEnabled(true);
            AddF2S.setEnabled(true);
            AddF2W.setEnabled(true);
            AddF2E.setEnabled(true);
        }else{
            AddF2N.setEnabled(false);
            AddF2S.setEnabled(false);
            AddF2W.setEnabled(false);
            AddF2E.setEnabled(false);
        }
        
        if(AddF3.isSelected()){
            AddF3N.setEnabled(true);
            AddF3S.setEnabled(true);
            AddF3W.setEnabled(true);
            AddF3E.setEnabled(true);
        }else{
            AddF3N.setEnabled(false);
            AddF3S.setEnabled(false);
            AddF3W.setEnabled(false);
            AddF3E.setEnabled(false);
        }
        
        if(AddF4.isSelected()){
            AddF4N.setEnabled(true);
            AddF4S.setEnabled(true);
            AddF4W.setEnabled(true);
            AddF4E.setEnabled(true);
        }else{
            AddF4N.setEnabled(false);
            AddF4S.setEnabled(false);
            AddF4W.setEnabled(false);
            AddF4E.setEnabled(false);
        }
    }
    
    private void Mng(){
        try {
            String Kret="UPDATE `tbl_ClassList` SET `"+Str+"`= 1 WHERE `Class`='"+Fm+"'";
            pst=(PreparedStatement) Conn.prepareStatement(Kret);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex+"\nClass Variables Errors");
        }
    }
    
    private void Greda(){
        if (FormGrad.getSelectedIndex()==0) {
            frgd="Form1";
        }
        if (FormGrad.getSelectedIndex()==1) {
            frgd="Form2";
        }
        if (FormGrad.getSelectedIndex()==2) {
            frgd="Form3";
        }
        if (FormGrad.getSelectedIndex()==3) {
            frgd="Form4";
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
            snmcls="Form3";
        }
        if (FrmSenrAdd.getSelectedIndex()==1) {
            snmcls="Form4";
        }
        
        /*if (StrmSenrAdd.getSelectedIndex()==0) {
            snmstr="North";
        }
        if (StrmSenrAdd.getSelectedIndex()==1) {
            snmstr="South";
        }
        if (StrmSenrAdd.getSelectedIndex()==2) {
            snmstr="East";
        }
        if (StrmSenrAdd.getSelectedIndex()==3) {
            snmstr="West";
        }*/
        
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
        if (SbjSenrChus.getSelectedIndex()==0) {
            snmsbj="Null";
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
    
    private void StrNx(){
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
                    StrNxt.addItem("All");
                    if(Nr ==1){
                        StrNxt.addItem("North");
                    }
                    if(St ==1){
                        StrNxt.addItem("South");
                    }
                    if(Ws ==1){
                        StrNxt.addItem("West");
                    }
                    if(Es ==1){
                        StrNxt.addItem("East");
                    }   
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nStr Error 22");
            }
    }
    
    private void StrPerf(){
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
                        StrPerf.addItem("North");
                    }
                    if(St ==1){
                        StrPerf.addItem("South");
                    }
                    if(Ws ==1){
                        StrPerf.addItem("West");
                    }
                    if(Es ==1){
                        StrPerf.addItem("East");
                    }   
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nStr Error 3");
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
            fdsa="Form3";
        }
        if (RepoClas.getSelectedIndex()==3) {
            fdsa="Form4";
        }
        try {
                String cops="SELECT Chemistry,Biology,Physics,Geography,CRE,Business,Agriculture FROM `tbl_Placer` WHERE `Class`='"+fdsa+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(cops);
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
                JOptionPane.showMessageDialog(null, e+"\nMade Error");
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
    
    private void Rugia(){
        int froma=Classe.getSelectedIndex();
        if (froma==0) {
            fromas="Form1";
            Summ(froma,45);
        }
        if (froma==1) {
            fromas="Form2";
        }
        if (froma==2) {
            fromas="Form3";
        }
    }
    
    private void InsBasic(int stdreg,Double stdscor,String stdsbjs){
        Nm();
        String sqll="UPDATE `"+lst+"` SET "+stdsbjs+"="+stdscor+" WHERE Reg_No="+stdreg+"";
        try {
            pst=(PreparedStatement) Conn.prepareStatement(sqll);
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex+" Basic Insertion Failed");
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
    //*-*-*-*-*-

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        All = new javax.swing.JPanel();
        PanLogs = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        BtnLogin = new javax.swing.JButton();
        PanHome = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        HmNewStudent = new javax.swing.JButton();
        HmTeacher = new javax.swing.JButton();
        HmStudents = new javax.swing.JButton();
        HmExam = new javax.swing.JButton();
        HmResults = new javax.swing.JButton();
        HmReports = new javax.swing.JButton();
        HmFee = new javax.swing.JButton();
        HmMails = new javax.swing.JButton();
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
        JrXmGen = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
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
        RepoTrm1 = new javax.swing.JRadioButton();
        RepoTrm2 = new javax.swing.JRadioButton();
        RepoTrm3 = new javax.swing.JRadioButton();
        SyncRepo = new javax.swing.JButton();
        Mprnt = new javax.swing.JButton();
        WannaBe = new javax.swing.JButton();
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
        CritLeaImp = new javax.swing.JRadioButton();
        CritMosImp = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbl_Analyse = new javax.swing.JTable();
        PanFinance = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
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
        jLabel24 = new javax.swing.JLabel();
        Cbf4 = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        YBx = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Cbf2 = new javax.swing.JCheckBox();
        Tr3 = new javax.swing.JRadioButton();
        ExxamTY = new javax.swing.JComboBox<>();
        Tr1 = new javax.swing.JRadioButton();
        Clser = new javax.swing.JComboBox<>();
        Cbf1 = new javax.swing.JCheckBox();
        Cbf3 = new javax.swing.JCheckBox();
        Tr2 = new javax.swing.JRadioButton();
        Senr = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        FrmSenrAdd = new javax.swing.JComboBox<>();
        StrmSenrAdd = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        SbjSenrChus = new javax.swing.JComboBox<>();
        SncSenr = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        SnrTblAd = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        SenrConfTbl = new javax.swing.JTable();
        InsrtSenr = new javax.swing.JButton();
        BacSett = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        ExamBay = new javax.swing.JComboBox<>();
        Marks = new javax.swing.JPanel();
        Pg0 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Tsta = new javax.swing.JTable();
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
        F4Log = new javax.swing.JLabel();
        F3Log = new javax.swing.JLabel();
        F2Log = new javax.swing.JLabel();
        F1Log = new javax.swing.JLabel();
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
        jPanel23 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        ClassMidPM1 = new javax.swing.JComboBox<>();
        ClassLvMid1 = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        ClassLvMidSbj1 = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        ClassMidFM1 = new javax.swing.JComboBox<>();
        PP1m = new javax.swing.JCheckBox();
        PP2m = new javax.swing.JCheckBox();
        PP3m = new javax.swing.JCheckBox();
        FFMid = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        ClassEndPM1 = new javax.swing.JComboBox<>();
        ClassLvEnd1 = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        ClassLvEndSbj1 = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        ClassEndFM1 = new javax.swing.JComboBox<>();
        PP1e = new javax.swing.JCheckBox();
        PP2e = new javax.swing.JCheckBox();
        PP3e = new javax.swing.JCheckBox();
        FFEnd = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        ClassCatPm1 = new javax.swing.JComboBox<>();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        ClassLvCatSbj1 = new javax.swing.JComboBox<>();
        jLabel66 = new javax.swing.JLabel();
        ClassLvCat1 = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        ClassCatFM1 = new javax.swing.JComboBox<>();
        FFCATS = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        AddF1 = new javax.swing.JCheckBox();
        AddF2 = new javax.swing.JCheckBox();
        AddF3 = new javax.swing.JCheckBox();
        AddF4 = new javax.swing.JCheckBox();
        SCls = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
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
        Head = new javax.swing.JPanel();
        MnAddStd = new javax.swing.JLabel();
        MnStd = new javax.swing.JLabel();
        MnExams = new javax.swing.JLabel();
        MnGraphs = new javax.swing.JLabel();
        MnCharts = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Exitt = new javax.swing.JLabel();
        Homie = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
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
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Log-in to Proceed"));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Username");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Password");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextField1.setToolTipText("");

        jPasswordField1.setToolTipText("");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Proceed As");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teacher", "Admin" }));

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
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
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

        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[] {0, 25, 0, 25, 0, 25, 0, 25, 0};
        jPanel4Layout.rowHeights = new int[] {0, 30, 0, 30, 0, 30, 0, 30, 0};
        jPanel4.setLayout(jPanel4Layout);

        HmNewStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/user-new-31.png"))); // NOI18N
        HmNewStudent.setToolTipText("Admit New Student");
        HmNewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmNewStudentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        jPanel4.add(HmNewStudent, gridBagConstraints);

        HmTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/identity.png"))); // NOI18N
        HmTeacher.setToolTipText("Staff Users");
        HmTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmTeacherActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        jPanel4.add(HmTeacher, gridBagConstraints);

        HmStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/system-users-4.png"))); // NOI18N
        HmStudents.setToolTipText("All Students");
        HmStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmStudentsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        jPanel4.add(HmStudents, gridBagConstraints);

        HmExam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/kate.png"))); // NOI18N
        HmExam.setToolTipText("Exams");
        HmExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmExamActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        jPanel4.add(HmExam, gridBagConstraints);

        HmResults.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/application-vnd.oasis.opendocument.spreadsheet-template.png"))); // NOI18N
        HmResults.setToolTipText("Exam Results");
        HmResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmResultsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        jPanel4.add(HmResults, gridBagConstraints);

        HmReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/office-chart-area-stacked1.png"))); // NOI18N
        HmReports.setToolTipText("Reports and Transcripts");
        HmReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmReportsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        jPanel4.add(HmReports, gridBagConstraints);

        HmFee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/emblem-money.png"))); // NOI18N
        HmFee.setToolTipText("Fee");
        HmFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmFeeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        jPanel4.add(HmFee, gridBagConstraints);

        HmMails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/mail-message.png"))); // NOI18N
        HmMails.setToolTipText("Mail and Messaging");
        HmMails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmMailsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        jPanel4.add(HmMails, gridBagConstraints);

        HmAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/system-users-3.png"))); // NOI18N
        HmAdmin.setToolTipText("Administrator");
        HmAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HmAdminActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        jPanel4.add(HmAdmin, gridBagConstraints);

        javax.swing.GroupLayout PanHomeLayout = new javax.swing.GroupLayout(PanHome);
        PanHome.setLayout(PanHomeLayout);
        PanHomeLayout.setHorizontalGroup(
            PanHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
            .addGroup(PanHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanHomeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PanHomeLayout.setVerticalGroup(
            PanHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(PanHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanHomeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
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

        StudentFindType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort By", "Class", "Reg No", "Stream" }));

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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
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

        JrXmGen.setText("Generate");
        JrXmGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JrXmGenActionPerformed(evt);
            }
        });

        jLabel52.setText("Exam Of Interest");

        jLabel53.setText("Class");

        RepoClas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4", "--Null--" }));

        RepoEX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CATS", "Mid-Term", "End-Term", "--Null--" }));

        jPanel46.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        GraphBar.setText("Bar");
        GraphBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphBarActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GraphLine)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(GraphBar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, Short.MAX_VALUE)
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

        VwCred.setText("View");
        VwCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VwCredActionPerformed(evt);
            }
        });

        jLabel68.setText("Exam Type");

        RepoTrm1.setText("Term 1");

        RepoTrm2.setText("Term 2");

        RepoTrm3.setText("Term 3");

        SyncRepo.setText("Sync");
        SyncRepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SyncRepoActionPerformed(evt);
            }
        });

        Mprnt.setText("Many Print");
        Mprnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MprntActionPerformed(evt);
            }
        });

        WannaBe.setText("Result Sheet");
        WannaBe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WannaBeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RepoEX, 0, 110, Short.MAX_VALUE)
                    .addComponent(RepoClas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(SyncRepo)
                        .addGap(15, 15, 15)
                        .addComponent(Mprnt))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(RepoTrm1)
                        .addGap(18, 18, 18)
                        .addComponent(RepoTrm2)
                        .addGap(18, 18, 18)
                        .addComponent(RepoTrm3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(JrXmGen)
                        .addGap(38, 38, 38)
                        .addComponent(VwCred, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(WannaBe, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
            .addComponent(jScrollPane5)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addGap(547, 547, 547)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(379, Short.MAX_VALUE)))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(RepoClas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68)
                    .addComponent(RepoTrm1)
                    .addComponent(RepoTrm2)
                    .addComponent(RepoTrm3)
                    .addComponent(WannaBe))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel52)
                        .addComponent(RepoEX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SyncRepo))
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JrXmGen)
                        .addComponent(VwCred)
                        .addComponent(Mprnt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(517, Short.MAX_VALUE)))
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

        FltPrf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compare", "Highest", "Lowest" }));
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
                        .addComponent(Ex2Perf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel84)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FltPrf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))))
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
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
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
            .addGap(0, 591, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Comparisons", jPanel29);

        jPanel47.setMinimumSize(new java.awt.Dimension(967, 553));
        jPanel47.setName(""); // NOI18N

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder("Criteria"));

        CritClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Class", "Form 1", "Form 2", "Form 3", "Form 4" }));
        CritClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CritClassActionPerformed(evt);
            }
        });

        CritStream.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stream" }));

        CritSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subjects", "Mathematics", "English", "Kiswahili", "Chemistry", "BIology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business Studies" }));

        CritAscend.setText("Ascending");

        CritDesc.setText("Descending");

        AnalyseExam.setText("Process");
        AnalyseExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalyseExamActionPerformed(evt);
            }
        });

        CritLeaImp.setText("Highest Decrement");

        CritMosImp.setText("Most Improved");

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
                            .addComponent(CritLeaImp)
                            .addComponent(CritMosImp))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AnalyseExam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(CritLeaImp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AnalyseExam)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(183, Short.MAX_VALUE))
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

        jLabel16.setText("Fees Per Class etc");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(796, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel16)
                .addContainerGap(439, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Fee Statement", jPanel11);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Search By"));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Deposits", jPanel12);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1045, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("tab3", jPanel13);

        javax.swing.GroupLayout PanFinanceLayout = new javax.swing.GroupLayout(PanFinance);
        PanFinance.setLayout(PanFinanceLayout);
        PanFinanceLayout.setHorizontalGroup(
            PanFinanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        PanFinanceLayout.setVerticalGroup(
            PanFinanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addContainerGap(288, Short.MAX_VALUE)
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
                .addComponent(DpImg, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );
        DpImgSLayout.setVerticalGroup(
            DpImgSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DpImgSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DpImg, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        NwStdImg.setText("...");
        NwStdImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NwStdImgActionPerformed(evt);
            }
        });

        NwStdFrm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form1", "Form2", "Form3", "Form4" }));
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
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(DpImgS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 153, Short.MAX_VALUE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(ImgP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
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
                        .addGap(0, 0, Short.MAX_VALUE)))
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

        NwResidence.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kiambu", "Murang'a", "Nairoboi", "Nyeri", "Nyandarua", "Nakuru", "Laikipia" }));

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
                .addGap(12, 12, 12)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(NwContacts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(NwResidence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Ext.setText("Exit");
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
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(NwSurName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(NwFrmSch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(NwKCPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(NwBirthYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(NwStdReg)
                        .addGap(34, 34, 34)
                        .addComponent(Ext)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NwStdReg)
                    .addComponent(Ext))
                .addContainerGap(114, Short.MAX_VALUE))
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

        Sett.setBackground(new java.awt.Color(204, 204, 204));
        Sett.setMinimumSize(new java.awt.Dimension(967, 594));
        Sett.setName(""); // NOI18N

        Nxt.setText("Next ->");
        Nxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NxtActionPerformed(evt);
            }
        });

        jLabel24.setText("Term");

        Cbf4.setText("Form 4");

        jLabel30.setText("Exam Type");

        jLabel31.setText("Year");

        jLabel32.setText("Classes");

        Cbf2.setText("Form 2");

        Tr3.setText("Term 3");

        ExxamTY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CATS", "Mid_Term", "End_Term", "-Null-" }));

        Tr1.setText("Term 1");

        Clser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Class", "Juniors", "Seniors" }));
        Clser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClserActionPerformed(evt);
            }
        });

        Cbf1.setText("Form 1");

        Cbf3.setText("Form 3");

        Tr2.setText("Term 2");

        javax.swing.GroupLayout SettLayout = new javax.swing.GroupLayout(Sett);
        Sett.setLayout(SettLayout);
        SettLayout.setHorizontalGroup(
            SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addGroup(SettLayout.createSequentialGroup()
                        .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ExxamTY, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YBx, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SettLayout.createSequentialGroup()
                                .addComponent(Tr1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(Tr2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Tr3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Clser, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SettLayout.createSequentialGroup()
                                .addComponent(Cbf1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Cbf2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SettLayout.createSequentialGroup()
                                .addComponent(Cbf3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Cbf4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(570, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Nxt, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(336, 336, 336))
        );
        SettLayout.setVerticalGroup(
            SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExxamTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(Tr1)
                    .addComponent(Tr2)
                    .addComponent(Tr3))
                .addGap(23, 23, 23)
                .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbf1)
                    .addComponent(Cbf2))
                .addGap(18, 18, 18)
                .addGroup(SettLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbf3)
                    .addComponent(Cbf4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addComponent(Nxt)
                .addGap(55, 55, 55))
        );

        Senr.setBackground(new java.awt.Color(204, 204, 204));
        Senr.setPreferredSize(new java.awt.Dimension(967, 594));

        jLabel79.setText("Form");

        jLabel80.setText("Stream");

        FrmSenrAdd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 3", "Form 4" }));
        FrmSenrAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrmSenrAddActionPerformed(evt);
            }
        });

        jLabel81.setText("Subject");

        SbjSenrChus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Null--", "Math.Eng.Kiswa", "Chemistry", "Biology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business" }));
        SbjSenrChus.setName(""); // NOI18N

        SncSenr.setText("Sync");
        SncSenr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SncSenrActionPerformed(evt);
            }
        });

        SnrTblAd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(SnrTblAd);

        SenrConfTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(SenrConfTbl);

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
                                .addComponent(ExamBay, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        Marks.setBackground(new java.awt.Color(204, 204, 204));
        Marks.setMinimumSize(new java.awt.Dimension(967, 594));

        Pg0.setBackground(new java.awt.Color(204, 204, 204));
        Pg0.setMinimumSize(new java.awt.Dimension(1000, 392));

        jScrollPane9.setPreferredSize(new java.awt.Dimension(1238, 468));

        Tsta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(Tsta);

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
            .addGap(0, 618, Short.MAX_VALUE)
            .addGroup(PanTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Marks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Senr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        Tr4.setText("Term 1");

        Tr5.setText("Term 2");

        Tr6.setText("Term 3");

        Cbf5.setText("Form 1");

        Cbf6.setText("Form 2");

        Cbf7.setText("Form 3");

        Cbf8.setText("Form 4");

        F4Log.setText("jLabel9");

        F3Log.setText("jLabel8");

        F2Log.setText("jLabel7");

        F1Log.setText("jLabel6");

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
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Cbf5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(F1Log, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Cbf6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(F2Log, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Cbf7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(F3Log, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Cbf8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(F4Log, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(Tr4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(Tr5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Tr6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel38)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(RstCont)
                        .addGap(137, 137, 137)
                        .addComponent(SetCont)))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(F1Log)
                    .addComponent(F2Log)
                    .addComponent(F3Log)
                    .addComponent(F4Log))
                .addGap(43, 43, 43)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RstCont)
                    .addComponent(SetCont))
                .addContainerGap(229, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(eXA, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Transfers", jPanel21);

        jPanel23.setDoubleBuffered(false);
        jPanel23.setFocusable(false);

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("Mid-Term Results"));

        ClassLvMid1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));

        jLabel56.setText("Form");

        jLabel57.setText("Subject");

        jLabel58.setText("Pass Marks");

        ClassLvMidSbj1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Subjects", "Mathematics", "English", "Kiswahili", "Chemistry", "Biology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business" }));
        ClassLvMidSbj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassLvMidSbj1ActionPerformed(evt);
            }
        });

        jLabel59.setText("Fail Mark");

        PP1m.setText("Paper One");

        PP2m.setText("Paper Two");

        PP3m.setText("Paper Three");

        FFMid.setText("Set");
        FFMid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FFMidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassLvMid1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel57)
                .addGap(32, 32, 32)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(PP1m)
                        .addGap(18, 18, 18)
                        .addComponent(PP2m)
                        .addGap(18, 18, 18)
                        .addComponent(PP3m)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FFMid))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(ClassLvMidSbj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClassMidPM1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassMidFM1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClassMidPM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(ClassLvMidSbj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(ClassLvMid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel59)
                    .addComponent(ClassMidFM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PP1m)
                    .addComponent(PP3m)
                    .addComponent(PP2m)
                    .addComponent(FFMid))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder("End-Term Results"));

        ClassLvEnd1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));

        jLabel60.setText("Form");

        jLabel61.setText("Subject");

        jLabel62.setText("Pass Marks");

        ClassLvEndSbj1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Subjects", "Mathematics", "English", "Kiswahili", "Chemistry", "Biology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business" }));
        ClassLvEndSbj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassLvEndSbj1ActionPerformed(evt);
            }
        });

        jLabel63.setText("Fail Mark");

        PP1e.setText("Paper One");

        PP2e.setText("Paper Two");

        PP3e.setText("Paper Three");

        FFEnd.setText("Set");
        FFEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FFEndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassLvEnd1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel61)
                .addGap(37, 37, 37)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(ClassLvEndSbj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClassEndPM1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClassEndFM1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(PP1e)
                        .addGap(18, 18, 18)
                        .addComponent(PP2e)
                        .addGap(18, 18, 18)
                        .addComponent(PP3e)
                        .addGap(104, 104, 104)
                        .addComponent(FFEnd)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClassEndPM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(ClassLvEndSbj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61)
                    .addComponent(ClassLvEnd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel63)
                    .addComponent(ClassEndFM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PP2e)
                    .addComponent(PP3e)
                    .addComponent(PP1e)
                    .addComponent(FFEnd)))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("CAT Results"));

        jLabel64.setText("Pass Marks");

        jLabel65.setText("Subject");

        ClassLvCatSbj1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Subjects", "Mathematics", "English", "Kiswahili", "Chemistry", "Biology", "Physics", "Geography", "CRE", "History", "Agriculture", "Business" }));

        jLabel66.setText("Form");

        ClassLvCat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form1", "Form2", "Form3", "Form4" }));

        jLabel67.setText("Fail Mark");

        FFCATS.setText("Set");
        FFCATS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FFCATSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassLvCat1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel65)
                .addGap(36, 36, 36)
                .addComponent(ClassLvCatSbj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassCatPm1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClassCatFM1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FFCATS)
                .addGap(141, 141, 141))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClassCatPm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(ClassLvCatSbj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65)
                    .addComponent(ClassLvCat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67)
                    .addComponent(ClassCatFM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(FFCATS))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Setting Marks", null, jPanel23, "");

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder("Class Streams"));

        jLabel45.setText("Add Classes To Interact With");

        AddF1.setText("Form 1");
        AddF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddF1ActionPerformed(evt);
            }
        });

        AddF2.setText("Form 2");
        AddF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddF2ActionPerformed(evt);
            }
        });

        AddF3.setText("Form 3");
        AddF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddF3ActionPerformed(evt);
            }
        });

        AddF4.setText("Form 4");
        AddF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddF4ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45)
                .addGap(18, 18, 18)
                .addComponent(AddF1)
                .addGap(31, 31, 31)
                .addComponent(AddF2)
                .addGap(18, 18, 18)
                .addComponent(AddF3)
                .addGap(31, 31, 31)
                .addComponent(AddF4)
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
                    .addComponent(AddF1)
                    .addComponent(AddF2)
                    .addComponent(AddF3)
                    .addComponent(AddF4))
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
                .addContainerGap(311, Short.MAX_VALUE))
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
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
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
                        .addGap(0, 316, Short.MAX_VALUE))
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
                        .addContainerGap(167, Short.MAX_VALUE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jTabbedPane6.addTab("Grading", jPanel41);

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FeeObject)
            .addComponent(FeeAmount)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane14)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(FeeObjectEdit)
                .addGap(18, 18, 18)
                .addComponent(FeeObjectAdd)
                .addGap(72, 72, 72))
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
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FeeObjectAdd)
                    .addComponent(FeeObjectEdit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
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
            .addGap(0, 580, Short.MAX_VALUE)
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

        jLabel13.setBackground(new java.awt.Color(255, 102, 102));
        jLabel13.setText("sdf");

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

        jLabel18.setText("jLabel18");

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
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(106, 106, 106)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Homie)
                .addGap(18, 18, 18)
                .addComponent(Exitt))
        );
        HeadLayout.setVerticalGroup(
            HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MnAddStd, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MnCharts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18))
            .addComponent(MnStd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MnExams, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MnGraphs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Exitt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Homie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    }//GEN-LAST:event_BtnLoginActionPerformed

    private void HmNewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmNewStudentActionPerformed
        // TODO add your handling code here:
        KillAll();
        PrepNewStd();
        PanAdmit.setVisible(true);
    }//GEN-LAST:event_HmNewStudentActionPerformed

    private void HmTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmTeacherActionPerformed
        // TODO add your handling code here:
        KillAll();
        PanTeacher.setVisible(true);
        CallTeacher(1);
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

    private void HmResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmResultsActionPerformed
        // TODO add your handling code here:
        KillAll();
        PanReports.setVisible(true);
    }//GEN-LAST:event_HmResultsActionPerformed

    private void HmReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmReportsActionPerformed
        // TODO add your handling code here:
        KillAll();
        PanReports.setVisible(true);
    }//GEN-LAST:event_HmReportsActionPerformed

    private void HmFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmFeeActionPerformed
        // TODO add your handling code here:
        KillAll();
        PopFinace();
        PanFinance.setVisible(true);
    }//GEN-LAST:event_HmFeeActionPerformed

    private void HmMailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmMailsActionPerformed
        // TODO add your handling code here:
        KillAll();
        PanFinance.setVisible(true);
    }//GEN-LAST:event_HmMailsActionPerformed

    private void HmAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HmAdminActionPerformed
        // TODO add your handling code here:
        KillAll();
        PopFee();
        PanAdmin.setVisible(true);
    }//GEN-LAST:event_HmAdminActionPerformed

    private void ExittMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExittMouseClicked
        // TODO add your handling code here:
        KillAll();
        Labo(1);
        PanLogs.setVisible(true);
    }//GEN-LAST:event_ExittMouseClicked

    private void HomieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomieMouseClicked
        // TODO add your handling code here:
        KillAll();
        PanHome.setVisible(true);
    }//GEN-LAST:event_HomieMouseClicked

    private void MnAddStdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnAddStdMouseClicked
        // TODO add your handling code here:
        KillAll();
        PanAdmit.setVisible(true);
    }//GEN-LAST:event_MnAddStdMouseClicked

    private void MnStdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnStdMouseClicked
        // TODO add your handling code here:
        KillAll();
        PanStudents.setVisible(true);
    }//GEN-LAST:event_MnStdMouseClicked

    private void MnExamsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnExamsMouseClicked
        // TODO add your handling code here:
        KillAll();
        PanMisc.setVisible(true);
    }//GEN-LAST:event_MnExamsMouseClicked

    private void MnGraphsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnGraphsMouseClicked
        // TODO add your handling code here:
        KillAll();
        PanReports.setVisible(true);
    }//GEN-LAST:event_MnGraphsMouseClicked

    private void MnChartsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnChartsMouseClicked
        // TODO add your handling code here:
        KillAll();
        PanReports.setVisible(true);
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
        /*try {
            JFileChooser prip=new JFileChooser();
            prip.showOpenDialog(null);
            File f=prip.getSelectedFile();
            Patt=f.getAbsolutePath();
            ImgP.setText(Patt);

            ImageIcon stV=new ImageIcon(Patt);
            Image Sd=stV.getImage().getScaledInstance(DpImg.getWidth(),DpImg.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon im=new ImageIcon(Sd);
            DpImg.setIcon(im);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Null or Invalid 'Image' File");
        }*/
    }//GEN-LAST:event_NwStdImgActionPerformed

    private void NwStdFrmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NwStdFrmActionPerformed
        // TODO add your handling code here:
        if (NwStdFrm.getSelectedIndex()==0) {
            ClStr="Form1";
            NwStdFrmSrm.removeAllItems();
            Str();
        }
        if (NwStdFrm.getSelectedIndex()==1) {
            ClStr="Form2";
            NwStdFrmSrm.removeAllItems();
            Str();
        }
        if (NwStdFrm.getSelectedIndex()==2) {
            ClStr="Form3";
            NwStdFrmSrm.removeAllItems();
            Str();
        }
        if (NwStdFrm.getSelectedIndex()==3) {
            ClStr="Form4";
            NwStdFrmSrm.removeAllItems();
            Str();
        }

//        if (NwStdFrm.getSelectedIndex()>1) {
//            Mann.setVisible(Boolean.FALSE);
//            Conff.setVisible(Boolean.TRUE);
//        }
//
//        NWstdStNm.setText(NwFullName.getText().toString());
//        NWstdStRg.setText(RgNo.getText().toString());
//        NWstdStFm.setText(NwStdFrm.getSelectedItem().toString());
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
    }//GEN-LAST:event_ExtActionPerformed

    private void JrXmGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JrXmGenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JrXmGenActionPerformed

    private void GraphBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphBarActionPerformed
        // TODO add your handling code here:
        try {
            //String Etha="SELECT `Name`,`Mathematics`,`English`,`Kiswahili` FROM "+lst+" WHERE `Class`='Form1' ";
            String Etha="SELECT `Name`,`Mathematics`,`English`,`Kiswahili`,`Chemistry`,`Biology`,`Physics`,`Geography`,`CRE`,`History`,`Agriculture`,`Business` FROM "+lst+" WHERE `Class`='Form1' ";
            JDBCCategoryDataset jcd=new JDBCCategoryDataset(Recorda.InitDb(),Etha);
            JFreeChart cht=ChartFactory.createBarChart("Student No, Performance", "Student Name","Y-Axs", jcd, PlotOrientation.VERTICAL, false, true, true);
            BarRenderer rndr=new BarRenderer();
            CategoryPlot cp=null;
            rndr=new BarRenderer();
            ChartFrame cf=new ChartFrame("Testing F High School", cht);
            cf.setVisible(true);
            cf.pack();
            
            final CategoryPlot catplot= cht.getCategoryPlot();
            rndr= (BarRenderer)catplot.getRenderer();
            DecimalFormat dcfm=new DecimalFormat("#.#");
            rndr.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}",dcfm));
            catplot.setRenderer(rndr);
            rndr.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.HALF_ASCENT_CENTER));
            rndr.setItemLabelsVisible(Boolean.TRUE);
            cht.getCategoryPlot().setRenderer(rndr);

            final ChartRenderingInfo cri=new ChartRenderingInfo(new StandardEntityCollection());
            final File chtfile= new File(lst+"Bar-Std Name.png");
            ChartUtilities.saveChartAsPNG(chtfile, cht, cf.getWidth(), cf.getHeight());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_GraphBarActionPerformed

    private void GraphLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphLineActionPerformed
        // TODO add your handling code here:
        try {
            //String Etha="SELECT `"+sbj+"` FROM `"+Todas+"` ";
            String Etha="SELECT `Name`,`Mathematics`,`English`,`Kiswahili`,`Chemistry`,`Biology`,`Physics`,`Geography`,`CRE`,`History`,`Agriculture`,`Business` FROM "+lst+" WHERE `Class`='Form1' ";
            //pst=(PreparedStatement) conn.prepareStatement(Etha);
            //rs=pst.executeQuery();
            JDBCCategoryDataset jcd=new JDBCCategoryDataset(Recorda.InitDb(),Etha);
            //JFreeChart cht=ChartFactory.createLineChart("English Performance", "Student Name","English", jcd, PlotOrientation.VERTICAL, false, true, true);
            JFreeChart cht=ChartFactory.createLineChart("Student Put Here Performance", "Student Name","Y-Ax", jcd, PlotOrientation.VERTICAL, false, true, true);
            BarRenderer rndr=null;
            CategoryPlot cp=null;
            rndr=new BarRenderer();
            ChartFrame cf=new ChartFrame("Testing F High School", cht);
            cf.setVisible(true);
            cf.pack();

            /*final CategoryPlot catplot= cht.getCategoryPlot();
            rndr= (BarRenderer)catplot.getRenderer();
            DecimalFormat dcfm=new DecimalFormat("#.#");
            rndr.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}",dcfm));
            catplot.setRenderer(rndr);
            rndr.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.HALF_ASCENT_CENTER));
            rndr.setItemLabelsVisible(Boolean.TRUE);
            cht.getCategoryPlot().setRenderer(rndr);*/

            final ChartRenderingInfo cri=new ChartRenderingInfo(new StandardEntityCollection());
            final File chtfile= new File(lst+"Line-Std Name.png");
            ChartUtilities.saveChartAsPNG(chtfile, cht, cf.getWidth(), cf.getHeight());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_GraphLineActionPerformed

    private void VwCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VwCredActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, lst);
        String csa=null,sq=null;
        if (RepoClas.getSelectedIndex()==0) {
            csa="Form1";
        }
        if (RepoClas.getSelectedIndex()==1) {
            csa="Form2";
        }
        if (RepoClas.getSelectedIndex()==02) {
            csa="Form3";
        }
        if (RepoClas.getSelectedIndex()==03) {
            csa="Form4";
        }
        try {
            String locc="/media/niccher/Bookies/Ap/Coding Theory/3/Muruaky3.0/src/v3/ClassAll.jrxml";
            JasperDesign jd=JRXmlLoader.load(locc);
            //lst="Name Class Reg_No Mathematics English Kiswahili Chemistry Biology Physics Geography History CRE Business Agriculture";
            /*sq="SELECT Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,History,CRE,Business,Agriculture FROM "+lst+" WHERE Class="+csa+" ";
            JRDesignQuery nq=new JRDesignQuery();
            nq.setText(sq);
            jd.setQuery(nq);*/
            JasperReport jas=JasperCompileManager.compileReport(jd);
            JasperPrint jprn=JasperFillManager.fillReport(jas, null, Conn);
            JasperViewer.viewReport(jprn,Boolean.FALSE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nJasper Error\n"+csa+"\n"+sq);
        }
    }//GEN-LAST:event_VwCredActionPerformed

    private void SyncRepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SyncRepoActionPerformed
        // TODO add your handling code here:
        String et,fll,trm;
        Calendar cl=new GregorianCalendar();
        int Y=cl.get(Calendar.YEAR);
        et=RepoEX.getSelectedItem().toString();
        fll=RepoClas.getSelectedItem().toString();
        //2018_CATS_Term2_Form2 CATS, Mid-Term, End-Term
        /*if (et=="CATS") {
            mck="CATS";
        }else if (et=="Mid-Term") {
            mck="Mid_Term";
        }else if (et=="End-Term") {
            mck="End_Term";
        }
        if (RepoTrm1.isSelected()) {
            Tem="Term1";
        }
        else if (RepoTrm2.isSelected()) {
            Tem="Term2";
            //JOptionPane.showMessageDialog(null, Tem);
        }
        else if (RepoTrm3.isSelected()) {
            Tem="Term3";
        }
        Tbll=String.valueOf(Y)+"_"+mck+"_"+Tem+"_"+pc;*/
        Nm();
        Tbll=lst;
        String pc=null;

        if (RepoClas.getSelectedIndex()==0) {
            pc="Form1";
        }
        if (RepoClas.getSelectedIndex()==1) {
            pc="Form2";
        }
        if (RepoClas.getSelectedIndex()==2) {
            pc="Form3";
        }
        if (RepoClas.getSelectedIndex()==3) {
            pc="Form4";
        }

        if (RepoEX.getSelectedIndex()==0) {
            Tem="CATS";
        }
        if (RepoEX.getSelectedIndex()==1) {
            Tem="Mid_Term";
        }
        if (RepoEX.getSelectedIndex()==2) {
            Tem="End_Term";
        }

        if (RepoTrm1.isSelected()) {
            mck="Term 1";
        }else if (RepoTrm2.isSelected()) {
            mck="Term 2";
        }else if (RepoTrm3.isSelected()) {
            mck="Term 3";
        }

        if (pc=="Form3" || pc=="Form4") {
            try {
                Makeit();
                String cops="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,Business,Agriculture FROM "+Tbll+" WHERE (`Class`='"+pc+"' )";
                pst=(PreparedStatement) Conn.prepareStatement(cops);
                rs=pst.executeQuery();
                RepoTbl.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nAction Not Allowed Please");
            }

        }else{
            try {
                String cops="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,CRE,Business,Agriculture FROM "+Tbll+" WHERE (`Class`='"+pc+"' )";
                pst=(PreparedStatement) Conn.prepareStatement(cops);
                rs=pst.executeQuery();
                RepoTbl.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nAction Not Allowed Please");
            }
        }
    }//GEN-LAST:event_SyncRepoActionPerformed

    private void MprntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MprntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MprntActionPerformed

    private void WannaBeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WannaBeActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tts=(DefaultTableModel) RepoTbl.getModel();
        int reg=Integer.parseInt(RepoTbl.getValueAt(RepoTbl.getSelectedRow(), 1).toString()) ;
        String stfnam=(RepoTbl.getValueAt(RepoTbl.getSelectedRow(), 0).toString()) ;
        try {
            String locc="/media/niccher/Bookies/Ap/Coding Theory/3/Muruaky3.0/src/v3/Wannabe.jrxml";
            JasperDesign jd=JRXmlLoader.load(locc);
            //lst="Name,Class,Reg_No,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,Geography,History,CRE,Business,Agriculture";
            String sq="SELECT * FROM "+lst+" WHERE Reg_No="+reg+" ";
            JRDesignQuery nq=new JRDesignQuery();
            nq.setText(sq);
            jd.setQuery(nq);//
            JasperReport jas=JasperCompileManager.compileReport(jd);
            JasperPrint jprn=JasperFillManager.fillReport(jas, null, Conn);
            JasperViewer.viewReport(jprn,Boolean.FALSE);

            String jrpdf="/media/niccher/Bookies/Ap/Coding Theory/3/Muruaky3.0/"+stfnam+".pdf";
            JRExporter exp=new JRPdfExporter();
            exp.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, jrpdf);
            exp.setParameter(JRExporterParameter.JASPER_PRINT, jprn);
            exp.exportReport();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nJasper Error");
        }
    }//GEN-LAST:event_WannaBeActionPerformed

    private void RstContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RstContActionPerformed
        // TODO add your handling code here:
        //YBx.setSelectedItem(2014);
        /*Cbf5.setSelected(false);
        Cbf6.setSelected(false);
        Cbf7.setSelected(false);
        Cbf8.setSelected(false);*/
        F1Log.setText(null);
        F4Log.setText(null);
        F3Log.setText(null);
        F2Log.setText(null);
        //Conf();
    }//GEN-LAST:event_RstContActionPerformed

    private void SetContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetContActionPerformed
        // TODO add your handling code here:
        int t=Integer.parseInt((String) YBx1.getSelectedItem());
        String tty1=((String) ExxamTY1.getSelectedItem().toString());
        Droop();
        Conf();

        //if (Cbf1.isSelected()) {
            //F1Log.setText("Pending");
            //Mats="Form1";
            //cs=t+"_"+tty1+"_"+Tem+"_"+Mats;
            cs=t+"_"+tty1+"_"+Tem;
            try{
                String Std="CREATE TABLE IF NOT EXISTS `"+cs+"` (`Count` int(3) NOT NULL AUTO_INCREMENT,`Name` varchar(50) NOT NULL,`Class` VARCHAR(5) NOT NULL,"
                + "`Reg_No` int(10) NOT NULL,`Stream` varchar(10) NOT NULL,`Mathematics` float NOT NULL DEFAULT '0',`English` float NOT NULL DEFAULT '0',"
                + "`Kiswahili` float NOT NULL DEFAULT '0',`Chemistry` float NOT NULL DEFAULT '0',`Biology` float NOT NULL DEFAULT '0',"
                + "`Physics` float NOT NULL DEFAULT '0',`Geography` float NOT NULL DEFAULT '0',`History` float NOT NULL DEFAULT '0',"
                + "`CRE` float NOT NULL DEFAULT '0',`Business` float NOT NULL DEFAULT '0',`Agriculture` float NOT NULL DEFAULT '0',"
                + "PRIMARY KEY (Reg_No),UNIQUE (`Count`) )";

                PreparedStatement pst1 = (PreparedStatement) Conn.prepareStatement(Std);
                pst1.execute();

                Filla();

                JOptionPane.showMessageDialog(null,cs+" Table Building Sucesfull");

                //F1Log.setText("Sucess");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex+"\nForm Table Bulding Segmentation Fault");
                //F1Log.setText("Failed");
            }
            //}

        /*if (Cbf2.isSelected()) {
            F2Log.setText("Pending");
            Mats="Form2";
            //cs=t+"_"+tty1+"_"+Tem+"_"+Mats;
            cs=t+"_"+tty1+"_"+Tem;
            try{
                String Std="CREATE TABLE IF NOT EXISTS `"+cs+"` (`Count` int(3) NOT NULL AUTO_INCREMENT,`Name` varchar(50) NOT NULL,`Class` VARCHAR(5) NOT NULL,"
                + "`Reg_No` int(10) NOT NULL,`Mathematics` float NOT NULL DEFAULT '0',`English` float NOT NULL DEFAULT '0',"
                + "`Kiswahili` float NOT NULL DEFAULT '0',`Chemistry` float NOT NULL DEFAULT '0',`Biology` float NOT NULL DEFAULT '0',"
                + "`Physics` float NOT NULL DEFAULT '0',`Geography` float NOT NULL DEFAULT '0',`History` float NOT NULL DEFAULT '0',"
                + "`CRE` float NOT NULL DEFAULT '0',`Business` float NOT NULL DEFAULT '0',`Agriculture` float NOT NULL DEFAULT '0',"
                + "PRIMARY KEY (Reg_No),UNIQUE (`Count`) )";

                PreparedStatement pst1 = conn.prepareStatement(Std);
                pst1.execute();

                Filla();

                F2Log.setText("Sucess");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex+"\nForm 2 Segmentation Fault");
                F2Log.setText("Failed");
            }
        }

        if (Cbf3.isSelected()) {
            F3Log.setText("Pending");
            Mats="Form3";
            //cs=t+"_"+tty1+"_"+Tem+"_"+Mats;
            cs=t+"_"+tty1+"_"+Tem;
            try{
                String Std="CREATE TABLE IF NOT EXISTS `"+cs+"` (`Count` int(3) NOT NULL AUTO_INCREMENT,`Name` varchar(50) NOT NULL,`Class` VARCHAR(5) NOT NULL,"
                + "`Reg_No` int(10) NOT NULL,`Mathematics` float NOT NULL DEFAULT '0',`English` float NOT NULL DEFAULT '0',"
                + "`Kiswahili` float NOT NULL DEFAULT '0',`Chemistry` float NOT NULL DEFAULT '0',`Biology` float NOT NULL DEFAULT '0',"
                + "`Physics` float NOT NULL DEFAULT '0',`Geography` float NOT NULL DEFAULT '0',`History` float NOT NULL DEFAULT '0',"
                + "`CRE` float NOT NULL DEFAULT '0',`Business` float NOT NULL DEFAULT '0',`Agriculture` float NOT NULL DEFAULT '0',"
                + "PRIMARY KEY (Reg_No),UNIQUE (`Count`) )";

                PreparedStatement pst1 = conn.prepareStatement(Std);
                pst1.execute();

                Filla();

                F3Log.setText("Sucess");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex+"\nForm 3 Segmentation Fault");
                F3Log.setText("Failed");
            }
        }

        if (Cbf4.isSelected()) {
            F4Log.setText("Pending");
            Mats="Form4";
            //cs=t+"_"+tty1+"_"+Tem+"_"+Mats;
            cs=t+"_"+tty1+"_"+Tem;
            try{
                String Std="CREATE TABLE IF NOT EXISTS `"+cs+"` (`Count` int(3) NOT NULL AUTO_INCREMENT,`Name` varchar(50) NOT NULL,`Class` VARCHAR(5) NOT NULL,"
                + "`Reg_No` int(10) NOT NULL,`Mathematics` float NOT NULL DEFAULT '0',`English` float NOT NULL DEFAULT '0',"
                + "`Kiswahili` float NOT NULL DEFAULT '0',`Chemistry` float NOT NULL DEFAULT '0',`Biology` float NOT NULL DEFAULT '0',"
                + "`Physics` float NOT NULL DEFAULT '0',`Geography` float NOT NULL DEFAULT '0',`History` float NOT NULL DEFAULT '0',"
                + "`CRE` float NOT NULL DEFAULT '0',`Business` float NOT NULL DEFAULT '0',`Agriculture` float NOT NULL DEFAULT '0',"
                + "PRIMARY KEY (Reg_No),UNIQUE (`Count`) )";

                PreparedStatement pst1 = conn.prepareStatement(Std);
                pst1.execute();

                Filla();

                F4Log.setText("Sucess");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex+"\nForm 4 Segmentation Fault");
                F4Log.setText("Failed");
            }
        }*/

        try {
            String Puz4="INSERT INTO `tbl_Tests` (`Count`, `Test`) VALUES (NULL, '"+cs+"' )";
            PreparedStatement pstf4 = (PreparedStatement) Conn.prepareStatement(Puz4);
            pstf4.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e+"\nTest Above Already Exists");
        }
    }//GEN-LAST:event_SetContActionPerformed

    private void ClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClasseActionPerformed
        // TODO add your handling code here:
        StrNxt.setEnabled(Boolean.TRUE);
        if (Classe.getSelectedIndex()==0) {
            ClStr="Form1";
            StrNxt.removeAllItems();
            StrNx();
        }
        if (Classe.getSelectedIndex()==1) {
            ClStr="Form2";
            StrNxt.removeAllItems();
            StrNx();
        }
        if (Classe.getSelectedIndex()==2) {
            ClStr="Form3";
            StrNxt.removeAllItems();
            StrNx();
        }
    }//GEN-LAST:event_ClasseActionPerformed

    private void ComBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComBinActionPerformed
        // TODO add your handling code here:
        int ccl=Classe.getSelectedIndex();
        String srm=StrNxt.getSelectedItem().toString();
        Lasta();

        if (ccl==0) {
            tbl="Form1";
        }if(ccl==1){
            tbl="Form2";
        }if(ccl==2){
            tbl="Form3";
        }if(ccl==3){
            tbl="Form4";
        }

        if (ComBin.getSelectedIndex()==1) {
            try {
                if (srm=="All") {
                    String Sq="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,History,Geography,CRE,Agriculture,Business FROM `"+lst+"` WHERE `Class`='"+tbl+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                }
                else{
                    String Sq="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,History,Geography,CRE,Agriculture,Business FROM `"+lst+"` WHERE `Class`='"+tbl+"' AND `Stream`='"+srm+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nNext Level Miss"+tbl);
            }
        }
        if(ComBin.getSelectedIndex()==0) {
            try {
                /*/*/
                int Mathpass=0,Engpass=0,Kiswapass=0,Chempass=0,Biopass=0,Phypass=0,Histpass=0,Geopass=0,CREpass=0,Agricpass=0,Buspass=0;

                String TrmSdy=null,EmTy=null;
                int Yer=cc.get(Calendar.YEAR);

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
                /*/*/
                if (srm=="All") {

                    String Sq="SELECT * FROM `"+lst+"` WHERE `Class`='"+tbl+"' AND `Mathematics`>='"+Mathpass+"' AND `English`>='"+Engpass+"' AND `Kiswahili`>='"+Kiswapass+"' AND `Chemistry`>='"+Chempass+"' AND `Biology` >='"+Biopass+"' AND `Physics`>='"+Phypass+"' AND `History`>='"+Histpass+"' AND `Geography`>='"+Geopass+"' AND `CRE`>='"+CREpass+"' AND `Agriculture`>='"+Agricpass+"' AND `Business`>='"+Buspass+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                }
                else{
                    String Sq="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,History,Geography,CRE,Agriculture,Business FROM `"+lst+"` WHERE `Class`='"+tbl+"' AND `Stream`='"+srm+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nPass level init fail");
            }
        }
        if(ComBin.getSelectedIndex()==3) {
            try {

                int Mathfail=0,Engfail=0,Kiswafail=0,Chemfail=0,Biofail=0,Phyfail=0,Histfail=0,Geofail=0,CREfail=0,Agricfail=0,Busfail=0;

                String TrmSdy=null,EmTy=null;
                int Yer=cc.get(Calendar.YEAR);

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

                String sav="SELECT * FROM `tbl_MarkF`  WHERE `Year`= '"+Yer+"' AND `Term`='"+TrmSdy+"' AND `EXAM`= '"+EmTy+"'";
                pst=(PreparedStatement) Conn.prepareStatement(sav);
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
                if (srm=="All") {

                    String Sq="SELECT * FROM `"+lst+"` WHERE `Class`='"+tbl+"' AND `Mathematics`<='"+Mathfail+"' AND `English`<='"+Engfail+"' AND `Kiswahili`<='"+Kiswafail+"' AND `Chemistry`<='"+Chemfail+"' AND `Biology` <='"+Biofail+"' AND `Physics`<='"+Phyfail+"' AND `History`<='"+Histfail+"' AND `Geography`<='"+Geofail+"' AND `CRE`<='"+CREfail+"' AND `Agriculture`<='"+Agricfail+"' AND `Business`<='"+Busfail+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                }
                else{
                    String Sq="SELECT Name,Reg_No,Stream,Mathematics,English,Kiswahili,Chemistry,Biology,Physics,History,Geography,CRE,Agriculture,Business FROM `"+lst+"` WHERE `Class`='"+tbl+"' AND `Stream`='"+srm+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(Sq);
                    rs=pst.executeQuery();
                    Leva.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "\nTable Missing");
            }
        }
    }//GEN-LAST:event_ComBinActionPerformed

    private void TrnClsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrnClsActionPerformed
        // TODO add your handling code here:
        int aigana=Leva.getSelectedRowCount(),ndari=0,regpass=0;
        String newcls=null;
        if (Classe.getSelectedIndex()==0){
            newcls="Form2";
        }
        if (Classe.getSelectedIndex()==1){
            newcls="Form3";
        }
        if (Classe.getSelectedIndex()==2){
            newcls="Form4";
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
                    JOptionPane.showMessageDialog(null, "\nProgression Error"+ e);
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

    private void ClassLvMidSbj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassLvMidSbj1ActionPerformed
        // TODO add your handling code here:
        if (ClassLvMidSbj1.getSelectedIndex()==0 ){
            PP1m.setEnabled(false);
            PP2m.setEnabled(false);
            PP3m.setEnabled(false);
        }else if (ClassLvMidSbj1.getSelectedIndex()>0 ){
            PP1m.setEnabled(true);
            PP2m.setEnabled(true);
            PP3m.setEnabled(true);
        }
    }//GEN-LAST:event_ClassLvMidSbj1ActionPerformed

    private void FFMidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FFMidActionPerformed
        // TODO add your handling code here:
        ths="Mid";
        fcll=ClassLvMid1.getSelectedItem().toString();
        Setta();
        SBJ=ClassLvMidSbj1.getSelectedItem().toString();
        sbjPck=(ClassLvMidSbj1.getSelectedIndex());
        pmp=Integer.parseInt(ClassMidPM1.getSelectedItem().toString());
        pmf=Integer.parseInt(ClassMidFM1.getSelectedItem().toString());
        if (sbjPck==0) {
            try {
                //String UpdF="UPDATE `tbl_MarkF` SET `Form`='"+fcll+"',`Exam`='"+fcll+"',`Term`='"+Trm+"',`Mathematics`=' "+pmf+" ',`English`=' "+pmf+" ',`Kiswahili`=' "+pmf+" ',`Chemistry`=' "+pmf+" ',`Biology`=' "+pmf+" ',`Physics`=' "+pmf+" ',`Geography`=' "+pmf+" ',`History`=' "+pmf+" ',`CRE`=' "+pmf+" ',`Business`=' "+pmf+" ',`Agriculture`=' "+pmf+" ' WHERE `Code`=' "+spa+" ' ";
                String Std="INSERT INTO `tbl_MarkF`(`Count`, `Year`, `Form`, `Exam`, `Term`, `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ')";
                PreparedStatement pst1 = (PreparedStatement) Conn.prepareStatement(Std);
                pst1.execute();

                String Std2="INSERT INTO `tbl_MarkP`(`Count`, `Year`, `Form`, `Exam`, `Term`, `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ')";
                PreparedStatement pst2 = (PreparedStatement) Conn.prepareStatement(Std2);
                pst2.execute();

                JOptionPane.showMessageDialog(null, "\nSucesfully Done\n"+SBJ+" Range Set Is "+pmp+" <-+->"+pmf+"");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nUpdation Of Margins/Range Of All Subject Errored");
            }
        }else if (sbjPck>0) {
            try {
                String UpdF="INSERT INTO `tbl_MarkF` (`Count`, `Year`, `Form`, `Exam`, `Term`, `"+SBJ+"`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+spa+"',' "+pmf+" ' )";
                PreparedStatement pstf = (PreparedStatement) Conn.prepareStatement(UpdF);
                pstf.executeUpdate();

                String UpdP="INSERT INTO `tbl_MarkP` (`Count`, `Year`, `Form`, `Exam`, `Term`, `"+SBJ+"`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+spa+"',' "+pmp+" ' )";
                PreparedStatement pstp = (PreparedStatement) Conn.prepareStatement(UpdP);
                pstp.executeUpdate();

                JOptionPane.showMessageDialog(null, "\nSucesfully Done\n"+SBJ+" Range Set Is "+pmp+" <-+->"+pmf+"");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nUpdation Of Margins/Range Of "+SBJ+" Errored");
            }
        }
    }//GEN-LAST:event_FFMidActionPerformed

    private void ClassLvEndSbj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassLvEndSbj1ActionPerformed
        // TODO add your handling code here:
        if (ClassLvEndSbj1.getSelectedIndex()==0 ){
            PP1e.setEnabled(false);
            PP2e.setEnabled(false);
            PP3e.setEnabled(false);
        }else if (ClassLvEndSbj1.getSelectedIndex()>0 ){
            PP1e.setEnabled(true);
            PP2e.setEnabled(true);
            PP3e.setEnabled(true);
        }
    }//GEN-LAST:event_ClassLvEndSbj1ActionPerformed

    private void FFEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FFEndActionPerformed
        // TODO add your handling code here:
        ths="End";
        Setta();
        fcll=ClassLvEnd1.getSelectedItem().toString();
        SBJ=ClassLvEndSbj1.getSelectedItem().toString();
        sbjPck=(ClassLvEndSbj1.getSelectedIndex());
        pmp=Integer.parseInt(ClassEndPM1.getSelectedItem().toString());
        pmf=Integer.parseInt(ClassEndFM1.getSelectedItem().toString());
        if (sbjPck==0) {
            try {
                //String UpdF="UPDATE `tbl_MarkF` SET `Form`='"+fcll+"',`Exam`='"+fcll+"',`Term`='"+Trm+"',`Mathematics`=' "+pmf+" ',`English`=' "+pmf+" ',`Kiswahili`=' "+pmf+" ',`Chemistry`=' "+pmf+" ',`Biology`=' "+pmf+" ',`Physics`=' "+pmf+" ',`Geography`=' "+pmf+" ',`History`=' "+pmf+" ',`CRE`=' "+pmf+" ',`Business`=' "+pmf+" ',`Agriculture`=' "+pmf+" ' WHERE `Code`=' "+spa+" ' ";
                String Std="INSERT INTO `tbl_MarkF`(`Count`, `Year`, `Form`, `Exam`, `Term`, `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ')";
                PreparedStatement pst1 = (PreparedStatement) Conn.prepareStatement(Std);
                pst1.execute();

                String Std2="INSERT INTO `tbl_MarkP`(`Count`, `Year`, `Form`, `Exam`, `Term`, `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ')";
                PreparedStatement pst2 = (PreparedStatement) Conn.prepareStatement(Std2);
                pst2.execute();

                JOptionPane.showMessageDialog(null, "\nSucesfully Done\n"+SBJ+" Range Set Is "+pmp+" <-+->"+pmf+"");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nUpdation Of Margins/Range Of All Subjects Errored"+fcll);
            }
        }else if (sbjPck>0) {
            try {
                String UpdF="INSERT INTO `tbl_MarkF` (`Count`, `Year`, `Form`, `Exam`, `Term`, `"+SBJ+"`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmf+" ' )";
                PreparedStatement pstf = (PreparedStatement) Conn.prepareStatement(UpdF);
                pstf.executeUpdate();

                String UpdP="INSERT INTO `tbl_MarkP` (`Count`, `Year`, `Form`, `Exam`,` `Term`, `"+SBJ+"`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmp+" ' )";
                PreparedStatement pstp = (PreparedStatement) Conn.prepareStatement(UpdP);
                pstp.executeUpdate();

                JOptionPane.showMessageDialog(null, "\nSucesfully Done\n"+SBJ+" Range Set Is "+pmp+" <-+->"+pmf+"");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nUpdation Of Margins/Range Of "+SBJ+" Errored");
            }
        }
    }//GEN-LAST:event_FFEndActionPerformed

    private void FFCATSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FFCATSActionPerformed
        // TODO add your handling code here:
        ths="CATS";
        Setta();
        fcll=ClassLvCat1.getSelectedItem().toString();
        pmp=Integer.parseInt(ClassCatPm1.getSelectedItem().toString());
        pmf=Integer.parseInt(ClassCatFM1.getSelectedItem().toString());
        if (sbjPck==0) {
            try {
                //String UpdF="UPDATE `tbl_MarkF` SET `Form`='"+fcll+"',`Exam`='"+fcll+"',`Term`='"+Trm+"',`Mathematics`=' "+pmf+" ',`English`=' "+pmf+" ',`Kiswahili`=' "+pmf+" ',`Chemistry`=' "+pmf+" ',`Biology`=' "+pmf+" ',`Physics`=' "+pmf+" ',`Geography`=' "+pmf+" ',`History`=' "+pmf+" ',`CRE`=' "+pmf+" ',`Business`=' "+pmf+" ',`Agriculture`=' "+pmf+" ' WHERE `Code`=' "+spa+" ' ";
                String Std="INSERT INTO `tbl_MarkF`(`Count`, `Year`, `Form`, `Exam`,`Term`, `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture`) VALUES (NULL,' "+ya+" ',' "+fcll+" ','"+ths+"','"+Trm+"',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ',' "+pmf+" ')";
                PreparedStatement pst1 = (PreparedStatement) Conn.prepareStatement(Std);
                pst1.execute();

                String Std2="INSERT INTO `tbl_MarkP`(`Count`, `Year`, `Form`, `Exam`, `Term`, `Mathematics`, `English`, `Kiswahili`, `Chemistry`, `Biology`, `Physics`, `Geography`, `History`, `CRE`, `Business`, `Agriculture`) VALUES (NULL,' "+ya+" ',' "+fcll+" ','"+ths+"','"+Trm+"',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ',' "+pmp+" ')";
                PreparedStatement pst2 = (PreparedStatement) Conn.prepareStatement(Std2);
                pst2.execute();

                JOptionPane.showMessageDialog(null, "\nSucesfully Done\n"+SBJ+" Range Set Is "+pmp+" <-+->"+pmf+"");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nUpdation Of Margins/Range Of "+SBJ+" Errored");
            }
        }else if (sbjPck>0) {
            try {
                String UpdF="INSERT INTO `tbl_MarkF` (`Count`, `Year`, `Form`, `Exam`, `Term`, `"+SBJ+"`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmf+" ' )";
                PreparedStatement pstf = (PreparedStatement) Conn.prepareStatement(UpdF);
                pstf.executeUpdate();

                String UpdP="INSERT INTO `tbl_MarkP` (`Count`, `Year`, `Form`, `Exam`, `Term`, `"+SBJ+"`) VALUES (NULL,' "+ya+" ','"+fcll+"','"+ths+"','"+Trm+"',' "+pmp+" ' )";
                PreparedStatement pstp = (PreparedStatement) Conn.prepareStatement(UpdP);
                pstp.executeUpdate();

                JOptionPane.showMessageDialog(null, "\nSucesfully Done\n"+SBJ+" Range Set Is "+pmp+" <-+->"+pmf+"");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nUpdation Of Margins/Range Of "+SBJ+" Errored");
            }
        }
    }//GEN-LAST:event_FFCATSActionPerformed

    private void AddF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddF1ActionPerformed
        // TODO add your handling code here:
        Slepa();
    }//GEN-LAST:event_AddF1ActionPerformed

    private void AddF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddF2ActionPerformed
        // TODO add your handling code here:
        Slepa();
    }//GEN-LAST:event_AddF2ActionPerformed

    private void AddF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddF3ActionPerformed
        // TODO add your handling code here:
        Slepa();
    }//GEN-LAST:event_AddF3ActionPerformed

    private void AddF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddF4ActionPerformed
        // TODO add your handling code here:
        Slepa();
    }//GEN-LAST:event_AddF4ActionPerformed

    private void SClsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SClsActionPerformed
        // TODO add your handling code here:

        if(AddF1.isSelected()){
            Fm="Form1";
            Fmm=1;
            if(AddF1N.isSelected()){
                F1n=1;
                Str="North";
                Mng();
            }
            if(AddF1S.isSelected()){
                F1s=1;
                Str="South";
                Mng();
            }
            if(AddF1W.isSelected()){
                F1w=1;
                Str="West";
                Mng();
            }
            if(AddF1E.isSelected()){
                F1e=1;
                Str="East";
                Mng();
            }
            JOptionPane.showMessageDialog(null, "Done Setting For "+Fm);
        }

        if(AddF2.isSelected()){
            Fm="Form2";
            Fmm=2;
            if(AddF2N.isSelected()){
                F2n=1;
                Str="North";
                Mng();
            }
            if(AddF2S.isSelected()){
                F2s=1;
                Str="South";
                Mng();
            }
            if(AddF2E.isSelected()){
                F2e=1;
                Str="East";
                Mng();
            }
            if(AddF2W.isSelected()){
                F2w=1;
                Str="West";
                Mng();
            }
            JOptionPane.showMessageDialog(null, "Done Setting For "+Fm);
        }

        if(AddF3.isSelected()){
            Fm="Form3";
            Fmm=3;
            if(AddF3N.isSelected()){
                F3n=1;
                Str="North";
                Mng();
            }
            if(AddF3S.isSelected()){
                F3s=1;
                Str="South";
                Mng();
            }
            if(AddF3E.isSelected()){
                F3e=1;
                Str="East";
                Mng();
            }
            if(AddF3W.isSelected()){
                F3w=1;
                Str="West";
                Mng();
            }
            JOptionPane.showMessageDialog(null, "Done Setting For "+Fm);
        }

        if(AddF4.isSelected()){
            Fm="Form4";
            Fmm=4;
            if(AddF4S.isSelected()){
                F4s=1;
                Str="South";
                Mng();
            }
            if(AddF4E.isSelected()){
                F4e=1;
                Str="East";
                Mng();
            }
            if(AddF4W.isSelected()){
                F4w=1;
                Str="West";
                Mng();
            }
            if(AddF4N.isSelected()){
                F4n=1;
                Str="North";
                Mng();
            }
            JOptionPane.showMessageDialog(null, "Done Setting For "+Fm);
        }
    }//GEN-LAST:event_SClsActionPerformed

    private void GrdSettActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrdSettActionPerformed
        // TODO add your handling code here:
        Nm();
        hr=Integer.parseInt(Hrange.getSelectedItem().toString());
        lr=Integer.parseInt(Lrange.getSelectedItem().toString());
        cmnt=CommBox.getText();
        Greda();
        String emh="Class ->"+frgd+"  Grade Level ->"+grd+"\nSubject ->"+sbgd+"  Range ->"+hr+"<-->"+lr+"\nComment ->"+cmnt+"\n";
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
        //2017_End_Term_Term2
        Putta();
        ExamBay.addItem(lst);
        ExamBay.setEnabled(Boolean.FALSE);
        if (!(Cbf3.isSelected() || Cbf4.isSelected() || Cbf1.isSelected() || Cbf2.isSelected())) {
            JOptionPane.showMessageDialog(null, "Check A Class To Proceed");
        }
        else if (Cbf3.isSelected() || Cbf4.isSelected()) {
            Sett.setVisible(Boolean.FALSE);
            Senr.setVisible(Boolean.TRUE);
            Pg0.setVisible(Boolean.FALSE);
        }
        else if (Cbf1.isSelected() || Cbf2.isSelected()) {
            Sett.setVisible(Boolean.FALSE);
            Senr.setVisible(Boolean.FALSE);
            Pg0.setVisible(Boolean.TRUE);
        }
    }//GEN-LAST:event_NxtActionPerformed

    private void ClserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClserActionPerformed
        // TODO add your handling code here:
        String gt=Clser.getSelectedItem().toString();
        if (gt=="Juniors") {
            Cbf1.setEnabled(true);
            Cbf2.setEnabled(true);
            Cbf3.setEnabled(false);
            Cbf4.setEnabled(false);
        }else if (gt=="Seniors") {
            Cbf1.setEnabled(false);
            Cbf2.setEnabled(false);
            Cbf3.setEnabled(true);
            Cbf4.setEnabled(true);
        }
    }//GEN-LAST:event_ClserActionPerformed

    private void FrmSenrAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrmSenrAddActionPerformed
        // TODO add your handling code here:
        if (FrmSenrAdd.getSelectedIndex()==0) {
            ClStr="Form3";
            StrmSenrAdd.removeAllItems();
            Chus();
        }
        if (FrmSenrAdd.getSelectedIndex()==1) {
            ClStr="Form4";
            StrmSenrAdd.removeAllItems();
            Chus();
        }
    }//GEN-LAST:event_FrmSenrAddActionPerformed

    private void SncSenrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SncSenrActionPerformed
        // TODO add your handling code here:
        SenrAd();
        Nm();
        if (SbjSenrChus.getSelectedIndex()==1) {
            if (StrmSenrAdd.getSelectedIndex()==0) {
                try {
                    String sql="SELECT `Name`,`Reg_No`,"+snmsbj+" FROM "+lst+" WHERE `Class`='"+snmcls+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    SnrTblAd.setModel(DbUtils.resultSetToTableModel(rs));
                    SnrTblAd.setVisible(Boolean.TRUE);
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\nNo Such Table 1");
                }
            }else if (StrmSenrAdd.getSelectedIndex() >0) {
                String sql="-----------------------";
                try {
                    snmstr=StrmSenrAdd.getSelectedItem().toString();
                    sql="SELECT `Name`,`Reg_No`,"+snmsbj+" FROM "+lst+" WHERE `Class`='"+snmcls+"' AND `Stream`= '"+StrmSenrAdd.getSelectedItem().toString()+"' ";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    SnrTblAd.setModel(DbUtils.resultSetToTableModel(rs));
                    SnrTblAd.setVisible(Boolean.TRUE);
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\nNo Such Table "+StrmSenrAdd.getSelectedItem().toString()+"\n"+sql);
                }
            }
        }
        else if (SbjSenrChus.getSelectedIndex()>1) {
            snmstr=StrmSenrAdd.getSelectedItem().toString();
            if (StrmSenrAdd.getSelectedIndex()==0) {
                try {
                    String sql="SELECT ("+lst+".Name),("+lst+".Class),("+lst+".Reg_No),("+lst+"."+snmsbj+") FROM "+lst+",`tbl_Placer`  WHERE ( "+lst+".Reg_No=`tbl_Placer`.Reg_No AND `tbl_Placer`."+snmsbj+"=1 AND `tbl_Placer`.`Class`='"+snmcls+"' )";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    SnrTblAd.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\nNo Such Table");
                }
            } else {
                try {
                    String sql="SELECT COALESCE("+lst+".Name) AS Name,COALESCE("+lst+".Class) AS Class,COALESCE("+lst+".Reg_No) AS Reg_No,("+lst+"."+snmsbj+") FROM "+lst+",`tbl_Placer`  WHERE ( "+lst+".Reg_No=`tbl_Placer`.Reg_No AND `tbl_Placer`."+snmsbj+"=1 AND `tbl_Placer`.`Class`= '"+snmcls+"' AND `"+lst+"`.`Stream`= '"+snmstr+"')";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    SnrTblAd.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\nNo Such Table");
                }
            }
        }
        //JOptionPane.showMessageDialog(null, "Class ->"+snmcls+"\n"+"Stream ->"+snmstr+"\n"+"Subjech Choosen ->"+snmsbj);
    }//GEN-LAST:event_SncSenrActionPerformed

    private void InsrtSenrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsrtSenrActionPerformed
        // TODO add your handling code here:
        Nm();
        DefaultTableModel tts1=(DefaultTableModel) SnrTblAd.getModel();
        if (SbjSenrChus.getSelectedIndex()==1) {
            try {
                for(int i=0; i<SnrTblAd.getRowCount(); i++){
                    String num=("Mathematics");//(int stdreg,int stdscor,String stdsbj)
                    Double kk=Double.valueOf(SnrTblAd.getValueAt(i, 2).toString()) ;
                    int reg=Integer.parseInt(SnrTblAd.getValueAt(i, 1).toString()) ;
                    InsBasic(reg,kk,num);
                }//JOptionPane.showMessageDialog(null, "Subject ->"+snmsbj+"Added ->"+kk+"\n"+"Reg No ->"+reg);
                for(int i=0; i<SnrTblAd.getRowCount(); i++){
                    String num=("English");
                    Double kk=Double.valueOf(SnrTblAd.getValueAt(i, 3).toString()) ;
                    int reg=Integer.parseInt(SnrTblAd.getValueAt(i, 1).toString()) ;
                    InsBasic(reg,kk,num);
                }
                for(int i=0; i<SnrTblAd.getRowCount(); i++){
                    String num=("Kiswahili");
                    Double kk=Double.valueOf(SnrTblAd.getValueAt(i, 4).toString()) ;
                    int reg=Integer.parseInt(SnrTblAd.getValueAt(i, 1).toString()) ;
                    InsBasic(reg,kk,num);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nSome Errors ");
            }

            try {
                String sql="SELECT `Name`,`Reg_No`,`Mathematics`,`English`,`Kiswahili` FROM `"+lst+"` WHERE `Class`='"+snmcls+"' ";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                SenrConfTbl.setModel(DbUtils.resultSetToTableModel(rs));
                SenrConfTbl.setVisible(Boolean.TRUE);
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nRendering Errors");
            }

        }
        if (SbjSenrChus.getSelectedIndex()>1) {
            try {
                for(int i=0; i<SnrTblAd.getRowCount(); i++){
                    String SB=snmsbj;
                    float kk=Integer.parseInt(SnrTblAd.getValueAt(i, 3).toString()) ;
                    int reg=Integer.parseInt(SnrTblAd.getValueAt(i, 2).toString()) ;
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
                SenrConfTbl.setModel(DbUtils.resultSetToTableModel(rs));
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
            crclas="Form1";
            CritStream.removeAllItems();
            PopAnaly();
        }
        if (CritClass.getSelectedIndex()==2) {
            crclas="Form2";
            CritStream.removeAllItems();
            PopAnaly();
        }
        if (CritClass.getSelectedIndex()==3) {
            crclas="Form3";
            CritStream.removeAllItems();
            PopAnaly();
        }
        if (CritClass.getSelectedIndex()==4) {
            crclas="Form4";
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
            JOptionPane.showMessageDialog(null, "Select Only one subject");
        }

        if (CritAscend.isSelected()) {
            if (CritStream.getSelectedItem()=="All") {
                try {
                    String sql="SELECT ("+lst+".Name),("+lst+".Reg_No),("+lst+"."+ctsbj+") FROM "+lst+"  WHERE `Class`='"+crclas+"' ORDER BY ("+lst+"."+ctsbj+") ASC";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    tbl_Analyse.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                }
            }
            if (CritStream.getSelectedIndex()>0) {
                try {
                    String sql="SELECT ("+lst+".Name),("+lst+".Reg_No),("+lst+"."+ctsbj+") FROM "+lst+"  WHERE (`Class`='"+crclas+"' AND `Stream`='"+CritStream.getSelectedItem().toString()+"') ORDER BY ("+lst+"."+ctsbj+") ASC";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    tbl_Analyse.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                }
            }
        }

        if (CritDesc.isSelected()) {
            if (CritStream.getSelectedItem()=="All") {
                try {
                    String sql="SELECT ("+lst+".Name),("+lst+".Reg_No),("+lst+"."+ctsbj+") FROM "+lst+"  WHERE `Class`='"+crclas+"' ORDER BY ("+lst+"."+ctsbj+") DESC";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    tbl_Analyse.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                }
            }
            if (CritStream.getSelectedIndex()>0) {
                try {
                    String sql="SELECT ("+lst+".Name),("+lst+".Reg_No),("+lst+"."+ctsbj+") FROM "+lst+"  WHERE (`Class`='"+crclas+"' AND `Stream`='"+CritStream.getSelectedItem().toString()+"') ORDER BY ("+lst+"."+ctsbj+") DESC";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    tbl_Analyse.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                }
            }
        }

        if (CritMosImp.isSelected()) {
            if (CritStream.getSelectedItem()=="All") {
                try {
                    String sql="SELECT ("+lst+".Name),("+lst+".Reg_No),("+lst+"."+ctsbj+"),("+lst2+"."+ctsbj+"),("+lst+"."+ctsbj+")-("+lst+"."+ctsbj+") AS Increment FROM "+lst+","+lst2+"  WHERE ("+lst+".Reg_No="+lst2+".Reg_No AND "+lst+".`Class`='"+crclas+"' AND "+lst2+".`Class`='"+crclas+"' ) ";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    tbl_Analyse.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\n Error");
                }
            }
            if (CritStream.getSelectedIndex()>0) {
                try {
                    String sql="SELECT ("+lst+".Name),("+lst+".Reg_No),COALESCE("+lst+"."+ctsbj+") AS Current,COALESCE("+lst2+"."+ctsbj+") AS Past, COALESCE("+lst+"."+ctsbj+"-"+lst+"."+ctsbj+") AS Points FROM "+lst+","+lst2+"  WHERE ("+lst+".Reg_No="+lst2+".Reg_No AND "+lst+".`Class`='"+crclas+"' AND "+lst2+".`Class`='"+crclas+"' AND "+lst+".`Stream`='"+CritStream.getSelectedItem().toString()+"' AND "+lst2+".`Stream`='"+CritStream.getSelectedItem().toString()+"') ";
                    pst=(PreparedStatement) Conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    tbl_Analyse.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e+"\n Error2");
                }
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
        
        String ExamClass,ExamSubject,Exam1,Exam2;
        
        if (Clss.getSelectedIndex()==0) {
            ExamClass="Form1";
        } else if (Clss.getSelectedIndex()==0) {
            ExamClass="Form2";
        }
        else if (Clss.getSelectedIndex()==0) {
            ExamClass="Form3";
        }
        else if (Clss.getSelectedIndex()==0) {
            ExamClass="Form4";
        }
        
        ExamSubject=this.ExamSubject.getSelectedItem().toString();
        Exam1=this.Ex1Perf.getSelectedItem().toString();
        Exam2=this.Ex2Perf.getSelectedItem().toString();
        
        String tcl=null,tsbj=null;
        tsbj=ExamSubject.getSelectedItem().toString();
        int kk,ll;
        String sb=null,nom,nom2,tbx1,tbx2;
        tbx1=Ex1Perf.getSelectedItem().toString();
        tbx2=Ex2Perf.getSelectedItem().toString();
        Ex2Perf.setEnabled(Boolean.TRUE);

        /*String bd = " ";
        String gd = "_";
        Pattern pt1 = Pattern.compile(bd);
        Matcher m1 = pt1.matcher(tbx1);
        Matcher m2 = pt1.matcher(tbx2);
        tbx1 = m1.replaceAll(gd);
        tbx2 = m1.replaceAll(gd);
        //JOptionPane.showMessageDialog(null, "Table 1 ->"+tbx1+"\nTable 2 ->"+tbx2);*/

        kk=ExamSubject.getSelectedIndex();
        ll=Clss.getSelectedIndex();
        if (ll==0) {
            sb="Form1";
        }
        if (ll==1) {
            sb="Form2";
        }
        if (ll==2) {
            sb="Form3";
        }
        if (ll==3) {
            sb="Form4";
        }

        nom=tsbj+lst;
        nom2=tsbj+lst2;

        if (FltPrf.getSelectedIndex()==0) {

            //lst=tbx1;lst2=tbx2;
            //JOptionPane.showMessageDialog(null, "Table 1 ->"+lst+"\nTable 2 ->"+lst2);

            try {
                //String sql="SELECT COALESCE("+lst+".Name) as Name,COALESCE("+lst+".Class) as Class,COALESCE("+lst+".Reg_No) as Reg_No,"+lst+"."+tsbj+","+lst2+"."+tsbj+" FROM "+lst+","+lst2+" WHERE ( "+lst+".Reg_No="+lst2+".Reg_No AND "+lst+".Class='"+sb+"')";
                String sql="SELECT COALESCE("+lst+".Name) as Name,COALESCE("+lst+".Reg_No) as Reg_No,("+lst+"."+tsbj+")AS "+nom+",("+lst2+"."+tsbj+")AS "+nom2+",("+lst+"."+tsbj+"-"+lst2+"."+tsbj+") AS VAP FROM "+lst+","+lst2+"  WHERE ( "+lst+".Reg_No="+lst2+".Reg_No AND "+lst+".Class='"+sb+"')";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tblExamCompare.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nNigga");
            }
        }

        if (FltPrf.getSelectedIndex()==1) {
            Ex2Perf.setEnabled(Boolean.FALSE);
            try {
                String sql="SELECT `Name`,`Reg_No`,`"+tsbj+"` FROM "+tbx1+"  WHERE `Class`='"+sb+"' ORDER BY `"+tsbj+"` DESC";
                pst=(PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                tblExamCompare.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e+"\nNigga");
            }
        }

        if (FltPrf.getSelectedIndex()==1) {

        }
    }//GEN-LAST:event_FltPrfActionPerformed

    private void ClssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClssActionPerformed
        // TODO add your handling code here:
        if (Clss.getSelectedIndex()==0) {
            ClStr="Form1";
            StrPerf.removeAllItems();
            StrPerf();
        }
        if (Clss.getSelectedIndex()==1) {
            ClStr="Form2";
            StrPerf.removeAllItems();
            StrPerf();
        }
        if (Clss.getSelectedIndex()==2) {
            ClStr="Form3";
            StrPerf.removeAllItems();
            StrPerf();
        }
        if (Clss.getSelectedIndex()==3) {
            ClStr="Form4";
            StrPerf.removeAllItems();
            StrPerf();
        }
    }//GEN-LAST:event_ClssActionPerformed

    private void AdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tts=(DefaultTableModel) Tsta.getModel();
        try {
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Mathematics");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 3).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("English");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 4).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Kiswahili");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 5).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Chemistry");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 6).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Biology");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 7).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Physics");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 8).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Geography");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 9).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("History");
                //float kk=Integer.parseInt(Tsta.getValueAt(i, 10).toString()) ;
                Double kk=Double.valueOf(Tsta.getValueAt(i, 10).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("CRE");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 11).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Business");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 12).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            for(int i=0; i<Tsta.getRowCount(); i++){
                String num=("Agriculture");
                Double kk=Double.valueOf(Tsta.getValueAt(i, 13).toString()) ;
                int reg=Integer.parseInt(Tsta.getValueAt(i, 2).toString()) ;
                Setta(kk,num,reg);
            }
            JOptionPane.showMessageDialog(null, "Done");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"Nigga");
        }
    }//GEN-LAST:event_AdaActionPerformed

    private void RshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RshActionPerformed
        // TODO add your handling code here:
        Putta();
    }//GEN-LAST:event_RshActionPerformed

    private void BcerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcerActionPerformed
        // TODO add your handling code here:
        Pg0.setVisible(Boolean.FALSE);
        Sett.setVisible(Boolean.TRUE);
        Senr.setVisible(Boolean.FALSE);
    }//GEN-LAST:event_BcerActionPerformed

    private void GraphyyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphyyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GraphyyActionPerformed

    private void FeeObjectAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeeObjectAddActionPerformed
        // TODO add your handling code here:
        try {
            String sql="INSERT INTO `tbl_Fees` (Count,Object_Name,Amount,Comment)  VALUES(NULL,?,?,?)";
            pst = Conn.prepareStatement(sql);
            pst.setString(1, FeeObject.getText().toString());
            pst.setInt(2, Integer.parseInt(FeeAmount.getText().toString()));
            pst.setString(3, FeeComment.getText().toString());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nObject Insertion Error");
        }
        PopFee();
    }//GEN-LAST:event_FeeObjectAddActionPerformed

    private void FeeObjectEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeeObjectEditActionPerformed
        // TODO add your handling code here:
        int reg=Integer.parseInt(tblFee.getValueAt(tblFee.getSelectedRow(), 0).toString());
        
        String Obj =FeeObject.getText().toString();
        int amnt =Integer.parseInt(FeeAmount.getText().toString());
        String Comm =FeeComment.getText().toString();
        
        lv="UPDATE `tbl_Fees` SET `Object_Name` ='"+Obj+"', `Amount` ="+amnt+", `Comment` ='"+Comm+"' WHERE `Count`='"+reg+"' ";
        try {
            pst=Conn.prepareStatement(lv);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nObject Update Error");
        }
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
        
        FeeObject.setText((tblFee.getValueAt(tblFee.getSelectedRow(), 1).toString()));
        FeeAmount.setText((tblFee.getValueAt(tblFee.getSelectedRow(), 2).toString()));
        FeeComment.setText((tblFee.getValueAt(tblFee.getSelectedRow(), 3).toString()));
    }//GEN-LAST:event_tblFeeMouseClicked

    private void StudentFindKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StudentFindKeyTyped
        // TODO add your handling code here:
        if (StudentFindType.getSelectedIndex()==1) {
            Varr="Name";
        }else if (StudentFindType.getSelectedIndex()==2) {
            Varr="Class";
        }else if (StudentFindType.getSelectedIndex()==3) {
            Varr="Reg_No";
        }

        String vl=StudentFind.getText().toString();
        try {               
            String Lv="SELECT  *  FROM `tbl_Students`  WHERE `"+Varr+"` LIKE '%"+vl+"%' ";
            pst=Conn.prepareStatement(Lv);
            rs=pst.executeQuery();
            tblAllStd.setModel(DbUtils.resultSetToTableModel(rs));  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\n");
            getToolkit().beep();
        }
    }//GEN-LAST:event_StudentFindKeyTyped

    private void ExamSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExamSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExamSubjectActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
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
    private javax.swing.JCheckBox AddF1;
    private javax.swing.JCheckBox AddF2;
    private javax.swing.JCheckBox AddF3;
    private javax.swing.JCheckBox AddF4;
    private javax.swing.JPanel All;
    private javax.swing.JButton AnalyseExam;
    private javax.swing.JButton BacSett;
    private javax.swing.JButton Bcer;
    private javax.swing.JButton BtnLogin;
    private javax.swing.JCheckBox Cbf1;
    private javax.swing.JCheckBox Cbf2;
    private javax.swing.JCheckBox Cbf3;
    private javax.swing.JCheckBox Cbf4;
    private javax.swing.JCheckBox Cbf5;
    private javax.swing.JCheckBox Cbf6;
    private javax.swing.JCheckBox Cbf7;
    private javax.swing.JCheckBox Cbf8;
    private javax.swing.JComboBox<String> ClassCatFM1;
    private javax.swing.JComboBox<String> ClassCatPm1;
    private javax.swing.JComboBox<String> ClassEndFM1;
    private javax.swing.JComboBox<String> ClassEndPM1;
    private javax.swing.JComboBox<String> ClassLvCat1;
    private javax.swing.JComboBox<String> ClassLvCatSbj1;
    private javax.swing.JComboBox<String> ClassLvEnd1;
    private javax.swing.JComboBox<String> ClassLvEndSbj1;
    private javax.swing.JComboBox<String> ClassLvMid1;
    private javax.swing.JComboBox<String> ClassLvMidSbj1;
    private javax.swing.JComboBox<String> ClassMidFM1;
    private javax.swing.JComboBox<String> ClassMidPM1;
    private javax.swing.JComboBox<String> Classe;
    private javax.swing.JComboBox<String> Clser;
    private javax.swing.JComboBox<String> Clss;
    private javax.swing.JComboBox<String> ComBin;
    private javax.swing.JTextArea CommBox;
    private javax.swing.JRadioButton CritAscend;
    private javax.swing.JComboBox<String> CritClass;
    private javax.swing.JRadioButton CritDesc;
    private javax.swing.JRadioButton CritLeaImp;
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
    private javax.swing.JComboBox<String> ExxamTY;
    private javax.swing.JComboBox<String> ExxamTY1;
    private javax.swing.JLabel F1Log;
    private javax.swing.JLabel F2Log;
    private javax.swing.JLabel F3Log;
    private javax.swing.JLabel F4Log;
    private javax.swing.JButton FFCATS;
    private javax.swing.JButton FFEnd;
    private javax.swing.JButton FFMid;
    private javax.swing.JTextField FeeAmount;
    private javax.swing.JTextArea FeeComment;
    private javax.swing.JTextField FeeObject;
    private javax.swing.JButton FeeObjectAdd;
    private javax.swing.JButton FeeObjectEdit;
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
    private javax.swing.JButton HmMails;
    private javax.swing.JButton HmNewStudent;
    private javax.swing.JButton HmReports;
    private javax.swing.JButton HmResults;
    private javax.swing.JButton HmStudents;
    private javax.swing.JButton HmTeacher;
    private javax.swing.JLabel Homie;
    private javax.swing.JComboBox<String> Hrange;
    private javax.swing.JTextField ImgP;
    private javax.swing.JButton InsrtSenr;
    private javax.swing.JButton JrXmGen;
    private javax.swing.JTable Leva;
    private javax.swing.JComboBox<String> Lrange;
    private javax.swing.JPanel Marks;
    private javax.swing.JLabel MnAddStd;
    private javax.swing.JLabel MnCharts;
    private javax.swing.JLabel MnExams;
    private javax.swing.JLabel MnGraphs;
    private javax.swing.JLabel MnStd;
    private javax.swing.JButton Mprnt;
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
    private javax.swing.JCheckBox PP1e;
    private javax.swing.JCheckBox PP1m;
    private javax.swing.JCheckBox PP2e;
    private javax.swing.JCheckBox PP2m;
    private javax.swing.JCheckBox PP3e;
    private javax.swing.JCheckBox PP3m;
    private javax.swing.JPanel PanAdmin;
    private javax.swing.JPanel PanAdmit;
    private javax.swing.JPanel PanExams;
    private javax.swing.JPanel PanFinance;
    private javax.swing.JPanel PanHome;
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
    private javax.swing.JRadioButton RepoTrm1;
    private javax.swing.JRadioButton RepoTrm2;
    private javax.swing.JRadioButton RepoTrm3;
    private javax.swing.JButton Rsh;
    private javax.swing.JButton RstCont;
    private javax.swing.JButton SCls;
    private javax.swing.JComboBox<String> SbjSenrChus;
    private javax.swing.JPanel Senr;
    private javax.swing.JTable SenrConfTbl;
    private javax.swing.JButton SetCont;
    private javax.swing.JPanel Sett;
    private javax.swing.JButton SncSenr;
    private javax.swing.JTable SnrTblAd;
    private javax.swing.JComboBox<String> StrNxt;
    private javax.swing.JComboBox<String> StrmSenrAdd;
    private javax.swing.JTextField StudentFind;
    private javax.swing.JComboBox<String> StudentFindType;
    private javax.swing.JComboBox<String> SubGrad;
    private javax.swing.JButton SyncRepo;
    private javax.swing.JPanel Tail;
    private javax.swing.JRadioButton Tr1;
    private javax.swing.JRadioButton Tr2;
    private javax.swing.JRadioButton Tr3;
    private javax.swing.JRadioButton Tr4;
    private javax.swing.JRadioButton Tr5;
    private javax.swing.JRadioButton Tr6;
    private javax.swing.JButton TrnCls;
    private javax.swing.JTable Tsta;
    private javax.swing.JButton VwCred;
    private javax.swing.JButton WannaBe;
    private javax.swing.JComboBox<String> YBx;
    private javax.swing.JComboBox<String> YBx1;
    private javax.swing.JTextField eXA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
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
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
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
    private javax.swing.JTable tbl_Analyse;
    // End of variables declaration//GEN-END:variables
}
