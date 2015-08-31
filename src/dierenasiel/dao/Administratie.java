/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenAsiel.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gebruiker
 */
public class Administratie {

    private final List<Dier> dieren = new ArrayList<>();
    private final List<Koppel> koppels = new ArrayList<>();

    public List<Dier> getDieren() {
        return dieren;
    }

    public List<Koppel> getKoppels() {
        return koppels;
    }

    public void registrerenDier(String naam, Date geboortedatum, String geboorteplaats, String geslacht) {
        Dier dier = new Dier(naam, geboortedatum, geboorteplaats, geslacht);
        dieren.add(dier);
        System.out.println(dier.toString());
    }

    public void registrerenKoppel(Dier ouder1, Dier ouder2) {
        Koppel koppel = new Koppel(ouder1, ouder2);
        koppels.add(koppel);
        System.out.println(koppel.toString());
    }   


}
