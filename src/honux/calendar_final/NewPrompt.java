package honux.calendar_final;

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

		public void runPrompt() {
			/**
			 * 메서드를 새로 생성할 때마다 scanner와 클래스를 불러오는 것은 비효율적이다.
			 * 따라서 이미 불러놓은 것이 있다면 참조해서 사용하는 것이 효율적이다.
			 * cmdPrint에서 scanner와 Calendar 클래스를 사용하기 위해서 미리 불러놓은 것을 매개변수로 활용한다. 
			 */
			Scanner scanner = new Scanner(System.in);
			Calendar cal = new Calendar();
			
			printMenu();
						
			while (true) {
				System.out.println("입력(1, 2, 3, h, q)");
				System.out.println(">> ");
				String cmd = scanner.next();
				System.out.println();	// 개행
				
				if(cmd.equals("1")) cmdRegister();
				else if (cmd.equals("2")) cmdSearch();
				else if (cmd.equals("3")) cmdPrint(scanner, cal);
				else if (cmd.equals("h")) printMenu();
				else if (cmd.equals("q")) break;
			}
		
			System.out.println("캘린더 입력을 종료합니다.");
			scanner.close();
		}

		private void cmdPrint(Scanner sc, Calendar cal) {

			int month = 1;
			int year = 2022;
			
			System.out.println("년도를 입력하세요.");
			System.out.print("YEAR> ");
			year = sc.nextInt();

			System.out.println("달을 입력하세요.");
			System.out.print("MONTH> ");
			month = sc.nextInt();
			System.out.println();	// 개행
			
			// 잘못된 월을 입력했을 때의 안내문
			if (month > 12 || month < 1) {
				System.out.println("1월부터 12월까지만 입력이 가능합니다.");
				System.out.println(); // 개행
				return;
				// loop 안에서만 break와 continue를 사용할 수 있다.
				// 함수(메서드)를 종료하기 위해서는 return을 입력하면 된다.
			}
			
			cal.printCalendar(year, month);
			
		}

		private void cmdSearch() {
			// TODO Auto-generated method stub
			
		}

		private void cmdRegister() {
			// TODO Auto-generated method stub
			
		}

		public static void main(String[] args) {
			// 셀 실행
			NewPrompt np = new NewPrompt();
			np.runPrompt();

		}

	}