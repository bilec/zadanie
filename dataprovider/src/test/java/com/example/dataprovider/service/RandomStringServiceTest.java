package com.example.dataprovider.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RandomStringServiceTest {

  @Test
  void testGetRandomString() {
    var service = new RandomStringService();
    var result = service.getRandomString();

    assertNotNull(result);
    assertEquals(20, result.length());
    assertTrue(result.matches("[a-z]{20}"));
  }

  @Test
  void testRegenerateNewRandomString() {
    var service = new RandomStringService();
    var first = service.getRandomString();

    service.generateNewRandomString();
    var second = service.getRandomString();

    assertNotEquals(first, second);
  }
}
