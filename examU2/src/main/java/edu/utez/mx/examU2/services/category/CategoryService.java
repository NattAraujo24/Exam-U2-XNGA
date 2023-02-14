package edu.utez.mx.examU2.services.category;

import edu.utez.mx.examU2.models.category.Category;
import edu.utez.mx.examU2.models.category.CategoryRepository;
import edu.utez.mx.examU2.utils.CustomResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
//////////////////////////////////////////////////////
    @Transactional(readOnly = true)
    public CustomResponse<List<Category>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }
    //////////////////////////////////////////////////////
    @Transactional(readOnly = true)
    public CustomResponse<Category> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,
                200,
                "Ok"
        );
    }
    //////////////////////////////////////////////////////
    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Category> insert(Category category){
        if(this.repository.existsByName(category.getName()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "La categoría ya esta registrada =("
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(category),
                false,
                200,
                "Categoría registrada =)"
        );
    }
    //////////////////////////////////////////////////////
    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Category> update(Category category){
        if(!this.repository.existsById(category.getId()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "La categoría no existe =("
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(category),
                false,
                200,
                "Categoría actualizada =)"
        );
    }
    //////////////////////////////////////////////////////
    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Integer> changeStatus(Category category){
        if(!this.repository.existsById(category.getId())){
            return new CustomResponse<>(
                    0,
                    true,
                    400,
                    "La categoría no existe =("
            );
        }
        return new CustomResponse<>(
                this.repository.updateStatusById(
                        category.getStatus(), category.getId()
                ),
                false,
                200,
                "Categoría actualizada =)"
        );
    }
}

