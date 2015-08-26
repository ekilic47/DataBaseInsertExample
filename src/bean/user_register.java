package bean;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class user_register {
String isim;
String soyad;
String email;
String sifre;
 
    public String getIsim() {
        return isim;
    }
 
    public void setIsim(String isim) {
        this.isim = isim;
    }
 
    public String getSoyad() {
        return soyad;
    }
 
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getSifre() {
        return sifre;
    }
 
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
    
    public void kaydet()
    {
        PreparedStatement ps=null;
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/uye","root","1");
            ps=con.prepareStatement("INSERT INTO uye_kayit(Adi, Soyadi, Email, Sifre) VALUES(?,?,?,?)");
 
            ps.setString(1, isim);
            ps.setString(2, soyad);
            ps.setString(3, email);
            ps.setString(4, sifre);
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally 
        {
            try{
            con.close();
            ps.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
    