package Demo;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Bill {
    private String CustomerName;
    private LocalDateTime Billdate;
    private String BillID;
    private String DSSPBill[];
    private int SoluongSpBill[];
    private double giaSpBill[];
    private double TongTienBill;
    private static double Thue = 0.1;

    Scanner sc = new Scanner(System.in);

    public Bill(){}

    public void setBillID(String billID) {
        BillID = billID;
    }
    public void setBilldate(LocalDateTime billdate) {
        Billdate = billdate;
    }
    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }
    public void setDSSPBill(String[] dSSPBill) {
        DSSPBill = dSSPBill;
    }
    public void setSoluongSpBill(int[] soluongSpBill) {
        SoluongSpBill = soluongSpBill;
    }
    public void setGiaSpBill(double[] giaSpBill) {
        this.giaSpBill = giaSpBill;
    }
    public void setTongTienBill(double tongTienBill) {
        TongTienBill = tongTienBill;
    }
    public String getBillID() {
        return BillID;
    }
    public LocalDateTime getBilldate() {
        return Billdate;
    }
    public String getCustomerName() {
        return CustomerName;
    }
    public double getTongTienBill() {
        return TongTienBill;
    }

    public void makeBill(){
        setBilldate(LocalDateTime.now());
        System.out.println("Nhap id cua bill:");
        setBillID(sc.nextLine());
        setCustomerName(Order.getCustomerName());
        setDSSPBill(Order.getOrderList());
        setSoluongSpBill(Order.getSoluongOrder());
        giaSpBill = new double[DSSPBill.length]; 
        Product dsProduct[] = ProductList.getProList();
        double tongtien = 0;
        for (int i = 0; i < DSSPBill.length; i++) {
            for (int j = 0; j < dsProduct.length; j++) {
                if (DSSPBill[i].equalsIgnoreCase(dsProduct[j].getProductName()) && SoluongSpBill[i]<=dsProduct[j].getSoLuong()) {
                    giaSpBill[i] = dsProduct[j].getDonGia();
                    tongtien = tongtien + giaSpBill[i]*SoluongSpBill[i];
                    dsProduct[j].setSoLuong(dsProduct[j].getSoLuong() - SoluongSpBill[i]);
                }
            }
        }
        setTongTienBill(tongtien);
    }

    public void printBill(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("\t\t  =======================================");
        System.out.println("\t\t|\t\tHOA DON");
        System.out.println("\t\t|\tNgay: "+ dtf.format(getBilldate()));
        System.out.println("\t\t|\tId Hoa don: "+getBillID());
        System.out.println("\t\t|\tTen KH: "+getCustomerName());
        System.out.println("\t\t|\t\tDanh sach mua hang");
        System.out.println("\t\t| Ten san pham\t\tDon gia\t\tSoluong");
        for (int i = 0; i < DSSPBill.length; i++) {
            if (SoluongSpBill[i] != 0) {
                System.out.println("\t\t| " + String.format("%-12s", DSSPBill[i]) + "\t\t" + giaSpBill[i] + "\t\t"
                + SoluongSpBill[i]);
            }
        }
        System.out.println("\t\t|\t-----------------------");
        System.out.println("\t\t| Tong tien: "+getTongTienBill());
        System.out.println("\t\t| Them 10% Thue, So tien can thanh toan la: " + (getTongTienBill()+getTongTienBill()*Thue));
    }

}