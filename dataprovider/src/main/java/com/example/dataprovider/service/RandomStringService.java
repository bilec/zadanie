package com.example.dataprovider.service;

import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RandomStringService {

  @Getter private String randomString;
  private final RandomStringGenerator generator;

  public RandomStringService() {
    generator = new RandomStringGenerator.Builder().withinRange('a', 'z').get();
    generateNewRandomString();
  }

  @Scheduled(timeUnit = TimeUnit.MINUTES, fixedRate = 5)
  @VisibleForTesting
  protected void generateNewRandomString() {
    this.randomString = generator.generate(20);
  }
}
