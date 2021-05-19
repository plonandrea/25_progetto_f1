/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._progetto_f1;

import eccezioni.*;
import file.TextFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author plona
 */
public class Campionato implements Serializable
{
    private Pilota[] piloti;
    private static final int NUM_MAX_PILOTI=20;
    public int nPilotiPresenti=0;

    public Campionato() 
    {   
        piloti=new Pilota[NUM_MAX_PILOTI];
    }
    
    public Campionato(Campionato c) 
    {   
        piloti=new Pilota[NUM_MAX_PILOTI];
        for(int i=0;i<nPilotiPresenti;i++)
        {
           piloti[i]=c.getPilotaPosizione(i);
        }
    }
    
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
    
    
    public void aggiungiPilota(Pilota p)
    {
            piloti[nPilotiPresenti]=new Pilota(p);
            nPilotiPresenti++;
    }
    
    public Pilota getPilota(int numero)
    {
        for(int i=0;i<nPilotiPresenti;i++)
        {
           if(piloti[i].getnPilota()==numero)
           {
               return piloti[i];
           }
        }
        return null;
    }
    
    public Pilota getPilotaPosizione(int posizione)
    {
        return piloti[posizione];
    }
    
    
    public void eliminaPilota(int numeroPilota) throws EccezionePilotaNonPresente   
    {
        
            for(int i=0;i<nPilotiPresenti;i++)
            {
               if(piloti[i].getnPilota()==numeroPilota)
               {
                   aggiornaPosizione(i);
               }
               else
                   throw new EccezionePilotaNonPresente();
                      
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
    
    public int aggiungiPunti(int numero,int punti) throws EccezionePilotaNonPresente
    {
        for(int i=0;i<nPilotiPresenti;i++)
            {
               if(piloti[i].getnPilota()==numero)
               {
                   punti=punti+piloti[i].getPunti();
                   piloti[i].setPunti(punti);                
               }
               else if(i==nPilotiPresenti-1)
               {
                   
                   throw new EccezionePilotaNonPresente();
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
    
    public Pilota[] visualizzaPilotiScuderiaOrdinati(String scuderia) throws EccezioneScuderiaNonPresente, ArrayIndexOutOfBoundsException
    {
        Pilota[] pilotiScuderia=new Pilota[getNumPiloti()];
        Pilota pilota;
        int c=0;
        
        for(int i=0;i<nPilotiPresenti;i++)
            {
               if(piloti[i].getScuderia().compareToIgnoreCase(scuderia)==0)
               {
                    pilota=piloti[i];
                    pilotiScuderia[c]=pilota;
                    c++;
               }
            }
        pilotiScuderia=Ordinatore.ordinaScuderia(pilotiScuderia);
        if(pilotiScuderia[0]==null)
            throw new EccezioneScuderiaNonPresente();
        else
            return pilotiScuderia;
        
    }
    
    public int visualizzaPuntiScuderia(String scuderia) throws EccezioneScuderiaNonPresente
    {
        int puntiScuderia=0;
        for(int i=0;i<nPilotiPresenti;i++)
            {
               if(piloti[i].getScuderia().compareToIgnoreCase(scuderia)==0)
               {
                    puntiScuderia=+puntiScuderia+piloti[i].getPunti();
               }
               else if(i==nPilotiPresenti-1 && puntiScuderia==0)
                     throw new EccezioneScuderiaNonPresente();
            }
        return puntiScuderia;
    }
    
    public void salvaPilota(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileException
    {
        TextFile f1=new TextFile(nomeFile,'W');
        Pilota pilota;
        for(int i=0;i<nPilotiPresenti;i++)
            {
               pilota=getPilotaPosizione(i);
                if(pilota!=null)
                {
                    f1.toFile(i+";"+pilota.getnPilota()+";"+pilota.getNome()+";"+pilota.getCognome()+";"+pilota.getAnnoDiNascita()+";"+pilota.getScuderia()+";"+pilota.getPunti()+";");
                }
            }
        f1.close(); 
    }
    
    public void salvaPilotaBinario(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
    
    
}
