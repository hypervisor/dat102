package no.hvl.dat102.klient;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParantesTest {

	@Test
	public boolean test1() {
		SimpleSourceParser javaSuger = new SimpleSourceParser();
		return javaSuger.erBalansert("{{{[[[]]]}}}(())");
	}
	
	@Test
	public boolean test2() {
		SimpleSourceParser javaSuger = new SimpleSourceParser();
		return javaSuger.erBalansert("{{{[[(]]]}})(())");
	}
}
