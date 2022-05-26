package Demo;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class PhieuNhapHang extends nhapHang{
    private LocalDateTime date ;
    private double tongTienNhapHang;
    private static int n;
    private nhapHang phieuNhap[];

    public PhieuNhapHang(){}

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setTongTienNhapHang(double tongTienNhapHang) {
        this.tongTienNhapHang = tongTienNhapHang;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public double getTongTienNhapHang() {
        return tongTienNhapHang;
    }

    public double tinhTongTienNhapHang(){
        double tongTien = 0;
        for (int i = 0; i < phieuNhap.length; i++) {
            tongTien += phieuNhap[i].getDonGia()*phieuNhap[i].getSoLuongNhap();
        }
        return tongTien;
    }

    public void nhap(){
        setDate(LocalDateTime.now());
        System.out.println("Moi nhap so luong hang can nhap:");
        n = Integer.parseInt(sc.nextLine());
        phieuNhap = new nhapHang[n];
        for (int i = 0; i < phieuNhap.length; i++) {
            phieuNhap[i] = new nhapHang();
            phieuNhap[i].nhap1sp();
        }
        setTongTienNhapHang(tinhTongTienNhapHang());
    }

    public void inPhieuNhapHang(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("\t\t  ======================================");
        System.out.println("\t\t|\tPHIEU NHAP HANG");
        System.out.println("\t\t|\tNgay nhap: " + dtf.format(getDate()));
        System.out.println("\t\t|\tDanh sach san pham duoc nhap");
        System.out.println("\t\t| Ten san pham\t\tSo luong\tDon gia");
        for (int i = 0; i < phieuNhap.length; i++) {
            System.out.println("\t\t| " + String.format("%-12s", phieuNhap[i].getProductName()) + "\t\t" + phieuNhap[i].getSoLuongNhap()
            +"\t\t" + phieuNhap[i].getDonGia());
        }
        System.out.println("\t\t|\t---------------------");
        tinhTongTienNhapHang();
        System.out.println("\t\t| Tong gia tri phieu nhap hang:" + getTongTienNhapHang());
    }
}
