package com.vzaichenko.map.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inhabitant {
    private Citizen citizen;
    private Flat flat;
}
