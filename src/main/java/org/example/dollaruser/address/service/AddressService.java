package org.example.dollaruser.address.service;

import java.util.List;
import lombok.RequiredArgsConstructor;

import org.example.dollaruser.address.dto.AddressRequestDto;
import org.example.dollaruser.address.dto.AddressResponseDto;
import org.example.dollaruser.address.entity.Address;
import org.example.dollaruser.address.repository.AddressRepository;
import org.example.dollaruser.user.entity.User;
import org.example.dollaruser.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public void createAddress(AddressRequestDto requestDto, User user) {
        User finduser = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        Address address = new Address(requestDto, finduser);
        addressRepository.save(address);
    }

    public List<AddressResponseDto> getUserAllAddress(User user) {
        return addressRepository.findAllByUser(user)
                .stream()
                .map(AddressResponseDto::new).toList();
    }

    public void updateAddress(Long addressId, AddressRequestDto requestDto, User user) {
        Address address = findOne(addressId);

        if(!address.getUser().getId().equals(user.getId())) {
            throw new IllegalArgumentException("해당 주소에 대한 권한이 없습니다.");
        }
        address.updateAddress(requestDto);
        addressRepository.save(address);
    }

    public void deleteAddress(Long addressId, User user) {
        Address address = findOne(addressId);

        if(!address.getUser().getId().equals(user.getId())) {
            throw new IllegalArgumentException("해당 주소에 대한 권한이 없습니다.");
        }
        addressRepository.delete(address);
    }

    private Address findOne(Long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new IllegalArgumentException("주소를 찾을 수 없습니다."));
    }
}
