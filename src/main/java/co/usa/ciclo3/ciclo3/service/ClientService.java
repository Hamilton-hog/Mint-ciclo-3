package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client f){
        if(f.getIdClient()==null){
            return clientRepository.save(f);
        }else{
            Optional<Client> paux=clientRepository.getClient(f.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.save(f);
            }else{
                return f;
            }
        }
    }
    public Client update(Client r){
        if(r.getIdClient()!=null){
            Optional<Client> paux= clientRepository.getClient(r.getIdClient());
            if(!paux.isEmpty()){

                if(r.getEmail()!=null){
                    paux.get().setEmail(r.getEmail());
                }
                if(r.getPassword()!=null){
                    paux.get().setPassword(r.getPassword());
                }
                if(r.getName()!=null){
                    paux.get().setName(r.getName());
                }
                if(r.getAge()!=null){
                    paux.get().setAge(r.getAge());
                }
                clientRepository.save(paux.get());
                return paux.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }
    public boolean deleteClient(int IdClient) {
        Boolean aBoolean = getClient(IdClient).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
