import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
//		int[] arr = {1, -2, 3, 5, -1};
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int ans = Integer.MIN_VALUE;
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > ans)
				ans = sum;
			if (sum < 0)
				sum = 0;
		}
		
		System.out.println(ans);
	}
}
