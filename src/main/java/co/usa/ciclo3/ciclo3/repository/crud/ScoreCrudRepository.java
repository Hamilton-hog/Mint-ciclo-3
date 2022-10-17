package usa.mintic.retos.repository.crud;

import org.springframework.data.repository.CrudRepository;
import usa.mintic.retos.entity.Reservation;
import usa.mintic.retos.entity.Score;

public interface ScoreCrudRepository extends CrudRepository<Score,Integer> {
}
