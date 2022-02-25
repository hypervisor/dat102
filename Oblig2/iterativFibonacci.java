
public class iterativFibonacci {

	public static void main(String[] args) {
		
		System.out.println(f(9));

	}
	public static int f(int n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        int naaVerdi = 0;
        int forrigeVerdi = 1;
        int forrigeForrigeVerdi = 0;
        for (int i = 2; i <= n; i++) {
            naaVerdi = forrigeForrigeVerdi - forrigeVerdi;
            forrigeForrigeVerdi = forrigeVerdi;
            forrigeVerdi = naaVerdi;
        }

        return Math.abs(naaVerdi);

    }

}
