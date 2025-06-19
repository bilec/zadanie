package com.example.biznisanalyst.service;

import static com.example.biznisanalyst.utils.VowelUtils.countUpperCaseVowels;
import static com.example.biznisanalyst.utils.VowelUtils.replaceVowelsWithUpperCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalysisService {

  private final DataProviderClient dataProviderClient;

  @Autowired
  public AnalysisService(DataProviderClient dataProviderClient) {
    this.dataProviderClient = dataProviderClient;
  }

  public long performAnalysis() {
    var data = dataProviderClient.getData();
    var dataWithUppedVowels = replaceVowelsWithUpperCase(data);

    return countUpperCaseVowels(dataWithUppedVowels);
  }
}
