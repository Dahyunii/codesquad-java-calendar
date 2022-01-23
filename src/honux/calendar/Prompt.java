package honux.calendar;

import java.util.Scanner;

public class Prompt {

	/**
	 * 
	 * @param week 요일명
	 * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
	 */
	public int parseDay(String week) {
		if (week.equals("SU"))
			return 0;
		else if (week.equals("MO"))
			return 1;
		else if (week.equals("TU"))
			return 2;
		else if (week.equals("WE"))
			return 3;
		else if (week.equals("TH"))
			return 4;
		else if (week.equals("FR"))
			return 5;
		else if (week.equals("SA"))
			return 6;
		else
			return 0; // default
	}

	// 변하지 않는 변수명은 대문자로
	private final static String PROMPT_Y = "YEAR> ";
	private final static String PROMPT_M = "MONTH> ";
	private final static String PROMPT_D = "WEEKDAY> ";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;
		int year = 2022;
		int weekday = 0;

		while (true) {
			System.out.println("년도를 입력하세요. (exit: 0)");
			System.out.print(PROMPT_Y);
			year = scanner.nextInt();
			// 종료를 위한 if문
			if (year == 0) {
				break;
			}

			System.out.println("달을 입력하세요");
			System.out.print(PROMPT_M);
			month = scanner.nextInt();
			// 잘못된 월을 입력했을 때의 안내문
			if (month > 12 || month < 1) {
				System.out.println("1월부터 12월까지만 입력이 가능합니다.");
				System.out.println(); // 개행
				continue;
			}
			
			System.out.println("첫째 날의 요일을 입력하세요.(SU, MO, WE, TH, FR, SA)");
			System.out.print(PROMPT_D);
			String strWeekday = scanner.next(); // SU, MO 등으로 출력받기 때문에 String으로 변수 설정
			weekday = parseDay(strWeekday);
			// weekday를 parsing 해주어야 하는데, 새로운 메소드(parseDay)를 생성하여 구현

			cal.printCalendar(year, month, weekday);
		}
		System.out.println("캘린더 입력을 종료합니다.");
		scanner.close();
	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
