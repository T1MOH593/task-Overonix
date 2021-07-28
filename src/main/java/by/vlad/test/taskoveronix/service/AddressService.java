package by.vlad.test.taskoveronix.service;

import by.vlad.test.taskoveronix.dto.AddressDto;
import by.vlad.test.taskoveronix.model.Address;
import by.vlad.test.taskoveronix.model.Coordinates;
import by.vlad.test.taskoveronix.model.LatAndLon;
import by.vlad.test.taskoveronix.repository.CoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AddressService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CoordinatesRepository coordinatesRepository;

    public List<AddressDto> getByAddress(String requestParams) {
        var addressDtos = restTemplate.exchange(
                "https://nominatim.openstreetmap.org/search?addressdetails=1&format=json&limit=50&" + requestParams,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AddressDto>>() {}
        ).getBody();
        for (AddressDto addressDto : addressDtos) {
            var latAndLon = new LatAndLon();

            latAndLon.setLat(addressDto.getLat());
            latAndLon.setLon(addressDto.getLon());

            var coordinates = new Coordinates();
            coordinates.setLatAndLon(latAndLon);

            coordinatesRepository.save(coordinates);
        }
        return addressDtos;
    }

    public List<AddressDto> getAllAddresses() {
        var coordinates = coordinatesRepository.findAll();
        List<AddressDto> response = new ArrayList<>();
        for (Coordinates coordinate : coordinates) {
            var lat = coordinate.getLatAndLon().getLat();
            var lon = coordinate.getLatAndLon().getLon();
            var addressDto = restTemplate.exchange(
                    "https://nominatim.openstreetmap.org/reverse?format=json&addressdetails=1&lat=" + lat + "&lon=" + lon,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<AddressDto>() {}
            ).getBody();

            response.add(addressDto);
        }
        return response;
    }
}
