import java.util.Scanner;

import Visao.ColaboradorMenu;
import Visao.EstagiarioMenu;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ColaboradorMenu menuColaborador = new ColaboradorMenu();
        EstagiarioMenu menuEstagiario = new EstagiarioMenu();
        int opcao = 0;
        while (opcao != 9) {
            System.out.println("----- TECH ACADEMY -----");
            System.out.println("1 - Colaborador");
            System.out.println("2 - Estagiário");
            System.out.println("9 - Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    menuColaborador.executar();
                    break;
                case 2:
                    menuEstagiario.executar();
                    break;
                case 9:
                    System.out.println("TCHAU");
                    break;
                default:
                    System.out.println("OPA, OPÇÃO ERRADA!!!");
                    break;
            }
        }
    }
}
