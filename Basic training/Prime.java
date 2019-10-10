

public class Prime {

	private static int MAX_N = 20000;
	private static boolean[] prime = new boolean[MAX_N + 1];
	
	public static void main(String[] args) {
		
		//初始化
		for (int i = 0; i <= MAX_N; i++)
			prime[i] = true;
		//2 的倍数不是素数
		for (int i = 4; i <= MAX_N; i += 2 ) 
			prime[i] = false;
		
		for (int i = 3; i * i <= MAX_N; i+= 2) {
			if (prime[i])
				for (int j = i * i; j <= MAX_N; j += 2 * i)
					prime[j] = false;
		}
		
		print(prime);
	}
	
	public static void print(boolean[] prime) {
		int cnt = 0;
		for (int i = 1; i <= MAX_N; i++) {
			if (prime[i]) {
				System.out.print(i + " ");
				cnt++;
				if (cnt % 5 == 0)
					System.out.println();
			}
				
			
		}
		
	}
	
}
