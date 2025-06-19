package com.example.biznisanalyst.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.biznisanalyst.service.AnalysisService;
import org.junit.jupiter.api.Test;

class AnalysisControllerTest {

  @Test
  void testGetAnalysis() {
    var mockService = mock(AnalysisService.class);
    when(mockService.performAnalysis()).thenReturn(0L);

    var controller = new AnalysisController(mockService);
    var result = controller.getAnalysis();

    assertEquals(0L, result);
  }
}
