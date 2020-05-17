package com.wrn.service.imp;

import java.util.List;
import java.util.Random;

import com.wrn.config.NodeConfig;
import com.wrn.service.LoadBalancer;

public class RandomLB implements LoadBalancer{

	@Override
	public String getServerHost() {
		List<String> nodes = NodeConfig.getNodes();
		return nodes.get(new Random().nextInt(nodes.size()));
	}
}
