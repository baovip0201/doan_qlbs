/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyDBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class Connect {
    public static Connection getConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/qlbansach","root","");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "KẾT NỐI CƠ SỞ DỮ LIỆU THẤT BẠI");
        }
        return null;
        
    }
    public static void main(String[] args) {
        Connect a=new Connect();
    }
}

