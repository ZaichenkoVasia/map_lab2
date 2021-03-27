package com.vzaichenko.map.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class House {
    private Integer number;
    private String coordinates;
    @ToString.Exclude
    @JsonIgnore
    private Street street;
    private List<Flat> flats;
}
