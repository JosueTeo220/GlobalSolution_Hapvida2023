package view;



import session.SessionFactoryProvider;
import view.utils.MenuUtils;


public class MenuMedico extends MenuBase{

    public MenuMedico(SessionFactoryProvider sessionFactoryProvider) {
        super(sessionFactoryProvider);
    }


    @Override
    public void exibirOpcoes() {
        MenuUtils.limparConsole();
        System.out.println("* MENU MÉDICO AUTENTICADO *\n");

        System.out.println("1. Registrar nova consulta");
        int opcao = lerOpcao();
        processar(opcao);

    }
    

    @Override
    public void processar(int opcao) {
        switch (opcao) {
            case 1:
                new MenuNovaConsulta(sessionFactoryProvider).exibirOpcoes();;
               
                break;
        }
    }


}
