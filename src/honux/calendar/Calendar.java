package honux.calendar;

import java.util.Scanner;

public class Calendar {
	private final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getmaxDaysOfMonth(int month) {
		return MAX_DAYS[month -1];
	}
	
	public void printSampleCalendar() {
		System.out.println(" 월 화 수 목 금 토");
		System.out.println("--------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		
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
	
	public static void main(String[] args) {

		// (강의)숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		String PROMPT = "cal> ";	// > 뒤 공백 있어야 함
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int month = 0;
		
		while(true) {
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if(month == 0) {
				break;
			}else if(month > 12 | month < 0) {
				System.out.println("1월부터 12월까지만 입력이 가능합니다.");
				continue;
			}
			System.out.printf("%d월은 %d일까지 있습니다. \n", month, cal.getmaxDaysOfMonth(month));
		}
		
		System.out.println("반복을 종료합니다.");
		scanner.close();
		
		
//		System.out.println("반복 횟수를 입력하세요.");
//		int repeat = scanner.nextInt();
//		int month = 0;
//		
//		if(month > 0 | month < 13) {
//			for(int i = 0; i < repeat; i++) {
//				System.out.println("달을 입력하세요.");
//				month = scanner.nextInt();
//				System.out.printf("%d월은 %d일까지 있습니다. \n", month, cal.getmaxDaysOfMonth(month));
//			}
//			System.out.println("반복을 종료합니다.");
//		}else {
//			System.out.println("1월부터 12월까지만 입력이 가능합니다.");
//		}

//		cal.madeByDahyunMaxCalendar();
		// >> public void 로만 작성한 거를 부를 때 사용하는 방법.

//		scanner.close();
		
	}

}
