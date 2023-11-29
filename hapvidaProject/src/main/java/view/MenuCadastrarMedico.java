package view;

import model.Medico;
import org.hibernate.Session;
import view.utils.MenuUtils;

public class MenuCadastrarMedico extends MenuBase {

    @Override
    public void exibirOpcoes(){
        MenuUtils.limparConsole();

        System.out.println("1. Digite sua CRM");
        String crm = MenuUtils.lerTexto();

        System.out.println("2. Digite sua senha");
        String senha = MenuUtils.lerTexto();

        System.out.println("Conta criada: " + crm + " " + senha);

        Medico medico = new Medico();
        medico.setDocumento(crm);
        medico.setPass(senha);



        processarOpcao(1);
    }

    @Override
    public void processarOpcao(int opcao) {
        new MenuAcessoMedico();
    }



}
