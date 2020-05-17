package com.wrn.service.imp;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import com.wrn.config.NodeConfig;

public class RandomLBTest {
	
	private static final Logger LOGGER = Logger.getLogger(RandomLBTest.class.getName());

	@Test
	public void testGetServerHost() {
		Integer nodesSize = NodeConfig.getNodes().size();
		int sumNodes = Integer.sum(nodesSize, nodesSize);
		for(int i = 0; sumNodes > i ; i ++) {
			String host = new RandomLB().getServerHost();
			LOGGER.info(host);
			assertNotNull(host);
		}
	}
}
