/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenasiel.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gebruiker
 */
@SuppressWarnings("serial")
public class Administratie implements dierenasiel.model.IStorageMediator, Serializable {

    private int nextKoppelNr;
    private int nextDierNr;
    private final List<Dier> dieren;
    private final List<Koppel> koppels;
    private final String filename = "temp.bin";

    public Administratie() {
        dieren = new ArrayList<>();
        koppels = new ArrayList<>();
        nextKoppelNr = 1;
        nextDierNr = 1;        
    }
    
    

    public List<Dier> getDieren() {
        return dieren;
    }

    public List<Koppel> getKoppels() {
        return koppels;
    }

    public String AddDier(Dier dier) {
        dier.chipregistratienummer = nextDierNr;
        nextDierNr++;
        dieren.add(dier);
        return dier.toString();

    }

    public String AddKoppel(Dier ouder1, Dier ouder2) {

        if (ouder1.getClass() == ouder2.getClass()) {
            Koppel koppel = new Koppel(nextKoppelNr,ouder1, ouder2);
            nextKoppelNr++;
            koppels.add(koppel);
            return koppel.toString();
        } else {
            return "Een kat kan geen koppel worden met een hond en vice versa";
        }

    }

    public void AddKind(Dier kind, Koppel koppel) {
        if (koppel.getOuder1().geboortedatum.after(kind.geboortedatum)
                && koppel.getOuder2().geboortedatum.after(kind.geboortedatum)) {
            koppel.getKinderen().add(kind);
        }
    }
    
    @Override
    public Administratie load() {
        FileInputStream fis;
        ObjectInputStream in;
        Administratie administratie = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            administratie = (Administratie) in.readObject();
            in.close();
            return administratie;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void bewaar(Administratie administratie) {
        FileOutputStream fos;
        ObjectOutputStream out;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(administratie);

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
