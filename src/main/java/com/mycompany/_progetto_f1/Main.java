/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._progetto_f1;

import eccezioni.*;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author plona
 */
public class Main 
{
    public static void main(String[] args) 
    {
        String[] vociMenu=new String[10];
        int sceltaUtente=-1;
        Scanner tastiera=new Scanner(System.in);
        Campionato c=new Campionato();
        Pilota pilota;
        int numeroPilota,punti,puntiScuderia;
        String scuderia;
        
        vociMenu[0]="esci:";
        vociMenu[1]="aggiungi pilota:";
        vociMenu[2]="rimuovi pilota:";       
        vociMenu[3]="visualizza pilota:";
        vociMenu[4]="visualizza piloti di una scuderia:";
        vociMenu[5]="aggiungi punti a pilota:";
        vociMenu[6]="visualizza punti scuderia:";
        vociMenu[7]="visualizza classifica piloti:";
        vociMenu[8]="salva dati su file csv";
        vociMenu[9]="salva dati su file binario";
        
        Menu menu=new Menu(vociMenu);
        
        do
        {
            {
                sceltaUtente=menu.sceltaMenu();
                switch(sceltaUtente)
                {
                    case 0:
                    {
                        System.out.println("l'applicazione verra terminata");
                        break;
                    }
                    case 1:
                    { 
                        if(c.getNumPiloti()==c.getNumMaxPiloti())
                        {
                            System.out.println("impossibile aggiunge un pilota, il campionato è pieno");
                            System.out.println("premi un pulsante per continuare");
                            tastiera.nextLine();
                            break;
                        }
                        else
                        {
                            pilota=new Pilota();
                            System.out.println("numero pilota--> ");     //chiedere al prof come fare il controllo
                            pilota.setnPilota(tastiera.nextInt());

                            /*for(int i=0;i<c.getnPilotiPresenti();i++)
                            {
                                if(pilota.getnPilota()==)
                            }*/
                            System.out.println("nome--> ");
                            pilota.setNome(tastiera.nextLine());
                            pilota.setNome(tastiera.nextLine());
                            System.out.println("cognome--> ");
                            pilota.setCognome(tastiera.nextLine());
                            System.out.println("anno di nascita--> ");   
                            pilota.setAnnoDiNascita(tastiera.nextInt());
                            System.out.println("scuderia--> ");
                            pilota.setScuderia(tastiera.nextLine());
                            pilota.setScuderia(tastiera.nextLine());

                            c.aggiungiPilota(pilota);
                            System.out.println("ok inserimento eseguito correttamente");

                            System.out.println("premi un pulsante per continuare");
                            tastiera.nextLine();
                            break;
                        }
                       
                    }
                    case 2:
                    {
                        System.out.println("inserisci il numero del pilota che vuoi eliminare--> ");
                        numeroPilota=tastiera.nextInt();
                        
                        try
                        {
                            c.eliminaPilota(numeroPilota);
                            System.out.println("ok rimozione effettuata correttamente");
                            System.out.println("premi un pulsante per continuare");
                            tastiera.nextLine();
                        }
                        catch(NullPointerException e1)
                        {
                            System.out.println("nessun pilota ha questo numero");
                            System.out.println("premi un pulsante per continuare");
                            tastiera.nextLine();
                        }
                        break;
                        
                    }
                    case 3:
                    {
                        try
                        {
                            System.out.println("numero pilota--> ");     
                            numeroPilota=tastiera.nextInt();
                            
                            pilota=c.getPilota(numeroPilota);
                            System.out.println(pilota.toString());
                            System.out.println("premi un pulsante per continuare");
                            tastiera.nextLine();
                        }
                        catch(NullPointerException e1)
                        {
                            System.out.println("nessun pilota ha questo numero");
                            System.out.println("premi un pulsante per continuare");
                            tastiera.nextLine();
                        }
                       break;
                    }
                    case 4:
                    {
                        
                            System.out.println("di che scuderia vuoi visuallizare i piloti?--> ");     
                            scuderia=tastiera.nextLine();

                            Pilota[] scuderiaOrdinato;
                            scuderiaOrdinato=c.visualizzaPilotiScuderiaOrdinati(scuderia);
                            for(int i=0;i<scuderiaOrdinato.length;i++)
                            {
                                System.out.println(scuderiaOrdinato[i].getCognome()+" "+scuderiaOrdinato[i].getNome());
                            }
                            System.out.println("premi un pulsante per continuare");
                            tastiera.nextLine();
                        
                            break;  
                    }
                    case 5:
                    {
                        
                            System.out.println("numero pilota--> ");     
                            numeroPilota=tastiera.nextInt();
                            System.out.println("punti da aggiungere--> ");     
                            punti=tastiera.nextInt();
                            c.aggiungiPunti(numeroPilota, punti);
                            System.out.println("punti aggiunti correttamente");
                            System.out.println("premi un pulsante per continuare");
                            tastiera.nextLine();
                            break;
    
                    }
                    case 6:
                    {
                        System.out.println("di che scuderia vuoi visuallizare i punti?--> ");     
                        scuderia=tastiera.nextLine();
                        
                        puntiScuderia=c.visualizzaPuntiScuderia(scuderia);
                        System.out.println("punti "+scuderia+": "+puntiScuderia);
                        System.out.println("premi un pulsante per continuare");
                        tastiera.nextLine();
                        
                        
                        break;
                    }
                    case 7:
                    {
                        Pilota[] classifica;
    
                        classifica=c.elencoPuntiPiloti();
                        for(int i=0;i<classifica.length;i++)
                        {
                            System.out.println(classifica[i].getCognome()+" "+classifica[i].getScuderia()+" punti: "+classifica[i].getPunti());
                        }
                        System.out.println("premi un pulsante per continuare");
                            tastiera.nextLine();  
                        break;
                    }          
                }
            }      
            
        }while(sceltaUtente!=0);
        
    }
    
    
}
