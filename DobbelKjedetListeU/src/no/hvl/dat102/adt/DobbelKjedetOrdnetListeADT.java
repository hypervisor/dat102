package no.hvl.dat102.adt;

public interface DobbelKjedetOrdnetListeADT<T> {
	
	

	/**
	 * 
	 * @param el er elementet som skal legges til
	 */
	void leggTil(T el);

	/**
	 * 
	 * @param el er elementet som skal fjernes hvis det fins
	 * @return elementet som skal fjernes ellers returneres null
	 * @exception EmptyCollectionException unntak kastes dersom listen allerede er
	 *                                     tom
	 */
	T fjern(T el);

	/**
	 * 
	 * @return returner true hvis listen er tom ellers false
	 */
	boolean erTom();

	/**
	 * 
	 * @return returnerer antall elementer
	 */
	int antall();
	
	
	boolean fins(T el);
	
	void visListe();

}
