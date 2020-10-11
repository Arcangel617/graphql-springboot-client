package com.example.graphqlspringbootclient.client;

import com.example.graphqlspringbootclient.service.VehicleQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "vehicle", url = "http://localhost:8080")
public interface GraphqlClient {

  @PostMapping("/graphql")
  Object vehicleQuery(VehicleQuery query);
}
