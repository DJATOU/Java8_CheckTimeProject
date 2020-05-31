package company.service;

import java.util.Date;
import java.util.List;

public interface TimeSheetService {

	List<Date> findNotCompleteTS(String refResdource, Date dateB, Date dateE);

}
