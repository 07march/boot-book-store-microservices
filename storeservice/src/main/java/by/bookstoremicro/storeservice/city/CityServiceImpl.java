package by.bookstoremicro.storeservice.city;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City addCity(City city) {
        return cityRepository.addCity(city);
    }

    @Override
    public City deleteCity(City city) {
        return cityRepository.deleteCity(city);
    }

    @Override
    public City deleteCityById(int id) {
        return cityRepository.deleteCityById(id);
    }

    @Override
    public City updateCity(City city) {
        return cityRepository.updateCity(city);
    }

    @Override
    public List<City> findAllCities() {
        return cityRepository.findAllCities();
    }

    @Override
    public City findCityByName(City city) {
        return cityRepository.findCityByName(city);
    }

    @Override
    public City findCityById(int id) {
        return cityRepository.findCityById(id);
    }

}
