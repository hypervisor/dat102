package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[bak - 1];
		liste[bak - 1] = null;
		bak--;
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		liste[0] = null;
		for (int i = 1; i < bak; i++) {
			liste[i - 1] = liste[i];
		}
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		
		return liste[bak - 1];
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
        if(bak == liste.length) {
            utvid();
        }
        
        if(bak == 0) {
            liste[0] = element;
            bak++;
            return;
        }
        
        if(element.compareTo(liste[bak-1]) > 0) {
            liste[bak] = element;
            bak++;
            return;
        }
        
        for (int n = 0; n < bak; n++) {
            if(element.compareTo(liste[n]) < 0)  {
                for(int i = bak; i > n; i--) {
                    liste[i] = liste[i-1];
                }
                liste[n] = element;
                bak++;
                return;
            }
        }
    }

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		int posisjon = finn(element);
		if (posisjon == IKKE_FUNNET)
			return null;
		
		for (int i = posisjon; i < bak - 1; i++) {
			liste[i] = liste[i + 1];
		}
		bak--;
        
        return element;
	}

	private int finn(T el) {
		for (int i = 0; i < bak; ++i) {
			if (liste[i] == el) {
				return i;
			}
		}
		return IKKE_FUNNET;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
