package edu.utez.mx.examU2.controllers.category;

import edu.utez.mx.examU2.dto.CategoryDto;
import edu.utez.mx.examU2.models.category.Category;
import edu.utez.mx.examU2.services.category.CategoryService;
import edu.utez.mx.examU2.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examU2/category/")
@CrossOrigin(origins = {"*"})
public class CategoryController {
    @Autowired
    private CategoryService service;
    //////////////////////////////////////////////////////
    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Category>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }
    //////////////////////////////////////////////////////
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Category>> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    //////////////////////////////////////////////////////
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Category>> insert(
            @RequestBody CategoryDto categoryDto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.insert(categoryDto.getCategory()),
                HttpStatus.CREATED
        );
    }

    //////////////////////////////////////////////////////
    @PutMapping("/")
    public ResponseEntity<CustomResponse<Category>> update(
            @RequestBody CategoryDto categoryDto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.update(categoryDto.getCategory()),
                HttpStatus.CREATED
        );
    }

    //////////////////////////////////////////////////////
    @PatchMapping("/")
    public ResponseEntity<CustomResponse<Integer>> enableOrDisable(
            @RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(
                this.service.changeStatus(categoryDto.getCategory()),
                HttpStatus.OK
        );
    }
}
