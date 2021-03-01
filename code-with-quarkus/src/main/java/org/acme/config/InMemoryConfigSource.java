package org.acme.config;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.config.spi.ConfigSource;


public class InMemoryConfigSource implements ConfigSource {

	private Map<String, String> confg = new HashMap<>();

	public InMemoryConfigSource() {
		confg.put("greeting.message", "Hello ibm ( in-memory-config )");
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
