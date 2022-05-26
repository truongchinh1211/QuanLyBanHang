package Demo;

import java.util.Scanner;

public class KeToan extends Person{
    private int namKinhNghiem;
    
    Scanner sc = new Scanner(System.in);

    public KeToan(){}

    public void setNamKinhNghiem(int namKinhNghiem) {
        this.namKinhNghiem = namKinhNghiem;
    }
    public int getNamKinhNghiem() {
        return namKinhNghiem;
    }

    @Override
    public double tinhLuong() {
        return 7500000;
    }

    @Override
    public String toString(){
        return super.toString() + " Nam kinh nghiem: " + namKinhNghiem;
    }
}
