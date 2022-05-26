package Demo;

import java.util.Scanner;

public class Order {
    private String OrderID;
    private static String CustomerName;
    private static String OrderList[];
    private static int soluongOrder[];

    Scanner sc = new Scanner(System.in);

    public Order(){}

    public void setCustomerName(String customerID) {
        CustomerName = customerID;
    }
    public void setOrderID(String orderID) {
        OrderID = orderID;
    }
    public void setOrderList(String[] orderList) {
        OrderList = orderList;
    }
    public void setSoluongOrder(int[] soluong) {
        soluongOrder = soluong;
    }
    public static String getCustomerName() {
        return CustomerName;
    }
    public String getOrderID() {
        return OrderID;
    }
    public static String[] getOrderList() {
        return OrderList;
    }
    public static int[] getSoluongOrder() {
        return soluongOrder;
    }

    public void makeOrder(){
        
        System.out.println("Nhap Id order:");
        setOrderID(sc.nextLine());
        System.out.println("Nhap ten khach hang:");
        setCustomerName(sc.nextLine());
        System.out.println("Nhap so luong mon an:");
        int n = Integer.parseInt(sc.nextLine());
        OrderList = new String[n];
        soluongOrder = new int[n];
        Product pd[] = ProductList.getProList();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap mon:");
            OrderList[i] = sc.nextLine();
            System.out.println("Nhap so luong:");
            int sl = Integer.parseInt(sc.nextLine());
            soluongOrder[i] = sl;
            for (int j = 0; j < pd.length; j++) {
                if (pd[j].getProductName().equalsIgnoreCase(OrderList[i]) && sl>pd[j].getSoLuong()){
                    if (pd[j].getSoLuong()>0) {
                        do {
                            System.out.println("San pham khong con du so luong! (con lai "+pd[j].getSoLuong()+")");
                            System.out.println("Nhap lai so luong:");
                            sl = Integer.parseInt(sc.nextLine());
                        } while (sl>pd[j].getSoLuong());
                        soluongOrder[i] = sl;
                    }
                    else {
                        System.out.println("Xin loi! san pham hien tai da het hang.");
                        soluongOrder[i] = 0;
                    }  
                }  
            }
        }


    }
    

}