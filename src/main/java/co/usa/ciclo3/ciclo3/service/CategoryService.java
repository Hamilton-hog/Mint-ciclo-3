package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category>getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category>getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save(Category p){
        if(p.getId()==null){
            return categoryRepository.save(p);
        }else{
            Optional<Category> paux=categoryRepository.getCategory(p.getId());
            if(paux.isEmpty()){
                return categoryRepository.save(p);
            }else{
                return p;
            }
        }
    }
    public Category update(Category r){
        if(r.getId()!=null){
            Optional<Category> paux= categoryRepository.getCategory(r.getId());
            if(!paux.isEmpty()){

                if(r.getName()!=null){
                    paux.get().setName(r.getName());
                }
                if(r.getDescription()!=null){
                    paux.get().setDescription(r.getDescription());
                }
                categoryRepository.save(paux.get());
                return paux.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }
    public boolean deleteCategory(int Id) {
        Boolean aBoolean = getCategory(Id).map(categoria -> {
            categoryRepository.delete(categoria);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
