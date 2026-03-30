package com.address.service.impl;

import com.address.model.dto.AddressDto;
import com.address.model.dto.AddressRequest;
import com.address.model.dto.AddressRequestDto;
import com.address.model.entity.Address;
import com.address.repository.AddressRepository;
import com.address.service.AddressService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public AddressServiceImpl(AddressRepository addressRepository,
    ModelMapper modelMapper){
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<AddressDto> saveAddress(AddressRequest addressRequest) {
        // TODO: check if employee exists

        List<Address> listToSave =  this.saveOrUpdateAddressRequest(addressRequest);
        List<Address> savedAddress =  addressRepository.saveAll(listToSave);
        return savedAddress.stream().map(address -> modelMapper.map(address, AddressDto.class)).toList();
    }

    @Override
    public List<AddressDto> updateAddress(AddressRequest addressRequest) {
        // TODO: check if employee exists

        List<Address> addressByEmpId =  addressRepository.findAllByEmpId(addressRequest.getEmpId());
        if(addressByEmpId.isEmpty()){
            log.info("No address found for employee id {} ", addressRequest.getEmpId());
            log.info("Creating new address for employee id {} ", addressRequest.getEmpId());
        }
        List<Address> listToUpdate = this.saveOrUpdateAddressRequest(addressRequest);


        return null;
    }

    @Override
    public AddressDto getSingleAddress(Long id) {
        return null;
    }

    @Override
    public List<AddressDto> getAllAddress() {
        return List.of();
    }

    @Override
    public void deleteAddress(Long id) {

    }

    private List<Address> saveOrUpdateAddressRequest(AddressRequest addressRequest){
        List<Address> listToSave = new ArrayList<>();
        for (AddressRequestDto addressRequestDto : addressRequest.getAddressRequestDtoList()){
            Address address = new Address();
            address.setId(addressRequestDto.getId() != null ? addressRequestDto.getId() : null);
            address.setStreet(addressRequestDto.getStreet());
            address.setCity(addressRequestDto.getCity());
            address.setCountry(addressRequestDto.getCountry());
            address.setPinCode(addressRequestDto.getPinCode());
            address.setAddressType(addressRequestDto.getAddressType());
            address.setEmpId(addressRequest.getEmpId());
            listToSave.add(address);

        }
        return listToSave;

    }
}
