package by.bookstoremicro.storeservice.city;

import by.bookstoremicro.storeservice.city.exceptions.CityNotFoundException;
import by.bookstoremicro.storeservice.city.exceptions.ExistsException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityRepositoryImpl implements CityRepository {

    private List<City> cities = new ArrayList<>();

    @Override
    public City addCity(City city) {
        if (cities.contains(city)) {
            throw new ExistsException("city already exists!");
        }
        cities.add(city);
        return city;
    }

    @Override
    public City deleteCity(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
            return city;
        }
        throw new CityNotFoundException("city not found!");
    }

    @Override
    public City deleteCityById(int id) {
        City old;
        int count = 0;
        for (City city : cities) {
            if (city.getId() == id) {
                old = city;
                cities.remove(id);
                return old;
            }
            count++;
        }
        throw new CityNotFoundException("city not found!");
    }

    @Override
    public City updateCity(City city) {
        City old = null;
        for (City city1 : cities) {
            if (city1.getId() == city.getId()) {
                old = city1;
                city1.setCity(city.getCity());
                return old;

            }
        }
        throw new CityNotFoundException("city not found!");
    }

    @Override
    public List<City> findAllCities() {
        return new ArrayList<>(cities);
    }

    @Override
    public City findCityByName(City city) {
        for (City city1 : cities) {
            if (city1.getCity().equals(city.getCity())) {
                return city1;
            }
        }
        throw new CityNotFoundException("city not found!");
    }

    @Override
    public City findCityById(int id) {
        for (City city1 : cities) {
            if (city1.getId() == id) {
                return city1;
            }
        }
        throw new CityNotFoundException("city not found!");
    }
}
