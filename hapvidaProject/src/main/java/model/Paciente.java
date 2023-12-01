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
    @OneToOne
    private Sintomas sintomas;

    private String documento;
    private String pescricaoMedica;

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public Sintomas getSintomas() {
        return sintomas;
    }

    public void setSintomas(Sintomas sintomas) {
        this.sintomas = sintomas;
    }

    @Override
    public String getDocumento() {
        return documento;
    }

    @Override
    public void setDocumento(String documento) {
        this.documento = documento;
    }


    public String getPescricaoMedica() {
        return pescricaoMedica;
    }

    public void setPescricaoMedica(String pescricaoMedica) {
        this.pescricaoMedica = pescricaoMedica;
    }




}
