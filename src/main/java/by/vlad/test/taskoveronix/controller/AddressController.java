package by.vlad.test.taskoveronix.controller;

import by.vlad.test.taskoveronix.model.Address;
import by.vlad.test.taskoveronix.service.AddressService;
import by.vlad.test.taskoveronix.dto.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public List<AddressDto> getByAddress(HttpServletRequest httpServletRequest) {
        var requestParams = httpServletRequest.getParameterMap().entrySet().stream()
                .map(stringEntry -> stringEntry.getKey() + "=" + String.join(",", stringEntry.getValue()))
                .collect(Collectors.joining("&"));

        return addressService.getByAddress(requestParams);
    }

    @GetMapping("/addresses")
    public List<AddressDto> getAllAddressesFromDB() {
        return addressService.getAllAddresses();
    }
}
