package com.panasalbk.app.testing.utils;

import org.junit.Test;
import org.junit.Assert;
import com.panasalbk.app.util.StringUtils;


public class StringUtilsTest {
	
	@Test
	public void testCapitalizeFormatSuccess() {
		Assert.assertEquals("Word", StringUtils.capitalize("WORD"));
		Assert.assertEquals("Word", StringUtils.capitalize("    WORD"));
		Assert.assertEquals("Word", StringUtils.capitalize("    WORD    "));
		Assert.assertEquals("Word", StringUtils.capitalize("W O R D "));
		Assert.assertEquals("Word", StringUtils.capitalize("wORD"));
		Assert.assertEquals("Word", StringUtils.capitalize("word"));
		Assert.assertEquals("Word", StringUtils.capitalize("wOrD"));
		Assert.assertEquals("Word", StringUtils.capitalize("w    ORD"));
	}
	
	@Test
	public void testTrimWhiteSpacesSuccess() {
		Assert.assertEquals("TEST", StringUtils.trim("     TEST"));
		Assert.assertEquals("TEST", StringUtils.trim(" T E S T "));
		Assert.assertEquals("TEST", StringUtils.trim(" TES  T      "));
		Assert.assertEquals("test", StringUtils.trim("t e s t"));
	}

	@Test
	public void testIsEmptySuccess() {
		Assert.assertTrue("Must be empty.", StringUtils.isEmpty(null));
		Assert.assertTrue("Must be empty", StringUtils.isEmpty(""));
		Assert.assertFalse("White Spaces are not empty string", StringUtils.isEmpty(" "));
	}
}
