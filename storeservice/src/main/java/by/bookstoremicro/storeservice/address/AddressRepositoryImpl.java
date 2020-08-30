package by.bookstoremicro.storeservice.address;

import by.bookstoremicro.storeservice.address.exceptions.AddressExistsException;
import by.bookstoremicro.storeservice.address.exceptions.AddressNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressRepositoryImpl implements AddressRepository {

    public List<Address> addresses = new ArrayList<>();

    @Override
    public Address addAddress(Address address) {
        if (addresses.contains(address)) {
            throw new AddressExistsException("address already exists!");
        }
        addresses.add(address);
        return address;
    }

    @Override
    public Address deleteAddress(Address address) {
        if (addresses.contains(address)) {
            addresses.remove(address);
            return address;
        }
        throw new AddressNotFoundException("address not found!");
    }

    @Override
    public Address deleteAddressById(int id) {
        Address old;
        int count = 0;
        for (Address address : addresses) {
            if (address.getId() == id) {
                old = address;
                addresses.remove(count);
                return old;
            }
            count++;
        }
        throw new AddressNotFoundException("address not found!");
    }

    @Override
    public Address updateAddress(Address address) {
        Address old;
        for (Address address1 : addresses) {
            if (address1.getId() == address.getId()) {
                old = address1;
                address1.setAddress(address.getAddress());
                return old;
            }
        }
        throw new AddressNotFoundException("address not found!");
    }

    @Override
    public List<Address> findAllAddresses() {
        return new ArrayList<>(addresses);
    }

    @Override
    public Address findAddressByName(String address) {
        for (Address address1 : addresses) {
            if (address1.getAddress().equals(address)) {
                return address1;
            }
        }
        throw new AddressNotFoundException("address not found!");
    }

    @Override
    public Address findAddressById(int id) {
        for (Address address1 : addresses) {
            if (address1.getId() == id) {
                return address1;
            }
        }
        throw new AddressNotFoundException("address not found!");
    }
}
