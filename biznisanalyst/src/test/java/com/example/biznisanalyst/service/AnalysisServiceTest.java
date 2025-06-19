package com.example.biznisanalyst.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AnalysisServiceTest {

  @Mock private DataProviderClient dataProviderClient;

  @InjectMocks private AnalysisService analysisService;

  @BeforeEach
  void setUp() {
    analysisService = new AnalysisService(dataProviderClient);
  }

  @ParameterizedTest
  @CsvSource({"hello world,3", ",0", "cry,0"})
  void testPerformAnalysis(String inputData, int expectedCount) {
    when(dataProviderClient.getData()).thenReturn(inputData);

    var result = analysisService.performAnalysis();

    assertEquals(expectedCount, result);
    verify(dataProviderClient, times(1)).getData();
  }

  @Test
  void testPerformAnalysisNull() {
    when(dataProviderClient.getData()).thenReturn(null);

    var result = analysisService.performAnalysis();

    assertEquals(0L, result);
    verify(dataProviderClient, times(1)).getData();
  }
}
