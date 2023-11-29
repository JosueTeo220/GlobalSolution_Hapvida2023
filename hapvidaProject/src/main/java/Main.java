import model.Medico;
import model.Paciente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import view.Menu;
import view.MenuPrincipal;



public class Main {
    public static void main(String[] args) {


        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();


        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Medico.class)
                .addAnnotatedClass(Paciente.class)
                .getMetadataBuilder()
                .build();

        try (SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
             Session session = sessionFactory.openSession()) {

            Menu menuAtual = new MenuPrincipal();

  
            menuAtual.exibirOpcoes();
            int opcao = menuAtual.lerOpcao();
            menuAtual.processarOpcao(opcao);


        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}