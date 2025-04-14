/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hello
 */
public class Dao {
     
     Connection con = KetNoi.getConnection();
     PreparedStatement ps;
     Statement st;
     ResultSet rs;
     
     public int getMaxRowSanPhamTable() {
          int row = 0;
          try {
               st = con.createStatement();
               rs = st.executeQuery("SELECT MAX(MaSanPham) FROM sanpham");
               while (rs.next()) {
                    row = rs.getInt(1);
               }
          } catch (Exception ex) {
               java.util.logging.Logger.getLogger(Dao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          return row + 1;
     }
     
     public boolean themSanPham(SanPham p) {
          String sql = "INSERT INTO sanpham (MaSanPham, TenSp, GiaTien, AnhSanPham) VALUES (?, ?, ?, ?)";
          try {
               ps = con.prepareStatement(sql);
               ps.setInt(1, p.getMaSanPham());
               ps.setString(2, p.getTenSp());
               ps.setDouble(3, p.getGiaTien());
               ps.setBytes(4, p.getAnhSanPham());
               return ps.executeUpdate() > 0;
          } catch (Exception ex) {         
               return false;
          }      
     }
     
     public void getTatCaSanPham(JTable table) {
          String sql = "SELECT * FROM sanpham ORDER BY MaSanPham DESC";
          try {
               ps = con.prepareStatement(sql);
               rs = ps.executeQuery();
               DefaultTableModel model = (DefaultTableModel) table.getModel();
               Object[] row;

               while (rs.next()) { 
                    row = new Object[4];
                    row[0] = rs.getInt(1);
                    row[1] = rs.getString(2);
                    row[2] = rs.getDouble(3);
                    row[3] = rs.getBytes(4); 
                    model.addRow(row);
               }

          } catch (Exception ex) {
               java.util.logging.Logger.getLogger(Dao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

          }
     }
    /* public List<SanPham> getTatCaSanPham() {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM sanpham ORDER BY MaSanPham DESC";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSp(rs.getString("TenSp"));
                sp.setGiaTien(rs.getDouble("GiaTien"));
                sp.setAnhSanPham(rs.getBytes("AnhSanPham"));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }*/
     
}



