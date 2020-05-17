package com.wrn.config;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class NodeWeightConfigTest {

	@Test
	public void testMap() {
		Map<String, String> nodes = NodeConfig.getMapNodes();
		assertEquals(10, nodes.size());
	}
	
	@Test
	public void testList() {
		List<String> nodes = NodeConfig.getNodes();
		assertEquals(5, nodes.size());
	}

}
