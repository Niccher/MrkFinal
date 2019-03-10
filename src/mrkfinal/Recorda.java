/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrkfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author niccher
 */
public class Recorda {
    String ff="";
    private Connection conn=null;
    
        public static Connection InitDb() {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");

                PreparedStatement dbs = conn.prepareStatement("CREATE DATABASE IF NOT EXISTS `Testing3`");
                dbs.execute();

               Statement stt = conn.createStatement();
               stt.execute("USE Testing3");
                              
               String Std = "CREATE TABLE IF NOT EXISTS `tbl_Students` (`Count` INT AUTO_INCREMENT UNIQUE, `Name` VARCHAR(35) NOT NULL , `Surname` VARCHAR(10) NOT NULL , `Reg_No` INT(6) NOT NULL PRIMARY KEY , `KCPE` INT(4) NOT NULL , `Birth` INT(4) NOT NULL , `Parent` VARCHAR(25) NOT NULL , `Contact` INT(10) NOT NULL , `Residence` VARCHAR(20) NOT NULL , `Class` VARCHAR(10) NOT NULL , `Avatar` LONGBLOB NOT NULL )";
               PreparedStatement pst1 = conn.prepareStatement(Std);
               pst1.execute();
               
               String Std2 = "CREATE TABLE IF NOT EXISTS `tbl_Tests` ( `Count` INT(3) AUTO_INCREMENT UNIQUE , `Test` VARCHAR(30) PRIMARY KEY NOT NULL )";
               PreparedStatement pst2 = conn.prepareStatement(Std2);
               pst2.execute();
               
               String Std22 = "INSERT INTO `tbl_Tests` ( `Count`, `Test`) VALUES (NULL, 'Sample')";
               PreparedStatement pst22 = conn.prepareStatement(Std22);
               //pst22.execute();
               
               String Std3 = "CREATE TABLE IF NOT EXISTS `tbl_Lvl` ( `Count` INT AUTO_INCREMENT UNIQUE,`Name` VARCHAR(35) NOT NULL , `Reg_No` INT(6) NOT NULL PRIMARY KEY,`Form` VARCHAR(5) NOT NULL,`Mathematics` int NOT NULL DEFAULT '1',`English` int NOT NULL DEFAULT '1',`Kiswahili` int NOT NULL DEFAULT '1',`Chemistry` int NOT NULL DEFAULT '1',`Biology` int NOT NULL DEFAULT '1',`Physics` int NOT NULL DEFAULT '1',`Geography` int NOT NULL DEFAULT '1',`History` int NOT NULL DEFAULT '1',`CRE` int NOT NULL DEFAULT '1',`Business` int NOT NULL DEFAULT '1',`Agriculture` int NOT NULL DEFAULT '1')";
               PreparedStatement pst3 = conn.prepareStatement(Std3);
               pst3.execute();
               
               String Std4 = "CREATE TABLE IF NOT EXISTS `tbl_MarkP` ( `Count` INT AUTO_INCREMENT UNIQUE, `Year` INT(5) ,`Form` VARCHAR(6) NOT NULL ,`Exam` VARCHAR(10),`Term` VARCHAR(10),`Mathematics` int NOT NULL DEFAULT '1',`English` int NOT NULL DEFAULT '1',`Kiswahili` int NOT NULL DEFAULT '1',`Chemistry` int NOT NULL DEFAULT '1',`Biology` int NOT NULL DEFAULT '1',`Physics` int NOT NULL DEFAULT '1',`Geography` int NOT NULL DEFAULT '1',`History` int NOT NULL DEFAULT '1',`CRE` int NOT NULL DEFAULT '1',`Business` int NOT NULL DEFAULT '1',`Agriculture` int NOT NULL DEFAULT '1')";
               PreparedStatement pst4 = conn.prepareStatement(Std4);
               pst4.execute();
               
               String Std5 = "CREATE TABLE IF NOT EXISTS `tbl_MarkF` ( `Count` INT AUTO_INCREMENT UNIQUE, `Year` INT(5) ,`Form` VARCHAR(6) NOT NULL ,`Exam` VARCHAR(10),`Term` VARCHAR(10),`Mathematics` int NOT NULL DEFAULT '1',`English` int NOT NULL DEFAULT '1',`Kiswahili` int NOT NULL DEFAULT '1',`Chemistry` int NOT NULL DEFAULT '1',`Biology` int NOT NULL DEFAULT '1',`Physics` int NOT NULL DEFAULT '1',`Geography` int NOT NULL DEFAULT '1',`History` int NOT NULL DEFAULT '1',`CRE` int NOT NULL DEFAULT '1',`Business` int NOT NULL DEFAULT '1',`Agriculture` int NOT NULL DEFAULT '1')";
               PreparedStatement pst5 = conn.prepareStatement(Std5);
               pst5.execute();
               
               String Std6 = "CREATE TABLE IF NOT EXISTS `tbl_Placer` ( `Count` INT AUTO_INCREMENT UNIQUE,`Reg_No` INT NOT NULL PRIMARY KEY,`Class` VARCHAR(6) NOT NULL ,`Stream` VARCHAR(6) NOT NULL ,`Chemistry` int NOT NULL DEFAULT '0',`Biology` int NOT NULL DEFAULT '0',`Physics` int NOT NULL DEFAULT '0',`Geography` int NOT NULL DEFAULT '0',`CRE` int NOT NULL DEFAULT '0',`History` int NOT NULL DEFAULT '0',`Business` int NOT NULL DEFAULT '0',`Agriculture` int NOT NULL DEFAULT '0')";
               PreparedStatement pst6 = conn.prepareStatement(Std6);
               pst6.execute();
               
               String Std7 = "CREATE TABLE IF NOT EXISTS `tbl_Papers` ( `Count` INT NOT NULL AUTO_INCREMENT UNIQUE,`Subjects` VARCHAR(12) PRIMARY KEY NOT NULL,`Paper_One` int NOT NULL DEFAULT '0',`Paper_Two` int NOT NULL DEFAULT '0',`Paper_Three` int NOT NULL DEFAULT '0')";
               PreparedStatement pst7 = conn.prepareStatement(Std7);
               pst7.execute();
               
               String Std8="INSERT INTO `tbl_Papers` (`Count`, `Subjects`, `Paper_One`, `Paper_Two`, `Paper_Three`) VALUES (NULL, 'Mathematics', 0, 0, 0) ,"+
                        "(NULL, 'English', 0, 0, 0)" +
                        ",(NULL, 'Kiswahili', 0, 0, 0)" +
                        ",(NULL, 'Chemistry', 0, 0, 0)" +
                        ",(NULL, 'Biology', 0, 0, 0)" +
                        ",(NULL, 'Physics', 0, 0, 0)" +
                        ",(NULL, 'Geography', 0, 0, 0)" +
                        ",(NULL, 'CRE', 0, 0, 0)" +
                        ",(NULL, 'Agriculture', 0, 0, 0)" +
                        ",(NULL, 'Business', 0, 0, 0)" ;
                PreparedStatement pst8 = conn.prepareStatement(Std8);
                //pst8.execute();
                
                String Std13="CREATE TABLE IF NOT EXISTS `tbl_ClassList` (`Count` int(2) NOT NULL AUTO_INCREMENT, `Class` varchar(10) NOT NULL, `North` int(2) NOT NULL DEFAULT '0', `East` int(2) NOT NULL DEFAULT '0', `West` int(2) NOT NULL DEFAULT '0', `South` int(2) NOT NULL DEFAULT '0' ,PRIMARY KEY (Count))";
                PreparedStatement pst13 = conn.prepareStatement(Std13);
                pst13.execute();

                String Std14="INSERT INTO `tbl_ClassList` (`Count`, `Class`, `North`, `East`, `West`, `South`) VALUES (NULL, 'Form1', '0', '0', '0', '0'), (NULL, 'Form2', '0', '0', '0', '0'), (NULL, 'Form3', '0', '0', '0', '0'), (NULL, 'Form4', '0', '0', '0', '0')";
                PreparedStatement pst14 = conn.prepareStatement(Std14);
                //pst14.executeUpdate();
                
                String Std15="CREATE TABLE IF NOT EXISTS `tbl_Users` (`Count` INT AUTO_INCREMENT UNIQUE, `Name` VARCHAR(35) NOT NULL , `Surname` VARCHAR(10) NOT NULL ,`Type` VARCHAR(15) NOT NULL , `PassPhrase` VARCHAR(10) NOT NULL PRIMARY KEY , `Avatar` LONGBLOB )";
                PreparedStatement pst15 = conn.prepareStatement(Std15);
                pst15.execute();
                
                String Std16="INSERT INTO `tbl_Users` (`Count`, `Name`, `Surname`, `Type`, `PassPhrase`) VALUES (NULL, 'Admin', 'Admin', 'SysAdmin', 'admin')";
                PreparedStatement pst16 = conn.prepareStatement(Std16);
                //pst16.executeUpdate();
                
                String Std17="CREATE TABLE IF NOT EXISTS `tbl_Grades` (`Count` INT AUTO_INCREMENT UNIQUE, `Class` VARCHAR(7) NOT NULL ,`Test` VARCHAR(40) NOT NULL ,`Grade` VARCHAR(2) NOT NULL ,`Best` INT NOT NULL DEFAULT '0' ,`Least` INT NOT NULL DEFAULT '0',`Comment` VARCHAR(50) NOT NULL)";
                PreparedStatement pst17 = conn.prepareStatement(Std17);
                pst17.execute();
                
                String Std18="CREATE TABLE IF NOT EXISTS `tbl_Fees` (`Count` INT AUTO_INCREMENT PRIMARY KEY, `Object_Name` VARCHAR(35) NOT NULL , `Class` VARCHAR(7) NOT NULL , `Amount` int(5) NOT NULL DEFAULT '0',`Comment` VARCHAR(70) NOT NULL )";
                PreparedStatement pst18 = conn.prepareStatement(Std18);
                pst18.execute();
                
                String Std19="CREATE TABLE IF NOT EXISTS `tbl_Paid` (`Count` INT AUTO_INCREMENT UNIQUE, `Name` VARCHAR(35) NOT NULL , `Class` VARCHAR(7) NOT NULL , `Reg_No` INT(6) NOT NULL PRIMARY KEY , `Total_Fee` int(5) NOT NULL DEFAULT '0',`Paid_Fee` int(5) NOT NULL DEFAULT '0',`Bal_Fee` int(5) NOT NULL DEFAULT '0')";
                PreparedStatement pst19 = conn.prepareStatement(Std19);
                pst19.execute();

                Statement stmt=conn.createStatement();
                return conn;

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Database  Error 2"+ex);
                System.out.println(""+ex);
                return  null;
            }
            //return null;
        }
        
        public static void main(String[] args) {
        // TODO code application logic here
        new Recorda();
    }
}
