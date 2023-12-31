package view.utils;

import java.util.Scanner;

public class MenuUtils {
    public static void limparConsole() {
        try{
            String operatingSystem = System.getProperty("os.name");

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static String lerTexto(){
        System.out.print("Digite: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int lerNumero(){
        System.out.print("Digite: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static char lerChar(){
        System.out.print("Digite: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().charAt(0);
    }

    public static void aguardarTempoCurto() throws InterruptedException{
        Thread.sleep(1000);
    }

    public static void aguardarTempoMedio() throws InterruptedException{
        Thread.sleep(2000);
    }

        public static void aguardarTempoLongo() throws InterruptedException{
        Thread.sleep(4000);
    }
}