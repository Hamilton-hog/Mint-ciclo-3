package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageControler {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getMesages(){
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id){
        return messageService.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message p){
        return messageService.save(p);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message p) {
        return messageService.update(p);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id) {
        return messageService.deleteMessage(Id);
    }
}
