package model;

import javax.persistence.*;

@Entity
public class Sintomas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "sintomas")
    private Paciente paciente;

    @Column(name = "febre")
    private boolean febre;

    @Column(name = "dor_de_cabeca")
    private boolean dorDeCabeca;

    @Column(name = "garganta_inflamada")
    private boolean gargantaInflamada;

    @Column(name = "problemas_respiratorios")
    private boolean problemasRespiratorios;

    @Column(name = "problemas_intestinais")
    private boolean problemasIntestinais;

    public boolean isFebre() {
        return febre;
    }

    public void setFebreFromChar(char input) {
        this.febre = (input == 'S');
    }

    public boolean isDorDeCabeca() {
        return febre;
    }

    public void setDorDeCabecaFromChar(char input) {
        this.dorDeCabeca = (input == 'S');
    }

    public boolean isGargantaInflamada() {
        return gargantaInflamada;
    }

    public void setGargantaInflamadaFromChar(char input) {
        this.gargantaInflamada = (input == 'S');
    }

    public boolean isProblemasRespiratorios() {
        return problemasRespiratorios;
    }

    public void setProblemasRespiratoriosFromChar(char input) {
        this.problemasRespiratorios = (input == 'S');
    }

    public boolean isProblemasIntestinais() {
        return problemasIntestinais;
    }

    public void setProblemasIntestinaisFromChar(char input) {
        this.problemasIntestinais = (input == 'S');
    }


}
