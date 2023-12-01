package view;

import model.Medico;
import model.Paciente;
import org.hibernate.Session;
import org.hibernate.query.Query;
import session.SessionFactoryProvider;
import view.utils.MenuUtils;

public class MenuPaciente extends MenuBase{

    public MenuPaciente(SessionFactoryProvider sessionFactoryProvider) {
        super(sessionFactoryProvider);
    }
    @Override
    public void exibirOpcoes(){
        MenuUtils.limparConsole();
        System.out.println("* MENU LOGIN PACIENTE *\n");


        System.out.println("1. Digite seu documento");
        String documento = MenuUtils.lerTexto();

        System.out.println("2. Digite sua senha provisória");
        String senha = MenuUtils.lerTexto();

        try (Session session = sessionFactoryProvider.getSessionFactory().openSession()) {

            Query<Paciente> query = session.createQuery("FROM Paciente WHERE documento = :documento AND pass = :senha", Paciente.class);
            query.setParameter("documento", documento);
            query.setParameter("senha", senha);

            Paciente paciente = query.uniqueResult();

            if (paciente != null) {
                MenuUtils.limparConsole();
                System.out.println("Login bem-sucedido!");
                MenuUtils.aguardarTempoMedio();
                processar(1);
            } else {
                MenuUtils.limparConsole();
                System.out.println("Login falhou. Verifique suas credenciais.");
                MenuUtils.aguardarTempoMedio();
                session.getTransaction().rollback();
                processar(2);
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Override
    public void processar(int opcao) {
        switch (opcao) {
            case 1:
               new MenuVerificarConsultas(sessionFactoryProvider).exibirOpcoes();
                break;
            case 2:
                exibirOpcoes();
                break;
        }
    }
}
