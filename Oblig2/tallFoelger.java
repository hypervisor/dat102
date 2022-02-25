
public class tallFoelger {

	public static void main(String[] args) {

		System.out.println(sum(2));

	}

	public static int sum(int a) {

		if (a == 0) {
			return 2;
		}
		if (a == 1) {
			return 5;
		}

		return 5 * sum(a - 1) - 6 * sum(a - 2) + 2;
	}
}
