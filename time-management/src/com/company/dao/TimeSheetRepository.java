package company.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.company.models.TimeSheet;



public interface TimeSheetRepository {
	
	List<TimeSheet> findNotCompleteTS(String refRessource, LocalDateTime beginDate, LocalDateTime endDate);

}
