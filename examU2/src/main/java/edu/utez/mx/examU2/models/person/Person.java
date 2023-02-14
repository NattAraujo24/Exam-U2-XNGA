package edu.utez.mx.examU2.models.person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "people")
@NoArgsConstructor
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 30)
    private String correo;
    @Column(nullable = false, unique = true, length = 18)
    private String contraseña;


    public Person(Long id, String name, String correo, String contraseña) {
        this.id = id;
        this.name = name;
        this.correo = correo;
        this.contraseña = contraseña;
    }
}

