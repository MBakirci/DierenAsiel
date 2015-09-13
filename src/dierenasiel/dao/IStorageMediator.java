/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenasiel.dao;
import dierenAsiel.dao.Administratie;

/**
 *
 * @author Gebruiker
 */
public interface IStorageMediator {

    public Administratie load() throws IStorageException;

    public void bewaar(Administratie administratie) throws IStorageException;
    
}
