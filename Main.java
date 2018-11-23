package UserStory;


import java.io.*;

public class Main {

    public static void main(String[] args)throws Exception {

        File file = new File("C:\\Users\\Kuba\\Desktop\\Nowydokumenttekstowy2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String[] tab = new String[44];
        String st;
        int i =0;
        while ((st = br.readLine()) != null)
        {
            tab[i]=st;
            i++;
        }

        System.out.println("Pierwsza tablica");
        for(int a = 0;a<=43;a++){
            System.out.println(tab[a]);
        }
        // pierwsza pętla dla rzędów(zmienna b)
        // druga pętla dla kolumn(zmienna a)
        // trzecia pętla (zmienna j)wczytuje 4 pierwsze znaki 4 pierwszych rzędów:
        //
        //1.  _  _  _  _  _  _  _  _  _  -->  " "
        //2. | || || || || || || || || | -->  "|"
        //3. |_||_||_||_||_||_||_||_||_| -->  "|"
        //4.                             -->  " "
        //
        // czwarta tabela (zmienna l) do 4 pierwszych rzędów (pętli powyżej) dopisuje 3 pierwsze znaki
        //
        //1.  _  _  _  _  _  _  _  _  _  -->  " _ "
        //2. | || || || || || || || || | -->  "| |"
        //3. |_||_||_||_||_||_||_||_||_| -->  "|_|"
        //4.                             -->  "   "
        //
        //
        //
        // if jest potzebny ponieważ funkcja charAt inaczej startuje z null'em
        // zmienna "start" służy temu by do tablicy nie dodawało się cały czas to samo
        // poniżej opisałem zmiany w kodzie od poprzedniej wersji:

        // dołożyłem pętlę dla rzędów
        // zmieniłem też pętlę ze zmienną j żeby wziąć pod uwagę rząd spacji rozdielających
        // do tablicy "tab" przy pętli dołożyłem zmienną (b*4) żeby wczytywało odpowiednii wzór cyfry

        int start ;
        String[][] cyfry = new String[11][9];

        for(int b = 0; b <= 10;b++) {
            for (int a = 0; a <= 8; a++) {
                for (int j = 0; j <= 3; j++) {
                    for (int l = 0; l <= 2; l++) {
                        start = a * 3;
                        if ((j == 0) && (l == 0)) {
                            cyfry[b][a] = "" + tab[j +(b*4)].charAt(start + l);
                        } else {
                            cyfry[b][a] += tab[j +(b*4) ].charAt(start + l);
                        }

                    }
                }
            }

        }
        System.out.println("Druga tablica");

        for(int a = 0;a<=10;a++) {
            System.out.println("");
            for(int b = 0;b<=8;b++)

                System.out.print(cyfry[a][b]);

        }

        //porównania, tablicę ustawiłem na tę samą co tablica cyfry
        //dołożyłem równierz spację
        int[][] liczby = new int[11][9];


        String zero = " _ | ||_|   ";
        String jeden = "     |  |   ";
        String dwa = " _  _||_    ";
        String trzy = " _  _| _|   ";
        String cztery = "   |_|  |   ";
        String piec = " _ |_  _|   ";
        String szesc = " _ |_ |_|   ";
        String siedem = " _   |  |   ";
        String osiem = " _ |_||_|   ";
        String dziewiec = " _ |_| _|   ";

        // można potem spróbować z switch case'em
        // używamy funkcji equals po zwykłe porównanie (a==b) nie działa
        // pętle ustawiłem tak żeby nie wyskakiwała poza tablice

        for(int a =0;a<=10;a++) {
            for(int b  = 0;b<=8;b++) {


                if (zero.equals(cyfry[a][b])) {

                    liczby[a][b] = 0;

                } else if (jeden.equals(cyfry[a][b])) {

                    liczby[a][b] = 1;

                } else if (dwa.equals(cyfry[a][b])) {

                    liczby[a][b] = 2;

                } else if (trzy.equals(cyfry[a][b])) {

                    liczby[a][b] = 3;

                } else if (cztery.equals(cyfry[a][b])) {

                    liczby[a][b] = 4;

                } else if (piec.equals(cyfry[a][b])) {

                    liczby[a][b] = 5;

                } else if (szesc.equals(cyfry[a][b])) {

                    liczby[a][b] = 6;

                } else if (siedem.equals(cyfry[a][b])) {

                    liczby[a][b] = 7;

                } else if (osiem.equals(cyfry[a][b])) {

                    liczby[a][b] = 8;

                } else if (dziewiec.equals(cyfry[a][b])) {

                    liczby[a][b] = 9;

                } else {
                    liczby[a][b] = -9;
                }
            }
        }


        System.out.println("\n\n Trzecia tablica");

        for (int a = 0; a <= 10; a++) {
            System.out.println("");
            //checksum
            //if ((liczby[a][8] + (2 * liczby[a][7]) + (3 * liczby[a][6]) + (4 * liczby[a][5]) + (5 * liczby[a][4]) + (6 * liczby[a][3]) + (7 * liczby[a][2]) + (8 * liczby[a][1]) + (9 * liczby[a][0])) % 11 == 0) {
                for (int b = 0; b <= 8; b++) {
                    System.out.print(liczby[a][b]);
                }
            //}
        }
    }


}