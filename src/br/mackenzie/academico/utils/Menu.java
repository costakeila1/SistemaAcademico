//[315.31.89-1] Keila Lopes Costa 
package br.mackenzie.academico.utils;

import java.io.*;

public class Menu {

    public void mostraMenu(String[] menu) {
        for (String menu1 : menu) {
            System.out.println(menu1);
        }
    }

    public String readInput(String directions) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(directions);
        try {
            return br.readLine();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return null;
    }
}
