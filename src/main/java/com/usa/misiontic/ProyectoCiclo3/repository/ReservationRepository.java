package com.usa.misiontic.ProyectoCiclo3.repository;


import com.usa.misiontic.ProyectoCiclo3.entities.Reservation;
import com.usa.misiontic.ProyectoCiclo3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
    
    //Reto 5
    
    //public List<Reservation> getDatesReport(dateA,dateB){
    //    return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(A,B);
    //}
    //public List<Reservation> getStatusReport(String sts){
    //    return reservationCrudRepository.findAllStatus(sts);
    //}

    //public List<Object[]> getTopClients(){
    //    return reservationCrudRepository.getTopClients();
    //}

}
