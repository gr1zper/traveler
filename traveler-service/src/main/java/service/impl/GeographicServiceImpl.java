package service.impl;

import org.app.infra.util.CommonUtil;
import org.app.model.entity.geography.City;
import service.GeographicService;

import java.util.ArrayList;
import java.util.List;

public class GeographicServiceImpl implements GeographicService {

    /**
     * Internal list of the cities
     */
    private final List<City> cities;

    public GeographicServiceImpl() {
        cities = new ArrayList<>();
    }

    @Override
    public List<City> findCities() {
        return CommonUtil.getSafeList(cities);
    }

    @Override
    public void saveCity(City city) {
        if(!cities.contains(city)) {
            cities.add(city);
        }
    }
}
