import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class İslemler {

    static Scanner scan = new Scanner(System.in);
    public static Map<Integer, UrunTanımlama> urunListesiMap = new HashMap<Integer, UrunTanımlama>();
    public static int urunId = 1000;

    public static void girisPaneli() {
        System.out.println("====================================\nDEPO YONETIM PANELI\n" +
                "====================================\n"
                + "1- BULUNDURULACAK URUN TANIMLAMA\n" +
                "2- URUN LİSTELE\n" +
                "3- DEPOYA URUN GİRİŞİ\n" +
                "4- URUNU RAFA KOY\n" +
                "5- DEPODAN URUN ÇIKIŞI\n" +
                "6- DEPO SİSTEMİNDEN ÇIKIŞ");

        System.out.println("*******Lutfen seciminizi yapın*******");
        String secim = scan.next().toUpperCase();

        switch (secim) {
            case "1":
                urunTanimlama();
                girisPaneli();
                break;
            case "2":
                urunListele();
                girisPaneli();
                break;
            case "3":
                urunGirisi();
                girisPaneli();
                break;
            case "4":
                urunuRafaKoy();
                girisPaneli();
                break;
            case "5":
                urunCikisi();
                girisPaneli();
                break;
            case "6":
                cıkıs();
                girisPaneli();
                break;
            default:
                System.out.println("Hatalı giris yaptınız");
                girisPaneli();
                break;
        }


    }

    public static void urunTanimlama() {
        System.out.println("urun ismi:");
        scan.nextLine();
        String urunİsmi = scan.nextLine();
        System.out.println("üretici");
        String uretici = scan.nextLine();
        System.out.println("Birim");
        String birim = scan.nextLine();

        int urunMiktar = 0;
        String raf = "-";

        UrunTanımlama urun = new UrunTanımlama(urunİsmi, uretici, birim, urunMiktar, raf);

        urunListesiMap.put(urunId,urun);
        urunId++;




    }


    public static void urunListele(){
        Set<Map.Entry<Integer, UrunTanımlama>> urunEntrySeti= urunListesiMap.entrySet();
        System.out.println("*********URUN LİSTESİ***********");
        System.out.println("id       ismi         ureticisi       birim       miktar         raf" +
                "\n----------------------------------------------------------------------");

        for (Map.Entry<Integer, UrunTanımlama> e : urunEntrySeti) {
            Integer entryKey=e.getKey();
            System.out.printf("%-8d %-12s %-15s %-12s %-12d %-9s\n",entryKey,
            urunListesiMap.get(entryKey).getUrunİsmi(),
            urunListesiMap.get(entryKey).getUretici(),
            urunListesiMap.get(entryKey).getBirim(),
            urunListesiMap.get(entryKey).getMiktar(),
            urunListesiMap.get(entryKey).getRaf());

        }

    }

    public static void urunGirisi(){
        System.out.println("******* Urun giris sayfası*******");
        System.out.println("guncellemek istediginiz urun id si giriniz");
        int arananId=scan.nextInt();
        if (urunListesiMap.keySet().contains(arananId)){
            System.out.println("miktarı giriniz");
            int guncelMıktar=0;
            boolean flag=true;
            do {
                try {
                    if(flag==true){
                        scan.nextLine();
                    }
                    guncelMıktar=scan.nextInt();
                    scan.nextLine();
                    flag=false;
                }catch (Exception e ){
                    System.out.println("Lutfen gecerli miktar giris yapınız");
                }
            }while (flag);

            urunListesiMap.get(arananId).setMiktar(guncelMıktar +urunListesiMap.get(arananId).getMiktar());

            System.out.println("urun mıktarınız guncel hale getırıldı\n" + "guncel mıktar: " + urunListesiMap.get(arananId).getMiktar());
        }else {
            System.out.println("aradıgınız urun yoktur");
            urunGirisi();
        }
    }
    public static void urunuRafaKoy(){
        System.out.println("*******urunu rafa koy sayfası********");
        System.out.println("Rafa yerlestirmek istediginiz  urunun Id giriniz");
        int arananId=scan.nextInt();
        if(urunListesiMap.keySet().contains(arananId)){
            System.out.println("hangi rafa kaldıracagınızı yazınız");
            String guncelraf=scan.next();
            urunListesiMap.get(arananId).setRaf(guncelraf);
        }else {
            System.out.println("Bu urun depoda mevcut degildir");
            urunuRafaKoy();

        }

    }

    public static void urunCikisi(){
        System.out.println("*****urun cıkıs sayfası*****");
        System.out.println("Cıkısını yapmak ıstedıgınız urunun ID sini giriniz");
        int arananId=scan.nextInt();
        if(urunListesiMap.keySet().contains(arananId)){
            System.out.println("miktar giriniz");
            int guncelMiktar=0;
            boolean flag=true;
            do {
                try {
                    if (flag == true) {
                        scan.nextLine();
                    }
                    guncelMiktar = scan.nextInt();
                    scan.nextLine();//dummy
                    flag = false;
                }catch (Exception e){
                    System.out.println("Lutfen gecerli bir tamsayı giriniz");
                }
            }while (flag);

            if(urunListesiMap.get(arananId).getMiktar()-guncelMiktar<0){
                System.out.println("Deponuzda bu miktarda urun yoktur.\n " +
                        "bulunan miktar"+urunListesiMap.get(arananId).getMiktar());
            }else {
                urunListesiMap.get(arananId).setMiktar(urunListesiMap.get(arananId).getMiktar() - guncelMiktar);
                System.out.println("Urun miktarınız guncel hale getirildi\n guncel miktar "
                        + urunListesiMap.get(arananId).getMiktar());
            }
            }else {
                System.out.println("Aradıgınız urun yoktur");
            }
        }

        public static void cıkıs(){
            System.out.println("Depodan cıkıs yaptınız tekrar beklerız");

    }
        }


