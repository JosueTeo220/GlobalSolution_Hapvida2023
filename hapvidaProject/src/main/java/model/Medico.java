package model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "medicos")
public class Medico extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "medico")
    private List<Paciente> pacientes;

}
