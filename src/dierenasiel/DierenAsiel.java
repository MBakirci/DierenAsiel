/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenasiel;

import dierenAsiel.dao.Administratie;
import dierenAsiel.dao.Dier;
import dierenAsiel.dao.Koppel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Gebruiker
 */
public class DierenAsiel {

    /**
     * @param args the command line arguments
     */
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final Scanner scanner = new Scanner(System.in);
    private final DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.GERMAN);

    public static void main(String[] args) throws IOException, ParseException {

        // TODO code application logic here
        DierenAsiel dierenAsiel = new DierenAsiel();
        Administratie administratie = new Administratie();

        //Een aantal dieren er in zetten en koppelen.
        dierenAsiel.SampleDier(administratie);

        //Actie methode voor Registreren, Koppelen, Koppelgegevens opvragen en Zoeken naar Dieren.
        dierenAsiel.action(administratie);
    }

    private void SampleDier(Administratie administratie) throws ParseException {

        administratie.registrerenDier("Cris", format.parse("30-01-1999"), "Breda", "V");
        administratie.registrerenDier("Lau", format.parse("26-02-2000"), "Breda", "V");
        administratie.registrerenDier("Miauw", format.parse("31-03-2001"), "Breda", "M");
        administratie.registrerenDier("WAF", format.parse("03-04-2002"), "Breda", "M");

        Dier DierlijkOuder1 = administratie.getDieren().get(0);
        Dier DierlijkOuder2 = administratie.getDieren().get(2);
        Dier DierlijkOuder3 = administratie.getDieren().get(1);
        Dier DierlijkOuder4 = administratie.getDieren().get(3);

        administratie.registrerenKoppel(DierlijkOuder1, DierlijkOuder2);
        administratie.registrerenKoppel(DierlijkOuder3, DierlijkOuder4);
    }

    public void action(Administratie administratie) throws IOException, ParseException {

        System.out.println("Typ R in voor Registreren, K voor Koppellen, G voor koppelgegevens, Z voor zoeken ");
        String input = scanner.nextLine();

        if (input.equals("R")) {

            Register(administratie);

        } else if (input.equals("K")) {

            Koppel(administratie);

        } else if (input.equals("G")) {

            KoppelGegevens(administratie);

        } else if (input.equals("Z")) {

            Zoek(administratie);

        }
        action(administratie);
    }

    private void Register(Administratie administratie) throws IOException, ParseException {

        System.out.print("Naam: ");
        String naam = br.readLine();

        System.out.print("Geboortedatum: ");
        String geboortedatum = br.readLine();
        Date date = format.parse(geboortedatum);

        System.out.print("Geboorteplaats: ");
        String geboorteplaats = br.readLine();

        System.out.print("Geslacht: ");
        String geslacht = br.readLine();

        administratie.registrerenDier(naam, date, geboorteplaats, geslacht);

    }

    private void Koppel(Administratie administratie) throws IOException {

        for (Dier d : administratie.getDieren()) {

            System.out.println(d.getChipregistratienummer() + ", " + d.getNaam()
                    + ", " + d.getGeboortedatum()
                    + ", " + d.getGeboorteplaats()
                    + ", " + d.getGeslacht());
        }

        System.out.println("typ chipnummer in Ouder1: ");
        String ouder1 = br.readLine();
        Dier DierlijkOuder1 = administratie.getDieren().get(Integer.parseInt(ouder1) - 1);

        System.out.println("typ chipnummer in Ouder2: ");
        String ouder2 = br.readLine();
        Dier DierlijkOuder2 = administratie.getDieren().get(Integer.parseInt(ouder2) - 1);

        administratie.registrerenKoppel(DierlijkOuder1, DierlijkOuder2);

    }

    private void KoppelGegevens(Administratie administratie) {

        for (Koppel k : administratie.getKoppels()) {
            System.out.println("Koppel met nummer: " + k.getKoppelnummer() + " bestaande uit: " + k.toString());
        }

    }

    private void Zoek(Administratie administratie) throws IOException {

        System.out.print("Zoekterm: ");
        String zoekterm = br.readLine();
        boolean success = false;

        for (Dier d : administratie.getDieren()) {

            if (d.getNaam().equalsIgnoreCase(zoekterm)) {
                success = true;
                System.out.println("Zoek opdracht heeft de volgende gevonden: \n" + d.toString());
            }
        }
        if (success == false) {
            System.out.println("Niks gevonden! ");
        }

    }

}
