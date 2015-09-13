/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenasiel;

import dierenAsiel.dao.Administratie;
import dierenAsiel.dao.Dier;
import dierenAsiel.dao.Geslacht;
import dierenAsiel.dao.Hond;
import dierenAsiel.dao.Kat;
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

    private Administratie administratie = new Administratie();

    ;

    public static void main(String[] args) throws IOException, ParseException {

        // TODO code application logic here
        DierenAsiel dierenAsiel = new DierenAsiel();

        //Een aantal dieren er in zetten en koppelen.
        //dierenAsiel.SampleDier(); Hoeft niet meer na Serializatie 

        //Actie methode voor Registreren, Koppelen, Koppelgegevens opvragen en Zoeken naar Dieren.
        dierenAsiel.action();

    }

    private void SampleDier() throws ParseException {

        administratie.AddDier(new Hond("Cris", format.parse("30-01-1999"), "Breda", Geslacht.Vrouw));
        administratie.AddDier(new Kat("Lau", format.parse("26-02-2000"), "Breda", Geslacht.Vrouw));
        administratie.AddDier(new Hond("Miauw", format.parse("31-03-2001"), "Breda", Geslacht.Man));
        administratie.AddDier(new Kat("WAF", format.parse("03-04-2002"), "Breda", Geslacht.Man));

        Dier DierlijkOuder1 = administratie.getDieren().get(0);
        Dier DierlijkOuder2 = administratie.getDieren().get(1);
        Dier DierlijkOuder3 = administratie.getDieren().get(2);
        Dier DierlijkOuder4 = administratie.getDieren().get(3);

        administratie.AddKoppel(DierlijkOuder1, DierlijkOuder3);
        administratie.AddKoppel(DierlijkOuder2, DierlijkOuder4);

    }

    public void action() throws IOException, ParseException {
        System.out.println("\nTyp R in voor Registreren, K voor Koppellen van paren, C voor kinderen toevoegen, G voor koppelgegevens, Z voor zoeken\n"
                + "B voor Opslaan en L voor Laden ");
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

        } else if(input.equalsIgnoreCase("B")){
            
            Bewaar();
            
        } else if(input.equalsIgnoreCase("L")){
            
            Load();
            
        }
        action();
    }

    private void Register() throws IOException, ParseException {

        System.out.print("Naam: ");
        String naam = br.readLine();

        System.out.print("Geboortedatum: ");
        String geboortedatum = br.readLine();
        Date date = format.parse(geboortedatum);

        System.out.print("Geboorteplaats: ");
        String geboorteplaats = br.readLine();

        System.out.print("Geslacht: ");
        String geslacht = br.readLine();
        Geslacht geslacht1 = Geslacht.valueOf(geslacht);

        System.out.print("Soort: ");
        String soort = br.readLine();

        if (soort.equalsIgnoreCase("Hond")) {
            System.out.println(administratie.AddDier(new Hond(naam, date, geboorteplaats, geslacht1)));
        } else {
            System.out.println(administratie.AddDier(new Kat(naam, date, geboorteplaats, geslacht1)));
        }

    }

    private void Koppel() throws IOException {

        DierGegevens();

        System.out.println("typ chipnummer in Ouder1: ");
        String ouder1 = br.readLine();
        Dier DierlijkOuder1 = administratie.getDieren().get(Integer.parseInt(ouder1) - 1);

        System.out.println("typ chipnummer in Ouder2: ");
        String ouder2 = br.readLine();
        Dier DierlijkOuder2 = administratie.getDieren().get(Integer.parseInt(ouder2) - 1);

        administratie.AddKoppel(DierlijkOuder1, DierlijkOuder2);

    }

    private void KoppelKind() throws IOException {

        KoppelGegevens();

        System.out.println("typ Koppelnummer in: ");
        String ouders = br.readLine();
        Koppel koppel = administratie.getKoppels().get(Integer.parseInt(ouders )- 1);

        DierGegevens();
        
        System.out.println("typ chipnummer in kind: ");
        String ouder1 = br.readLine();
        Dier kind = administratie.getDieren().get(Integer.parseInt(ouder1) - 1);
        
        administratie.AddKind(kind, koppel);

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
    
    private void Bewaar(){
        
        administratie.bewaar(administratie);
        System.out.println("Opgeslagen");
        
    }

    private void Load() {
        
        administratie = administratie.load();
        
    }

}
