package honux.calendar;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 수를 입력하세요.");
		int num = sc.nextInt();
		int num2 = sc.nextInt();
//		int sum = num + num2;
//		System.out.println("두 수의 합은 " + sum + "입니다.");
//		System.out.printf("두 수의 합은 %d입니다.", num+num2);
		System.out.printf("%d와 %d의 합은 %d입니다.", num, num2, num+num2);
	
		sc.close();
	}

}
