package edu.utez.mx.examU2.models.transaccion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "people")
@NoArgsConstructor
@Setter
@Getter
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idT;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idU;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idP;


    public Transaccion(Long idT,Long idU,Long idP) {
        this.idT = idT;
        this.idU = idT;
        this.idP = idT;
    }
}


