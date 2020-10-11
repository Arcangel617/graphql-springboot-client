package com.example.graphqlspringbootclient.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.graphqlspringbootclient.service.QueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

  private final QueryService queryService;

  public VehicleController(QueryService queryService) {
    this.queryService = queryService;
  }

  @GetMapping(value = "/vehicle/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getVehicle(
      @PathVariable String id
  ) {
    return ResponseEntity.ok(queryService.queryVehicle(id));
  }

}
