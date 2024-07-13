import java.util.List;
public class MilliPark {
    String milliParkAdi;
    String ilAdi;
    int ilanYili;
    int yuzOlcumu;
    List<String> bilgiler;

    public MilliPark(String milliParkAdi, String ilAdi, int ilanYili, int yuzOlcumu, List<String> bilgiler) {
        this.milliParkAdi = milliParkAdi;
        this.ilAdi = ilAdi;
        this.ilanYili = ilanYili;
        this.yuzOlcumu = yuzOlcumu;
        this.bilgiler = bilgiler;
    }

    public String getMilliParkAdi() {
        return milliParkAdi;
    }

    public String getIlAdi() {
        return ilAdi;
    }

    public int getIlanYili() {return ilanYili;}

    public int getYuzOlcumu() {return yuzOlcumu;}

    public List<String> getBilgiler() {
        return bilgiler;
    }

    public void setIlanYili(int ilanYili) {
        this.ilanYili = ilanYili;
    }

    @Override
    public String toString() {
        return
                "Adı:" + getMilliParkAdi() +
                        " Bulunduğu İl: " + getIlAdi() +
                        " İlan Yılı:" + getIlanYili() +
                        " Yüz Ölçümü:" + getYuzOlcumu() +
                        " Bilgi:"  + getBilgiler()  ;
    }
}