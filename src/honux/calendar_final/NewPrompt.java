package honux.calendar_final;

import java.text.ParseException;
import java.util.Scanner;

public class NewPrompt {

	public void printMenu() {
		System.out.println("+--------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말  q. 종료");
		System.out.println("+--------------------+");
	}

	/**
	 * 
	 * @param week 요일
	 * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
	 */
	public int parseDay(String week) {
		switch (week) {
		case "SU" :
			return 0;
		case "MO" :
			return 1;
		case "TU" :
			return 2;
		case "WE" :
			return 3;
		case "TH" :
			return 4;
		case "FR" :
			return 5;
		case "SA" :
			return 6;
		default :
			return 0;
		}
	}
	
	public void runPrompt() throws ParseException {
		/**
		 * 메서드를 새로 생성할 때마다 scanner와 클래스를 불러오는 것은 비효율적이다. 따라서 이미 불러놓은 것이 있다면 참조해서 사용하는 것이
		 * 효율적이다. cmdPrint에서 scanner와 Calendar 클래스를 사용하기 위해서 미리 불러놓은 것을 매개변수로 활용한다.
		 */
		Scanner scanner = new Scanner(System.in);
		NewCalendar Ncal = new NewCalendar();

		printMenu();

		// 강의에서 구현한 switch문(wheil문 빠져나가기 위해 boolean 선언)
		boolean isLoop = true;
		while (isLoop) {
			System.out.println();
			System.out.println("입력(1, 2, 3, h, q)");
			System.out.println(">> ");
			String cmd = scanner.next();
			System.out.println(); // 개행
			
			switch(cmd) {
			case "1" :
				cmdRegister(scanner, Ncal);
				break;
			case "2" :
				cmdSearch(scanner, Ncal);
				break;
			case "3" :
				cmdPrint(scanner, Ncal);
				break;
			case "h" :
				printMenu();
				break;
			case "q" :
				System.out.println("캘린더 입력을 종료합니다.");
				isLoop = false;
				break;
			default :
				System.out.println("다시 입력해 주세요.");
				continue;
			}
			
			// 내가 구현한 switch문(while문 빠져나가기 위해 return 사용)
//			switch(cmd) {
//			case "1" :
//				cmdRegister(scanner, Ncal);
//				continue;
//			case "2" :
//				cmdSearch(scanner, Ncal);
//				continue;
//			case "3" :
//				cmdPrint(scanner, Ncal);
//				continue;
//			case "h" :
//				printMenu();
//				continue;
//			case "q" :
//				System.out.println("캘린더 입력을 종료합니다.");
//				break;
//			default :
//				System.out.println("다시 입력해 주세요.");
//				continue;
//			}
//			return;	// 함수(메소드)를 종료하기 위해서는 return을 입력한다. (반복문 종료는 break)
			
//			if (cmd.equals("1"))
//				cmdRegister(scanner, Ncal);
//			else if (cmd.equals("2"))
//				cmdSearch(scanner, Ncal);
//			else if (cmd.equals("3"))
//				cmdPrint(scanner, Ncal);
//			else if (cmd.equals("h"))
//				printMenu();
//			else if (cmd.equals("q"))
//				break;
		}

//		System.out.println("캘린더 입력을 종료합니다.");
//		scanner.close();
	}

	private void cmdPrint(Scanner sc, NewCalendar Ncal) {

		int month = 1;
		int year = 2022;

		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR> ");
		year = sc.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.print("MONTH> ");
		month = sc.nextInt();
		System.out.println(); // 개행

		// 잘못된 월을 입력했을 때의 안내문
		if (month > 12 || month < 1) {
			System.out.println("1월부터 12월까지만 입력이 가능합니다.");
			System.out.println(); // 개행
			return;
			// loop 안에서만 break와 continue를 사용할 수 있다.
			// 함수(메서드)를 종료하기 위해서는 return을 입력하면 된다.
		}

		Ncal.printCalendar(year, month);

	}

	private void cmdSearch(Scanner sc, NewCalendar Ncal) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해주세요.(ex: yyyy-MM-dd)");
		String date = sc.next();
		String plan = "";
		try {
			plan = Ncal.searchPlan(date);
		} catch (ParseException e) {
			e.printStackTrace();	// 에러 메세지의 발생 근원지를 찾아 단계별로 에러 출력
			System.out.println("일정 검색 중 오류 발생");
		}
		System.out.println(plan);
	}

	private void cmdRegister(Scanner sc, NewCalendar Ncal) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요.(ex: yyyy-MM-dd)");
		String date = sc.next();
		String text = "";
		sc.nextLine();	// ignore one newline
		System.out.println("일정을 입력해 주세요.");
		text = sc.nextLine();
		
		Ncal.registerPlan(date, text);
		
//		System.out.println("일정을 입력해주세요.(단, 문장 끝에 . 입력)");
//		while(true) {
//			String word = sc.next();
//			text += word + " ";
//			if(word.endsWith(".")) {
//				break;
//			}
//		}
//		Ncal.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException {
		// 셀 실행
		NewPrompt np = new NewPrompt();
		np.runPrompt();

	}

}