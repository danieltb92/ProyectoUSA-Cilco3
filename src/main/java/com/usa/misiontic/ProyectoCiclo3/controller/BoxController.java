package com.usa.misiontic.Proyectociclo3.controller;



import com.usa.misiontic.ProyectoCiclo3.entities.Box;
import com.usa.misiontic.Proyectociclo3.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Box")
public class BoxController {

    @Autowired
    private BoxService boxService;
    @GetMapping("/all")
    public List<Box> getAll(){
        return boxService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Box save(@RequestBody  Box box){
        return boxService.save(box);
    }
    
    @GetMapping("/id")
    public Optional<Box> getBox(@PathVariable("id")int id){
        return boxService.getBox(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Box update(@RequestBody  Box p){
        return boxService.update(p);
    }
    
    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int boxId){
        return boxService.deleteBox(boxId);
    }
}

