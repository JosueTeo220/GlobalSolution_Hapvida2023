package view;

import session.SessionFactoryProvider;
import view.utils.MenuUtils;

public class MenuPrincipal extends MenuBase{

    public MenuPrincipal(SessionFactoryProvider sessionFactoryProvider) {
        super(sessionFactoryProvider);
    }

    @Override
    public void exibirOpcoes(){
        MenuUtils.limparConsole();
        System.out.println("Escolha uma opção: ");
        System.out.println("1. Sou Médico");
        System.out.println("2. Sou Paciente");
        System.out.println("0. Sair");
    }

    @Override
    public void processar(int opcao) {
        switch (opcao) {
            case 1:
                new MenuAcessoMedico(sessionFactoryProvider).exibirOpcoes();
                break;
            case 2:
                new MenuPaciente(sessionFactoryProvider).exibirOpcoes();
                break;
            case 3:
                System.out.println("Saindo...");
                System.exit(0);
                break;
        }
    }
}
