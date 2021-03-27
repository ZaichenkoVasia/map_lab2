package com.vzaichenko.map.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "houses")
@Builder
public class HouseEntity {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "coordinates")
    private String coordinates;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    private StreetEntity streetEntity;

    @OneToMany(mappedBy = "houseEntity", cascade = CascadeType.ALL)
    private List<FlatEntity> flatEntities;
}
