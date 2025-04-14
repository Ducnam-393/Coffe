/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author Hello
 */
public class QuanLyDao {

     Connection con = KetNoi.getConnection();
     PreparedStatement ps;
     Statement st;
     ResultSet rs;

     public int getMaxRowAdminTable() {
          int row = 0;
          try {
               st = con.createStatement();
               rs = st.executeQuery("SELECT MAX(ID) FROM QuanLy");
               while (rs.next()) {
                    row = rs.getInt(1);
               }
          } catch (Exception ex) {
               java.util.logging.Logger.getLogger(QuanLyDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          return row + 1;
     }

     public boolean isAdminNameExist(String TenDangNhap) {
          try {
               ps = con.prepareStatement("select * from quanly where username = ?");
               ps.setString(1, TenDangNhap);
               rs = ps.executeQuery();
               if (rs.next()) {
                    return true;
               }
          } catch (Exception ex) {
               java.util.logging.Logger.getLogger(QuanLyDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          return false;
     }

     public boolean insertQuanLy(Quan_Ly quanly) {
          String sql = "INSERT INTO QuanLy (ID,username,password) VALUES (?, ?, ?)";
          try {
               ps = con.prepareStatement(sql);
               ps.setInt(1, quanly.getId());
               ps.setString(2, quanly.getTen_Dang_Nhap());
               ps.setString(3, quanly.getMat_Khau());
               return ps.executeUpdate() > 0;
          } catch (Exception ex) {
               java.util.logging.Logger.getLogger(QuanLyDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
               return false;
          }
     }

     public boolean dangky(String username, String password) {
          try {
               ps = con.prepareStatement("select * from quanly where username = ? and password = ?");
               ps.setString(1, username);
               ps.setString(2, password);
               rs = ps.executeQuery();
               if (rs.next()) {
                    return true;
               }
          } catch (Exception ex) {
               java.util.logging.Logger.getLogger(QuanLyDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          return false;
     }
     
    public boolean getUser(String username) {
    try {       
        PreparedStatement ps = con.prepareStatement("SELECT * FROM quanly WHERE username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        
        return rs.next(); // trả về true nếu có username trong CSDL

    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return false;
}
     
     public boolean setPassword(String username , String Password) {
          String sql = "update quanly set password = ? where username = ?";
          try {
               ps = con.prepareStatement(sql);
               ps.setString(1, Password);
               ps.setString(2, username);
               return ps.executeUpdate() > 0;
               
          } catch (Exception ex) {
               return false;
          }        
     }

}
