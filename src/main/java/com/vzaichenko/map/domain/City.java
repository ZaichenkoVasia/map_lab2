package com.vzaichenko.map.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City {
    private Integer population;
    @ToString.Exclude
    @JsonIgnore
    private Country country;
    private List<Street> streets;
}
