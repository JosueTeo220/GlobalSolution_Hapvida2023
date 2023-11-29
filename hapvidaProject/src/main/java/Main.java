import model.Medico;
import model.Paciente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import session.SessionFactoryProvider;
import view.Menu;
import view.MenuPrincipal;



public class Main implements SessionFactoryProvider {
    private final SessionFactory sessionFactory;

    public Main() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Medico.class)
                .addAnnotatedClass(Paciente.class)
                .getMetadataBuilder()
                .build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        try (Session session = sessionFactory.openSession()) {
            Menu menuAtual = new MenuPrincipal(this);

            menuAtual.exibirOpcoes();
            int opcao = menuAtual.lerOpcao();
            menuAtual.processar(opcao);
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(sessionFactory.getSessionFactoryOptions().getServiceRegistry());
        }
    }
}