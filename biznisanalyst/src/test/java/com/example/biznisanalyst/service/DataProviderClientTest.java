package com.example.biznisanalyst.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class DataProviderClientTest {

  @Mock private RestTemplate restTemplate;

  @InjectMocks private DataProviderClient dataProviderClient;

  private static final String DATA_PROVIDER_URL = "http://dataprovider/random-text";

  @BeforeEach
  void setUp() {
    dataProviderClient = new DataProviderClient(restTemplate, DATA_PROVIDER_URL);
  }

  @Test
  void testGetData() {
    var expectedData = "test data";
    when(restTemplate.getForObject(DATA_PROVIDER_URL, String.class)).thenReturn(expectedData);

    var actualData = dataProviderClient.getData();

    assertEquals(expectedData, actualData);
    verify(restTemplate, times(1)).getForObject(DATA_PROVIDER_URL, String.class);
  }

  @Test
  void testGetDataApiFails() {
    when(restTemplate.getForObject(DATA_PROVIDER_URL, String.class))
        .thenThrow(new RuntimeException("API call failed"));

    assertThrows(RuntimeException.class, () -> dataProviderClient.getData());
    verify(restTemplate, times(1)).getForObject(DATA_PROVIDER_URL, String.class);
  }

  @Test
  void testGetDataNull() {
    when(restTemplate.getForObject(DATA_PROVIDER_URL, String.class)).thenReturn(null);

    var actualData = dataProviderClient.getData();

    assertNull(actualData);
    verify(restTemplate, times(1)).getForObject(DATA_PROVIDER_URL, String.class);
  }
}
