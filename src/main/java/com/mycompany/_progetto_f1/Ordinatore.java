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
public class Ordinatore 
{
    
    
    
    /*public static void scambia(Libro v[],int posizione1, int posizione2)
    {
        Libro c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    
    public static Libro[] selectionSortLibriPrezzoCrescente(Libro[] a)
    {
        Libro[] ordinato=new Libro[a.length];
        
        
        
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];
        
        
        for (int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].Prezzo()<ordinato[i].Prezzo())
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }*/
    
    public static void scambia(Pilota v[], int posizione1, int posizione2)
    {
        Pilota pilota;
        pilota=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=pilota;
    }
    
    
    /*//ordina un array di interi
    public static int[] selectionSortCrescente(int[] a)
    {
        int[] ordinato=new int[a.length];
        
        
        //creo un vettore di copia che sarà il vettore restituito
        for (int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j]<ordinato[i])
                    scambia(ordinato,i,j);
            }
        }  
        return ordinato;     
    }*/
    
    //ordina un array di interi
    public static Pilota[] ordinaClassificaPiloti(Pilota[] a)
    {
        Pilota[] ordinato=new Pilota[a.length];
        
        for (int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].getPunti()>ordinato[i].getPunti())
                    scambia(ordinato,i,j);
            }
        }  
        return ordinato;     
    }
    
    public static Pilota[] ordinaScuderia(Pilota[] a) throws NullPointerException, EccezionePosizioneNonValida
    {
        int c=0;
        for (int i=0;i<a.length;i++)
        {
            if(a[i]!=null)
                c++;        
        }
        
        Pilota[] ordinato=new Pilota[c];
        
        for (int i=0;i<ordinato.length;i++)
                ordinato[i]=a[i];
        
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].getCognome().compareToIgnoreCase(ordinato[i].getCognome())<0 || (ordinato[j].getCognome().compareToIgnoreCase(ordinato[i].getCognome())==0 && ordinato[j].getNome().compareToIgnoreCase(ordinato[i].getNome())<0))
                    scambia(ordinato,i,j);
            }
        }  
        return ordinato;     
    }
    
    
    
    
    public static void scambia(String v[], int posizione1, int posizione2)
    {
        String c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    /*
    //ordina un array di stringhe
    public static String[] selectionSortCrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        
        //creo un vettore di copia che sarà il vettore restituito
        for (int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])<0)
                    scambia(ordinato,i,j);
            }
        }  
        return ordinato;     
    }*/
    
   /* public static String[] selectionSortCrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        
        
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];
        
        
        for (int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])<0)
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }*/
    
    /*//ordina un array di libri in ordine alfabetico
    public static Libro[] selectionSortAlfabeticoAutoreTitolo(Libro[] a)
    {
        Libro[] ordinato=new Libro[a.length];
        
        
        
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];
        
        
        for (int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].getAutore().compareToIgnoreCase(ordinato[i].getAutore())<0 || ( ordinato[j].getAutore().compareToIgnoreCase(ordinato[i].getAutore())==0 && ordinato[j].getTitolo().compareToIgnoreCase(ordinato[i].getTitolo())<0))
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }*/
    
    
    
}
    
    
    
    
    

