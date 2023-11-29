package view;

import session.SessionFactoryProvider;

public class MenuPrincipal extends MenuBase{
    private final SessionFactoryProvider sessionFactoryProvider;

    public MenuPrincipal(SessionFactoryProvider sessionFactoryProvider) {
        this.sessionFactoryProvider = sessionFactoryProvider;
    }
    @Override
    public void exibirOpcoes(){
        System.out.println("1. Sou Médico");
        System.out.println("2. Sou Paciente");
        System.out.println("0. Sair");
    }

    @Override
    public void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                new MenuAcessoMedico(sessionFactoryProvider).exibirOpcoes();
            case 2:
                new MenuLoginPaciente();
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
        }
    }
}
