package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		
		T resultat = foerste.getElement();
		foerste = foerste.getNeste();
		antall--;
		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();
		
		LinearNode<T> node = foerste;
		LinearNode<T> prev = null;
		
		for (; node.getNeste() != null; prev = node, node = node.getNeste());
		
		// node peker n� til siste elementet
		// prev peker n� til elementet f�r siste
		
		if (prev != null)
			prev.setNeste(null);
		
		siste = prev;
		
		antall--;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}
	
	public void leggTil(T element) {
        LinearNode<T> ny = new LinearNode<T>(element);
        
        if (erTom()) {
            foerste = ny;
            siste = ny;
            antall++;
            return;
        }
        
        LinearNode<T> denne = foerste, forrige = foerste;
        if (element.compareTo(denne.getElement()) < 0) {
            ny.setNeste(foerste);
            foerste = ny;
            antall++;
            
            return;
        }
        
        if (element.compareTo(siste.getElement()) > 0) {
            siste.setNeste(ny);
            siste = ny;
            antall++;
            
            return;
        }
        
        while (denne != null && element.compareTo(denne.getElement()) > 0) {
            forrige = denne;
            denne = denne.getNeste();
        }
        
        if (denne != null && forrige != null) {
            forrige.setNeste(ny);
            ny.setNeste(denne);
            antall++;
        }
    }

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // F�rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
