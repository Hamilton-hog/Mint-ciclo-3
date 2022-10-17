package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
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
            Optional<Reservation> paux=reservationRepository.getReservation(p.getIdReservation());
            if(paux.isEmpty()){
                return reservationRepository.save(p);
            }else{
                return p;
            }
        }
    }
    public Reservation update(Reservation r){
        if(r.getIdReservation()!=null){
            Optional<Reservation> paux= reservationRepository.getReservation(r.getIdReservation());
            if(!paux.isEmpty()){

                if(r.getStartDate()!=null){
                    paux.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    paux.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getStatus()!=null){
                    paux.get().setStatus(r.getStatus());
                }
                reservationRepository.save(paux.get());
                return paux.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
