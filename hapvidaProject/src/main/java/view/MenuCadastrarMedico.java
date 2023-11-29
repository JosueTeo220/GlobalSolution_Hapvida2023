package view;

import model.Medico;
import org.hibernate.Session;
import session.SessionFactoryProvider;
import view.utils.MenuUtils;

public class MenuCadastrarMedico extends MenuBase {
    private final SessionFactoryProvider sessionFactoryProvider;

    public MenuCadastrarMedico(SessionFactoryProvider sessionFactoryProvider) {
        this.sessionFactoryProvider = sessionFactoryProvider;
    }

    @Override
    public void exibirOpcoes() {
        MenuUtils.limparConsole();

        System.out.println("1. Digite sua CRM");
        String crm = MenuUtils.lerTexto();

        System.out.println("2. Digite sua senha");
        String senha = MenuUtils.lerTexto();

        System.out.println("Conta criada: " + crm + " " + senha);

        try (Session session = sessionFactoryProvider.getSessionFactory().openSession()) {
            session.beginTransaction();

            Medico medico = new Medico();
            medico.setDocumento(crm);
            medico.setPass(senha);

            session.save(medico);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        processarOpcao(1);
    }

    @Override
    public void processarOpcao(int opcao) {
        new MenuAcessoMedico(sessionFactoryProvider).exibirOpcoes();
    }
}