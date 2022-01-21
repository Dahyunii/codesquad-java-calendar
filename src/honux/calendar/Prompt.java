package honux.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT_Y = "YEAR> ";
	private final static String PROMPT_M = "MONTH> ";
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 0;
		int year = 0;
		
		while (true) {
			System.out.println("년도를 입력하세요.");
			System.out.print(PROMPT_Y);
			year = scanner.nextInt();
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT_M);
			month = scanner.nextInt();
			
			if (year == 0 || month == 0) {
				break;
			} else if (month > 12 | month < 0) {
				System.out.println("1월부터 12월까지만 입력이 가능합니다.");
				continue;
			}
			cal.printCalendar(year, month);
		}

		System.out.println("반복을 종료합니다.");
		scanner.close();
	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
