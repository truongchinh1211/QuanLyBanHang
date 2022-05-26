package Demo;

import java.util.Scanner;

public class Product {
    private String productName;
    private String productID;
    private int soLuong;
    private double donGia;

    Scanner sc = new Scanner(System.in);

    public Product(){}

    public Product(String name, String id, int sl, double dg){
        this.productName = name;
        this.productID = id;
        this.soLuong = sl;
        this.donGia = dg;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductID(String productID) {
        this.productID = productID;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    public String getProductName() {
        return productName;
    }
    public String getProductID() {
        return productID;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public double getDonGia() {
        return donGia;
    }

    public void nhapsp(){
        System.out.println("Nhap ten sp:");
        setProductName(sc.nextLine());
        System.out.println("Nhap id sp:");
        setProductID(sc.nextLine());
        System.out.println("Nhap don gia sp:");
        setDonGia(Double.parseDouble(sc.nextLine()));
        System.out.println("Nhap so luong sp");
        setSoLuong(Integer.parseInt(sc.nextLine()));
    }
    @Override
    public String toString(){
        return "[Ten sp:"+this.productName+" id:"+this.productID+" don gia:"+this.donGia
        +" so luong:"+this.soLuong+" ]";
    }
}