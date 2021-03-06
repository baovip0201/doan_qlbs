/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChucVu;
import MyDBConnect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class cvDAO {
    public static Connection conn=Connect.getConnect();
    public static PreparedStatement ps=null;
    public static ResultSet rs=null;
    public static void them(ChucVu cv){
        String sql="insert into ChucVu(maChucVu,chucVu,luong) values(?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, cv.getMaChucVu());
            ps.setString(2, cv.getChucVu());
            ps.setFloat(3, cv.getLuong());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    public static void sua(ChucVu cv){
        String sql="update ChucVu set luong='"+cv.getLuong()+"' where maChucVu='"+cv.getMaChucVu()+"'";
        try {
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
        
    }
    public static void xoa(ChucVu cv){
        String sql="delete from ChucVu where maChucVu='"+cv.getMaChucVu()+"'";
        try {
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể xóa khi có ít nhất 1 nhân viên đảm nhiệm chức vụ đó");
        }
    }
    public static ArrayList getListCV(){
        ArrayList<ChucVu> dscv=new ArrayList<>();
        String sql="select * from ChucVu";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                ChucVu cv=new ChucVu();
                cv.setMaChucVu(rs.getString("maChucVu"));
                cv.setChucVu(rs.getString("chucVu"));
                cv.setLuong(rs.getFloat("luong"));
                dscv.add(cv);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc");
        }
        return dscv;
    }
    public static ArrayList getListCBB(){
        ArrayList<String> list=new ArrayList<>();
        String sql="select maChucVu from ChucVu";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString("maChucVu"));
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public static boolean checkPrimaryKey(String txt){
        String sql="Select * from ChucVu where maChucVu='"+txt+"'";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException e) {
        }
        return false;
    }
}
