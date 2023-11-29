package view;

import session.SessionFactoryProvider;
import view.utils.MenuUtils;

public class MenuNovaConsulta extends MenuBase {

        public MenuNovaConsulta(SessionFactoryProvider sessionFactoryProvider) {
            super(sessionFactoryProvider);
        }

        @Override
        public void exibirOpcoes() {
            MenuUtils.limparConsole();
            System.out.println("* NOVA CONSULTA *\n");
    
            System.out.print("1. Nome Paciente: ");

            System.out.println("2. Verificar consultas anteriores");
            int opcao = lerOpcao();
            processar(opcao);
    
        }
        
    
        @Override
        public void processar(int opcao) {
            switch (opcao) {
                case 1:
                    new MenuNovaConsulta(sessionFactoryProvider);
                   
                    break;
                case 2:
                    new MenuCadastrarMedico(sessionFactoryProvider).exibirOpcoes();
                    break;
            }
        }
}
