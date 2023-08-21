package com.proect.stations.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuelInfoDTO {
    private double median;

    private double max;

    private double min;
}
