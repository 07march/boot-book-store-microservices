package by.bookstoremicro.storeservice.address;

import java.util.List;

public interface AddressService {

    Address addAddress(Address address);
    Address deleteAddress(Address address);
    Address deleteAddressById(int id);
    Address updateAddress(Address address);
    List<Address> findAllAddresses();
    Address findAddressByName(String address);
    Address findAddressById(int id);

}
