package view;

import session.SessionFactoryProvider;
import view.utils.MenuUtils;

public class MenuAcessoMedico extends MenuBase {
    
    public MenuAcessoMedico(SessionFactoryProvider sessionFactoryProvider) {
        super(sessionFactoryProvider);
    }


    @Override
    public void exibirOpcoes() {
        MenuUtils.limparConsole();
        System.out.println("1. Login");
        System.out.println("2. Cadastrar");
        System.out.println("0. Sair");
        int opcao = this.lerOpcao();
        this.processar(opcao);
    }

    @Override
    public void processar(int opcao) {
        switch (opcao) {
            case 1:
                new MenuLoginMedico(sessionFactoryProvider).exibirOpcoes();
                break;
            case 2:
                new MenuCadastrarMedico(sessionFactoryProvider).exibirOpcoes();
                break;
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}
