package com.example.biznisanalyst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataProviderClient {

  private final RestTemplate restTemplate;
  private final String dataProviderUrl;

  @Autowired
  public DataProviderClient(
      RestTemplate restTemplate, @Value("${data.provider.url}") String dataProviderUrl) {
    this.restTemplate = restTemplate;
    this.dataProviderUrl = dataProviderUrl;
  }

  public String getData() {
    return restTemplate.getForObject(dataProviderUrl, String.class);
  }
}
