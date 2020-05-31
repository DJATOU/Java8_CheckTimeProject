package company.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import company.config.DatabaseConnection;
public class JdbcUtilities {

	public static void createTable() throws SQLException {

		try (Connection conn = DatabaseConnection.getInstance().getConnection();
				Statement stmt = conn.createStatement();) {

			StringBuilder cb = new StringBuilder();

			cb.append("CREATE TABLE  IF NOT EXISTS  temps");
			cb.append("(");
			cb.append("ref_temps SERIAL NOT NULL,");
			cb.append("date timestamp without time zone,");
			cb.append("ref_contrat character(16),");
			cb.append("quantite numeric,");
			cb.append("code_heure text ,");
			cb.append("ref_prestation text ,");
			cb.append("ref_ressource text,");
			cb.append("titre_projet text ");
			cb.append(")");
			stmt.execute(cb.toString());

		}

	}

	public static void deleteTableRows() throws SQLException {
		try (Connection conn = DatabaseConnection.getInstance().getConnection();
				Statement stmt = conn.createStatement();) {

			stmt.execute("delete from temps");

		}
	}

	public static void insertDataIntoTable() throws SQLException {

		try (Connection conn = DatabaseConnection.getInstance().getConnection();
				Statement stmt = conn.createStatement();) {

			String insert0 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-15 00:00:00', '11309946' , 1,'1','MIS7369','COMP38' , null)";
			
			String insert1 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-16 00:00:00', '11309946' , 1,'1','MIS7369','COMP38' , null)";

			String insert2 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-17 00:00:00', '11309946' , 1,'1','MIS7369','COMP40' , null)";

			String insert3 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-18 00:00:00', '11309946' , 1,'1','MIS7369','COMP40' , null)";

			String insert4 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-19 00:00:00', '11309946' , 0.5,'1','MIS7369','COMP38' , null)";

			String insert5 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-20 00:00:00', '11309946' , 1,'1','MIS7369','COMP38' , null)";

			String insert6 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-21 00:00:00', '11309946' , 1,'1','MIS7369','COMP55' , null)";

			String insert7 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-22 00:00:00', '11309946' , 0.25,'1','MIS7369','COMP38' , null)";

			String insert8 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-23 00:00:00', '11309946' , 1,'1','MIS7369','COMP38' , null)";

			String insert9 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-24 00:00:00', '11309946' , 1,'1','MIS7369','COMP66' , null)";

			String insert10 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-25 00:00:00', '11309946' , 1,'1','MIS7369','COMP38' , null)";

			String insert11 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-26 00:00:00', '11309946' , 1,'1','MIS7369','COMP38' , null)";

			String insert12 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-27 00:00:00', '11309946' , 0.75,'1','MIS7369','COMP38' , null)";

			String insert13 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-28 00:00:00', '11309946' , 1,'1','MIS7369','COMP41' , null)";

			String insert14 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-29 00:00:00', '11309946' , 1,'1','MIS7369','COMP38' , null)";

			String insert15 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-30 00:00:00', '11309946' , 0.25,'1','MIS7369','COMP38' , null)";

			String insert16 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2019-12-31 00:00:00', '11309946' , 1,'1','MIS7369','COMP38' , null)";

			String insert17 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2020-01-01 00:00:00', '11309946' , 0.25,'1','MIS7369','COMP38' , null)";

			String insert18 = "INSERT INTO temps(date, ref_contrat, quantite , code_heure, ref_prestation , ref_ressource , titre_projet)"
					+ "VALUES('2020-01-02 00:00:00', '11309946' , 0.75,'1','MIS7369','COMP38' , null)";

			stmt.executeUpdate(insert0);
			stmt.executeUpdate(insert1);
			stmt.executeUpdate(insert2);
			stmt.executeUpdate(insert3);
			stmt.executeUpdate(insert4);
			stmt.executeUpdate(insert5);
			stmt.executeUpdate(insert6);
			stmt.executeUpdate(insert7);
			stmt.executeUpdate(insert8);
			stmt.executeUpdate(insert9);
			stmt.executeUpdate(insert10);
			stmt.executeUpdate(insert11);
			stmt.executeUpdate(insert12);
			stmt.executeUpdate(insert13);
			stmt.executeUpdate(insert14);
			stmt.executeUpdate(insert15);
			stmt.executeUpdate(insert16);
			stmt.executeUpdate(insert17);
			stmt.executeUpdate(insert18);

		}

	}

}
