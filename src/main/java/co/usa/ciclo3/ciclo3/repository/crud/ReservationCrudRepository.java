package co.usa.ciclo3.ciclo3.repository.crud;

import co.usa.ciclo3.ciclo3.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date d1, Date d2);
    public List<Reservation> findAllByStatus(String sts);
    @Query("SELECT c.client,COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT (c.client) DESC")
    public List<Object[]>getTopClients();
}
