package Demo;

import java.util.Scanner;

public abstract class Person {
    private String IDPerson;
    private String hoTen;
    private int namSinh;
    private String gioiTinh;
    private String chucVu;
    private String queQuan;
    private String sdt;

    Scanner sc = new Scanner(System.in);

    public Person(){}

    public void setIDPerson(String iDPerson) {
        IDPerson = iDPerson;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String getIDPerson() {
        return IDPerson;
    }
    public String getHoTen() {
        return hoTen;
    }
    public int getNamSinh() {
        return namSinh;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    public String getChucVu() {
        return chucVu;
    }
    public String getQueQuan() {
        return queQuan;
    }
    public String getSdt() {
        return sdt;
    }

    public abstract double tinhLuong();

    @Override
    public String toString(){
        return "ID: "+IDPerson+" Ho ten: "+hoTen+" Nam sinh: "+namSinh+" Gender: "
        +gioiTinh+" Chuc vu: "+chucVu+" Que quan: "+queQuan+" SDT: "+sdt;
    };
}