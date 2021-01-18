package org.example.javagradle.gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import org.example.javagradle.dto.Person;

public class GsonTest {
	private Gson gson;

	private static GsonTest gTest;

	private GsonTest() {
		gson = new Gson();
	}

	public static GsonTest getInstance() {
		if (gTest == null) gTest = new GsonTest();

		return gTest;
	}

	public String objectToJson(Person person) {
		return gson.toJson(person);
	}

	public <T> T jsonToObject(final String json, Type typeOfT) {
		return gson.fromJson(json, typeOfT);

	}
	
	public String jsonFileToString(File jsonFile) {
		String jsonString = "";
		try (JsonReader jsonReader = new JsonReader(new FileReader(jsonFile))){
			jsonString = gson.toJson(jsonReader);
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonString;
	}
}