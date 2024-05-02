package org.example.dollaruser.address.controller;

import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.example.dollaruser.address.entity.Address;
import org.example.dollaruser.address.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/external")
public class FeignAddressController {

    private final AddressService addressService;

    @GetMapping("/address/{addressId}")
    public Address getAddress(@PathVariable Long addressId) {
        return addressService.findOne(addressId);
    }

    @PostMapping("/address/addressIdList")
    List<Address> findAddressListByAddressIdList(
        @RequestBody Set<Long> addressIdSet) {
        return addressService.findAddressListByAddressIdList(addressIdSet);
    }
}
