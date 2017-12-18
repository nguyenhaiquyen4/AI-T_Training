package com.packt.legacy.unfavorable.construct.instantiate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.packt.legacy.unfavorable.construct.constructor.DatabaseDependency;

public class VariableInitializationTest {
	@Mock DatabaseDependency dependency;
	VariableInitialization initialization;
	
	@Before
	public void setUp() throws Exception {
		initialization = new VariableInitialization(dependency);
	}
	
	@Test
	public void sanity() throws Exception {
		
	}
}
