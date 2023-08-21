package com.proect.stations.dto.payload;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JsonParseDTO implements Serializable {

    private StationDTO[] stations;
}
