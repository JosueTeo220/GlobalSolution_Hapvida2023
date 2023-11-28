package model;

import javax.persistence.*;

@Entity
public class Paciente extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;
    private String nome;
    private int idade;
    private Genero sexo;
    private Sintomas sintomas;
    private long documento;
    private String passProvisoria;
    private String pescricaoMedica;


}
