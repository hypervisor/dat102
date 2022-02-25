public class matteProblem1 {

	public static void main(String[] args) {
		
		System.out.println(Sum(100));		
	}
	
	public static int Sum(int n) {
		if (n == 1) {
			return 1;
		}
		else {
			return n + Sum(n - 1);
		}
	}
}
