package Demo;

import java.util.Scanner;

public class PhucVu extends Person {
    private String caPhucVu;
    private int ngayCong;

    Scanner sc = new Scanner(System.in);

    public PhucVu(){}

    public void setCaPhucVu(String caPhucVu) {
        this.caPhucVu = caPhucVu;
    }
    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }
    public String getCaPhucVu() {
        return caPhucVu;
    }
    public int getNgayCong() {
        return ngayCong;
    }

    @Override
    public double tinhLuong() {
        return this.ngayCong*200000;
    }
    
    @Override
    public String toString(){
        return super.toString() + " Ca: "+caPhucVu + " Ngay cong:" + ngayCong;
    }
}
