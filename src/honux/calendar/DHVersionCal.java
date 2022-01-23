package honux.calendar;

import java.util.Scanner;

public class DHVersionCal {
	private int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void madeByDahyunMaxCalendar() {
		// (다현)숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		System.out.println("달을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) {
			System.out.println(month + "월은 " + "31일까지 있습니다.");
		} else if (month == 2) {
			System.out.println(month + "월은 " + "28일까지 있습니다.");
		} else {
			System.out.println(month + "월은 " + "30일까지 있습니다.");
		}
		sc.close();
	}

	
	
	public static void main(String[] args) {
		DHVersionCal dhv = new DHVersionCal();
		Scanner sc = new Scanner(System.in);

		int month = 0;

		while (true) {
			System.out.println("월을 입력하세요.");
			month = sc.nextInt();
			if (month == 0) {
				break;
			} else if (month < 0 || month > 12) {
				System.out.println("1월부터 12월까지만 입력이 가능합니다.");
				continue;
			}
			System.out.printf("%d월은 %d일까지 있습니다. \n", month, dhv.getMaxDaysOfMonth(month));
		}
		System.out.println("입력을 종료합니다.");
		sc.close();
	}

}
