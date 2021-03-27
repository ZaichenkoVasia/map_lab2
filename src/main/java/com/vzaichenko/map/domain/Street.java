package com.vzaichenko.map.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Street {
    private String name;
    @ToString.Exclude
    @JsonIgnore
    private City city;
    private List<House> houses;
}
