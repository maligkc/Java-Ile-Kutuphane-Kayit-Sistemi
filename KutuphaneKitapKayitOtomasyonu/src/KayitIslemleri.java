
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KayitIslemleri {
    
    private Connection con = null;
    
    private PreparedStatement preparedStatement = null;

    public KayitIslemleri() {
        
        
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.database_ismi + "?useUnicode=true&characterEncoding=utf8";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Veritabanına bağlantı başarılı");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class bulunamadı...");
        } catch (SQLException ex) {
            System.out.println("SQLException...");
        }
    }
    
    
    
    public boolean girisYap(String kullaniciAdi,String parola){
        
        String sorgu = "SELECT * FROM adminpanel WHERE username = ? AND password = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, kullaniciAdi);
            preparedStatement.setString(2, parola);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            
            return rs.next();
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(KayitIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return false;
        
    }
    
    
    
    public LinkedList<Kayit> kayitlariGetir(){
        
        
        LinkedList<Kayit> kayit = new LinkedList<Kayit>();
        
        String sorgu = "SELECT * FROM kitapkayit";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            
            
            while(rs.next()){
                
                int id = rs.getInt("ID");
                String kitapAd = rs.getString("kitapAd");
                String kitapYazar = rs.getString("kitapYazar");
                String kisiAdSoyad = rs.getString("kisiAdSoyad");
                String kisiTelNo = rs.getString("telNo");
                String tarih = rs.getString("tarih");
                
                kayit.add(new Kayit(id, kitapAd, kitapYazar, kisiAdSoyad, kisiTelNo, tarih));
                
                
            }
            
            return kayit;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(KayitIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
    
    
    public void kayitEkle(String kitapAd,String kitapYazar,String kisiAdSoyad,String kisiTelNo,String tarih){
        
        String sorgu = "INSERT INTO kitapkayit (kitapAd,kitapYazar,kisiAdSoyad,telNo,tarih) VALUES(?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, kitapAd);
            preparedStatement.setString(2, kitapYazar);
            preparedStatement.setString(3, kisiAdSoyad);
            preparedStatement.setString(4, kisiTelNo);
            preparedStatement.setString(5, tarih);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(KayitIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void kayitGuncelle(int id, String kitapAd,String kitapYazar,String kisiAdSoyad,String kisiTelNo,String tarih){
        
        String sorgu = "UPDATE kitapkayit SET kitapAd=?, kitapYazar=?, kisiAdSoyad = ?, telNo = ?, tarih = ? WHERE ID = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, kitapAd);
            preparedStatement.setString(2, kitapYazar);
            preparedStatement.setString(3, kisiAdSoyad);
            preparedStatement.setString(4, kisiTelNo);
            preparedStatement.setString(5, tarih);
            preparedStatement.setInt(6, id);
            
            preparedStatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(KayitIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void kayitSil(int id){
        
        String sorgu = "DELETE FROM kitapkayit WHERE ID = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(KayitIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void yeniKayitOlustur(String kullaniciAdi,String sifre){
        
        String sorgu = "INSERT INTO adminpanel (username, password) VALUES (?, ?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, kullaniciAdi);
            preparedStatement.setString(2, sifre);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(KayitIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean kullaniciAdiGetir(String kullaniciAdi){
        
        
        String sorgu = "SELECT * FROM adminpanel WHERE username = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, kullaniciAdi);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(KayitIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
        
        
        
        
    }
    
    
    
    
}
