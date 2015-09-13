/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenAsiel.dao;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Gebruiker
 */
public class Hond extends Dier implements Serializable{

    public Hond(String naam, Date geboortedatum, String geboorteplaats, Geslacht geslacht) {
        super(naam, geboortedatum, geboorteplaats, geslacht);
    }
    
    @Override
    public String toString(){
        
        return super.toString() + "\nSoort: Hond";
        
    }
    
    
    
}
