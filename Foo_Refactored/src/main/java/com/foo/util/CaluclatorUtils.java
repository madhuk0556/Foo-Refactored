package com.foo.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CaluclatorUtils {
	
	public static double rounding(double value) {
		return new BigDecimal(value).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
	}
}
