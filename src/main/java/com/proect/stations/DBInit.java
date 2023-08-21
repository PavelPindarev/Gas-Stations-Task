package com.proect.stations;

import com.google.gson.Gson;
import com.proect.stations.dto.payload.JsonParseDTO;
import com.proect.stations.service.StationService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.net.URL;

import static com.proect.stations.config.AppConstants.JSON_URL;

@Component
public class DBInit implements CommandLineRunner {
    private final StationService stationService;

    private final Gson gson;

    private final ModelMapper modelMapper;


    public DBInit(StationService stationService, Gson gson, ModelMapper modelMapper) {
        this.stationService = stationService;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }


    @Override
    public void run(String... args) throws Exception {

        URL url = new URL(JSON_URL);
        InputStreamReader reader = new InputStreamReader(url.openStream());

        Object jsonParseDTO = gson.fromJson(reader, Object.class);

        JsonParseDTO jsonDTO = modelMapper.map(jsonParseDTO, JsonParseDTO.class);

        stationService.save(jsonDTO);
        reader.close();
    }
}
