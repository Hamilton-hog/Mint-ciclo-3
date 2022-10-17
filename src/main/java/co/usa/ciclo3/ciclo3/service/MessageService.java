package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Lib;
import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message g){
        if(g.getIdMessage()==null){
            return messageRepository.save(g);
        }else{
            Optional<Message> paux=messageRepository.getMessage(g.getIdMessage());
            if(paux.isEmpty()){
                return messageRepository.save(g);
            }else{
                return g;
            }
        }
    }
    public Message update(Message r){
        if(r.getIdMessage()!=null){
            Optional<Message> paux= messageRepository.getMessage(r.getIdMessage());
            if(!paux.isEmpty()){

                if(r.getMessageText()!=null){
                    paux.get().setMessageText(r.getMessageText());
                }
                messageRepository.save(paux.get());
                return paux.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }
    public boolean deleteMessage(int IdMessage) {
        Boolean aBoolean = getMessage(IdMessage).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
