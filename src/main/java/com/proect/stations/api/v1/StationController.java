package com.proect.stations.api.v1;

import com.proect.stations.dto.payload.RequestObject;
import com.proect.stations.dto.response.FuelInfoDTO;
import com.proect.stations.dto.response.ResponseDTO;
import com.proect.stations.model.enums.FuelType;
import com.proect.stations.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static com.proect.stations.config.AppConstants.API_BASE;

@RestController
@RequestMapping(API_BASE + "/stations")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping("/fuel-info")
    public ResponseEntity<ResponseDTO<Object>> getFuelInfoByType(@RequestBody RequestObject requestObject) {
        FuelType fuelType = requestObject.getFuelType();
        boolean isValidFuelType = Arrays.stream(FuelType.values())
                .anyMatch(f -> f.name().equals(fuelType.name()));
        if (!isValidFuelType) {
            return ResponseEntity.badRequest()
                    .body(
                            ResponseDTO
                                    .builder()
                                    .status(HttpStatus.BAD_REQUEST.value())
                                    .message("Invalid fuel type value!")
                                    .content(null)
                                    .build()
                    );
        }
        FuelInfoDTO fuelInfoDTO = stationService.getFuelInfoByType(fuelType);

        return ResponseEntity.ok(
                ResponseDTO
                        .builder()
                        .message("Successfully get info about fuel prices")
                        .status(HttpStatus.OK.value())
                        .content(fuelInfoDTO)
                        .build()
        );
    }


}