/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang;


import DTO.TaiKhoan;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Thanh Phuc
 */
public class DangNhap extends Login_Frame {
     public  void DNhap(String user,String password){
         Connection connectt = null;
         PreparedStatement stm = null;
         PreparedStatement stm2 = null;
         boolean check=false;
         try {
             try {
                 Class.forName("com.mysql.jdbc.Driver");
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
             }
             connectt = DriverManager.getConnection("jdbc:mysql://localhost/qlbansach", "root", "");
             String sql = "select * from taikhoan where tentk=? and pass=? and phanloai='1'";//admin
             String sql2= "select * from taikhoan where tentk=? and pass=? and phanloai='2'";//user
             //admin
             stm = connectt.prepareStatement(sql);
             stm.setString(1, user);
             stm.setString(2, password);
             //user
             stm2 = connectt.prepareStatement(sql2);
             stm2.setString(1, user);
             stm2.setString(2, password);
             
             ResultSet rs = stm.executeQuery();//admin
             ResultSet rs2 = stm2.executeQuery();//user
             if(rs.next()){
                 JOptionPane.showMessageDialog(this, "Đăng nhập thành công.");
                 Admin_Frame DN_admin = new Admin_Frame();
                 DN_admin.setVisible(true);
                 dispose();
                 
             }
             else if(rs2.next()){
                 JOptionPane.showMessageDialog(this, "Đăng nhập thành công.");
                 User_Frame DN_user = new User_Frame();
                 DN_user.setVisible(true);
                 dispose();
         }
             else{
                JOptionPane.showMessageDialog(this, "Thông tin đăng nhập sai."); 
             }
         } catch (SQLException ex) {
             Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connectt != null) {
                try {
                    connectt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

     
     }
    public static String comparePassword(String pass) {
        Connection connect = null;
        Statement stm = null; // lay database
        try {
            try {
                //Lay tat ca danh sach sinh vien
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
            connect = DriverManager.getConnection("jdbc:mysql://localhost/qlbansach", "root", "");

            //Query( truy van )
            String sql = "select * from taikhoan";
            stm = connect.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);
            //con tro tra ve du lieu truy van
            if (resultSet.next()) {              
                pass = resultSet.getString("pass");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return pass;
    }
     public static void DoiMatKhau(String tk,String pass){         
        Connection connect = null;
        Statement stm = null;
        TaiKhoan tentk = new TaiKhoan();
        try {
            //Lay tat ca danh sach sinh vien
            connect = DriverManager.getConnection("jdbc:mysql://localhost/qlbansach", "root", "");            
            //Query( truy van )
            stm = connect.createStatement();
            String sql="update taikhoan  set pass= '"+pass+"' where tentk= '"+tk+"'";            
            int rs = stm.executeUpdate(sql);                   
        } catch (SQLException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
     }
}
