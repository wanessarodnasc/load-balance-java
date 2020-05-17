package com.wrn.config;

import junit.framework.TestCase;

public class NodeConfigTest extends TestCase {

	public void testGetNodes() {
		assertNotNull(NodeConfig.getNodes());
	}
}
