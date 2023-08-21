package com.proect.stations.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "stations")
public class StationEntity {
    @NotNull
    @Id
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String brand;
    @NotNull
    private String street;
    @NotNull
    private String place;
    @NotNull
    private double lat;
    @NotNull
    private double lng;
    @NotNull
    private double dist;
    @NotNull
    private double diesel;
    @NotNull
    private double e5;
    @NotNull
    private double e10;
    @NotNull
    private boolean isOpen;
    @NotNull
    private String houseNumber;
    @NotNull
    private double postCode;
}
