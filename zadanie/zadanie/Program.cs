using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace zadanie
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("wpisz pierwszą liczbę: ");
            int n = Int32.Parse(Console.ReadLine());
            Console.Write("wpisz drugą liczbę: ");
            int m = Int32.Parse(Console.ReadLine());
            bool a = false;


            //zad 1
            if (((n >= 13) && (n <= 19) && (m < 13) | (m > 19)) || ((m >= 13) && (m <= 19) && (n < 13) | (n > 19)))

            {
                Console.WriteLine(a = true);
            }
            else
            {
                Console.WriteLine(a);
            }
            //zad 2
            Console.Write("wpisz trzecią liczbę: ");
            int b = Int32.Parse(Console.ReadLine());
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
            Console.WriteLine("Wynik wynosi:{0}", wynik);
            Console.WriteLine();
            //zad 3
            int[] tab = new int[5];
            for (int i = 0; i < tab.Length; i++)
            {
                Console.WriteLine("Podaj wartość {0} indeksu tablicy", i + 1);
                tab[i] = Convert.ToInt32(Console.ReadLine());
            }
            for (int i = 0; i < tab.Length; i++)
            {
                Console.WriteLine(" wartość {0} indeksu tablicy wynosi: {1}", i+1,tab[i]);
            }
            a = false;
            for (int i = 0; i < tab.Length; i++)
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
            Console.WriteLine(a);

                Console.ReadKey();
        }
    }
}
