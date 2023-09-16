import java.util.Random;
import java.util.Scanner;

public class MineSweeper extends Main {
    public static void run() {
        System.out.print("Sutun Sayisini Giriniz :");
        Scanner scanner = new Scanner(System.in);
        int sutunSayisi = scanner.nextInt();
        System.out.print("Satir Sayisini Giriniz :");
        int satirSayisi = scanner.nextInt();
        System.out.print("Mayin Sayisini Giriniz :");
        int mayinSayisi = scanner.nextInt();

        boolean[][] mayinTarlasi= new boolean[satirSayisi][sutunSayisi];
        Random random=new Random();
        for (int i=0;i<mayinSayisi;i++){
            int rowMayin=random.nextInt(satirSayisi);
            int colMayin=random.nextInt(sutunSayisi);
            if (!mayinTarlasi[rowMayin][colMayin]){
                mayinTarlasi[rowMayin][colMayin]=true;
            }else i--;
        }
        char[][] oyunAlani = new char[satirSayisi][sutunSayisi];
        for (int i=0;i<satirSayisi;i++){
            for (int j=0;j<sutunSayisi;j++){
                oyunAlani[i][j]='-';
            }
        }
        boolean oyunDevamEdiyor=true;
        while (oyunDevamEdiyor) {
            for (int i = 0; i < satirSayisi; i++) {
                for (int j = 0; j < sutunSayisi; j++) {
                    System.out.print(oyunAlani[i][j] + " ");
                }
                System.out.println();
            }
            System.out.print("Satir ve Sutun Sayisini Giriniz :");
            int satir = scanner.nextInt();
            int sutun = scanner.nextInt();
            int etrafindakiMayinSayisi = 0;
            if (mayinTarlasi[satir][sutun]) {
                System.out.println("Uzgunum,Mayina Bastiniz..! Oyunu Kaybettiniz...");
                oyunDevamEdiyor = false;
            } else {
                etrafindakiMayinSayisi = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (satir + i >= 0 && satir + i < satirSayisi && sutun + j >= 0 && sutun + j < sutunSayisi) {
                            if (mayinTarlasi[satir + i][sutun + j]) {
                                etrafindakiMayinSayisi++;
                            }
                        }
                    }
                }
            }
            oyunAlani[satir][sutun] = (char) (etrafindakiMayinSayisi + '0');
            int bosKutucukSayisi = 0;
            for (int i = 0; i < satirSayisi; i++) {
                for (int j = 0; j < sutunSayisi; j++) {
                    if (oyunAlani[i][j] == '-') {
                        bosKutucukSayisi++;
                    }
                }
            }
            if (bosKutucukSayisi == mayinSayisi) {
                System.out.println("Tebrikler, oyunu kazandiniz!");
                oyunDevamEdiyor = false;
            }
        }
        scanner.close();
    }





}

