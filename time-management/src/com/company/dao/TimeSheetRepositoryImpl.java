package company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import company.config.DatabaseConnection;
import com.company.models.TimeSheet;

public class TimeSheetRepositoryImpl implements TimeSheetRepository {

	DatabaseConnection databaseConnection;

	public TimeSheetRepositoryImpl() {
		super();
		try {
			databaseConnection = DatabaseConnection.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<TimeSheet> findNotCompleteTS(String refRessource, LocalDateTime beginDate, LocalDateTime endDate) {
		// TODO Auto-generated method stub

		List<TimeSheet> temps = new ArrayList<TimeSheet>();

		try (Connection conn = databaseConnection.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("SELECT * FROM temps where ref_ressource = ? AND date BETWEEN ? AND ? ");) {

			stmt.setString(1, refRessource);
			stmt.setObject(2, beginDate);
			stmt.setObject(3, endDate);

			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				TimeSheet ts = new TimeSheet(resultSet.getString("ref_temps"),
						resultSet.getObject("date", LocalDateTime.class), resultSet.getString("ref_contrat"),
						resultSet.getDouble("quantite"), resultSet.getString("code_heure"),
						resultSet.getString("ref_prestation"), resultSet.getString("ref_ressource"),
						resultSet.getString("titre_projet"));

				temps.add(ts);
			}
			return temps;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return temps;

	}

}
