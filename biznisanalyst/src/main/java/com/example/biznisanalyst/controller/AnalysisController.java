package com.example.biznisanalyst.controller;

import com.example.biznisanalyst.service.AnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biznis-analysis")
@Tag(name = "Analysis", description = "Endpoints for business analysis operations")
public class AnalysisController {

  private final AnalysisService analysisService;

  @Autowired
  public AnalysisController(AnalysisService analysisService) {
    this.analysisService = analysisService;
  }

  @GetMapping
  @Operation(
      summary = "Get analysis result",
      description = "Performs analysis on data and returns the count of uppercase vowels.",
      responses = {
        @ApiResponse(responseCode = "200", description = "Successful analysis result"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
      })
  public long getAnalysis() {
    return analysisService.performAnalysis();
  }
}
