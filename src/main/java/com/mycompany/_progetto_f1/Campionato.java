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
 * la classe campionato rappresenta un campionato di piloti
 * un campionato è costituto da una array di piloti, ci possono 
 * essere massimo 20 piloti NUM_MAX_PILOTI
 * questa classe consente di svolgere operazioni di ricerca, inserimento, eliminazione
 * dei piloti nel campionato
 * gli attributi sono<br>
 * piloti: array di piloti<br>
 * NUM_MAX_PILOTI: costante che indica il numero massimi di piloti presenti<br>
 * nPilotiPresenti: indica il numero di piloti presenti nell'array
 * @author
 */
public class Campionato implements Serializable
{
    private Pilota[] piloti;
    private static final int NUM_MAX_PILOTI=20;
    public int nPilotiPresenti=0;

    /**
     * costruttore della classe campionato 
     * consenti di istanziare un nuovo campionato
     * costituito da NUM_MAX_PILOTI piloti vuoto
     */
    
    public Campionato() 
    {   
        piloti=new Pilota[NUM_MAX_PILOTI];
    }
    
    /**
     * costruttore di copia
     * consente di istanziare un nuovo campionato
     * copia del campionato passato come parametro
     * @param c il campionato di cui creare la copia
     */
    
    public Campionato(Campionato c) 
    {   
        piloti=new Pilota[NUM_MAX_PILOTI];
        for(int i=0;i<nPilotiPresenti;i++)
        {
           piloti[i]=c.getPilotaPosizione(i);
        }
    }
    
    /**
     * restituisce il numero massimo di piloti presenti
     * @return 
     */
    
    public static int getNumMaxPiloti()
    {
        return NUM_MAX_PILOTI;
    }

    /**
     * restituisce il numero di piloti presenti
     * @return 
     */
    
    public int getnPilotiPresenti() 
    {
        return nPilotiPresenti;
    }  
    
   /* public int getNumPiloti()
    {
        int contatore=0;
   
        for(int i=0;i<NUM_MAX_PILOTI;i++)
        {
            if(piloti[i]!=null)
                contatore++;
        }
        return contatore;
    }*/
    
    /**
     * consente di aggiungere un pilota nel campionato
     * @param p il pilota da inserire nel campionato
     */
    
    public void aggiungiPilota(Pilota p)
    {
            piloti[nPilotiPresenti]=new Pilota(p);
            nPilotiPresenti++;
    }
    
    /**
     * permette di visualizzare un pilota del campionato in base al suo numero
     * @param numero numero del pilota da visualizzare
     * @return 
     */
    
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
    
    /**
     * permette di visualizzare un pilota del campionato in base alla sua posizione
     * @param posizione posizione del pilota da visualizzare
     * @return 
     */
    
    public Pilota getPilotaPosizione(int posizione)
    {
        return piloti[posizione];
    }
    
    /**
     * permetto di eliminare un pilota dal campionato passando il suo numero
     * @param numeroPilota numero del pilota da eliminare
     * @throws EccezionePilotaNonPresente eccezione che si solleva nel caso non ci siano piloti presenti con quel numero
     */
    
    public void eliminaPilota(int numeroPilota) throws EccezionePilotaNonPresente   
    {
        
            for(int i=0;i<nPilotiPresenti;i++)
            {
               if(piloti[i].getnPilota()==numeroPilota)
               {
                   aggiornaPosizione(i);
                   break;
               }
               else if(i==nPilotiPresenti-1)
               {
                   throw new EccezionePilotaNonPresente();
               }
                      
            }    
    }
    
    /**
     * aggiorna la posizione dei piloti dopo l'eliminazione di un pilota
     * @param posizione posizione del pilota eliminato
     */
    
    private void aggiornaPosizione(int posizione)
    {
        for(int i=posizione;i<nPilotiPresenti-1;i++)            
        {
            piloti[i]=piloti[i+1];
        }
        nPilotiPresenti--;    
    }
    
    /**
     * permette di visualizzare tutti i piloti presenti
     * @return 
     */
    
    public String mostraPiloti()
    {
        String s="";
        
        for(int i=0;i<nPilotiPresenti;i++)
        {
            s=s+" "+i+" "+piloti[i].toString()+"\n";
        }
        return s; 
    }
    
    /**
     * permette di aggiungere punti ad un pilota in base al numero
     * @param numero numero del pilota a cui si vuole aggiungere punti
     * @param punti numero di punti che si vogliono aggiungere al pilota
     * @return
     * @throws EccezionePilotaNonPresente eccezione che si solleva nel caso non ci siano piloti presenti con quel numero
     */
    
    public int aggiungiPunti(int numero,int punti) throws EccezionePilotaNonPresente
    {
        for(int i=0;i<nPilotiPresenti;i++)
            {
               if(piloti[i].getnPilota()==numero)
               {
                   punti=punti+piloti[i].getPunti();
                   piloti[i].setPunti(punti);   
                   break; 
               }
               else if(i==nPilotiPresenti-1)
               {
                   
                   throw new EccezionePilotaNonPresente();
               }
                 
               
            }
        return 0; 
    }
    
    /**
     * permette di visualizzare la classifica dei piloti in base ai punti
     * @return 
     */
    
    public Pilota[] elencoPuntiPiloti() throws EccezionePilotiNonPresenti, ArrayIndexOutOfBoundsException
    {
        Pilota[] classifica=new Pilota[getnPilotiPresenti()];
        Pilota pilota;
        
        for(int i=0;i<nPilotiPresenti;i++)
            {
               pilota=piloti[i];
               classifica[i]=pilota;
            }
        
        if(classifica[0]==null)
            throw new EccezionePilotiNonPresenti();
        
        
        classifica=Ordinatore.ordinaClassificaPiloti(classifica);
        
        return classifica; 
    }
    
    /**
     * permette di visualizzare i piloti di una specifica scuderia in ordina alfabetico
     * @param scuderia nome della scuderia di cui si vogliono visualizzare i piloti
     * @return
     * @throws EccezioneScuderiaNonPresente eccezione che si solleva nel caso non ci esista la scuderia passata 
     */
    
    public Pilota[] visualizzaPilotiScuderiaOrdinati(String scuderia) throws EccezioneScuderiaNonPresente//, ArrayIndexOutOfBoundsException
    {
        Pilota[] pilotiScuderia=new Pilota[getnPilotiPresenti()];
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
    
    /**
     * permette di visualizzare i punti di una scuderia sommando i punti dei piloti di quella scuderia
     * @param scuderia nome della scuderia di cui si vogliono visualizzare i punti
     * @return
     * @throws EccezioneScuderiaNonPresente eccezione che si solleva nel caso non ci esista la scuderia passata 
     */
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
    
    /**
     * permette di salvare i dati dei piloti su un file csv
     * @param nomeFile nome del file
     * @throws IOException
     * @throws EccezionePosizioneNonValida
     * @throws FileException 
     */
    
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
    
    /**
     * permette di salvare i dati dei piloti su un file binario
     * @param nomeFile nome del file
     * @throws IOException
     * @throws EccezionePosizioneNonValida
     * @throws FileException 
     */
    
    public void salvaPilotaBinario(String nomeFile) throws IOException, FileException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close(); 
    }
    
    
    
}
