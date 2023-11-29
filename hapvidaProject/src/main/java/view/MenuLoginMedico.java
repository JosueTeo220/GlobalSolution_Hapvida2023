package view;


import org.hibernate.query.Query;
import org.hibernate.Session;
import model.Medico;
import session.SessionFactoryProvider;
import view.utils.MenuUtils;

public class MenuLoginMedico extends MenuBase{
    
    public MenuLoginMedico(SessionFactoryProvider sessionFactoryProvider) {
        super(sessionFactoryProvider);
    }

    @Override
    public void exibirOpcoes(){
        MenuUtils.limparConsole();
        System.out.println("* MENU LOGIN MÉDICO *\n");
        

        System.out.println("1. Digite sua CRM");
        String crm = MenuUtils.lerTexto();

         System.out.println("2. Digite sua senha");
        String senha = MenuUtils.lerTexto();

        try (Session session = sessionFactoryProvider.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query<Medico> query = session.createQuery("FROM Medico WHERE documento = :crm AND pass = :senha", Medico.class);
            query.setParameter("crm", crm);
            query.setParameter("senha", senha);

      

            Medico medico = query.uniqueResult();

            if (medico != null) {
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
                new MenuMedico(sessionFactoryProvider).exibirOpcoes();;
                break;
            case 2:
                exibirOpcoes();
                break;
        }
    }
}
