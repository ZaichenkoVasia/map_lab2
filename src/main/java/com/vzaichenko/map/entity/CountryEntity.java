package com.vzaichenko.map.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
@Builder
public class CountryEntity {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "population")
    private Integer population;

    @OneToMany(mappedBy = "countryEntity", cascade = CascadeType.ALL)
    private List<CityEntity> cities;
}
