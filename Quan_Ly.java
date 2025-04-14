/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

/**
 *
 * @author Hello
 */
public class Quan_Ly {

     private int id;
     private String ten_Dang_Nhap;
     private String mat_Khau;

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getTen_Dang_Nhap() {
          return ten_Dang_Nhap;
     }

     public void setTen_Dang_Nhap(String ten_Dang_Nhap) {
          this.ten_Dang_Nhap = ten_Dang_Nhap;
     }

     public String getMat_Khau() {
          return mat_Khau;
     }

     public void setMat_Khau(String mat_Khau) {
          this.mat_Khau = mat_Khau;
     }

     public Quan_Ly(int id, String ten_Dang_Nhap, String mat_Khau) {
          this.id = id;
          this.ten_Dang_Nhap = ten_Dang_Nhap;
          this.mat_Khau = mat_Khau;
     }

     public Quan_Ly() {
     }

}
