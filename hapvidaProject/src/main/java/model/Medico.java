package model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Medico")
public class Medico extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "medico")
    private List<Paciente> pacientes;

    private String Nome;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }




}
