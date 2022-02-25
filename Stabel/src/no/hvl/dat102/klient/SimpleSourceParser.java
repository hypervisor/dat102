package no.hvl.dat102.klient;

import no.hvl.dat102.kjedet.KjedetStabel;

public class SimpleSourceParser implements Parentessjekker {

	@Override
	public boolean erVenstreparentes(char p) {
		return p == '(' || p == '[' || p == '{';
	}

	@Override
	public boolean erHogreparentes(char p) {
		return p == ')' || p == ']' || p == '}';
	}

	@Override
	public boolean erParentes(char p) {
		return erVenstreparentes(p) || erHogreparentes(p);
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		switch (venstre) {
		case '(': return hogre == ')';
		case '[': return hogre == ']';
		case '{': return hogre == '}';
		default: return false;
		}
	}

	@Override
	public boolean erBalansert(String s) {
		KjedetStabel<Character> parantesStabel = new KjedetStabel<Character>();
		for (char c : s.toCharArray()) {
			if (erVenstreparentes(c)) {
				parantesStabel.push(c);
			} else if (erHogreparentes(c)) {
				if (!erPar(parantesStabel.pop(), c))
					return false;
			}
		}
		
		return true;
	}

}
