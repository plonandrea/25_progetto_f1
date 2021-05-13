/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._progetto_f1;

/**
 *
 * @author plona
 */
public class Pilota 
{
    private String nome;
    private String cognome;
    private int annoDiNascita;
    private String scuderia;
    private int punti=0;
    

    public Pilota(String nome, String cognome, int annoDiNascita, String scuderia) 
    {
        this.nome=nome;
        this.cognome=cognome;
        this.annoDiNascita=annoDiNascita;
        this.scuderia=scuderia;
    }
    
    public Pilota(Pilota p)
    {
        nome=p.getNome();
        cognome=p.getCognome();
        annoDiNascita=p.getAnnoDiNascita();
        scuderia=p.getScuderia();
        punti=p.getPunti();
    }
    public Pilota()
    {
        nome="";
        cognome="";
        annoDiNascita=0;
        scuderia="";
        punti=0;
    }
    

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome=nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public void setCognome(String cognome) 
    {
        this.cognome=cognome;
    }

    public int getAnnoDiNascita() 
    {
        return annoDiNascita;
    }

    public void setAnnoDiNascita(int annoDiNascita) 
    {
        this.annoDiNascita=annoDiNascita;
    }

    public String getScuderia() 
    {
        return scuderia;
    }

    public void setScuderia(String scuderia) 
    {
        this.scuderia=scuderia;
    }

    public int getPunti() 
    {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public String toString() 
    {
        String s;
        s="nome: "+getNome()+" cognome:" +getCognome()+" anno di nascita: " +getAnnoDiNascita()+ " scuderia: " +getScuderia()+ " punti: "+getPunti();
        return s;
    }
    
    
 
    
}