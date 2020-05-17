package com.wrn.service.imp;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.junit.Test;

import com.wrn.config.NodeWeightConfig;

public class WeightRoundRobinLBTest {

	private final static Logger LOGGER = Logger.getLogger(WeightRoundRobinLBTest.class.getName());

	@Test
	public void testGetServerHost() {
		WeightRoundRobinLB loadBalancer = new WeightRoundRobinLB();

		Map<String, Integer> nodesMap = NodeWeightConfig.getNodesMap();
		Map<String, Integer> newNodesMap = new HashMap<>();
		int nodeSize = NodeWeightConfig.getNodesList().size();

		while (nodeSize > 0) {
			String nodeReturned = loadBalancer.getServerHost();
			LOGGER.info("Node returned " + nodeReturned);
			if (newNodesMap.isEmpty() || !newNodesMap.containsKey(nodeReturned)) {
				newNodesMap.put(nodeReturned, 1);
			} else {
				for (Entry<String, Integer> node : newNodesMap.entrySet()) {
					if (node.getKey().equals(nodeReturned)) {
						newNodesMap.replace(nodeReturned, node.getValue(), node.getValue() + 1);
					}
				}
			}
			nodeSize --;
		}
		assertEquals(nodesMap, newNodesMap);
	}
}
