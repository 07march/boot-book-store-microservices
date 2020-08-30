package by.bookstoremicro.storeservice.store;

import by.bookstoremicro.storeservice.store.exceptions.StoreExistsException;
import by.bookstoremicro.storeservice.store.exceptions.StoreNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreRepositoryImpl implements StoreRepository {

    public List<Store> stores = new ArrayList<>();

    @Override
    public Store addStore(Store store) {
        if (stores.contains(store)) {
            throw new StoreExistsException("store already exist!");
        }
        stores.add(store);
        return store;
    }

    @Override
    public Store deleteStore(Store store) {
        if (stores.contains(store)) {
            stores.remove(store);
            return store;
        }
        throw new StoreNotFoundException("store not found!");
    }

    @Override
    public Store deleteStoreById(int id) {
        Store old;
        int count = 0;
        for (Store store : stores) {
            if (store.getId() == id) {
                old = store;
                stores.remove(id);
                return old;
            }
            count++;
        }
        throw new StoreNotFoundException("store not found!");
    }

    @Override
    public Store updateStoreName(Store storeName, int id) {
        Store old;
        for (Store store : stores) {
            if (store.getId() == id) {
                old = store;
                store.setStore(storeName.getStore());
                return old;
            }
        }
        throw new StoreNotFoundException("store not found!");
    }

    @Override
    public Store updateStoreAddress(Store storeAddress, int id) {
        Store old;
        for (Store store : stores) {
            if (store.getId() == id) {
                old = store;
                store.setAddress(storeAddress.getAddress());
                return old;
            }
        }
        throw new StoreNotFoundException("store not found!");
    }

    @Override
    public Store updateStoreCity(Store storeCity, int id) {
        Store old;
        for (Store store : stores) {
            if (store.getId() == id) {
                old = store;
                store.setCity(storeCity.getCity());
                return old;
            }
        }
        throw new StoreNotFoundException("store not found!");
    }

    @Override
    public List<Store> findAllStores() {
        return new ArrayList<>(stores);
    }

    @Override
    public Store findStoreByName(Store storeName) {
        for (Store store1 : stores) {
            if (store1.getStore().equals(storeName.getStore())) {
                return store1;
            }
        }
        throw new StoreNotFoundException("store not found!");
    }

    @Override
    public Store findStoreByAddress(Store storeAddress) {
        for (Store store1 : stores) {
            if (store1.getAddress().equals(storeAddress.getAddress())) {
                return store1;
            }
        }
        throw new StoreNotFoundException("store not found!");
    }

    @Override
    public Store findStoreByCity(Store storeCity) {
        for (Store store1 : stores) {
            if (store1.getCity().equals(storeCity.getCity())) {
                return store1;
            }
        }
        throw new StoreNotFoundException("store not found!");
    }

    @Override
    public Store findStoreById(int id) {
        for (Store store1 : stores) {
            if (store1.getId() == id) {
                return store1;
            }
        }
        throw new StoreNotFoundException("store not found!");
    }
}


