/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Demo;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Bum
 */
public class AccountList {
    private int n;
    Account[] acc;
    
    public AccountList()
    {
        ReadObject();
    }


    public int getN() {
        return n;
    }

    public Account[] getAcc() {
        return acc;
    }
    
    public void createAcc()
    {
        System.out.println("Tien hanh tao tai khoan......");
        System.out.println("_____Tao tai khoan______");
        n++;
        Account temp = new Account();
        temp.nhap();
        int flag = 1;
        for(int i=0;i<acc.length;i++)
            if(acc[i]!=null)
                if(temp.getName().equals(acc[i].getName())){
                    System.out.println("Ten tai khoan da ton tai, tao tk that bai!!!");
                    flag = 0;
                    break;}
        if(flag ==1){
            System.out.println("Tao tai khoan thanh cong");
            acc[n] = new Account();
            acc[n]=temp;
            WriteObject();
        }
    }
    public void nhapDS()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap n:");
        n = Integer.parseInt(sc.nextLine());
        acc = new Account[10];
        for(int i=0;i<n;i++){
          acc[i] = new Account();
          acc[i].nhap();}
        WriteObject();
    }
    public void WriteObject()
    {        
        try{
        FileOutputStream fos = new FileOutputStream("log.txt");
        ObjectOutputStream oos = new ObjectOutputStream((fos));
        oos.writeInt(n);
        oos.writeObject(acc);
        fos.close();
        oos.close();
        System.out.println("done");
        } catch (IOException ex){ System.out.println("Error");;}
    }
    public void ReadObject()
    {
        Account acc[]=null; int n = 0;
        try{
        FileInputStream fis = new FileInputStream("log.txt");
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));
        n = (int)ois.readInt();
        acc = new Account[10];
        acc = (Account[])ois.readObject();
        ois.close();
        fis.close();
    } catch (IOException ex){ System.out.println("error");}
      catch (ClassNotFoundException e) {
            System.out.println("Class not found");
}        
        this.acc= acc;this.n= n;
    }
    public void show ()
    {
        for (Account Acc1: acc)
            if(Acc1!=null) System.out.println(Acc1.toString());
    }
    public int login()
    {
        Account login = new Account();
        int flag = 0;
        System.out.println("-------Xin hay dang nhap--------");
        do {
            login.nhap();
            for (int i = 0; i<acc.length; i++) {
                if(acc[i]!=null)
                    if (login.getName().equals(acc[i].getName())) {
                        if (login.getPass().equals(acc[i].getPass()))
                        if(acc[i].getType()==1){
                            System.out.println("login success");
                            flag = 1;
                            break;
                        }
                    }
            }
            if (flag == 0) {
                System.out.println("Ten dang nhap hoac mat khau khong dung!!!");
                System.out.println("Moi nhap lai!");
            }
        } while (flag == 0);
        return 1;
    }
    public static void main(String[] args)
    {
        AccountList acc = new AccountList();
        acc.createAcc();
        acc.show();
        acc.login();
    }

  }

