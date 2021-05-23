/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._progetto_f1;

import java.io.Serializable;

/**
 * la classe rappresentea un pilota
 * i suoi attribuiti sono:<br>
 * nome<br>
 * cognome<br>
 * annoDiNascita<br>
 * scuderia<br>
 * punti<br>
 * nPilota<br>
 *
 * @author plona
 */
public class Pilota implements Serializable
{
    private String nome;
    private String cognome;
    private int annoDiNascita;
    private String scuderia;
    private int punti=0;
    private int nPilota;           //numero univoco pilota
    
    /**
     * costruttore della classe pilota
     * @param nome nome del pilota
     * @param cognome cognome del pilota
     * @param annoDiNascita anno di nascita del pilota
     * @param scuderia nome della scuderia del pilota
     * @param nPilota numero univoco che identifica il pilota
     */

    public Pilota(String nome, String cognome, int annoDiNascita, String scuderia,int nPilota) 
    {
        this.nome=nome;
        this.cognome=cognome;
        this.annoDiNascita=annoDiNascita;
        this.scuderia=scuderia;
        this.nPilota=nPilota;
    }
    
    /**
     * costruttore di copia della classe pilota, consente di istanziare un nuovo pilota
     * @param p: pilota da cui verra istanziato il nuovo pilota, il pilota istanzioato sarà una copia del pilota p
     */
    
    public Pilota(Pilota p)
    {
        nome=p.getNome();
        cognome=p.getCognome();
        annoDiNascita=p.getAnnoDiNascita();
        scuderia=p.getScuderia();
        punti=p.getPunti();
        nPilota=p.getnPilota();
    }
    
    /**
     *  costruttore di default della classe piloat.
     * consente di istanziare un nuovo pilota con i seguenti
     * valori di default per gli attributi<br>
     * nome: stringa vuota<br>
     * cognome: stringa vuota<br>
     * annoDiNascita=0<br>
     * scuderia: stringa vuota<br>
     * punti=0<br>
     * nPilota=0
     */
    
    public Pilota()
    {
        nome="";
        cognome="";
        annoDiNascita=0;
        scuderia="";
        punti=0;
        nPilota=0;
    }
    
     /**
     * restituisce il nome
     * @return 
     */
    public String getNome() 
    {
        return nome;
    }

    /**
     * assegna il nome al pilota
     * @param nome nome del pilota
     */
    
    public void setNome(String nome) 
    {
        this.nome=nome;
    }

    /**
     * restituisce il cognome
     * @return 
     */
    
    public String getCognome()
    {
        return cognome;
    }

    /**
     * assegna il cognome al pilota
     * @param cognome cognome del pilota
     */
    
    public void setCognome(String cognome) 
    {
        this.cognome=cognome;
    }

    /**
     * restituisce l'anno di nascita
     * @return 
     */
    
    public int getAnnoDiNascita() 
    {
        return annoDiNascita;
    }

    /**
     * assegna l'anno di nascita al pilota
     * @param annoDiNascita l'anno di nascita del pilota
     */
    
    public void setAnnoDiNascita(int annoDiNascita) 
    {
        this.annoDiNascita=annoDiNascita;
    }

    /**
     * restituisce la scuderia
     * @return 
     */
    
    public String getScuderia() 
    {
        return scuderia;
    }

    /**
     * assegna la scuderia al pilota
     * @param scuderia scuderia del pilota
     */
    
    public void setScuderia(String scuderia) 
    {
        this.scuderia=scuderia;
    }

    /**
     * restituisce i punti
     * @return 
     */
    
    public int getPunti() 
    {
        return punti;
    }

    /**
     * assegna i punti al pilota
     * @param punti punti del pilota
     */
    
    public void setPunti(int punti) 
    {
        this.punti=punti;
    }

    /**
     * restituisce il numero
     * @return 
     */
    
    public int getnPilota() 
    {
        return nPilota;
    }

    /**
     * assegna il numero al pilota
     * @param nPilota numero del pilota
     */
    
    public void setnPilota(int nPilota) 
    {
        this.nPilota=nPilota;
    }
    
    /**
     * crea una stringa che permette di visualizzare le informazione del pilota
     * @return 
     */

    public String toString() 
    {
        String s;
        s="numero: "+getnPilota()+" nome: "+getNome()+" cognome:" +getCognome()+" anno di nascita: " +getAnnoDiNascita()+ " scuderia: " +getScuderia()+ " punti: "+getPunti();
        return s;
    }
    
    
 
    
}
