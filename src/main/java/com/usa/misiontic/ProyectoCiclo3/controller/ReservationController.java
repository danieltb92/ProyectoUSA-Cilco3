package com.usa.misiontic.Proyectociclo3.controller;


import com.usa.misiontic.ProyectoCiclo3.entities.Reservation;
import com.usa.misiontic.Proyectociclo3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody  Reservation p){
        return reservationService.save(p);
    }
    
    //Reto 4
    
    @GetMapping("/id")
    public Optional<Reservation> getReservation(@PathVariable("id")int id){
        return reservationService.getReservation(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody  Reservation p){
        return reservationService.update(p);
    }
    
    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int reservationId){
        return reservationService.deleteReservation(reservationId);
    }
   
    //Reto 5
    
    //@GetMapping("/report-dates/{dateA}/{dateB}")
    //public List<Reservation> getDatesReport(@PathVariable("dateA")String da,@PathVariable("dateB")String db ){
    //    return reservationService.getReservationsByPeriod(da,db);
    //}
    //@GetMapping("/report-status")
   // public StatusAccount getStatus(){
    //    return reservationService.getReportByStatus();
    //}
    //@GetMapping("/report-clients")
    //public List<TopClients> getTopClients(){
    //    return reservationService.getTopClients();
    //}
    
    
    
}
