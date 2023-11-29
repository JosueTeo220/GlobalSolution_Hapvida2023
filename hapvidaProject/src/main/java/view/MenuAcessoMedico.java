package view;

import view.utils.MenuUtils;

public class MenuAcessoMedico extends MenuBase {
    @Override
    public void exibirOpcoes(){
        MenuUtils.limparConsole();
        System.out.println("1. Login");
        System.out.println("2. Cadastrar");
        System.out.println("0. Sair");
        int opcao = this.lerOpcao();
        this.processarOpcao(opcao);

    }

    @Override
    public void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                MenuLoginMedico menuLogin = new MenuLoginMedico();
                menuLogin.exibirOpcoes();
                break;
            case 2:
                new MenuCadastrarMedico().exibirOpcoes();
                break;
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
        }
    }
}
