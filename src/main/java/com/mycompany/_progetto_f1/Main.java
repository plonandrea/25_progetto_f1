/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._progetto_f1;

import eccezioni.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.io.Serializable;
import java.util.InputMismatchException;

/**
 *
 * @author plona
 */
public class Main implements Serializable
{
    public static void main(String[] args) 
    {
        String[] vociMenu=new String[10];
        int sceltaUtente=-1;
        Scanner tastiera=new Scanner(System.in);
        Campionato c=new Campionato();
        Pilota pilota;
        Pilota[] piloti;
        int numeroPilota,punti,puntiScuderia;
        String scuderia;
        String nomeFile="piloti.txt";
        String nomeFileBinario="pilotiBinario.bin";
        
        
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
        
        try 
        {
            FileInputStream f1=new FileInputStream(nomeFileBinario);
            ObjectInputStream reader=new ObjectInputStream(f1);

            try
            {
                c=(Campionato)reader.readObject();
                reader.close();
                System.out.println("\nLettura avvenuta correttamente");
            }
            catch(ClassNotFoundException ex)
            {
                reader.close();
                System.out.println("Errore di lettura");
            }
        }
        catch(IOException ex)
        {
            System.out.println("\nImpossibile accedere al file"); 
        }
        
        
        do
        {
            try
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
                        if(c.getnPilotiPresenti()==c.getNumMaxPiloti())
                        {
                            System.out.println("impossibile aggiungere un pilota, il campionato è pieno");
                            System.out.println("premi un pulsante per continuare");
                            tastiera.nextLine();
                            break;
                        }
                        else
                        {
                            try
                            {
                                pilota=new Pilota();
                                System.out.println("numero pilota--> ");
                                pilota.setnPilota(tastiera.nextInt());


                                numeroPilota=pilota.getnPilota(); 

                                    for(int i=0;i<c.getnPilotiPresenti();i++)
                                    {
                                      Pilota pilotaTest;
                                      pilotaTest=c.getPilotaPosizione(i);

                                        if(pilotaTest.getnPilota()==numeroPilota)
                                        {
                                            throw new EccezionePilotaGiaPresente();
                                        }                                       
                                    }
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
                            catch(InputMismatchException e1)
                            {
                                System.out.println("il valore inserito non è corretto");
                                tastiera.nextLine();
                                
                                break;
                            }
                            catch(EccezionePilotaGiaPresente e2)
                            {
                                System.out.println(e2.toString());
                                break;
                            }         
                        }                      
                    }
                    case 2:
                    {
                                         
                        try
                        {
                            System.out.println("inserisci il numero del pilota che vuoi eliminare--> ");
                            numeroPilota=tastiera.nextInt();      
                            c.eliminaPilota(numeroPilota);
                            System.out.println("ok rimozione effettuata correttamente");
                            break;
                        }
                        catch(InputMismatchException e1)
                        {
                            System.out.println("il valore inserito non è corretto");
                            tastiera.nextLine();
                                
                            break;
                        }  
                        catch(EccezionePilotaNonPresente e2)
                        {
                            System.out.println(e2.toString());
                            tastiera.nextLine();
                                
                            break;
                        }       
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
                            tastiera.nextLine();
                            break;
                        }
                        catch(NullPointerException e1)
                        {
                            System.out.println("Nessun pilota presente con questo numero");
                            tastiera.nextLine();
                            break;
                        }
                        catch(InputMismatchException e1)
                        {
                            System.out.println("il valore inserito non è corretto");
                            tastiera.nextLine();
                                
                            break;
                        } 
                       
                    }
                    case 4:
                    {
                        try
                        {
                            System.out.println("di che scuderia vuoi visualizzare i piloti?--> ");     
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
                        catch(EccezioneScuderiaNonPresente e1)
                        {
                            System.out.println(e1.toString());
                            break;
                        }
                        catch(ArrayIndexOutOfBoundsException e2)
                        {
                            System.out.println("la scuderia inserita non e' presente");
                            break;
                        }
                            
                    }
                    case 5:
                    {
                        try
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
                        catch(InputMismatchException e1)
                        {
                            System.out.println("il valore inserito non è corretto");
                            tastiera.nextLine();      
                            break;
                        } 
                        catch(EccezionePilotaNonPresente e2)
                        {
                            System.out.println(e2.toString());
                            tastiera.nextLine();        
                            break;
                        } 
              
                    }
                    case 6:
                    {
                        try
                        {
                            System.out.println("di che scuderia vuoi visuallizare i punti?--> ");     
                            scuderia=tastiera.nextLine();

                            puntiScuderia=c.visualizzaPuntiScuderia(scuderia);
                            System.out.println("punti "+scuderia+": "+puntiScuderia);
                            System.out.println("premi un pulsante per continuare");
                            tastiera.nextLine();
                            break;
                        }
                        catch(EccezioneScuderiaNonPresente e1)
                        {
                            System.out.println(e1.toString());
                            break;
                        }
                        catch(ArrayIndexOutOfBoundsException e2)
                        {
                            System.out.println("la scuderia inserita non e' presente");
                            break;
                        }
                        
                    }
                    case 7:
                    {
                        try
                        {
                            Pilota[] classifica;

                            classifica=c.elencoPuntiPiloti();
                            for(int i=0;i<classifica.length;i++)
                            {
                                System.out.println(classifica[i].getnPilota()+" "+classifica[i].getCognome()+" "+classifica[i].getScuderia()+" punti: "+classifica[i].getPunti());
                            }
                            System.out.println("premi un pulsante per continuare");
                                tastiera.nextLine();  
                            break;
                        }
                        catch(EccezionePilotiNonPresenti e1)
                        {
                            System.out.println(e1.toString());
                            break;
                        }
                        catch(ArrayIndexOutOfBoundsException e2)
                        {
                            System.out.println("nessun pilota presente");
                            break;
                        }  
                    }   
                    case 8:
                    {
                        try
                        {
                            c.salvaPilota(nomeFile);
                            System.out.println("salvataggio avvenuto correttamente");
                            break;
                        }
                        catch(IOException e1)
                        {
                            System.out.println("impossibile accedere al file, i piloti non sono stati salvati");
                            break;
                        }
                        catch(EccezionePosizioneNonValida | FileException e2)
                        {
                            System.out.println(e2.toString());
                            break;
                        }    
                    }
                    case 9:
                    {
                        try
                        {
                            c.salvaPilotaBinario(nomeFileBinario);
                            System.out.println("salvataggio avvenuto correttamente");
                            break;
                        }
                        catch(IOException e1)
                        {
                            System.out.println("impossibile accedere al file, i piloti non sono stati salvati");
                            break;
                        }
                        catch(FileException e2)
                        {
                            System.out.println(e2.toString());
                            break;
                        }  

                    }
                }
            }   
            catch(InputMismatchException | NumberFormatException e1)
            {
                tastiera.nextLine();
                System.out.println("input non corretto");
            }
            
        }while(sceltaUtente!=0);
        
    }
    
    
}
