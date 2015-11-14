/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenasiel.model;

/**
 *
 * @author Gebruiker
 */
public class DierMetGeneratie {
    
     private final String diergegevens;
    private final int generatie;
    
    //***********************constructoren**********************************
    public DierMetGeneratie(String tekst, int generatie) {
        this.diergegevens = tekst;
        this.generatie = generatie;
    }

    DierMetGeneratie(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //**********************methoden****************************************
    public int getGeneratie() {
        return generatie;
    }

    public String getDiergegevens() {
        return diergegevens;
    }
    
}
