package by.bookstoremicro.storeservice.store;

import by.bookstoremicro.storeservice.address.Address;
import by.bookstoremicro.storeservice.address.AddressRepository;
import by.bookstoremicro.storeservice.city.City;
import by.bookstoremicro.storeservice.city.CityRepository;
import by.bookstoremicro.storeservice.store.exceptions.StoreAddressNotFoundException;
import by.bookstoremicro.storeservice.store.exceptions.StoreCityNotFoundException;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;

    @Override
    public Store addStore(Store store) {
        int cityId = store.getCity().getId();
        int addressId = store.getAddress().getId();
        City cityById = cityRepository.findCityById(cityId);
        if (cityById == null) throw new StoreCityNotFoundException("Store city " + store.getId() + " not found!");
        Address addressById = addressRepository.findAddressById(addressId);
        if (addressById == null)
            throw new StoreAddressNotFoundException("Store address " + store.getId() + " not found!");
        store.setCity(cityById);
        store.setAddress(addressById);
        return storeRepository.addStore(store);
    }

    @Override
    public Store deleteStore(Store store) {
        return storeRepository.deleteStore(store);
    }

    @Override
    public Store deleteStoreById(int id) {
        return storeRepository.deleteStoreById(id);
    }

    @Override
    public List<Store> findAllStores() {
        return storeRepository.findAllStores();
    }

    @Override
    public Store updateStoreName(Store storeName, int id) {
        return storeRepository.updateStoreName(storeName, id);
    }

    @Override
    public Store updateStoreAddress(Store storeAddress, int id) {
        return storeRepository.updateStoreAddress(storeAddress, id);
    }

    @Override
    public Store updateStoreCity(Store storeCity, int id) {
        return storeRepository.updateStoreCity(storeCity, id);
    }

    @Override
    public Store findStoreByName(Store storeName) {
        return storeRepository.findStoreByName(storeName);
    }

    @Override
    public Store findStoreByAddress(Store storeAddress) {
        return storeRepository.findStoreByAddress(storeAddress);
    }

    @Override
    public Store findStoreByCity(Store storeCity) {
        return storeRepository.findStoreByCity(storeCity);
    }

    @Override
    public Store findStoreById(int id) {
        return storeRepository.findStoreById(id);
    }

}
