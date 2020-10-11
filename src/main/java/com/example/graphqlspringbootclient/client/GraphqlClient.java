package com.example.graphqlspringbootclient.client;

import com.apollographql.apollo.ApolloCall.Callback;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.VehicleQuery;
import com.example.VehicleQuery.Data;
import com.example.graphqlspringbootclient.dto.VehicleDto;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GraphqlClient {

  private VehicleDto vehicleDto;

  public VehicleDto vehicleQuery(String id) {
    ApolloClient apolloClient =
        ApolloClient.builder().serverUrl("http://localhost:8080/graphql").build();

    apolloClient.query(new VehicleQuery(id)).enqueue(new Callback<Data>() {
      @Override
      public void onResponse(@NotNull Response<Data> response) {
        VehicleDto object = new VehicleDto();
        log.info(String.valueOf(Objects.requireNonNull(response.getData()).vehicle()));
        object.setId(Objects.requireNonNull(response.getData().vehicle()).id());
        object.setType(Objects.requireNonNull(response.getData().vehicle()).type());
        object.setModelCode(Objects.requireNonNull(response.getData().vehicle()).modelCode());
        vehicleDto = object;
      }

      @Override
      public void onFailure(@NotNull ApolloException e) {
        log.error(e.getMessage());
      }
    });
    return vehicleDto;
  }

}
