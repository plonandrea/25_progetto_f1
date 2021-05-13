/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._progetto_f1;

import eccezioni.*;

/**
 *
 * @author plona
 */
public class Campionato 
{
    private Pilota[] piloti;
    private static final int NUM_MAX_PILOTI=20;
    public int nPilotiPresenti=0;

    public Campionato() 
    {   
        piloti=new Pilota[NUM_MAX_PILOTI];
    }
    
    /*public Campionato(Campionato c) 
    {   
        piloti=new Pilota[NUM_MAX_PILOTI];
        for(int i=0;i<NUM_MAX_PILOTI;i++)
            piloti[i]=c.getPilota(getN, cognome);
    }*/
    
    public static int getNumMaxPiloti()
    {
        return NUM_MAX_PILOTI;
    }

    public int getnPilotiPresenti() 
    {
        return nPilotiPresenti;
    }  
    
    public int getNumPiloti()
    {
        int contatore=0;
   
        for(int i=0;i<NUM_MAX_PILOTI;i++)
        {
            if(piloti[i]!=null)
                contatore++;
        }
        return contatore;
    }
    
    
    public int aggiungiPilota(Pilota p)
    {
        try
        {
            piloti[nPilotiPresenti]=new Pilota(p);
            nPilotiPresenti++;
            return 0;                               //0 pilota aggiunto corretamente
        }
        catch(ArrayIndexOutOfBoundsException posizioneNonValida)
        {
            return -1;
        }    
    }
    
    public Pilota getPilota(String nome, String cognome)
    {
        for(int i=0;i<nPilotiPresenti;i++)
        {
           if(piloti[i].getCognome()==cognome && piloti[i].getNome()==nome)
           {
               return piloti[i];
           }
        }
        return null;
    }
    
    public void eliminaPilota(String nome, String cognome)   
    {
        
            for(int i=0;i<nPilotiPresenti;i++)
            {
               if(piloti[i].getCognome()==cognome && piloti[i].getNome()==nome)
               {
                   aggiornaPosizione(i);
               }
            }    
    }
    
    private void aggiornaPosizione(int posizione)
    {
        for(int i=posizione;i<nPilotiPresenti;i++)            
        {
            piloti[i]=piloti[i+1];
        }
        nPilotiPresenti--;    
    }
    
    public String mostraPiloti()
    {
        String s="";
        
        for(int i=0;i<nPilotiPresenti;i++)
        {
            s=s+" "+i+" "+piloti[i].toString()+"\n";
        }
        return s; 
    }
    
    public int aggiungiPunti(String nome,String cognome,int punti)
    {
        for(int i=0;i<nPilotiPresenti;i++)
            {
               if(piloti[i].getCognome()==cognome && piloti[i].getNome()==nome)
               {
                   punti=punti+piloti[i].getPunti();
                   piloti[i].setPunti(punti);
               }
            }
        return 0; 
    }
    
    public Pilota[] elencoPuntiPiloti()
    {
        Pilota[] classifica=new Pilota[getNumPiloti()];
        Pilota pilota;
        
        for(int i=0;i<nPilotiPresenti;i++)
            {
               pilota=piloti[i];
               classifica[i]=pilota;
            }
        
        classifica=Ordinatore.ordinaClassificaPiloti(classifica);
        
        return classifica; 
    }
    
    public Pilota[] visualizzaPilotiScuderiaOrdinati(String scuderia) throws EccezionePosizioneNonValida
    {
        Pilota[] pilotiScuderia=new Pilota[getNumPiloti()];
        Pilota pilota;
        int c=0;
        
        for(int i=0;i<nPilotiPresenti;i++)
            {
               if(piloti[i].getScuderia()==scuderia)
               {
                    pilota=piloti[i];
                    pilotiScuderia[c]=pilota;
                    c++;
               }
            }
        pilotiScuderia=Ordinatore.ordinaScuderia(pilotiScuderia);
        return pilotiScuderia;
        
    }
    
    public int visualizzaPuntiScuderia(String scuderia)
    {
        int puntiScuderia=0;
        for(int i=0;i<nPilotiPresenti;i++)
            {
               if(piloti[i].getScuderia()==scuderia)
               {
                    puntiScuderia=+puntiScuderia+piloti[i].getPunti();
               }
            }
        
        return puntiScuderia;
    }
    
    
    
}
