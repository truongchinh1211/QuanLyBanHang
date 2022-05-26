package Demo;

import java.util.Calendar;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DSPerson {
    private  Person listPerson[];
    private static int n;

    Scanner sc = new Scanner(System.in);

    public void setListPerson(Person[] listPerson) {
        this.listPerson = listPerson;
    }
    public static void setN(int n) {
        DSPerson.n = n;
    }
    public Person[] getListPerson() {
        return listPerson;
    }
    public static int getN() {
        return n;
    }

    public int capNhatSoPerson(){
        int count = 0;
        try {
            BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\Bum\\Documents\\NetBeansProjects\\QuanLyBanHang\\src\\main\\java\\Demo\\dsnhanvien.txt"));
            while ((rd.readLine())!=null) {
                count+=1;
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void docFileDsPerson(){
        n = capNhatSoPerson();
        listPerson = new Person[n];
        try {
            BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\Bum\\Documents\\NetBeansProjects\\QuanLyBanHang\\src\\main\\java\\Demo\\dsnhanvien.txt"));
            String line;
            for (int i = 0; i < listPerson.length; i++) {
                line = r.readLine(); 
                String split[] = line.split(", ");
                String chucvu = split[4];
                switch (chucvu) {
                    case "phucvu":
                        listPerson[i] = new PhucVu();
                        ((PhucVu) listPerson[i]).setCaPhucVu(split[7]);
                        ((PhucVu) listPerson[i]).setNgayCong(Integer.parseInt(split[8]));
                        break;
                    case "ketoan":
                        listPerson[i] = new KeToan();
                        ((KeToan) listPerson[i]).setNamKinhNghiem(Integer.parseInt(split[7]));
                        break;
                    case "quanly":
                        listPerson[i] = new QuanLy();
                        ((QuanLy) listPerson[i]).setBoPhanQl(split[7]);
                        break;
                    default:
                        i-=1;
                        break;
                    }
                listPerson[i].setIDPerson(split[0]);
                listPerson[i].setHoTen(split[1]);
                listPerson[i].setNamSinh(Integer.parseInt(split[2]));
                listPerson[i].setGioiTinh(split[3]);
                listPerson[i].setChucVu(split[4]);
                listPerson[i].setQueQuan(split[5]);
                listPerson[i].setSdt(split[6]);    
            }
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void xuatDS(){
        for (int i = 0; i < listPerson.length; i++) {
            System.out.println(listPerson[i].toString());
        }
    }

    public void themDS(){
        System.out.println("Nhap so luong Nhan vien muon them:");
        int sl = Integer.parseInt(sc.nextLine());
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter("C:\\Users\\Bum\\Documents\\NetBeansProjects\\QuanLyBanHang\\src\\main\\java\\Demo\\dsnhanvien.txt", true));
            for (int i = 0; i < sl; i++) {
                w.newLine();
                System.out.println("Chon chuc vu nhan vien can them: 1)Phuc vu\t2)Quan ly\t3)Ke toan");
                int choice = Integer.parseInt(sc.nextLine());
                while (choice<1 || choice>3) {
                    System.out.println("Chon khong hop le, chon lai");
                    choice = Integer.parseInt(sc.nextLine());
                }
                String chucvu = null;
                switch (choice) {
                    case 1:
                        chucvu = "phucvu"; break;
                    case 2:
                        chucvu = "quanly"; break;
                    case 3:
                        chucvu = "ketoan"; break;
                }
                System.out.println("Nhap ID: ");
                w.write(sc.nextLine() + ", ");
                System.out.println("Nhap ten:");
                w.write(sc.nextLine() + ", ");
                System.out.println("Nhap nam sinh:");
                String birthYear = sc.nextLine();
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                while (currentYear-(Integer.parseInt(birthYear))<18) {
                    System.out.println("Tuoi phai >=18, nhap lai:");
                    birthYear = sc.nextLine();
                }
                w.write(birthYear + ", ");
                System.out.println("Nhap gioi tinh:");
                String gender = sc.nextLine();
                while (gender.equalsIgnoreCase("nam")==false && gender.equalsIgnoreCase("nu")==false) {
                    System.out.println("Gioi tinh phai la 'nam' hoac 'nu', nhap lai:");
                    gender = sc.nextLine();
                }
                w.write(gender + ", ");
                w.write(chucvu + ", ");
                System.out.println("Nhap que quan:");
                w.write(sc.nextLine() + ", ");
                System.out.println("Nhap sdt:");
                boolean flag; String phone;
                do{
                phone=sc.nextLine();
                flag=phone.matches("0\\d{9,10}");
                if(!flag) System.out.println("Sdt phai co 10 hoac 11 so, bat dau bang 0 va khong chua ky tu!!");
                } while(!flag); w.write(phone +",");
                w.write(sc.nextLine() + ", ");
                switch (chucvu) {
                    case "quanly":
                        System.out.println("Nhap bo phan quan ly:");
                        w.write(sc.nextLine()); break;
                    case "phucvu":
                        System.out.println("Nhap ca lam:");
                        String ca = sc.nextLine();
                        while (ca.equalsIgnoreCase("sang")==false&&ca.equalsIgnoreCase("toi")==false) {
                            System.out.println("Ca lam la 'sang' hoac 'toi', nhap lai:" );
                            ca = sc.nextLine();
                        }
                        w.write(ca + ", ");
                        System.out.println("Nhap so ngay cong:");
                        w.write(sc.nextLine()); break;
                    case "ketoan":
                        System.out.println("Nhap so nam kinh nghiem:");
                        w.write(sc.nextLine() + ", "); break;
                }
            }
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        docFileDsPerson();
    }

    public void suaDS(){
        System.out.println("Nhap ID cua nhan vien muon sua:");
        String IDEdit = sc.nextLine();
        try {
            BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\Bum\\Documents\\NetBeansProjects\\QuanLyBanHang\\src\\main\\java\\Demo\\dsnhanvien.txt"));
            String line; String oldline = null;
            StringBuffer tempBuffer = new StringBuffer();
            StringBuffer newline = new StringBuffer();
            boolean flag = false;
            for(int i = 0; i < n; i++) {
                line=r.readLine();
                String split[] = line.split(", ");
                if (split[0].equalsIgnoreCase(IDEdit)) {
                    flag = true;
                    oldline = line;
                    System.out.println("Chon chuc vu cho nhan vien can sua 1)Phuc vu\t2)Quan ly\t3)Ke toan");
                    int choice = Integer.parseInt(sc.nextLine());
                    while (choice<1 || choice>3) {
                        System.out.println("Lua chon khong hop le, moi chon lai:");
                        choice = Integer.parseInt(sc.nextLine());
                    }
                    String chucvu = "";
                    switch (choice) {
                        case 1:
                            chucvu = "phucvu"; break;
                        case 2:
                            chucvu = "quanly"; break;
                        case 3:
                            chucvu = "ketoan"; break;
                    }
                    System.out.println("Nhap ID:"); newline.append(sc.nextLine() + ", ");
                    System.out.println("Nhap hoten:"); newline.append(sc.nextLine() + ", ");
                    System.out.println("Nhap nam sinh:"); String birthYear = sc.nextLine();
                    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                    while (currentYear-(Integer.parseInt(birthYear))<18) {
                        System.out.println("Tuoi phai >=18, nhap lai:"); birthYear = sc.nextLine();
                    }
                    newline.append(birthYear + ", ");
                    System.out.println("Nhap gioi tinh"); String gender = sc.nextLine();
                    while (gender.equalsIgnoreCase("nam")==false && gender.equalsIgnoreCase("nu")==false) {
                        System.out.println("Gioi tinh phai la 'nam' hoac 'nu', nhap lai:"); gender = sc.nextLine();
                    }
                    newline.append(gender + ", ");
                    newline.append(chucvu + ", ");
                    System.out.println("Nhap que quan:"); newline.append(sc.nextLine() + ", ");
                    System.out.println("Nhap sdt:"); newline.append(sc.nextLine() + ", ");
                    switch (chucvu) {
                        case "phucvu":
                            System.out.println("Nhap ca lam:"); String ca = sc.nextLine();
                            while (ca.equalsIgnoreCase("sang")==false&&ca.equalsIgnoreCase("toi")==false) {
                                System.out.println("Ca lam la 'sang' hoac 'toi', nhap lai:" ); ca = sc.nextLine();
                            }
                            newline.append(ca + ", ");
                            System.out.println("Nhap so ngay cong:"); newline.append(sc.nextLine());
                            break;
                        case "quanly":
                            System.out.println("Nhap bo phan quan ly:"); newline.append(sc.nextLine());
                            break;
                        case "ketoan":
                            System.out.println("Nhap so nam kinh nghiem:"); newline.append(sc.nextLine());
                            break;
                    }
                }
                if(i==(n-1)) tempBuffer.append(line);
                else tempBuffer.append(line + "\n");
            }
            r.close();
            if (flag == false) System.out.println("Khong tim thay nhan vien co ID da nhap!");
            String editString = tempBuffer.toString().replaceAll(oldline, newline.toString());
            BufferedWriter w = new BufferedWriter(new FileWriter("C:\\Users\\Bum\\Documents\\NetBeansProjects\\QuanLyBanHang\\src\\main\\java\\Demo\\dsnhanvien.txt"));
            w.write(editString);
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        docFileDsPerson();
    }
    
    public void xoaDS(){
        System.out.println("Nhap so nhan vien muon xoa:");
        int sl = Integer.parseInt(sc.nextLine());
        String dsDel[] = new String[sl];
        for (int i = 0; i < dsDel.length; i++) {
            System.out.println("Nhap ID cua nhan vien muon xoa lan " + (i+1)+":");
            dsDel[i] = sc.nextLine();
        }
        try {
            BufferedReader r = new BufferedReader(new FileReader("/Users/phuckhai/NetBeansProjects/QuanLyBanHang/src/main/java/Demo/dsnhanvien.txt"));
            String line;
            StringBuffer tempBuffer = new StringBuffer();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                line = r.readLine();
                String split[] = line.split(", ");
                for (int j = 0; j < dsDel.length; j++) {
                    if (split[0].equalsIgnoreCase(dsDel[j])==true) {
                        flag = true;
                        r.readLine();
                        break;
                    }
                }
                if (i==(n-1)) tempBuffer.append(line);
                else tempBuffer.append(line + "\n");
            }
            r.close();
            if (flag == false) System.out.println("Khong tim thay nhan vien co ID da nhap!");
            String newString = tempBuffer.toString();
            BufferedWriter w = new BufferedWriter(new FileWriter("/Users/phuckhai/NetBeansProjects/QuanLyBanHang/src/main/java/Demo/dsnhanvien.txt"));
            w.write(newString);
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        docFileDsPerson();
    }

    public void searchByID(){
        System.out.println("Nhap ID cua nhan vien tra cuu:");
        String IDSearch = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < listPerson.length; i++) {
            if (listPerson[i].getIDPerson().equalsIgnoreCase(IDSearch)) {
                flag = true;
                System.out.println("Da tim thay! Thong tin nhan vien:");
                System.out.println(listPerson[i].toString());
            }
        }
        if (flag == false) System.out.println("Khong tim thay nhan vien co ID da nhap!");
    }
}