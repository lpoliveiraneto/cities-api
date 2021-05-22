package com.github.lpoliveiraneto.citiesapi;

import com.github.lpoliveiraneto.citiesapi.country.Country.Country;
import com.github.lpoliveiraneto.citiesapi.repository.CountrRepository;
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
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private CountrRepository repository;

//    @GetMapping
//    public List<Country> countries(){
//        return repository.findAll();
//    }

    //mesmo método para paginação
    @GetMapping
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Country> opCountry = repository.findById(id);
        if(opCountry.isPresent()){
            return ResponseEntity.ok().body(opCountry.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
