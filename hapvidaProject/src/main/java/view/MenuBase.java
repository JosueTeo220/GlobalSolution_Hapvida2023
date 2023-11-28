package view;

import java.util.Scanner;
public abstract class MenuBase implements Menu {
    protected  Scanner scanner;

    public MenuBase(){
        this.scanner = new Scanner(System.in);
    }

    protected int lerOpcao(){
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

}
