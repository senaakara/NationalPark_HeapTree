import java.io.*;
import java.util.*;
import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] milliParkAdlari = {"Yozgat Camligi Milli Parki","Karatepe Aslantas Milli Parki", "Soguksu Milli Parki", "Kuscenneti Milli Parki", "Uludag Milli Parki" ,"Yedigoller Milli Parki", "Dilek Y B Menderes D Milli Parki", "Spil Dagi Milli Parki", "Kizildag Milli Parki","Gulluk Dagi Termessos Milli Parki",
                "Kovada Golu Milli Parki", "Munzur Vadisi Milli Parki", "Beydaglari Sahil Milli Parki", "Koprulu Kanyon Milli Parki", "Ilgaz Dagi Milli Parki", "Baskomutan Tarihi Milli Parki", "Altindere Vadisi Milli Parki","Bogazkoy Alacahoyuk Milli Parki",
                "Nemrut Dagi Milli Parki", "Beysehir Golu Milli Parki", "Kazdagi Milli Parki", "Altinbesik Magarasi Milli Parki" ,"Hatila Vadisi Milli Parki", "Karagol Sahara Milli Parki" ,
                "Kackar Daglari Milli Parki", "Aladaglar Milli Parki" ,"Marmaris Milli Parki", "Saklikent Milli Parki", "Troya Tarihi Milli Parki","Honaz Dagi Milli Parki", "Küre Daglari Milli Parki" ,"Sarikamis Allahuekber Daglari Milli Parki","Agri Dagi Milli Parki","Gala Golu Milli Parki","Sultan Sazligi Milli Parki",
                "Tek Tek Daglari Milli Parki ","Igneada Longoz Ormanlari Milli Parki", "Yumurtalik Lagunu Milli Parki", "Nene Hatun Tarihi Milli Parki", "Sakarya Meydan Muharebesi Tarihi Milli Parki", "Kop Dagi Mudafaasi Tarihi Milli Parki","Malazgirt Meydan Muharebesi Tarihi Milli Parki","Istiklal Yolu Tarihi Milli Parki ","Botan Vadisi Milli Parki", "Hakkari Cilo ve Sat Daglari Milli Parki", "Saricali Dagi Milli Parki", "Derebucak Camlik Magaralari Milli Parki", "Abant Golu Milli Parki"};
        String[] ilAdlari = {"Yozgat", "Osmaniye", "Ankara" ,"Balıkesir", "Bursa" ,"Bolu", "Aydın",
                "Manisa", "Isparta", "Antalya", "Isparta" ,"Tunceli", "Antalya", "Antalya", "Kastamonu", "Afyonkarahisar",
                "Trabzon", "Çorum", "Adıyaman", "Konya","Balıkesir", "Antalya", "Artvin", "Artvin", "Rize" ,"Niğde",
                "Muğla", "Muğla" ,"Çanakkale" ,"Denizli" ,"Kastamonu", "Kars", "Ağrı", "Edirne", "Kayseri", "Şanlıurfa",
                "Kırklareli", "Adana", "Erzurum", "Ankara", "Bayburt","Muş",
                "Kastamonu" ,"Siirt", "Hakkari" ,"Ankara", "Konya" ,"Bolu"};
        int [] ilanYillari = {1958 ,1958 ,1959 ,1959 ,1961 ,1965,1966,1968 ,1969,1970,1970,1971,1972,1973 ,1976,1981
                ,1987,1988,1988 ,1993 ,1994 ,1994 ,1994 ,1994 ,1994 ,1995 ,1996 ,1996 ,1996 ,1998 ,2000,2004,2004 ,2005
                ,2006 ,2007,2007,2008 ,2009,2015 ,2016, 2018, 2018, 2019, 2020, 2021, 2022, 2022};
        int[] yuzOlcumleri = {517, 4143 ,1186 ,17058 ,13024 ,1623,27598, 6801, 80200, 6700,6551 ,42674 ,31166 ,47473,
                1118 ,34834 ,4468, 2600,13827 ,82157, 20935 ,1147 ,16944 ,3251 ,52970 ,55064 ,29206 ,1643 ,13517 ,9429 ,
                37753, 22520,88015, 5923, 24358 ,19335,3155,16980 ,387,  13850 ,6335,238, 236, 11358,27500, 1024 ,1147, 1262};

        List<List<String>> bolunmus = new ArrayList<>();

        File file = new File("bilgiler.txt");               // DOSYA OKUMA
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(file));

        String satir = reader.readLine();
        while (satir!=null) {
            List<String> geciciListe = new ArrayList<>();
            geciciListe.add(satir);
            bolunmus.add(geciciListe);
            satir = reader.readLine();
        }

        Tree kelimeAgaci = new Tree();

        for (int i = 0; i <48; i++) {                           // DOSYAYI SATIR SATIR CÜMLE CÜMLE BÖLEN KISIM.
            String gecici = bolunmus.get(i).toString();
            StringBuilder sb = new StringBuilder(gecici);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length()-1);
            String resultString = sb.toString();
            String[] gecici2 = resultString.split("\\. ");
            List<String> gecici3 = new ArrayList<>();
            for (int j = 0; j < gecici2.length; j++) {
                gecici3.add(j,gecici2[j]);
            }
            bolunmus.set(i,gecici3);
        }
        Scanner s = new Scanner(new File("bilgiler.txt"));

        ArrayList<String> list = new ArrayList<>();

        while (s.hasNext()){                    // TÜM KELİMELERİ LİSTEYE ATAN KISIM.
            list.add(s.next());
        }
        s.close();
        ArrayList<String> bulunanlar = new ArrayList<>();
        for (String value : list) {
            if (!bulunanlar.contains(value)) {
                kelimeAgaci.insertInfo(value, bulunanlar);
                bulunanlar.add(value);
            }
            kelimeAgaci.insertInfo(value, bulunanlar).count++;
        }

        Tree nesneAgaci = new Tree();
        Hashtable<String, MilliPark> milliParkHash = new Hashtable<>();   // HASH TABLE IN OLUŞTURULDUĞU YER.
        MilliPark[] milliparklistesi = new MilliPark[48];

        for (int i = 0; i < 48; i++) { //MİLLİ PARK NESNELERİNİN OLUŞTURULUP GEREKLİ YAPILARA EKLENDİĞİ YER.
            MilliPark milliParkNesnesi = new MilliPark(milliParkAdlari[i], ilAdlari[i], ilanYillari[i], yuzOlcumleri[i] , bolunmus.get(i));
            nesneAgaci.insertMilliPark(milliParkNesnesi);
            milliParkHash.put(milliParkNesnesi.getMilliParkAdi(), milliParkNesnesi);
            milliparklistesi[i] = milliParkNesnesi;
        }

        System.out.println();
        System.out.println("Milli park ağacının preorder dolaşılması");
        System.out.println();
        nesneAgaci.PreOrder(nesneAgaci.getRoot());
        System.out.println("Ağacın maksimum derinliği: " + nesneAgaci.maxDepth(nesneAgaci.getRoot()));
        System.out.println("Ağacın Node sayısı: " + nesneAgaci.countNodes(nesneAgaci.getRoot()));
        System.out.println("Dengeli ağaç olsaydı derinliği: "+ nesneAgaci.balancedMaxDepth(nesneAgaci.getRoot()) );
        Scanner input = new Scanner(in);
        Scanner input2 = new Scanner(in);
        boolean a = true;
        while (a){
            System.out.println("Aramak istediğiniz milli parkın ilk üç harfini listede verilen şekilde giriniz: (Çıkmak için x giriniz!): ");
            String aranan = input.nextLine();
            if(Objects.equals(aranan, "x")){
                a = false;
                System.out.println();
            }
            else{
                System.out.println(nesneAgaci.iteSearch(aranan));
            }
        }
        kelimeAgaci.PreOrder2(kelimeAgaci.getRoot2());
        boolean b = true;
        while (b){
            System.out.println("Tarihini değiştirmek istediğiniz milli parkın ismini listede verilen şekilde giriniz: (Çıkmak için x giriniz!): ");
            String degisenPark = input.nextLine();

            if(Objects.equals(degisenPark,"x")){
                b = false;
            }
            else {
                if (milliParkHash.containsKey(degisenPark)){
                    System.out.println("Yeni tarihi giriniz: ");
                    int yeniTarih = input2.nextInt();
                    milliParkHash.get(degisenPark).setIlanYili(yeniTarih);
                }
                else System.out.println("Yanlış girildi veya bulunamadı!");

            }
        }
        System.out.println();
        System.out.println("HASH TABLE");
        System.out.println();

        for (MilliPark milliPark : milliParkHash.values()) {
            System.out.println(milliPark);
        }

        Heap theHeap = new Heap(milliParkAdlari.length);            // HEAP IN OLUŞTURULDUĞU YER

        System.out.println();
        System.out.println("HEAP YAPISI");
        System.out.println();
        for (int i = 0; i < milliParkAdlari.length; i++) {
            theHeap.ekle(milliparklistesi[i]);
        }

        theHeap.heapYazdir();

        System.out.println();
        System.out.println("EN BÜYÜK 3 MİLLİ PARK");
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(theHeap.sil().getMilliPark());
        }
        SelectionSort selectionSortArr = new SelectionSort(10);
        int[] numbers = {26, 12, 1, 24, 167, 10, 89, 6, 298, 4};
        for (int number : numbers) {
            selectionSortArr.ekle(number);
        }
        selectionSortArr.sortArray();
        selectionSortArr.yazdir();
    }
}