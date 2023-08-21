package com.proect.stations.dto.payload;

import com.proect.stations.model.enums.FuelType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestObject implements Serializable {

    private FuelType fuelType;
}
