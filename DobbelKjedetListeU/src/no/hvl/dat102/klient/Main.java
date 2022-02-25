package no.hvl.dat102.klient;
 
import no.hvl.dat102.adt.DobbelKjedetOrdnetListeADT;
import no.hvl.dat102.kjedet.DobbelKjedetOrdnetListe;
 
public class Main {
 
    public static void main(String[] args) {
 
        DobbelKjedetOrdnetListeADT<Integer> liste = new DobbelKjedetOrdnetListe<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
 
        liste.leggTil(-3);
        liste.leggTil(1);
        liste.leggTil(0);
        liste.leggTil(19);
        liste.leggTil(28);
        liste.leggTil(8);
        liste.leggTil(1);
        liste.leggTil(-17);
 
        System.out.println(liste.fins(19));
        System.out.println(liste.fins(7));
 
        System.out.println();
 
        liste.visListe();
 
    }
 
}