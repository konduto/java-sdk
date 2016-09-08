package com.konduto.sdk.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 */
public class TestUtils {

	public static JsonElement readJSONFromFile(String resourceName) {
		try {
			URL resource = Thread.currentThread().getContextClassLoader().getResource(resourceName);
			if(resource != null) {
				URI uri = resource.toURI();
				byte[] bytes = readAllBytes(uri);
				String jsonString = new String(bytes, "UTF-8");
				JsonParser parser = new JsonParser();
				return parser.parse(jsonString);
			} else {
				throw new IllegalArgumentException(resourceName + " is an invalid resource name");
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] readAllBytes(URI uri) {
		int byteRead;
		try {
			FileInputStream fileStream = new FileInputStream(new File(uri));
			ByteArrayOutputStream ouputStream = new ByteArrayOutputStream();
			byteRead = fileStream.read();
			while (byteRead != -1) {
				ouputStream.write(byteRead);
				byteRead = fileStream.read();
			}
			fileStream.close();
			return ouputStream.toByteArray(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
