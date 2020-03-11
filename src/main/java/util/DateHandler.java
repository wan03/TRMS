package util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DateHandler extends StdDeserializer<LocalDate> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DateHandler() {
		this(null);
	}
	
	public DateHandler(Class<?> clazz) {
		super(clazz);
	}
	
	@Override
	public LocalDate deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
		String dateString = jsonparser.getText();
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
			return LocalDate.parse(dateString, formatter);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
