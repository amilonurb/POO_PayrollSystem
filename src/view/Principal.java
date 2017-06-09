package view;

import controller.PayrollSystem;
import util.Teclado;

/**
 *
 * @author Bruno Lima
 */
public class Principal {

    private static final int ADD = 1;
    private static final int PRINT = 2;
    private static final int SEARCH = 3;
    private static final int DELETE = 4;
    private static final int SAIR = 5;
    
    public static void inicializa() {
        System.out.println("PAYROLL SYSTEM");
        System.out.println("Bem-vindo ao sistema de folha de pagamento.");
        System.out.println("Escolha uma das opções abaixo:");
    }
    
    public static void menu() {
        
        int opcao;
        PayrollSystem ps = new PayrollSystem();
        
        do {
            
            System.out.println("\n\nOpções do sistema:");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Exibir todos os funcionários");
            System.out.println("3 - Procurar um funcionário");
            System.out.println("4 - Remover um funcionário");
            System.out.println("5 - Sair");
            opcao = Teclado.lerInt(":> ");

            switch(opcao) {
                case ADD:
                    ps.addFuncionario();
                    break;
                case PRINT:
                    ps.printFuncionarios();
                    break;
                case SEARCH:
                    ps.buscaFuncionario();
                    break;
                case DELETE:
                    ps.removeFuncionario();
                    break;
                case SAIR:
                    break;
            }

        } while(opcao != SAIR);
    }
    
    public static void main(String[] args) {
        inicializa();
        menu();
        System.out.println("Saída do sistema.");
    }

}