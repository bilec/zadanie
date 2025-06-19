package com.example.dataprovider.controller;

import com.example.dataprovider.service.RandomStringService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random-text")
@Tag(name = "Data provider", description = "Endpoints for providing random text data")
public class RandomTextController {

  private final RandomStringService randomStringService;

  @Autowired
  public RandomTextController(RandomStringService randomStringService) {
    this.randomStringService = randomStringService;
  }

  @GetMapping
  @Operation(
      summary = "Get a random text string",
      description = "Generates and returns a random string using the RandomStringService.",
      responses = {
        @ApiResponse(responseCode = "200", description = "Random string generated successfully"),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error while generating random string")
      })
  public String getText() {
    return randomStringService.getRandomString();
  }
}
