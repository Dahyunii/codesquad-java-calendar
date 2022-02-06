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
		// string 타입으로 Date 타입의 변수에 넣기 위해
		Date date = null;	// null 값으로 초기화
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;	// 오류 발생시 date(null값이 return 된다.)
	}
	
	public PlanItem(String date, String detail) {
		this.detail = detail;
	}
	
	public Date getDate() {
		return planDate;
	}
	
	public void addPeople(String name) {
		peoples += name + ", ";
	}
}
