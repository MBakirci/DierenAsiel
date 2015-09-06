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
public abstract class Dier {

    private static int count = 0;
    protected final int chipregistratienummer;
    protected String naam;
    protected Date geboortedatum;
    protected String geboorteplaats;
    private Geslacht geslacht;

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

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }

    public Dier(String naam, Date geboortedatum, String geboorteplaats, Geslacht geslacht) {
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
