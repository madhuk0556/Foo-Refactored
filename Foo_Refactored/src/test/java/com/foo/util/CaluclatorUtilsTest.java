package com.foo.util;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CaluclatorUtilsTest {
	
	@Test
	public void testRounding(){
		assertTrue(CaluclatorUtils.rounding(12.4678d)==12.47d);
	}
	
}
