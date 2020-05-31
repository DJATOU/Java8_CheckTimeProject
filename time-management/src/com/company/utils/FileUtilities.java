package company.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtilities {

	public static List<LocalDateTime> getListOfHolidaysFromFile() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		List<LocalDateTime> listDates = new ArrayList<>();

		String fileName = "holidays.txt";

		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(x -> listDates.add(LocalDateTime.parse(x, formatter)));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listDates;

	}

	public static boolean checkIsHoliday(LocalDateTime dateWorked) {
		return getListOfHolidaysFromFile().stream().anyMatch(dateWorked::equals);

	}

	public static HashMap<String, String> loadValuesFromProperties() {

		HashMap<String, String> mymap = new HashMap<>();

		final String PROPERTIES_FILE_PATH = "database.properties";

		Properties properties = new Properties();

		try {

			properties.load(new FileInputStream(PROPERTIES_FILE_PATH));

			mymap.putAll(properties.entrySet().stream()
					.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())));

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return mymap;

	}

}
