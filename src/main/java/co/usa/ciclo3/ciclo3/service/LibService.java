package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Client;
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

    public Optional<Lib> getLib(int id){
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
    public Lib update(Lib r){
        if(r.getId()!=null){
            Optional<Lib> paux= libRepository.getLib(r.getId());
            if(!paux.isEmpty()){

                if(r.getName()!=null){
                    paux.get().setName(r.getName());
                }
                if(r.getTarget()!=null){
                    paux.get().setTarget(r.getTarget());
                }
                if(r.getTarget()!=null){
                    paux.get().setTarget(r.getTarget());
                }
                if(r.getCapacity()!=null){
                    paux.get().setCapacity(r.getCapacity());
                }
                if(r.getDescription()!=null){
                    paux.get().setDescription(r.getDescription());
                }
                if(r.getCategory()!=null){
                    paux.get().setCategory(r.getCategory());
                }
                libRepository.save(paux.get());
                return paux.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }
    public boolean deleteLib(int IdLib) {
        Boolean aBoolean = getLib(IdLib).map(client -> {
            libRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
