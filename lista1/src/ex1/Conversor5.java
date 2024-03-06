package ex1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Junior
 */
public class Conversor5 {
    
    public double CF(double c) {
        double f = 0;
        f=(c*1.8)+32;
        return f;
    }
    
    public double CK(double c) {
        double k = 0;
        k=c+273;
        return k;
    }  
    
    public double FC(double f) {
        double c = 0;
        c=(f-32)/1.8;
        return c;
    }
    
    public double FK(double f) {
        double k = 0;
        k=(f-32)*5/9+273;
        return k;
    }  
      public double KC(double k) {
        double c = 0;
        c=k-273;
        return c;
    }
    
    public double KF(double k) {
        double f = 0;
        f =(k-273.15)*9/5+32;
        return f;
    }  
}
