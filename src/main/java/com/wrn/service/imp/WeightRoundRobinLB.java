package com.wrn.service.imp;

import java.util.List;

import com.wrn.config.NodeWeightConfig;
import com.wrn.service.LoadBalancer;

public class WeightRoundRobinLB implements LoadBalancer{
	
	private static int position;

	@Override
	public String getServerHost() {
		List<String> nodes = NodeWeightConfig.getNodesList();
		return nodes.get(getPosition(nodes.size()));
	}
	
	private synchronized int getPosition(int sizeNodeList) {
		int currentPosition = position;
		if(sizeNodeList - 1 <= position) {
			position = 0;
		}
		position ++;
		return currentPosition;
	}
}
