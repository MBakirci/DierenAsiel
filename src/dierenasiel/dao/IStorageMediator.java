/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenasiel.dao;

/**
 *
 * @author Gebruiker
 */
public interface IStorageMediator {

    Administratie load() throws IStorageException;

    void bewaar(Administratie administratie) throws IStorageException;
}
