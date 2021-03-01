package org.acme.config;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.config.spi.ConfigSource;


/*
 * 
 *  400 ==> system properties
 *  300 ==> envi
 *  260 ==> application.properties at config directory
 *  250 ==> application.properties at project directory
 * 
 * 
 */

public class InMemoryConfigSource implements ConfigSource {

	private Map<String, String> confg = new HashMap<>();

	public InMemoryConfigSource() {
		confg.put("greeting.message", "Hello Ibm ( in-memory-config )");
	}

	@Override
	public Map<String, String> getProperties() {
		return confg;
	}

	@Override
	public String getValue(String propertyName) {
		return confg.get(propertyName);
	}

	@Override
	public String getName() {
		return "InMemoryConfig";
	}
	
	@Override
	public int getOrdinal() {
		return 249;
	}

}
