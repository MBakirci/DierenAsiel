/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenasiel;

import dierenasiel.model.Administratie;
import dierenasiel.model.Dier;
import dierenasiel.model.Geslacht;
import dierenasiel.model.Hond;
import dierenasiel.model.Kat;
import dierenasiel.model.Koppel;
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

    private Administratie administratie = new Administratie();

    private String soort = null;

    public static void main(String[] args) throws IOException, ParseException {

        // TODO code application logic here
        DierenAsiel dierenAsiel = new DierenAsiel();

        //Een aantal dieren er in zetten en koppelen.
        //dierenAsiel.SampleDier(); //Hoeft niet meer na Serializatie 
        //Actie methode voor Registreren, Koppelen, Koppelgegevens opvragen en Zoeken naar Dieren.
        dierenAsiel.action();

    }

    private void SampleDier() throws ParseException {

        administratie.AddDier(new Hond(0, "Cris", format.parse("30-01-1999"), "Breda", Geslacht.Vrouw, null));
        administratie.AddDier(new Kat(0, "Lau", format.parse("26-02-2000"), "Breda", Geslacht.Vrouw, null));
        administratie.AddDier(new Hond(0, "Miauw", format.parse("31-03-2001"), "Breda", Geslacht.Man, null));
        administratie.AddDier(new Kat(0, "WAF", format.parse("03-04-2002"), "Breda", Geslacht.Man, null));

        Dier DierlijkOuder1 = administratie.getDieren().get(0);
        Dier DierlijkOuder2 = administratie.getDieren().get(1);
        Dier DierlijkOuder3 = administratie.getDieren().get(2);
        Dier DierlijkOuder4 = administratie.getDieren().get(3);

        administratie.AddKoppel(DierlijkOuder1, DierlijkOuder3);
        administratie.AddKoppel(DierlijkOuder2, DierlijkOuder4);

    }

    public void action() throws IOException, ParseException {
        System.out.println("\nTyp R in voor Registreren, K voor Koppellen van paren, C voor kinderen toevoegen, G voor koppelgegevens, Z voor zoeken\n"
                + "S voor Stamboomgegevens, B voor Opslaan en L voor Laden\nX voor afsluiten");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("R")) {

            Register();

        } else if (input.equalsIgnoreCase("K")) {

            Koppel();

        } else if (input.equalsIgnoreCase("C")) {

            KoppelKind();

        } else if (input.equalsIgnoreCase("G")) {

            KoppelGegevens();

        } else if (input.equalsIgnoreCase("Z")) {

            Zoek();

        } else if (input.equalsIgnoreCase("B")) {

            Bewaar();

        } else if (input.equalsIgnoreCase("L")) {

            Load();

        } else if (input.equalsIgnoreCase("S")) {
            Stamboom();
        } else if (input.equalsIgnoreCase("X")) {
            System.exit(0);
        }
        action();
    }

    private void Register() throws IOException, ParseException {

        System.out.print("Naam: ");
        String naam = br.readLine();
        if(naam.equals("")){
            return;
        }

        System.out.print("Geboortedatum: [enter voor vandaag]");
        String geboortedatum = br.readLine();
        Date date = new Date();
        try {
            date = format.parse(geboortedatum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Geboorteplaats: ");
        String geboorteplaats = br.readLine();

        System.out.print("Geslacht: [Man of Vrouw]");
        String geslacht = br.readLine();
        if (geslacht.equals("")) {
            geslacht = "Man";
        }
        Geslacht geslacht1 = Geslacht.valueOf(geslacht);

        if (soort == null) {
            System.out.print("Soort: [Hond of Kat]");
            soort = br.readLine();
        }

        System.out.print("Ouders:  (0 voor verder gaan zonder ouders)\n");
        KoppelGegevens();
        System.out.println("typ Koppelnummer in: ");
        String ouders = br.readLine();
        if (!ouders.equals("0") && !ouders.equals("")) {
            Koppel k = administratie.getKoppels().get(Integer.parseInt(ouders) - 1);

            if (soort.equalsIgnoreCase("Hond")) {
                System.out.println(administratie.AddDier(new Hond(0, naam, date, geboorteplaats, geslacht1, k)));
            } else {
                System.out.println(administratie.AddDier(new Kat(0, naam, date, geboorteplaats, geslacht1, k)));
            }
        } else {
            if (soort.equalsIgnoreCase("Hond")) {
                System.out.println(administratie.AddDier(new Hond(0, naam, date, geboorteplaats, geslacht1, null)));
            } else {
                System.out.println(administratie.AddDier(new Kat(0, naam, date, geboorteplaats, geslacht1, null)));
            }
        }

        soort = null;

    }

    private void Koppel() throws IOException {

        DierGegevens();

        try {
            System.out.println("typ chipnummer in Ouder1: ");
            String ouder1 = br.readLine();
            Dier DierlijkOuder1 = administratie.getDieren().get(Integer.parseInt(ouder1) - 1);

            System.out.println("typ chipnummer in Ouder2: ");
            String ouder2 = br.readLine();
            Dier DierlijkOuder2 = administratie.getDieren().get(Integer.parseInt(ouder2) - 1);

            administratie.AddKoppel(DierlijkOuder1, DierlijkOuder2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void KoppelKind() throws IOException, ParseException {

        KoppelGegevens();

        System.out.println("typ Koppelnummer in: ");
        String ouders = br.readLine();
        Koppel koppel = administratie.getKoppels().get(Integer.parseInt(ouders) - 1);

        DierGegevens();

        soort = koppel.getClass().getSimpleName();
        System.out.println("typ chipnummer in kind:     (0) voor niew dier ");
        if (!br.readLine().equals("0")) {
            String ouder1 = br.readLine();
            Dier kind = administratie.getDieren().get(Integer.parseInt(ouder1) - 1);

            administratie.AddKind(kind, koppel);
        } else {

            Register();

        }

    }

    private void DierGegevens() {

        for (Dier d : administratie.getDieren()) {

            System.out.println(d.getChipregistratienummer() + ", " + d.getNaam()
                    + ", " + d.getGeboortedatum()
                    + ", " + d.getGeboorteplaats()
                    + ", " + d.getGeslacht()
                    + ", " + d.getClass().getSimpleName());
        }

    }

    private void KoppelGegevens() {

        for (Koppel k : administratie.getKoppels()) {
            System.out.println("Koppel met nummer: " + k.getKoppelnummer() + " bestaande uit: " + k.toString());
        }

    }

    private void Zoek() throws IOException {

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

    private void Bewaar() {

        administratie.bewaar(administratie);
        System.out.println("Opgeslagen");

    }

    private void Load() {

        administratie = administratie.load();

    }

    private void Stamboom() throws IOException {

        DierGegevens();
        System.out.println("Voer dier nummer in:");

        String dier = br.readLine();
        Dier d = administratie.getDieren().get(Integer.parseInt(dier) - 1);
        System.out.println(d.stamboomAlsString());

    }

}
