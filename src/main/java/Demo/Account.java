/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Demo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

import java.io.Serializable;
import java.util.Scanner;


public class Account implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String pass;
    private int type;

    public Account() {
    }

    public Account(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public void nhap()
    {        
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten tai khoan: ");
        setName(sc.nextLine());
        System.out.println("Nhap mat Khau: ");
        setPass(sc.nextLine());
        type=0;
    }

    @Override
    public String toString() {
        return "Account{" + "name=" + name + ", pass=" + pass + "}";
    }
    
}
