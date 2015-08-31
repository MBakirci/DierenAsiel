/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOA;

import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.ConsoleHandler;

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

    public void registrerenDier(String naam, String geboorteplaats, String geslacht) {
        Date date = new Date();
        Dier dier = new Dier(naam, date, geboorteplaats, geslacht);
        dieren.add(dier);
        String dierString = dier.getChipregistratienummer() + " , " + naam + " , " + geboorteplaats + " , " + geslacht;
        System.out.print("Dier geregistreerd als: " + dierString);
    }

    public void registrerenKoppel(Koppel koppel) {

    }

}
