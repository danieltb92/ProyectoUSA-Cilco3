package com.usa.misiontic.ProyectoCiclo3.service;


import com.usa.misiontic.ProyectoCiclo3.entities.Score;
import com.usa.misiontic.ProyectoCiclo3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int score){
        return scoreRepository.getScore(score);
    }
    public Score save(Score p){
        if(p.getIdScore()==null){
            return scoreRepository.save(p);
        }else{
            Optional<Score> e =scoreRepository.getScore(p.getIdScore());
            if(e.isPresent()){
                return p;
            }else{
                return scoreRepository.save(p);
            }
        }
    }
    public Score update(Score p){
        if(p.getIdScore()!=null){
            Optional<Score> q =scoreRepository.getScore(p.getIdScore());
            if(q.isPresent()){
                if(p.getIdScore()!=null){
                    q.get().setIdScore(p.getIdScore());   
                }
                
                scoreRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean deleteScore(int id){
        boolean d = getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return d;
    }


}
