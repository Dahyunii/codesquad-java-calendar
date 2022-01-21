package honux.calendar;

import java.util.Scanner;

public class DHVersionCal {
	private int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month-1];
	}
	
	public static void main(String[] args) {
		DHVersionCal dhv = new DHVersionCal();
		Scanner sc = new Scanner(System.in);
		
		int month = 0;
		
		while(true) {
			System.out.println("월을 입력하세요.");
			month = sc.nextInt();
			if(month == 0) {
				break;
			}else if(month < 0 || month > 12) {
				System.out.println("1월부터 12월까지만 입력이 가능합니다.");
				continue;
			}
			System.out.printf("%d월은 %d일까지 있습니다. \n", month, dhv.getMaxDaysOfMonth(month));
		}
		System.out.println("입력을 종료합니다.");
		sc.close();
	}

}
