package com.example.graphqlspringbootclient.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VehicleDto {

  private String id;
  private String type;
  private String modelCode;

}
