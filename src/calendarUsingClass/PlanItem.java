package calendarUsingClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {	
	public Date planDate;
	public String detail;
	public String peoples = "";
	
	// 날짜를 돌려주는 메소드
	public static Date getDateFromString(String strDate) {
		// string 타입을 Date 타입으로 변환
		Date date = null;	// null 값으로 초기화
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;	// 오류 발생시 date 출력(null값이 return 된다.)
	}
	
	public PlanItem(String date, String detail) {
		this.planDate = getDateFromString(date);
		this.detail = detail;
	}
	
	public Date getDate() {
		return planDate;
	}
	
	public void addPeople(String name) {
		peoples += name + ", ";
	}

	public String saveString() {
		// date 타입을 String 타입으로 변환
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = formatter.format(planDate);
		return sdate + ", " + "\"" + detail + "\"" + "\n";	// "\"" => " 출력
	}
}
