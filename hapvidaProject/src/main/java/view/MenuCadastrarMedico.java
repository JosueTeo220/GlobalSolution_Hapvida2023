package view;

import model.Medico;
import org.hibernate.Session;
import session.SessionFactoryProvider;
import view.utils.MenuUtils;

public class MenuCadastrarMedico extends MenuBase {

    public MenuCadastrarMedico(SessionFactoryProvider sessionFactoryProvider) {
        super(sessionFactoryProvider);
    }

    @Override
    public void exibirOpcoes() {
        MenuUtils.limparConsole();
        System.out.println("* MENU CADASTRO MÉDICO *\n");

        System.out.println("1. Digite sua CRM");
        String crm = MenuUtils.lerTexto();

        System.out.println("2. Digite sua senha");
        String senha = MenuUtils.lerTexto();


        try (Session session = sessionFactoryProvider.getSessionFactory().openSession()) {
            System.out.println("Criando conta...");
            MenuUtils.aguardarTempoCurto();

            session.beginTransaction();

            Medico medico = new Medico();
            medico.setDocumento(crm);
            medico.setPass(senha);

            session.save(medico);
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        }

        
        processar(1);
    }

    @Override
    public void processar(int opcao) {
        try {
            System.out.println("Conta criada com sucesso!");
            MenuUtils.aguardarTempoMedio();        
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        new MenuAcessoMedico(sessionFactoryProvider).exibirOpcoes();
    }
}