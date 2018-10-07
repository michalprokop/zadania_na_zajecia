import java.util.Scanner;
public class Main{


    public static void main(String[] args) {
        System.out.print("podaj pierwszą liczbe: ");
        int n;
        Scanner pierwszy = new Scanner(System.in);
        n = pierwszy.nextInt();
        System.out.print("podaj drugą liczbe: ");
        int m;
        Scanner drugi = new Scanner(System.in);
        m = drugi.nextInt();
        boolean a = false;
        //zad 1
        if (((n >= 13) && (n <= 19) && (m < 13) | (m > 19)) || ((m >= 13) && (m <= 19) && (n < 13) | (n > 19)))
        {
            System.out.println(a=true);

        }

        else
        {
            System.out.println(a);

        }
    //zad 2
        System.out.print("wpisz trzecią liczbę: ");
        int b;
        Scanner trzeci = new Scanner(System.in);
        b = trzeci.nextInt();
        int wynik;

        if (n == 13)
        {
            wynik = 0;
        }
        else if (m == 13)
        {
            wynik = n;
        }
        else if (b == 13)
        {
            wynik = n + m;
        }
        else
        {
            wynik = n + m + b;
        }
        System.out.println("Wynik wynosi:"+wynik );
        System.out.println();
        //zad 3
        System.out.println("podaj rozmiar tablicy :");
        int j;
        Scanner piaty = new Scanner(System.in);
        j = piaty.nextInt();

        int s=0;

        a = false;

        int tab [] = new int[j];

        for (int i = 0; i < tab.length; i++)
        {
            System.out.println("Podaj wartość indeksu tablicy: " + (++s));
            //tab[i] = Convert.ToInt32(Console.ReadLine());
            int wartosc;
            Scanner czwarty = new Scanner(System.in);
            wartosc = czwarty.nextInt();
            tab[i]=wartosc;
        }

        for (int i = 0; i < tab.length; i++)
        {
            System.out.print(tab[i]+",");
        }

        for (int i = 0; i < tab.length; i++)
        {
            if ((tab[i] == 3)&&(i>=2))
            {
                if (tab[i - 1]==2)
                {
                    if(tab[i-2]==1)
                    {
                        a = true;

                    }
                }

            }
        }
        System.out.println();
        System.out.println(a);


            }


    }


