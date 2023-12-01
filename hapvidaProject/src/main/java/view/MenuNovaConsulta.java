package view;

import model.Medico;
import model.Paciente;
import model.Sintomas;
import org.hibernate.Session;
import org.hibernate.Transaction;
import session.SessionFactoryProvider;
import view.utils.MenuUtils;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MenuNovaConsulta extends MenuBase {

    public MenuNovaConsulta(SessionFactoryProvider sessionFactoryProvider) {
        super(sessionFactoryProvider);
    }

    @Override
    public void exibirOpcoes() {
        MenuUtils.limparConsole();
        System.out.println("* NOVA CONSULTA *\n");

        System.out.println("1. Nome Paciente: ");
        String pacienteNome = MenuUtils.lerTexto();

        System.out.println("2. Idade: ");
        int pacienteIdade = MenuUtils.lerNumero();

        System.out.println("3. Sexo [M ou F]: ");
        char pacienteSexo = MenuUtils.lerChar();

        System.out.println("4. Documento do paciente: ");
        String pacienteDocumento = MenuUtils.lerTexto();

        System.out.println("5. Descreva em texto os sintomas que o paciente apresenta: ");
        String descricaoGeral = MenuUtils.lerTexto();

        try {
            MenuUtils.aguardarTempoCurto();
            MenuUtils.limparConsole();
        } catch (Exception ex) {

        }

        System.out.println("\nPaciente pré-Cadastrado com sucesso!\n");
        System.out.println("Agora crie a senha temporária do paciente: ");
        System.out.println("Senha temporária: ");
        String pacienteSenhaTemporaria = MenuUtils.lerTexto();

        System.out.println("\nAgora vamos finalizar o cadastro do paciente");
        Sintomas sintomas = coletarSintomas();
        MenuUtils.limparConsole();

        System.out.println("\nAgora vamos finalizar o cadastro do paciente");

        System.out.println("Abaixo escreva a receita médica");
        String pacienteReceita = MenuUtils.lerTexto();


        System.out.println("\nAgora associe um médico para associar a receita:");

        List<Medico> medicosDisponiveis = obterMedicosDisponiveis();
        Medico medicoSelecionado = selecionarMedico(medicosDisponiveis);

        try (Session session = sessionFactoryProvider.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {


                Paciente paciente = new Paciente();
                paciente.setNome(pacienteNome);
                paciente.setIdade(pacienteIdade);
                paciente.setDocumento(pacienteDocumento);
                paciente.setPass(pacienteSenhaTemporaria);
                paciente.setDescricao(descricaoGeral);
                paciente.setPescricaoMedica(pacienteReceita);

                session.save(sintomas);

                paciente.setSintomas(sintomas);
                paciente.setMedico(medicoSelecionado);

                session.save(paciente);
                transaction.commit();


                MenuUtils.limparConsole();
                System.out.println("Registro realizado com sucesso!");
                MenuUtils.aguardarTempoMedio();


            } catch (Exception ex) {
                if (transaction != null) {
                    transaction.rollback();
                }
                ex.printStackTrace();
            }
            finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
                MenuUtils.limparConsole();
                System.out.println("Pronto!");
                System.out.println("Encerrando...");
                System.exit(0);
            }


        }
    }

    public Sintomas coletarSintomas() {
            System.out.println("\nQuais sintomas o paciente apresenta?");
            System.out.println("Responda com S ou N\n");
            System.out.print("Febre - (S ou N)\n");
            char sintomaFebre = MenuUtils.lerChar();
            validarInputSintoma("Febre", sintomaFebre);

            System.out.print("Dor de cabeça - (S ou N)\n");
            char sintomaDorCabeca = MenuUtils.lerChar();
            validarInputSintoma("Dor de cabeça", sintomaDorCabeca);

            System.out.print("Garganta infladamada: - (S ou N)\n");
            char sintomaGarganta = MenuUtils.lerChar();
            validarInputSintoma("Garganta inflamada", sintomaGarganta);

            System.out.print("Problemas respiratórios: - (S ou N)\n");
            char sintomaRespiratorio = MenuUtils.lerChar();
            validarInputSintoma("Problemas respiratórios", sintomaRespiratorio);

            System.out.print("Problemas intestinais: - (S ou N)\n");
            char sintomaIntestinal = MenuUtils.lerChar();
            validarInputSintoma("Problemas intestinais", sintomaIntestinal);


            Sintomas sintomas = new Sintomas();
            sintomas.setFebreFromChar(sintomaFebre);
            sintomas.setDorDeCabecaFromChar(sintomaDorCabeca);
            sintomas.setGargantaInflamadaFromChar(sintomaGarganta);
            sintomas.setProblemasRespiratoriosFromChar(sintomaRespiratorio);
            sintomas.setProblemasIntestinaisFromChar(sintomaIntestinal);



        return sintomas;
    }

    public char validarInputSintoma(String sintoma, char input) {
        while (input != 'S' && input != 'N') {
            try {
                System.out.println("* Lembre-se: Preencha com S ou N *");
                System.out.print("Digite para " + sintoma + ": ");
                input = MenuUtils.lerChar();
            } catch (Exception ex) {

            }
        }
        return input;
    }

    public List<Medico> obterMedicosDisponiveis() {
        try (Session session = sessionFactoryProvider.getSessionFactory().openSession()) {
            Query<Medico> query = session.createQuery("FROM Medico", Medico.class);
            return query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
    public Medico selecionarMedico(List<Medico> medicosDisponiveis) {
        System.out.println("Selecione um médico digitando o número correspondente:");
        for (int i = 0; i < medicosDisponiveis.size(); i++) {
            System.out.println((i + 1) + ". " + medicosDisponiveis.get(i).getNome());
        }

        int opcao = MenuUtils.lerNumero();
        if (opcao >= 1 && opcao <= medicosDisponiveis.size()) {
            return medicosDisponiveis.get(opcao - 1);
        } else {
            System.out.println("Opção inválida. Tente novamente.");
            return selecionarMedico(medicosDisponiveis);
        }
    }

    @Override
    public void processar(int opcao) {
        switch (opcao) {
            case 1:
                new MenuPrincipal(sessionFactoryProvider);
                break;
        }
    }
}
