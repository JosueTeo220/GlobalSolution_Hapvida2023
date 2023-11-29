package view;

import session.SessionFactoryProvider;
import java.util.Scanner;

public abstract class MenuBase implements Menu {
    protected final Scanner scanner;
    protected final SessionFactoryProvider sessionFactoryProvider;

    public MenuBase(SessionFactoryProvider sessionFactoryProvider) {
        this.sessionFactoryProvider = sessionFactoryProvider;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }
}