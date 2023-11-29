package view;

import session.SessionFactoryProvider;
import view.utils.MenuUtils;

public class MenuVerificarConsultas extends MenuBase{
    public MenuVerificarConsultas(SessionFactoryProvider sessionFactoryProvider) {
        super(sessionFactoryProvider);
    }

    @Override
    public void exibirOpcoes() {
        MenuUtils.limparConsole();
        System.out.println("* CONSULTAS PASSADAS *\n");


    }
    

    @Override
    public void processar(int opcao) {

    }

}
