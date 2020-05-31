package company.service;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import company.dao.TimeSheetRepository;
import company.dao.TimeSheetRepositoryImpl;

import com.company.models.TimeSheet;
import company.utils.FileUtilities;






public class TimeSheetServiceImpl implements TimeSheetService {
//	  private final Logger logger = LogFactory.getLog(getClass());
	private TimeSheetRepository timeSheetRepository;

	public TimeSheetServiceImpl() {
		super();
		this.timeSheetRepository = new TimeSheetRepositoryImpl();

	}

	@Override
	public List<Date> findNotCompleteTS(String refRessource, Date dateB, Date dateE) {

		//LocaldateTime 
		// LocalDateTime beginDate = LocalDateTime.of(2019,Month.DECEMBER,23,00,00,00);
		// LocalDateTime endDate = LocalDateTime.of(2020,Month.JANUARY,02,00,00,00);


		List<Date> temps = new ArrayList<>();

		// Converts Date to LocalDateTime As Postgress look for this new types from java8
		// https://jdbc.postgresql.org/documentation/head/8-date-time.html

		LocalDateTime beginDate = Instant.ofEpochMilli(dateB.getTime()).atZone(ZoneId.systemDefault())
				.toLocalDateTime();

		LocalDateTime endDate = Instant.ofEpochMilli(dateE.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();

		// get List of temps from databse basing on filters ( date && ref-ressources) 
		List<TimeSheet> timeSheets = timeSheetRepository.findNotCompleteTS(refRessource, beginDate, endDate);


		// Filter on date by quantite <1  and eliminate weekends (SATURDAY & SUNDAY)


		// Map<Double, List<TimeSheet>> t = new HashMap<>();
		//        
		// t =  timeSheets.stream()
		//                .collect(Collectors.groupingBy(TimeSheet::getQuantite));

		// timeSheets.forEach(System.out::println);

//		System.out.println("heeeere");

		List<TimeSheet> filtertimeSheets = new ArrayList<>() ;
		timeSheets.stream()
		.collect(Collectors.toMap(ts -> Arrays.asList(ts.getDate()), TimeSheet::getQuantite, (e,c)->(e+c)))


		.forEach((date, quantite) ->

		{LocalDateTime rr = (LocalDateTime) date.get(0) ;
		filtertimeSheets.add(new TimeSheet("",rr, "", quantite, "", "", "", "")) ;

		}
				)



		;

//		filtertimeSheets.forEach(System.out::println);
		Predicate<TimeSheet> filterPredicate = sheet -> sheet.getQuantite() < 1
				&& !sheet.getDate().getDayOfWeek().equals(DayOfWeek.SATURDAY)
				&& !sheet.getDate().getDayOfWeek().equals(DayOfWeek.SUNDAY)
				&& !FileUtilities.checkIsHoliday(sheet.getDate());


		// apply Predicate 
			filtertimeSheets.stream()
			.filter(filterPredicate)
			.forEach(x -> temps.add(java.util.Date.from(x.getDate().atZone(ZoneId.systemDefault()).toInstant())));

		return temps;
	}

}
