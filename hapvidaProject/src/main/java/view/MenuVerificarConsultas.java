package view;

import model.Paciente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import session.SessionFactoryProvider;
import view.utils.MenuUtils;

import java.util.List;

public class MenuVerificarConsultas extends MenuBase{
    public MenuVerificarConsultas(SessionFactoryProvider sessionFactoryProvider) {
        super(sessionFactoryProvider);
    }

    @Override
    public void exibirOpcoes() {
        MenuUtils.limparConsole();
        System.out.println("* CONSULTAS PASSADAS *\n");

        System.out.println("Por questãoes de segurança, confirme seu Documento: ");
        String documento = MenuUtils.lerTexto();

        List<Paciente> consultas = obterConsultasPorPaciente(documento);

        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada para o paciente com ID " + documento);
        } else {
            MenuUtils.limparConsole();
            System.out.println("Consultas para o paciente Documento " + documento + ":\n");
            for (Paciente consulta : consultas) {
                System.out.println("Médico: " + consulta.getMedico().getNome());
                System.out.println("Receita: " + consulta.getPescricaoMedica());
                System.out.println("------------------------------");
                System.exit(0);
            }
        }
    }

    private List<Paciente> obterConsultasPorPaciente(String documento) {
        try (Session session = sessionFactoryProvider.getSessionFactory().openSession()) {
            Query<Paciente> query = session.createQuery(
                    "FROM Paciente p LEFT JOIN FETCH p.medico WHERE p.documento = :documento", Paciente.class);
            query.setParameter("documento", documento);
            return query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return List.of();
        }
    }

    @Override
    public void processar(int opcao) {

    }

}
