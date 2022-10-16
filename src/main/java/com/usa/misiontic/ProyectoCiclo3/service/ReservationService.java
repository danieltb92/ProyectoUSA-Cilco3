package com.usa.misiontic.Proyectociclo3.service;


import com.usa.misiontic.ProyectoCiclo3.entities.Reservation;
import com.usa.misiontic.ProyectoCiclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation p){
        if(p.getIdReservation()==null){
            return reservationRepository.save(p);
        }else{
            Optional<Reservation> e =reservationRepository.getReservation(p.getIdReservation());
            if(e.isPresent()){
                return p;
            }else{
                return reservationRepository.save(p);
            }
        }
    }
    public Reservation update(Reservation p){
        if(p.getIdReservation()!=null){
            Optional<Reservation> q =reservationRepository.getReservation(p.getIdReservation());
            if(q.isPresent()){
                if(p.getIdReservation()!=null){
                    q.get().setIdReservation(p.getIdReservation());   
                }
       
                if(p.getStarDate()!=null){
                    q.get().setStarDate(p.getStarDate());
                }
                if(p.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                reservationRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean deleteReservation(int id){
        boolean d = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
    
    
    //Reto 5
    
    //public List<Reservation> getReservationsByPeriod(String dateA,String dateB){
//
 //       SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
 //       Date a= new Date();
 //       Date b=new Date();
  //      try {
  //          a=parser.parse(dateA);
  //          b=parser.parse(dateB);
  //      }catch (ParseException e){
   //         e.printStackTrace();;
  //      }
  //      if(a.before(b)){
  //          return reservationRepository.getDatesReport(a,b);
  //      }else{
  //          return new ArrayList<Reservation>();
  //      }
 //   }
 //   public StatusAccount getReportByStatus(){
 //       List<Reservation> completes=reservationRepository.getStatusReport("completed");
 //       List<Reservation> cancelled=reservationRepository.getStatusReport("cancelled");
//
 //       StatusAccount resultado=new StatusAccount(completes.size(),cancelled.size());
 //       return resultado;

  //  }
 //   public List<TopClients> getTopclients(){
  //      List<TopClients> tc=new ArrayList<>();
 //       List<Object[]> result= reservationRepository.getTopClients();
//
  //      for(int i=0;i<result.size();i++){
  //          int total=Integer.parseInt(result.get(i)[1].toString());
  //          Client client= (Client) result.get(i)[0];
  //          TopClients topClient=new TopClients(total,client);
   //         tc.add(topClient);
  //      }
  //      return tc;
 //   }


}
