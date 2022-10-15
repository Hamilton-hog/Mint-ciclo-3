package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Lib;
import co.usa.ciclo3.ciclo3.repository.LibRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibService {
    @Autowired
    private LibRepository libRepository;

    public List<Lib> getAll(){
        return libRepository.getAll();
    }

    public Optional<Lib> getPapeleria(int id){
        return libRepository.getLib(id);
    }

    public Lib save(Lib p){
        if(p.getId()==null){
            return libRepository.save(p);
        }else{
            Optional<Lib> paux= libRepository.getLib(p.getId());
            if(paux.isEmpty()){
                return libRepository.save(p);
            }else{
                return p;
            }
        }
    }
}
