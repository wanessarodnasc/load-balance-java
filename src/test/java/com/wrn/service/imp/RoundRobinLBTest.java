package com.wrn.service.imp;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import com.wrn.config.NodeConfig;

public class RoundRobinLBTest {
	
	private static final Logger LOGGER = Logger.getLogger(RoundRobinLBTest.class.getName());

	@Test
	public void testGetServerHost() {
		RoundRobinLB loadBalancer = new RoundRobinLB();

		List<String> nodes = NodeConfig.getNodes();
		nodes.addAll(NodeConfig.getNodes());
		
		for (String node : nodes) {
			String nodeReturned = loadBalancer.getServerHost();
			LOGGER.info("Node=" + node + " Node Returned: " +  nodeReturned);
			assertEquals(node, nodeReturned);
		}
	}
}
