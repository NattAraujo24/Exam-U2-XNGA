package edu.utez.mx.examU2.controllers.person;

import edu.utez.mx.examU2.services.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping("/examU2/person/")
@CrossOrigin(origins = {"*"})
public class PersonController {
    @Autowired
    private PersonService service;

    //////////////////////////////////////////////////////
    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Person>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    //////////////////////////////////////////////////////
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Person>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    //////////////////////////////////////////////////////
    @PostMapping
    public ResponseEntity<CustomResponse<Person>> insert(
            @Valid @RequestBody PersonDto personDto){
        return new ResponseEntity<>(
                this.service.insert(personDto.getPerson()),
                HttpStatus.CREATED
        );
    }

    //////////////////////////////////////////////////////
    @PutMapping("/")
    public ResponseEntity<CustomResponse<Person>> update(
            @RequestBody PersonDto personDto,@Valid BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.update(personDto.getPerson()),
                HttpStatus.CREATED
        );
    }

    //////////////////////////////////////////////////////
    @PatchMapping("/")
    public ResponseEntity<CustomResponse<Integer>> enableOrDisable(
            @RequestBody PersonDto personDto){
        return new ResponseEntity<>(
                this.service.changeStatus(personDto.getPerson()),
                HttpStatus.OK
        );
    }
}
