package company.com.company;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import company.service.TimeSheetService;
import company.service.TimeSheetServiceImpl;
import company.utils.JdbcUtilities;

public class TimeManagementEntry {

	public static void main(String[] args) throws SQLException, IOException {

		// I Run this To create table
		JdbcUtilities.createTable();

		// I Run this to clean table rows
		JdbcUtilities.deleteTableRows();
//
		// I Run this to insert test data into table
		JdbcUtilities.insertDataIntoTable();

		// PARAMETERS TO PASS TO our JAR FROM OTHER APPLICATION

		Date dateB = new GregorianCalendar(2019, Calendar.DECEMBER, 17).getTime();
		Date dateE = new GregorianCalendar(2020, Calendar.JANUARY, 02).getTime();
		String ref_ressource = "COMP38";

		// CLIENT FOR OUR SERVICE

		TimeSheetService service = new TimeSheetServiceImpl();
		List<Date> times = service.findNotCompleteTS(ref_ressource, dateB, dateE);

		// PRINT LIST OF RESULT DATES
		times.forEach(x -> System.out.println(x));

	}

}
