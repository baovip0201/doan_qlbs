/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVien;
import MyDBConnect.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author MSI
 */
public class nvDAO {
    public static Connection conn=Connect.getConnect();
    public static PreparedStatement ps=null;
    public static ResultSet rs=null;
    public static void them(NhanVien nv){
        String sql="insert into ThongTinNhanVien(maNV, maChucVu, hoTen, gioiTinh, ngaySinh, diaChi, soDienthoai, Email, luong)"+
                "values(?,?,?,?,?,?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, nv.getMaNv());
            ps.setString(2, nv.getMaCv());
            ps.setString(3, nv.getHoTen());
            ps.setString(4, nv.getGender());
            ps.setString(5, nv.getDob());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getSdt());
            ps.setString(8, nv.getEmail());
            ps.setFloat(9, nv.getLuong());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!!");
        }
    }
    public static void sua(NhanVien nv){
        String sql="update ThongTinNhanVien set maChucVu='"+nv.getMaCv()+"', hoTen='"+nv.getHoTen()+"', gioiTinh='"+nv.getGender()+"',"+
                "ngaySinh='"+nv.getDob()+"', diaChi='"+nv.getDiaChi()+"',"+
                "soDienThoai='"+nv.getSdt()+"', email='"+nv.getEmail()+"', luong='"+nv.getLuong()+"' where maNV='"+nv.getMaNv()+"'";
        try {
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    public static void xoa(NhanVien nv){
        String sql="delete from ThongTinNhanVien where maNV='"+nv.getMaNv()+"'";
        try {
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
    }
    public static ArrayList searchTenNV(String tf){
        ArrayList<NhanVien> dsnv=new ArrayList<>();
        String sql="select * from ThongTinNhanVien where hoTen like '%"+tf+"%'";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                NhanVien nv=new NhanVien();
                nv.setMaNv(rs.getString("maNV"));
                nv.setMaCv(rs.getString("maChucVu"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setGender(rs.getString("gioiTinh"));
                nv.setDob(rs.getString("ngaySinh"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("soDienThoai"));
                nv.setEmail(rs.getString("email"));
                nv.setLuong(rs.getFloat("luong"));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
        }
        return dsnv;
    }
    public static ArrayList searchMaNV(String tf){
        ArrayList<NhanVien> dsnv=new ArrayList<>();
        String sql="select * from ThongTinNhanVien where maNV like '%"+tf+"%'";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                NhanVien nv=new NhanVien();
                nv.setMaNv(rs.getString("maNV"));
                nv.setMaCv(rs.getString("maChucVu"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setGender(rs.getString("gioiTinh"));
                nv.setDob(rs.getString("ngaySinh"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("soDienThoai"));
                nv.setEmail(rs.getString("email"));
                nv.setLuong(rs.getFloat("luong"));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
        }
        return dsnv;
    }
    public static ArrayList getListNV(){
        ArrayList<NhanVien> dsnv=new ArrayList<>();
        String sql="select * from ThongTinNhanVien";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                NhanVien nv=new NhanVien();
                nv.setMaNv(rs.getString("maNV"));
                nv.setMaCv(rs.getString("maChucVu"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setGender(rs.getString("gioiTinh"));
                nv.setDob(rs.getString("ngaySinh"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("soDienThoai"));
                nv.setEmail(rs.getString("email"));
                nv.setLuong(rs.getFloat("luong"));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc");
        }
        return dsnv;    
    }
    public static ArrayList searchByDate(String txt1, String txt2){
        ArrayList<NhanVien> dsnv=new ArrayList<>();
        String sql="select * from ThongTinNhanVien where ngaySinh between'"+txt1+"' and '"+txt2+"'";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                NhanVien nv=new NhanVien();
                nv.setMaNv(rs.getString("maNV"));
                nv.setMaCv(rs.getString("maChucVu"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setGender(rs.getString("gioiTinh"));
                nv.setDob(rs.getString("ngaySinh"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("soDienThoai"));
                nv.setEmail(rs.getString("email"));
                nv.setLuong(rs.getFloat("luong"));
                dsnv.add(nv);
            }
        } catch (SQLException e) {
        }
        return dsnv;
    }
    public static boolean CheckPrimaryKey(String txt){
        String sql="Select * from ThongTinNhanVien where maNV='"+txt+"'";
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
