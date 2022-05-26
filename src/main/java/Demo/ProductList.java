package Demo;

import java.util.Scanner;

public class ProductList extends Product{
    private static int N;
    private static  Product ProList[];

    Scanner sc = new Scanner(System.in);

    public ProductList(){}

    public void setN(int n) {
        N = n;
    }
    public static void setProList(Product[] proList) {
        ProList = proList;
    }
    public static int getN() {
        return N;
    }
    public static Product[] getProList() {
        return ProList;
    }

    public void nhapdssp(){
        System.out.println("Nhap so luong cac sp:");
        N = Integer.parseInt(sc.nextLine());
        ProList = new Product[N];
        for (int i = 0; i < ProList.length; i++) {
            System.out.println("Nhap thong tin sp thu "+(i+1)+" :");
            ProList[i] = new Product();
            ProList[i].nhapsp();
        }
    }
    public void xuatdssp(){
        System.out.println("Thong tin ds cac sp:");
        for (int i = 0; i < ProList.length; i++) {
            System.out.println(ProList[i].toString());
        }
    }
}
