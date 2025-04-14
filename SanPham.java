/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

/**
 *
 * @author Hello
 */
public class SanPham {
     private int MaSanPham;
     private String TenSp;
     private double GiaTien;
     private byte []AnhSanPham;

     public int getMaSanPham() {
          return MaSanPham;
     }

     public String getTenSp() {
          return TenSp;
     }

     public double getGiaTien() {
          return GiaTien;
     }

     public byte[] getAnhSanPham() {
          return AnhSanPham;
     }

     public void setMaSanPham(int MaSanPham) {
          this.MaSanPham = MaSanPham;
     }

     public void setTenSp(String TenSp) {
          this.TenSp = TenSp;
     }

     public void setGiaTien(double GiaTien) {
          this.GiaTien = GiaTien;
     }

     public void setAnhSanPham(byte[] AnhSanPham) {
          this.AnhSanPham = AnhSanPham;
     }
     
}
