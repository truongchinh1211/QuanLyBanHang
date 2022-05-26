package Demo;

import java.util.Scanner;

public class QuanLy extends Person{
    private String boPhanQl;

    Scanner sc = new Scanner(System.in);

    public QuanLy(){}

    public void setBoPhanQl(String boPhanQl) {
        this.boPhanQl = boPhanQl;
    }
    public String getBoPhanQl() {
        return boPhanQl;
    }

    @Override
    public double tinhLuong() {
        return 12000000;
    }

    @Override
    public String toString(){
        return super.toString() + " Bo phan quan ly: " + boPhanQl;
    }
}
