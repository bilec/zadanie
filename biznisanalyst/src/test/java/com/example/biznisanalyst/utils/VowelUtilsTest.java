package com.example.biznisanalyst.utils;

import static com.example.biznisanalyst.utils.VowelUtils.countUpperCaseVowels;
import static com.example.biznisanalyst.utils.VowelUtils.replaceVowelsWithUpperCase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class VowelUtilsTest {

  @Test
  void testReplaceVowelsWithUpperCase() {
    assertEquals("hEllO", replaceVowelsWithUpperCase("hello"));
    assertEquals("AEIOU", replaceVowelsWithUpperCase("aeiou"));
    assertEquals("JAvA", replaceVowelsWithUpperCase("Java"));
  }

  @Test
  void testReplaceVowelsWithUpperCaseNoVowels() {
    assertEquals("rhythm", replaceVowelsWithUpperCase("rhythm"));
  }

  @Test
  void testReplaceVowelsWithUpperCaseNullOrEmpty() {
    assertNull(replaceVowelsWithUpperCase(null));
    assertEquals("", replaceVowelsWithUpperCase(""));
  }

  @Test
  void testCountUpperCaseVowels() {
    assertEquals(2, countUpperCaseVowels("hEllO"));
    assertEquals(5, countUpperCaseVowels("AEIOU"));
    assertEquals(0, countUpperCaseVowels("Java"));
  }

  @Test
  void testCountUpperCaseVowelsNoUppercaseVowels() {
    assertEquals(0, countUpperCaseVowels("hello"));
    assertEquals(0, countUpperCaseVowels("rhythm"));
  }

  @Test
  void testCountUpperCaseVowelsNullOrEmpty() {
    assertEquals(0, countUpperCaseVowels(null));
    assertEquals(0, countUpperCaseVowels(""));
  }
}
