/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenAsiel.dao;

import java.util.ArrayList;
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

    public String AddDier(Dier dier) {

        dieren.add(dier);
        return dier.toString();

    }

    public String AddKoppel(Dier ouder1, Dier ouder2) {

        if (ouder1.getClass() == ouder2.getClass()) {
            Koppel koppel = new Koppel(ouder1, ouder2);
            koppels.add(koppel);
            return koppel.toString();
        } else {
            return "Een kat kan geen koppel worden met een hond en vice versa";
        }

    }

    public void AddKind(Dier kind, Koppel koppel) {
        koppel.getKinderen().add(kind);
    }

}
