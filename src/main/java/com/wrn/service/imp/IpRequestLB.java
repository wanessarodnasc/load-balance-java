package com.wrn.service.imp;

import com.wrn.config.NodeConfig;

public class IpRequestLB  {

	public String getServerHost(String ip) {
		return NodeConfig.getMapNodes().get(ip);
	}
}
