/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

/**
 *
 * @author STUDENTE
 */
public class EccezionePilotaNonPresente extends Exception
{
    public String toString()
    {
        String s="";
        s+="nessun pilota presente con questo numero";
        return s;
    }
}
