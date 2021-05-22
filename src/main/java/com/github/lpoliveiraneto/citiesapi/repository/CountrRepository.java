package com.github.lpoliveiraneto.citiesapi.repository;

import com.github.lpoliveiraneto.citiesapi.country.Country.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountrRepository extends JpaRepository<Country, Long> {
}
