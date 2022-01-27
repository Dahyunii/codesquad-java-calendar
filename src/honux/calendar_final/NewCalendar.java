package honux.calendar_final;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class NewCalendar {

	private final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// 일정 등록을 위해 검색기능 필요 > HashMap 클래스 사용
	// HashMap 클래스 이름인 planMap을 초기화해야하는데, 생성자를 호출할 때 초기화를 해주어야 한다.
	private HashMap<Date, String> planMap;

	public NewCalendar() {
		planMap = new HashMap<Date, String>();
	}

	/**
	 * 
	 * @param strDate : ex) "2022-01-27"
	 * @param plan
	 * @throws ParseException
	 */
	// 캘린더에 일정 등록 메소드
	public void registerPlan(String strDate, String plan) throws ParseException {
		// date는 검색이 가능하도록 해야한다. 일정 등록 후 해당 date에 작성한 일정이 뜨도록 해야하기 때문
		// 이 때, hashMap 클래스를 사용한다.
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
//			System.out.println(date);

		// HashMap의 데이터를 저장
		planMap.put(date, plan);
	}

	// 캘린더 일정 검색 메소드
	public String searchPlan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		String plan = planMap.get(date);
		return plan;
	}

	// 윤년 계산
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
		}
	}

	public void printCalendar(int year, int month) {
		System.out.printf("   <<%d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");

		// get weekday automatically(직접 요일을 입력하지 않고, 자동으로 출력)
		int weekday = getWeekday(year, month, 1);

		// print calendar blank space(요일 공백 출력)
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDay = getMaxDaysOfMonth(year, month);

		int count = 7 - weekday;

		int remainder = (count < 7) ? count : 0;
		/**
		 * if(count < 7) { remainder = count; }else { remainder = 0; }
		 */

		// print first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		// print from second line to last line
		for (int i = count + 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == remainder) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();

//			System.out.println(" 1  2  3  4  5  6  7");
//			System.out.println(" 8  9 10 11 12 13 14");
//			System.out.println("15 16 17 18 19 20 21");
//			System.out.println("22 23 24 25 26 27 28");

	}

	private int getWeekday(int year, int month, int day) {
		// 컴퓨터의 캘린더가 1970년을 기준으로 하므로, 1970년 1월 1을 기준으로 요일을 count한다.
		// 1970년 1월 1일 -> 목요일
		int syear = 1970;
		final int STANDARDWEEKDAY = 4; // 1970/Jan/1st = Thursday

		int count = 0; // total days
		// YEAR
		// 1년은 365일이지만, 윤년의 경우 366일을 더해야 한다.
		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365; // count에 + 하기 위해
			count += delta;
		}
//			System.out.println(count);	// test code에서 윤년이 count되는지 확인.

		// MONTH
		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}

		// DAY
		count += day - 1;
		// getWeekday에 int day에 입력하는 숫자만큼 일수를 count한다.
		// ex) 1월 1일 -> 1, 1월 3일 -> 3으로 count.

		// WEEKDAY(요일)
		int weekday = (count + STANDARDWEEKDAY) % 7;
		// day의 숫자 + 1970년 1월 1일은 목요일로 '3'에 해당한다.
		// 두 수를 더한 후 7로 나눈 나머지는 해당 숫자의 요일을 나타낸다.
		return weekday;
	}

	// simple test code here
	public static void main(String[] arg) throws ParseException {
		NewCalendar Ncal = new NewCalendar();
		System.out.println(Ncal.getWeekday(1970, 1, 1));

		Ncal.registerPlan("2022-01-27", "Meeting");
		System.out.println(Ncal.searchPlan("2022-01-27").equals("Meeting"));
	}
}
