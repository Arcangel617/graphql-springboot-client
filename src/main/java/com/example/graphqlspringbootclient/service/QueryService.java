package com.example.graphqlspringbootclient.service;

import com.example.graphqlspringbootclient.client.GraphqlClient;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

  private final GraphqlClient graphqlClient;

  public QueryService(GraphqlClient graphqlClient) {
    this.graphqlClient = graphqlClient;
  }

  public Object queryVehicle(String id) {
    VehicleQuery vehicleQuery = new VehicleQuery();
    vehicleQuery.setQuery("{ vehicle(id: " + id + ") { id type modelCode } }\" }");
    return graphqlClient.vehicleQuery(vehicleQuery);
  }
}
