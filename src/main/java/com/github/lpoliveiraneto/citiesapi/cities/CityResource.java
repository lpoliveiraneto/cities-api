package com.github.lpoliveiraneto.citiesapi.cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityResource {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public Page<City> cities(final Pageable page){
        return cityRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCity(@PathVariable Long id){
        Optional<City> opCity  = cityRepository.findById(id);

        if(opCity.isPresent()){
             return ResponseEntity.ok().body(opCity.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
