package by.bookstoremicro.storeservice.address;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address) {
        return addressRepository.addAddress(address);
    }

    @Override
    public Address deleteAddress(Address address) {
        return addressRepository.deleteAddress(address);
    }

    @Override
    public Address deleteAddressById(int id) {
        return addressRepository.deleteAddressById(id);
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.updateAddress(address);
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAllAddresses();
    }

    @Override
    public Address findAddressByName(String address) {
        return addressRepository.findAddressByName(address);
    }

    @Override
    public Address findAddressById(int id) {
        return addressRepository.findAddressById(id);
    }

}
