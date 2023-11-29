package view;

public class MenuLoginMedico extends MenuBase{
    



    @Override
    public void exibirOpcoes(){
        System.out.println("1. Olaaa");
        System.out.println("2. Sou Paciente");
        System.out.println("0. Sair");
    }

    @Override
    public void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                new MenuLoginMedico();
                break;
            case 2:
                new MenuLoginPaciente();
                break;
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
        }
    }
}
