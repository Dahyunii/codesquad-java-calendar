package honux.calendar;

import java.util.Scanner;

public class Calendar {
	private final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
		}
	
	public int getMaxDaysOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		}else {
			return MAX_DAYS[month - 1];
		}
	}
	
	public void printCalendar(int year, int month) { 
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		
		int maxDay = getMaxDaysOfMonth(year, month);
		
		for(int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if(i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
		
	}
	
	public void madeByDahyunMaxCalendar() {
		// (다현)숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		System.out.println("달을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		if(month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 |month == 12) {
			System.out.println(month + "월은 " + "31일까지 있습니다.");
		}else if(month == 2) {
			System.out.println(month + "월은 " + "28일까지 있습니다.");
		}
		else {
			System.out.println(month + "월은 " + "30일까지 있습니다.");
		}
		sc.close();
	}
	


}
