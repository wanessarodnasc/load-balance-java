package com.wrn.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NodeConfig {
	
	private static List<String> nodes = new ArrayList<>();
	private static Map<String, String> mapNodes = new HashMap<>();
	
	private NodeConfig() {
	}

	public static List<String> getNodes() {
		isNodesNull();
		return nodes;
	}

	public static Map<String, String> getMapNodes() {
		isNodesNull();
		return mapNodes;
	}

	private static void isNodesNull() {
		if(mapNodes.isEmpty()) {
			setNodes();
		}
	}

	private static void setNodes() {
		mapNodes.put("192.168.133.1", "192.168.0.1");
		mapNodes.put("192.168.133.2", "192.168.0.2");
		mapNodes.put("192.168.133.3", "192.168.0.3");
		mapNodes.put("192.168.133.4", "192.168.0.4");
		mapNodes.put("192.168.133.5", "192.168.0.5");
		mapNodes.put("192.168.133.6", "192.168.0.1");
		mapNodes.put("192.168.133.7", "192.168.0.2");
		mapNodes.put("192.168.133.8", "192.168.0.3");
		mapNodes.put("192.168.133.9", "192.168.0.4");
		mapNodes.put("192.168.133.10", "192.168.0.5");
		nodes.addAll(mapNodes.values().stream().distinct().collect(Collectors.toList()));
	}
}
