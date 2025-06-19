package com.example.biznisanalyst.utils;

import java.util.Locale;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VowelUtils {

  private static final String VOWEL_CHARS = "aeiou";
  private static final Pattern VOWEL_PATTERN = Pattern.compile("(?i)[%s]".formatted(VOWEL_CHARS));

  public static String replaceVowelsWithUpperCase(String input) {
    if (input == null) {
      return null;
    }

    var matcher = VOWEL_PATTERN.matcher(input);
    return matcher.replaceAll(matchResult -> matchResult.group().toUpperCase());
  }

  public static long countUpperCaseVowels(String input) {
    if (input == null) {
      return 0;
    }

    var uppercaseVowels = VOWEL_CHARS.toUpperCase(Locale.ROOT);
    return input.chars().filter(c -> uppercaseVowels.indexOf(c) >= 0).count();
  }
}
