/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.nvDAO;
import DTO.NhanVien;
import java.util.ArrayList;


/**
 *
 * @author MSI
 */
public class nvBUS{
    public static ArrayList<NhanVien> dsnv;
    public static ArrayList<String> list;
    public nvBUS(){
        
    }
    public static void docDSNV(){
        if(dsnv==null) dsnv=new ArrayList<>();
        dsnv=nvDAO.getListNV();
    }
    public static void ADD(NhanVien nv){
        nvDAO.them(nv);
        dsnv.add(nv);
    }
    public static void sua(NhanVien nv){
        
        nvDAO.sua(nv);
    }
    public static void xoa(NhanVien nv){
        nvDAO.xoa(nv);
    }
    public static void searchTenNV(String tf){
        if(dsnv==null) dsnv=new ArrayList<>();
        dsnv=nvDAO.searchTenNV(tf);
        
    }
    public static void searchMaNV(String tf){
        if(dsnv==null) dsnv=new ArrayList<>();
        dsnv=nvDAO.searchMaNV(tf);
    }
    public static boolean checkPrimaryKey(String txt){
        return nvDAO.CheckPrimaryKey(txt);
    }
    public static void searchByDate(String txt1, String txt2){
        if(dsnv==null) dsnv=new ArrayList<>();
        dsnv=nvDAO.searchByDate(txt1, txt2);
    }
}
