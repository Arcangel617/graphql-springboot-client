package com.example.graphqlspringbootclient.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.graphqlspringbootclient.client.GraphqlClient;
import com.example.graphqlspringbootclient.dto.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

  @Autowired
  private GraphqlClient graphqlClient;

  @GetMapping(value = "/vehicle/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<VehicleDto> getVehicle(
      @PathVariable String id
  ) {
    return ResponseEntity.ok(graphqlClient.vehicleQuery(id));
  }

}
