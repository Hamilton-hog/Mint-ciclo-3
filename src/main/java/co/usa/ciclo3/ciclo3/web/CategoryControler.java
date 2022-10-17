package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryControler {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategorys(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c){
        return categoryService.save(c);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category c) {
        return categoryService.update(c);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id) {
        return categoryService.deleteCategory(Id);
    }
}
