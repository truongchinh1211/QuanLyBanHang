package Demo;

import java.util.Scanner;

public class Console { 
    Scanner sc = new Scanner(System.in);   

    public static void Commands(){
        System.out.println("1.Tao danh sach san pham moi ");
        System.out.println("2.Hien thi danh sach san pham");
        System.out.println("3.Nhap hang");
        System.out.println("4.Order");
        System.out.println("5.Tinh bill");
        System.out.println("6.Quan Ly nhan vien");
        System.out.println("7.Thoat");
    }
    public static void QuanLyCommands()
    {
        System.out.println("1.Xem danh sach nhan vien");
        System.out.println("2.Them nhan vien");
        System.out.println("3.Chinh sua");
        System.out.println("4.Tra cuu");
        System.out.println("5.Tao them tai khoan");
        System.out.println("6.Thoat");
    }
    public void QuanLyPermission(){
        DSPerson dsP = new DSPerson();
        dsP.docFileDsPerson();
        int function;
        do {
            System.out.println("------Moi nhap lua chon-------");
            QuanLyCommands();
            function = Integer.parseInt(sc.nextLine());
            switch (function) {
                case 1: dsP.xuatDS(); break;
                case 2: dsP.themDS(); break;
                case 3: dsP.suaDS(); break;
                case 4: dsP.searchByID(); break;
                case 5: AccountList acc = new AccountList(); acc.createAcc(); break;
            }
        } while(function != 6);
    }
    
    public void console() {
        Scanner sc = new Scanner(System.in);
        ProductList dssp = new ProductList();
        int choice;
        do  {
            
            System.out.println("Moi nhap lua chon:");
            Commands();
            choice =  Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: dssp.nhapdssp(); dssp.xuatdssp(); break;
                case 2: dssp.xuatdssp(); break;
                case 3:
                    System.out.println("==Nhap hang==");
                    PhieuNhapHang p = new PhieuNhapHang();
                    p.nhap();
                    p.inPhieuNhapHang(); 
                    break;
                case 4:
                    Order o = new Order();
                    System.out.println("==Order mon==");
                    o.makeOrder();
                    break;
                case 5:
                    Bill b = new Bill();
                    b.makeBill();
                    b.printBill();
                    break;
                case 6:
                    AccountList Acc = new AccountList();
                    if(Acc.login()==1)
                    QuanLyPermission(); 
                    break;
                default:
                    break;
            }


        } while (choice != 7); System.out.println("Cam on ban da su dung chuong trinh!");
    }
        public static void main(String[] args)
        {
            Console c = new Console();
            c.console();
        }
            
    }

