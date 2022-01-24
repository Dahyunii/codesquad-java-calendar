package dahyun.calendar;

import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) {
		Calendar cal = new Calendar();
		Scanner sc = new Scanner(System.in);

		int year = 1970;
		int month = 1;

		while (true) {
			System.out.println("년도를 입력하세요. (exit: 0)");
			System.out.println("YEAR> ");
			year = sc.nextInt();
			if (year == 0) {
				break;
			}

			System.out.println("달을 입력하세요.");
			System.out.println("MONTH> ");
			month = sc.nextInt();
			if (month < 1 || month > 12) {
				System.out.println("1월부터 12까지 입력이 가능합니다.");
				System.out.println();
				continue;
			}

			cal.printCalendar(year, month);
		}
		System.out.println("캘린더 입력을 종료합니다.");
		sc.close();
	}

}
