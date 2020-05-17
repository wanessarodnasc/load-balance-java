package com.wrn.service.imp;

import static org.junit.Assert.*;

import org.junit.Test;

public class IpRequestLBTest {

	@Test
	public void testGetServerHost() {
		IpRequestLB loadBalancer = new IpRequestLB();
		assertEquals("192.168.0.1",loadBalancer.getServerHost("192.168.133.1"));
		assertEquals("192.168.0.2",loadBalancer.getServerHost("192.168.133.2"));
		assertEquals("192.168.0.3",loadBalancer.getServerHost("192.168.133.3"));
		assertEquals("192.168.0.4",loadBalancer.getServerHost("192.168.133.4"));
		assertEquals("192.168.0.5",loadBalancer.getServerHost("192.168.133.5"));
		assertEquals("192.168.0.1",loadBalancer.getServerHost("192.168.133.6"));
		assertEquals("192.168.0.2",loadBalancer.getServerHost("192.168.133.7"));
		assertEquals("192.168.0.3",loadBalancer.getServerHost("192.168.133.8"));
		assertEquals("192.168.0.4",loadBalancer.getServerHost("192.168.133.9"));
		assertEquals("192.168.0.5",loadBalancer.getServerHost("192.168.133.10"));
	}
}
