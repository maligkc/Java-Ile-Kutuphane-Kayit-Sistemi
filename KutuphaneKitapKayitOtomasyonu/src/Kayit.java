
public class Kayit {
    
    
    private int id;
    private String kitapAd;
    private String kitapYazar;
    private String kisiAdSoyad;
    private String telNo;
    public String tarih;

    public Kayit(int id, String kitapAd, String kitapYazar, String kisiAdSoyad, String telNo,String tarih) {
        this.id = id;
        this.kitapAd = kitapAd;
        this.kitapYazar = kitapYazar;
        this.kisiAdSoyad = kisiAdSoyad;
        this.telNo = telNo;
        this.tarih = tarih;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKitapAd() {
        return kitapAd;
    }

    public void setKitapAd(String kitapAd) {
        this.kitapAd = kitapAd;
    }

    public String getKitapYazar() {
        return kitapYazar;
    }

    public void setKitapYazar(String kitapYazar) {
        this.kitapYazar = kitapYazar;
    }

    public String getKisiAdSoyad() {
        return kisiAdSoyad;
    }

    public void setKisiAdSoyad(String kisiAdSoyad) {
        this.kisiAdSoyad = kisiAdSoyad;
    }

    

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
    
    
    
}
