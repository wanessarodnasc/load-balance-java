package com.wrn.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class NodeWeightConfig {

	private static Map<String, Integer> nodesMap = new HashMap<>();

	private NodeWeightConfig() {
	}

	public static List<String> getNodesList() {
		getNodesMap();

		List<String> allNodes = new ArrayList<>();

		int toRemove = getNewMap().keySet().size();
		TreeMap<String, Integer> newMap = new TreeMap<>();
		TreeMap<String, Integer> mapToRead = new TreeMap<>(getNewMap());

		while (toRemove > 0) {
			
			for (Entry<String, Integer> node : mapToRead.entrySet()) {

				if(!newMap.containsKey(node.getKey())) {
					newMap.put(node.getKey(), node.getValue() - 1);
					allNodes.add(node.getKey());
				}else if(newMap.get(node.getKey()) > 0) {
					newMap.put(node.getKey(), newMap.get(node.getKey()) - 1);
					allNodes.add(node.getKey());
				}
			}
			toRemove --;
		}
		
		return allNodes;
	}

	public static List<String> getNodesRandomList() {
		getNodesMap();

		List<String> allNodes = new ArrayList<>();
		TreeMap<String, Integer> mapToChange = new TreeMap<>(getNewMap());

		for (Entry<String, Integer> node : mapToChange.entrySet()) {
			for (int add = 0; node.getValue() > add; add++) {
				allNodes.add(node.getKey());
			}
		}
		return allNodes;
	}

	private static Map<String, Integer> getNewMap() {
		Map<String, Integer> mapToRemove = new HashMap<>();
		mapToRemove.putAll(nodesMap);
		return mapToRemove;
	}

	public static Map<String, Integer> getNodesMap() {
		if (nodesMap.isEmpty()) {
			setNodesMap();
		}
		return nodesMap;
	}

	private static void setNodesMap() {
		nodesMap.put("192.168.0.1", 2);
		nodesMap.put("192.168.0.2", 1);
		nodesMap.put("192.168.0.3", 2);
		nodesMap.put("192.168.0.4", 10);
		nodesMap.put("192.168.0.5", 2);
	}
}
