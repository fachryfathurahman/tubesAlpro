package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        String[][] namaDanPekerjaan = new String[2][4];
        for (int i = 0; i < namaDanPekerjaan[0].length; i++) {
            System.out.println("masukkan pekerjaan");
            namaDanPekerjaan[0][i]=scanner.nextLine();
        }
        for (int i = 0; i < namaDanPekerjaan[0].length; i++) {
            System.out.println("masukkan nama");
            namaDanPekerjaan[1][i]=scanner.nextLine();
        }


        int jumlah = 0;
        int[][] array = {
                {80, 40, 50, 46},
                {40, 8, 90, 25},
                {50, 20, 50, 30},
                {75, 30, 25, 60},
        };
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length; j++) {
//                System.out.println("masukkan harga pekerja "+namaDanPekerjaan[1][i]+" yang bekerja "+namaDanPekerjaan[0][j]);
//                array[i][j]=scanner.nextInt();
//            }
//        }

        System.out.println("sebelum");
        System.out.print("\t|");
        for (int i = 0; i < namaDanPekerjaan[0].length; i++) {
            System.out.print(namaDanPekerjaan[0][i]+"\t");
        }
        System.out.println("\n--------------------");
        for (int i = 0; i < array.length; i++) {
            System.out.print(namaDanPekerjaan[1][i]+"\t|");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n\n");
        //cari nilai terkecil dari tiap baris
        int[] minBaris = new int[array.length];
        for (int i = 0; i < array.length; i++) {

            int tempMin = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] < tempMin || j == 0) {
                    tempMin = array[i][j];
                }

            }
            minBaris[i] = tempMin;
        }

        //mengurangi tiap baris dengan nilai terkecil

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] -= minBaris[i];
            }
        }

        //cari nilai terkecil tiap kolom

        int[] minKolom = new int[array.length];
        for (int i = 0; i < array.length; i++) {

            int tempMin = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] < tempMin || j == 0) {
                    tempMin = array[j][i];
                }

            }
            minKolom[i] = tempMin;
        }

        //mengurangi minKolom setiap kolom

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[j][i] -= minKolom[i];
            }
        }

        //menambah jumlah harga

        for (int data :
                minBaris) {
            jumlah += data;
        }
        for (int data :
                minKolom) {
            jumlah += data;
        }


        //mencari jumlah 0 dalam tiap baris
        int[] tampung0SetiapBaris = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int temp = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == 0) {
                    temp++;
                }
            }
            tampung0SetiapBaris[i] = temp;
        }

        //mencari jumlah 0 dalam tiap kolom

        int[] tampung0SetiapKolom = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int temp = 0;
            for (int j = 0; j < array.length; j++) {

                if (array[j][i] == 0) {
                    temp++;
                }

            }
            tampung0SetiapKolom[i] = temp;
        }

        //menentukan baris terbanyak setiap kolom


        //mencari angka 0 terbanyak baris
        int max = 0;
        for (int i = 0; i < tampung0SetiapBaris.length; i++) {

            if (tampung0SetiapBaris[i] > max) {
                max = tampung0SetiapBaris[i];
            }
        }

        ArrayList<Integer> redBaris = new ArrayList<>();

        for (int i = 0; i < tampung0SetiapBaris.length; i++) {
            if (tampung0SetiapBaris[i] == max) {
                redBaris.add(i);
            }
        }

        //mencari angka 0 terbanyak kolom
        max = 0;
        for (int i = 0; i < tampung0SetiapKolom.length; i++) {
            if (tampung0SetiapKolom[i] > max) {
                max = tampung0SetiapKolom[i];
            }
        }
        ArrayList<Integer> redKolom = new ArrayList<>();

        for (int i = 0; i < tampung0SetiapKolom.length; i++) {
            if (tampung0SetiapKolom[i] == max) {
                redKolom.add(i);
            }
        }
        //mencari nilai terminimum baris yang tidak terkena warna merah

        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if ((!redBaris.contains(i) || !redKolom.contains(j)) && array[i][j] <= min && array[i][j] != 0) {
                    min = array[i][j];
                }

            }
        }

        //mengurangi setiap array yang berwarna kuning
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if ((!redBaris.contains(i) || !redKolom.contains(j)) && array[i][j] <= min && array[i][j] != 0) {
                    array[i][j] -= min;
                }
                if (redBaris.contains(i) && redKolom.contains(j)) {
                    array[i][j] += min;
                }

            }
        }
        jumlah += min;

        System.out.println("sesudah");
        System.out.print("\t|");
        for (int i = 0; i < namaDanPekerjaan[0].length; i++) {
            System.out.print(namaDanPekerjaan[0][i]+"\t");
        }

        System.out.println("\n--------------------");
        for (int i = 0; i < array.length; i++) {
            System.out.print(namaDanPekerjaan[1][i]+"\t|");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("total biaya minimum " + jumlah);


        //optimasi

        ArrayList<Optimasi> hasil = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j != i) {
                    for (int k = 0; k < array.length; k++) {
                        if (k != i && k != j) {
                            for (int l = 0; l < array.length; l++) {
                                if (l != i && l != k && l != j) {
                                    ArrayList<Integer> tes = new ArrayList<>();
                                    tes.add(i);
                                    tes.add(j);
                                    tes.add(k);
                                    tes.add(l);
                                    hasil.add(new Optimasi(tes));
                                }
                            }
                        }
                    }
                }
            }
        }


        for (int i = 0; i <hasil.size() ; i++) {
            int total = 0;
            for (int j = 0; j < hasil.get(i).result.size(); j++) {
                int temp = hasil.get(i).result.get(j);
                total+=array[j][temp];
            }
            hasil.get(i).setTotal(total);
        }

        Optimasi jawaban = hasil.get(0) ;

        for (int i = 0; i < hasil.size(); i++) {
            if (jawaban.total>hasil.get(i).total){
                jawaban=hasil.get(i);
            }
        }

        System.out.println(jawaban.result.toString());

        for (int i = 0; i < namaDanPekerjaan[0].length; i++) {
            System.out.println(namaDanPekerjaan[1][i]+" mengerjakan "+namaDanPekerjaan[0][jawaban.result.get(i)]);
        }

    }
    


}
