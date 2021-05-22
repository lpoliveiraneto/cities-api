package com.github.lpoliveiraneto.citiesapi.staties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staties")
public class StateResource {

    @Autowired
    private StateRepository stateRepository;

    @GetMapping
    public List<State> staties(){
        return stateRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getState(@PathVariable Long id){
        Optional<State> opState = stateRepository.findById(id);

        if(opState.isPresent()){
            return ResponseEntity.ok().body(opState.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
