package honux.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 0;

		while (true) {
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if (month == 0) {
				break;
			} else if (month > 12 | month < 0) {
				System.out.println("1월부터 12월까지만 입력이 가능합니다.");
				continue;
			}
			cal.printCalendar(2022, month);
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
