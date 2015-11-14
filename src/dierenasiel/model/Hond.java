/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenasiel.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Gebruiker
 */
public class Hond extends Dier implements Serializable{
    private static final long serialVersionUID = 1L;

    public Hond(int nummer,String naam, Date geboortedatum, String geboorteplaats, Geslacht geslacht, Koppel ouders) {
        super(nummer,naam, geboortedatum, geboorteplaats, geslacht, ouders);
    }
    
    @Override
    public String toString(){
        
        return super.toString() + "\nSoort: Hond";
        
    }
    
    
    
}
