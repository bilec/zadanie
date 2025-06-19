package com.example.dataprovider.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.dataprovider.service.RandomStringService;
import org.junit.jupiter.api.Test;

class RandomTextControllerTest {

  @Test
  void testGetText() {
    var mockService = mock(RandomStringService.class);
    when(mockService.getRandomString()).thenReturn("mocked-string");

    var controller = new RandomTextController(mockService);
    var result = controller.getText();

    assertEquals("mocked-string", result);
  }
}
