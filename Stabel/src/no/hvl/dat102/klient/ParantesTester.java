package no.hvl.dat102.klient;

public class ParantesTester {

	public static void main(String[] args) { 
		SimpleSourceParser javaSuger = new SimpleSourceParser();
		if (!javaSuger.erBalansert("{{{[[[]]]}}}(())"))
			System.out.println("Feil kode");
		
		if (javaSuger.erBalansert("{{{[[(]]]}})(())"))
			System.out.println("Feil kode");
		
		if (javaSuger.erBalansert("{({[[(]]]}})(()}"))
			System.out.println("Feil kode");
		
		System.out.println("Ferdig");
	}

}
