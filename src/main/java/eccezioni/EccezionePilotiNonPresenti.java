/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

/**
 *
 * @author plona
 */
public class EccezionePilotiNonPresenti extends Exception
{
    public String toString()
    {
        String s="";
        s+="nessun pilota presente";
        return s;
    }
}
