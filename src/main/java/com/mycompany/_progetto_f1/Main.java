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
public class Main 
{
    public static void main(String[] args) 
    {
        
        Campionato c=new Campionato();
        
        Pilota p1=new Pilota("charles","leclerc",1998,"ferrari");
        Pilota p2=new Pilota("carlos","sainz",1996,"ferrari");
        Pilota p3=new Pilota("lando","norris",1998,"mclaren");
        Pilota p4=new Pilota("max","verstappen",1996,"red bull");
        Pilota p5=new Pilota("sebastian","vettel",1986,"aston martin");
        Pilota p6=new Pilota("kimi","raikkonen",1984,"alfa romeo");
    
        c.aggiungiPilota(p1);
        c.aggiungiPilota(p2);
        c.aggiungiPilota(p3);
        c.aggiungiPilota(p4);
        c.aggiungiPilota(p5);
        c.aggiungiPilota(p6);
        
        System.out.println(c.mostraPiloti());
        
        c.eliminaPilota("carlos", "sainz");
        c.eliminaPilota("sebastian", "vettel");
        
        System.out.println(c.mostraPiloti());
        
        
        
    }
    
    
}
