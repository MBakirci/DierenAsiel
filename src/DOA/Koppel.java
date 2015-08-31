/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOA;

import java.util.List;

/**
 *
 * @author Gebruiker
 */
public class Koppel {

    private int koppelnummer;
    private Dier ouder1;
    private Dier ouder2;
    private List<Dier> kinderen;

    public int getKoppelnummer() {
        return koppelnummer;
    }

    public Dier getOuder1() {
        return ouder1;
    }

    public void setOuder1(Dier ouder1) {
        this.ouder1 = ouder1;
    }

    public Dier getOuder2() {
        return ouder2;
    }

    public void setOuder2(Dier ouder2) {
        this.ouder2 = ouder2;
    }

    public List<Dier> getKinderen() {
        return kinderen;
    }

    public Koppel(Dier ouder1, Dier ouder2) {
        this.ouder1 = ouder1;
        this.ouder2 = ouder2;
    }

}
