package com.usa.misiontic.Proyectociclo3.service;


import com.usa.misiontic.ProyectoCiclo3.entities.Box;
import com.usa.misiontic.Proyectociclo3.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoxService {

    @Autowired
    private BoxRepository boxRepository;

    public List<Box> getAll(){
        return boxRepository.getAll();
    }
    public Optional<Box> getBox(int id){
        return boxRepository.getBox(id);
    }
    public Box save(Box box){
        if(box.getId()==null){
            return boxRepository.save(box);
        }else{
            Optional<Box> e = boxRepository.getBox(box.getId());
            if(e.isPresent()){
                return box;
            }else{
                return boxRepository.save(box);
            }
        }
    }
    public Box update(Box box){
        if(box.getId()!=null){
            Optional<Box> q = boxRepository.getBox(box.getId());
            if(q.isPresent()){
                if(box.getName()!=null){
                    q.get().setName(box.getName());
                }
                if(box.getDescription()!=null){
                    q.get().setDescription(box.getDescription());
                }
                if(box.getLocation()!=null){
                    q.get().setLocation(box.getLocation());
                }
                if(box.getCapacity()!=null){
                    q.get().setCapacity(box.getCapacity());
                }
                if(box.getCategory()!=null){
                    q.get().setCategory(box.getCategory());
                }

                boxRepository.save(q.get());
                return q.get();
            }else{
                return box;
            }
        }else{
            return box;
        }
    }
    public boolean deleteBox(int id){
        boolean d = getBox(id).map(box -> {
            boxRepository.delete(box);
            return true;
        }).orElse(false);
        return d;
    }


}
