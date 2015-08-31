/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenAsiel.dao;

import java.util.Date;

/**
 *
 * @author Gebruiker
 */
public class Dier {

    private static int count = 0;
    private final int chipregistratienummer;
    private String naam;
    private Date geboortedatum;
    private String geboorteplaats;
    private String geslacht;

    public int getChipregistratienummer() {
        return chipregistratienummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getGeboorteplaats() {
        return geboorteplaats;
    }

    public void setGeboorteplaats(String geboorteplaats) {
        this.geboorteplaats = geboorteplaats;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public Dier(String naam, Date geboortedatum, String geboorteplaats, String geslacht) {
        count++;
        chipregistratienummer = count;
        this.naam = naam;
        this.geboortedatum = geboortedatum;
        this.geboorteplaats = geboorteplaats;
        this.geslacht = geslacht;
    }

    @Override
    public String toString() {

        String dierString = "\nDier geregistreerd als: " + "\n"
                + "chipNR: " + chipregistratienummer + "\n"
                + "Naam: " + naam + "\n"
                + "Geboortedatum: " + geboortedatum.toString() + "\n"
                + "Geboorteplaats: " + geboorteplaats + "\n"
                + "Geslacht: " + geslacht;

        return dierString;

    }

}
