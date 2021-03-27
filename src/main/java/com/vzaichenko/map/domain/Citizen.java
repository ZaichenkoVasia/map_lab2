package com.vzaichenko.map.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Citizen {
    private String name;
    private String surname;
    private Integer age;
}
