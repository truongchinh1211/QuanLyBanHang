package Demo;

import java.util.Scanner;

public class nhapHang {
    private String productName;
    private int soLuongNhap;
    private double donGia;

    Scanner sc = new Scanner(System.in);

    public nhapHang(){}

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getProductName() {
        return productName;
    }
    public int getSoLuongNhap() {
        return soLuongNhap;
    }
    public double getDonGia() {
        return donGia;
    }

    public void nhap1sp(){
        System.out.println("Moi nhap ten sp:");
        setProductName(sc.nextLine());
        Product proList[] = ProductList.getProList();
        boolean flag=false;
        for (int i = 0; i < ProductList.getN(); i++) {
            if (getProductName().equalsIgnoreCase(proList[i].getProductName())){
                flag=true;
                System.out.println("Nhap so luong:");
                setSoLuongNhap(Integer.parseInt(sc.nextLine()));
                setDonGia(proList[i].getDonGia());
                int newsl = proList[i].getSoLuong() + getSoLuongNhap();
                proList[i].setSoLuong(newsl);
            }
            else continue;
        }
        if (flag==false) 
            System.out.println("Xin loi, san pham ban can nhap khong nam trong danh muc san pham cua cua hang!");
    }

}
