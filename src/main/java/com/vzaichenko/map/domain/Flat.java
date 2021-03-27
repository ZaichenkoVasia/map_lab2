package com.vzaichenko.map.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flat {
    private Integer number;
    @ToString.Exclude
    @JsonIgnore
    private House house;
}
