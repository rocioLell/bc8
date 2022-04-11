package katas.Ecorrea;

import java.io.*;

class CuatroSiete {


    static Object fourSeven(int sum)
    {
        int a = 0, b = 0;
        while (sum > 0)
        {

            if (sum % 7 == 0)
            {
                b++;
                sum -= 7;
            }
            else if (sum % 4 == 0)
            {
                a++;
                sum -= 4;
            }


            else
            {
                a++;
                sum -= 4;
            }
        }

        if (sum < 0)
        {
            System.out.print("-1n");
            return null;
        }

        for (int i = 0; i < a; i++)
            System.out.print("4");

        for (int i = 0; i < b; i++)
            System.out.print("7");

        System.out.println();
        return null;
    }


    public static void main(String args[])
            throws IOException
    {
        fourSeven(15);
    }
}