package com.konduto.sdk.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by rsampaio on 07/08/14.
 */
public class TestUtils {
	public static String readJSONFromFile(String resourceName) {
		try {
			URL resource = Thread.currentThread().getContextClassLoader().getResource(resourceName);
			if(resource != null) {
				URI uri = resource.toURI();
				byte[] bytes = Files.readAllBytes(Paths.get(uri));
				return new String(bytes, "UTF-8");
			} else {
				throw new IllegalArgumentException(resourceName + " is an invalid resource name");
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
