package com.proect.stations.service;

import com.proect.stations.dto.payload.JsonParseDTO;
import com.proect.stations.dto.payload.StationDTO;
import com.proect.stations.dto.response.FuelInfoDTO;
import com.proect.stations.exception.InvalidFuelTypeException;
import com.proect.stations.model.entity.StationEntity;
import com.proect.stations.model.enums.FuelType;
import com.proect.stations.repository.StationRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Transactional
@Service
public class StationService {
    private final StationRepository stationRepository;

    private final ModelMapper modelMapper;

    public StationService(StationRepository stationRepository, ModelMapper modelMapper) {
        this.stationRepository = stationRepository;
        this.modelMapper = modelMapper;
    }

    public void save(JsonParseDTO jsonParseDTO) {
        List<StationEntity> collectedEntities = Arrays.stream(jsonParseDTO.getStations())
                .filter(StationDTO::isOpen)
                .map(x -> modelMapper.map(x, StationEntity.class))
                .toList();

        stationRepository.saveAll(collectedEntities);
    }

    public FuelInfoDTO getFuelInfoByType(FuelType fuelType) {
        List<Double> values;
        switch (fuelType) {
            case E5 -> values = stationRepository.findAllE5()
                    .stream().sorted().toList();

            case E10 -> values = stationRepository.findAllE10()
                    .stream().sorted().toList();

            case DIESEL -> values = stationRepository.findAllDiesel()
                    .stream().sorted().toList();

            default -> throw new InvalidFuelTypeException();
        }
        double median = findMedian(values);
        double max = values.get(values.size() - 1);
        double min = values.get(0);

        return FuelInfoDTO.builder()
                .median(median)
                .max(max)
                .min(min)
                .build();
    }

    private double findMedian(List<Double> fuelPrices) {
        if (fuelPrices.size() % 2 == 1) {
            return fuelPrices.get(fuelPrices.size() / 2);
        } else {
            int middleIndex1 = fuelPrices.size() / 2 - 1;
            int middleIndex2 = fuelPrices.size() / 2;
            double middleValue1 = fuelPrices.get(middleIndex1);
            double middleValue2 = fuelPrices.get(middleIndex2);
            return (middleValue1 + middleValue2) / 2.0;
        }
    }
}
