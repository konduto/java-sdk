package com.konduto.sdk.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 */
public class TestUtils {

	public static JsonElement readJSONFromFile(String resourceName) {
		try {
			URL resource = Thread.currentThread().getContextClassLoader().getResource(resourceName);
			if(resource != null) {
				URI uri = resource.toURI();
				byte[] bytes = Files.readAllBytes(Paths.get(uri));
				String jsonString = new String(bytes, "UTF-8");
				JsonParser parser = new JsonParser();
				return parser.parse(jsonString);
			} else {
				throw new IllegalArgumentException(resourceName + " is an invalid resource name");
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

}
