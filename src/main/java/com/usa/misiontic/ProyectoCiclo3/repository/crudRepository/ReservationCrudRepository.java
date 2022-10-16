package com.usa.misiontic.ProyectoCiclo3.repository.crudRepository;

import com.usa.misiontic.ProyectoCiclo3.entities.Reservation;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
    
    //Reto 5
    
    //@Query(select c.category, COUNT(c.category) FROM Reservation AS c group by c.category order by COUNT(c.category)desc)
    //public List<Object[]> countTotalReservationByCategory();
    
    //public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    //public List<Reservation> findAllByDescription(String description);
}
