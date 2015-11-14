/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenasiel.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gebruiker
 */
public abstract class Dier implements Serializable {

    private static final long serialVersionUID = 1L;
    protected  int chipregistratienummer;
    protected String naam;
    protected Date geboortedatum;
    protected String geboorteplaats;
    private Geslacht geslacht;
    private Koppel ouders;

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

    public Dier(int nummer,String naam, Date geboortedatum, String geboorteplaats, Geslacht geslacht, Koppel ouders) {
        this.chipregistratienummer = nummer;
        this.naam = naam;
        this.geboortedatum = geboortedatum;
        this.geboorteplaats = geboorteplaats;
        this.geslacht = geslacht;
        this.ouders = ouders;
    }

    public int afmetingStamboom() {
        int afmeting = 1;
        if (this.ouders != null) {
            afmeting += this.ouders.getOuder1().afmetingStamboom();
            if (this.ouders.getOuder2() != null) {
                afmeting += this.ouders.getOuder2().afmetingStamboom();
            }
        }
        return afmeting;
    }

    void voegStamboomToe(ArrayList<DierMetGeneratie> lijst, int g) {
        lijst.add(new DierMetGeneratie(this.naam, g));

        if (this.ouders != null) {
            g++;
            this.ouders.getOuder1().voegStamboomToe(lijst, g);
            if (this.ouders.getOuder2() != null) {
                this.ouders.getOuder2().voegStamboomToe(lijst, g);
            }
        }
    }

    public String stamboomAlsString() {
        StringBuilder builder = new StringBuilder();
        ArrayList<DierMetGeneratie> stamboom = new ArrayList();

        voegStamboomToe(stamboom, 0);

        for (DierMetGeneratie dier : stamboom) {

            builder.append(this.spaties(2 * (dier.getGeneratie())));
            builder.append(dier.getDiergegevens()).append(System.getProperty("line.separator"));
        }

        return builder.toString();
    }

    static final String SPATIES = "                                                                  ";

    static String spaties(int nr) {
        if (nr > SPATIES.length()) {
            return SPATIES;
        }
        return SPATIES.substring(0, nr);
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
