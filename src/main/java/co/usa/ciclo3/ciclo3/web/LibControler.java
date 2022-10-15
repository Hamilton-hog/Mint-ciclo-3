package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Lib;
import co.usa.ciclo3.ciclo3.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Lib")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class LibControler {

    @Autowired
    private LibService libService;

    @GetMapping("/all")
    public List<Lib> getLibs(){
        return libService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Lib> getLib(@PathVariable("id") int id){
        return libService.getPapeleria(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Lib save(@RequestBody Lib p){
        return libService.save(p);
    }
}
