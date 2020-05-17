package com.wrn.service.imp;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LoadBalancerImpTest {

	private LoadBalancerImp loadBalancer = new LoadBalancerImp();

	@Test
	public void testGetServerHostRandon() {
		assertNotNull(loadBalancer.getServerHost(new RandomLB()));
	}
	
	@Test
	public void testGetServerHostRoundRobin() {
		assertNotNull(loadBalancer.getServerHost(new RoundRobinLB()));
	}
	
	@Test
	public void testGetServerHostWeightRobinRound() {
		assertNotNull(loadBalancer.getServerHost(new WeightRoundRobinLB()));
	}
}
