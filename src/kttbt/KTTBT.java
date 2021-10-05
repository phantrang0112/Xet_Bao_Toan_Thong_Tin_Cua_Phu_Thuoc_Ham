/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kttbt;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class KTTBT {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);

    public String[][] nhapF(String allTapR[][], int n) {

        //input.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("phụ thuộc hàm thứ" + (i + 1));
            for (int j = 0; j < 2; j++) {
                allTapR[i][j] = input.nextLine();
            }

        }
        return allTapR;
    }

    public boolean XetBaoToanThongTin(String mangXBTTT[][]) {
        boolean check = true;
        for (int i = 1; i < mangXBTTT.length; i++) {
            check = true;
            for (int j = 1; j < mangXBTTT[i].length; j++) {
                if (mangXBTTT[i][j].contains("b")) {
                    check = false;
                }
            }
            if (check == true) {
                return check;
            }

        }
        return check;

    }

    public boolean TongKetTinhBaoToanThongTin(String mangXBTTT[][], String pTH[][], int soTapPhuThuocHam) {
        boolean check = true;
        String bang[][] = XetPhuThuocHam(mangXBTTT, pTH, soTapPhuThuocHam);
        if (XetBaoToanThongTin(bang)) {
            return true;
        } else {
            return false;
        }
    }

    public String[][] DienABVaoBang(String mangXBTTT[][], String q) {
        int tam = 1;
        for (int i = 0; i < mangXBTTT.length; i++) {
            for (int j = 0; j < mangXBTTT[i].length; j++) {

                if (mangXBTTT[i][0].contains(mangXBTTT[0][j])) {
                    if (i != 0 && j != 0) {
                        mangXBTTT[i][j] = "a" + j;
                    }

                } else {
                    if (i != 0 && j != 0) {
                        mangXBTTT[i][j] = "b" + tam;
                        tam++;
                    }
                }

            }
        }
        return mangXBTTT;
    }

    public static String findDuplicate(String mangXBTTT[], int n) {
        StringBuffer aBuffer = new StringBuffer();
        System.out.println("" + mangXBTTT.toString());
//        for (int i = 0; i < n; i++) {
//            System.out.println("*"+a[i]);
//            
//        }
        int tam = 1;
        int tam2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (mangXBTTT[i].equals(mangXBTTT[j])) { // tai vi trong bang bat dau tu 1 nen vi tri phai bang j+1
                    aBuffer.append((j + 1) + "*");
                    tam++;//de xet xem co thuoc tinh nao so sanh hay khong
                    tam2 = i;//luu lai gia tri so sanh
                }
            }
            if (tam > 1) {
                aBuffer.append((tam2 + 1) + "*");
                return aBuffer.toString();
            }
        }
        if (tam > 1) {
            aBuffer.append((tam2 + 1) + "*");
            return aBuffer.toString();
        } else {
            return null;
        }

    }

    public boolean SoSanhHaiBang(String[][] array1, String[][] array2) {
        boolean check = true;
        if (array1 != null && array2 != null) {
            if (array1.length != array2.length) {
                check = false;
            } else {
                for (int i = 0; i < array2.length; i++) {
                    for (int j = 0; j < array2[i].length; j++) {
                        if (array2[i][j].equals(array1[i][j]) == false) {
                            check = false;
                        }
                    }

                }
            }
        } else {
            check = false;
        }
        return check;
    }

    public String[][] XetPhuThuocHam(String mangXBTTT[][], String AllTapR[][], int n) {//n la so tap phu thuoc ham
        String tamString[][] = new String[mangXBTTT.length][];
        int soPT = mangXBTTT.length * mangXBTTT[0].length;
        for (int i = 0; i < mangXBTTT.length; ++i) {
            // allocating space for each row of destination array
            tamString[i] = new String[mangXBTTT[i].length];
            System.arraycopy(mangXBTTT[i], 0, tamString[i], 0, tamString[i].length);
        }

        for (int i = 0; i < n; i++) {
            mangXBTTT = XetTungPhuThuocHam(AllTapR[i], mangXBTTT);
            System.out.println("xet bao toan" + XetBaoToanThongTin(mangXBTTT));
            XuatMang(mangXBTTT, mangXBTTT.length, mangXBTTT[0].length);
            if (XetBaoToanThongTin(mangXBTTT)) {

                return mangXBTTT;
            }

        }
        System.out.println("xet bao toan" + XetBaoToanThongTin(mangXBTTT));

        if (XetBaoToanThongTin(mangXBTTT)) {
            return mangXBTTT;
        } else {
            if (SoSanhHaiBang(mangXBTTT, tamString)) {
                System.out.println(SoSanhHaiBang(mangXBTTT, tamString));
                return mangXBTTT;
            } else {
                mangXBTTT = XetPhuThuocHam(mangXBTTT, AllTapR, n);
            }
        }

        return mangXBTTT;
    }

    public String[][] XetTungPhuThuocHam(String tapR[], String mangXBTTT[][]) {
//        if(b[0].length()>1){
//            String c[] = new String[a.length-1*2];
//        }
        String mangPTCotPTH[] = new String[mangXBTTT.length - 1];
        int tam = 0;
        int tampt = 0;
        for (int i = 0; i < mangXBTTT.length; i++) {
            mangPTCotPTH[tam] = "";
            for (int j = 0; j < mangXBTTT[i].length; j++) {
                if (tapR[0].contains(mangXBTTT[0][j])) {
                    if ((i != 0)) {
                        mangPTCotPTH[tam] += mangXBTTT[i][j];
                        tampt = 1;
                    }

                }
            }
            if (tampt == 1) {
                tam++;
            }

        }
        String chuoi = findDuplicate(mangPTCotPTH, mangXBTTT.length - 1);
        if (chuoi != null) {
            String[] mangStrings = chuoi.split("[*]");
            String viTriDauString[] = new String[2];
            viTriDauString = TimViTriDau(mangXBTTT, mangStrings, tapR);
            String bienB = "";
            for (int i = 0; i < mangXBTTT.length; i++) {
                for (int j = 0; j < mangXBTTT[i].length; j++) {
                    if (tapR[1].contains(mangXBTTT[0][j]) && i != 0) {
                        if (mangXBTTT[i][j].equals(viTriDauString[1])) {
                            mangXBTTT[i][j] = viTriDauString[0];
                        }
                        for (int f = 0; f < mangStrings.length; f++) {
                            int tam2 = Integer.parseInt(mangStrings[f]);
                            if (i == tam2) {
                                mangXBTTT[i][j] = viTriDauString[0];
//                                System.out.println("so doi:" + viTriDauString + mangStrings.length);
                            }
                        }
                    }
                }
            }
        }

        return mangXBTTT;
    }

    public String[] TimViTriDau(String mangXBTTT[][], String mangViTri[], String tapR[]) {
        String tamString = "";
        String tamB = "";
        String mangChuaAB[] = new String[2];
//        System.out.println("jhajks" + a.length);
        for (int i = 0; i < mangXBTTT.length; i++) {
            for (int j = 0; j < mangXBTTT[i].length; j++) {
                if (tapR[1].contains(mangXBTTT[0][j]) && i != 0) {
//                    System.out.println("ksksjlaj" + tamString);
                    int vtdau = Integer.parseInt(mangViTri[mangViTri.length - 1]);
                    tamString = mangXBTTT[vtdau][j];
                    for (int k = 0; k < mangViTri.length; k++) {
                        int tam1 = Integer.parseInt(mangViTri[k]);
                        if (i == tam1) {
                            if (mangXBTTT[i][j].contains("a")) {
                                tamString = mangXBTTT[i][j];
//                                System.out.println("ksj" + tamString);

                            } else {
                                tamB = mangXBTTT[i][j];
                            }
                        }
                    }

                }
            }
        }
//        System.out.println("hja" + tamString + "jg" + tamB);
        mangChuaAB[0] = tamString;
        mangChuaAB[1] = tamB;
        return mangChuaAB;

    }

    public void XuatMang(String mangXBTTT[][], int soCot, int soDong) {//bảng xét bảo toàn thông tin
        for (int i = 0; i < soCot; i++) {
            for (int j = 0; j < soDong; j++) {

                System.out.print(mangXBTTT[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public static int nhap() {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        int n = 0;
        while (!check) {
            System.out.print(" ");
            try {

                n = input.nextInt();
                if (n < 0) {
                    check = false;
                    System.out.println("Vui long nhap so nguyen duong");
                    n = input.nextInt();

                }
                check = true;
            } catch (Exception e) {
                System.out.println("Ban phai nhap so! hay nhap lai...");
                input.nextLine();
            }
        }
        return (n);
    }

    public String[][] taoBangNhapRong(String mangXBTTT[][], String q) {
        for (int i = 0; i < mangXBTTT.length; i++) {
            for (int j = 0; j < mangXBTTT[i].length; j++) {
                if (i == 0 && j != 0) {
                    mangXBTTT[i][j] = Character.toString(q.charAt(j - 1));
                } else if (i == 0 && j == 0) {
                    mangXBTTT[i][j] = " ";
                } else if (j == 0 && i != 0) {
                    System.out.println("nhap R" + i);
                    mangXBTTT[i][j] = input.nextLine();
                } else {
                    mangXBTTT[i][j] = " ";
                }
            }
        }
        return mangXBTTT;
    }

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        KTTBT kttbt = new KTTBT();
        String pTH[][] = new String[100][100];
        System.out.println("Nhap Q:");
        String q = input.nextLine();
        System.out.println("nhap so phu thuoc ham:");
        int soPTH = nhap();
        System.out.println("nhap so tap R:");
        int tapR = nhap();

        pTH = kttbt.nhapF(pTH, soPTH);
        String bangString[][] = new String[tapR + 1][q.length() + 1];
        kttbt.taoBangNhapRong(bangString, q);
        int soPTCuaMoiPTH = 2;
        kttbt.XuatMang(pTH, soPTH, soPTCuaMoiPTH);
//        System.out.println("bang moi tao:");
//        kttbt.XuatMang(bangString, tapR + 1, q.length() + 1);
        System.out.println("bang dien a,b:");
        bangString = kttbt.DienABVaoBang(bangString, q);
        kttbt.XuatMang(bangString, tapR + 1, q.length() + 1);//xuat ra bang vua dien a,b
        //String fruits[] = new String[]{"a", "c"};
        if (kttbt.TongKetTinhBaoToanThongTin(bangString, pTH, soPTH)) {
            System.out.println("Phep ket noi bao toan thong tin");
        } else {
            System.out.println("phep ket noi khong bao toan thong tin");
        }
//        kttbt.XuatMang(kttbt.XetPhuThuocHam(bangString, pTH, n), tapR + 1, q.length() + 1);

    }

}
