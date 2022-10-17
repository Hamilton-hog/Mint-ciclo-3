package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Category;
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
        return libService.getLib(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Lib save(@RequestBody Lib p){
        return libService.save(p);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Lib update(@RequestBody Lib p) {
        return libService.update(p);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id) {
        return libService.deleteLib(Id);
    }
}
