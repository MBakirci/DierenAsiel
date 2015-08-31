/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenasiel;

import DOA.Administratie;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Gebruiker
 */
public class DierenAsiel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        // TODO code application logic here
        DierenAsiel dierenAsiel = new DierenAsiel();
        Administratie administratie = new Administratie();
        dierenAsiel.Register(administratie);
    }

    public void Register(Administratie administratie) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Typ R in voor Registreren dier of K voor Koppel");

        if (br.readLine().equals("R")) {

            System.out.print("Naam: ");
            String naam = br.readLine();

            System.out.print("Geboorteplaats: ");
            String geboorteplaats = br.readLine();

            System.out.print("Geslacht: ");
            String geslacht = br.readLine();

            administratie.registrerenDier(naam, geboorteplaats, geslacht);
        }
        Register(administratie);
    }

}
