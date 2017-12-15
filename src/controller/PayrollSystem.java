package controller;


import java.util.ArrayList;
import java.util.List;
import model.BasePlusCommissionEmployee;
import model.CommissionEmployee;
import model.Employee;
import model.HourlyEmployee;
import model.SalariedEmployee;
import util.ComparadorPorFirstName;
import static util.Teclado.*;

/**
 * classe relativa às ações do sistema
 * @author Bruno Lima
 */
public class PayrollSystem {
    
    public static final int COMISSION = 1;
    public static final int BASE_PLUS_COMISSION = 2;
    public static final int HOURLY = 3;
    public static final int SALARIED = 4;
    
    private List<Employee> funcionarios;
    
    public PayrollSystem() {
        funcionarios = new ArrayList<>();               
        funcionarios.add(
                new SalariedEmployee(
                        "John", "Smith", "111-11-1111", 800.00));
        funcionarios.add(
                new SalariedEmployee(
                        "John", "Cane", "444-44-4444", 900.00));
        funcionarios.add(
                new HourlyEmployee(
                        "Karen", "Price", "222-22-2222", 16.75, 40));
        funcionarios.add(
                new CommissionEmployee(
                        "Sue", "Jones", "333-33-3333", 10000, .06));
        funcionarios.add(
                new BasePlusCommissionEmployee(
                    "Bob", "Lewis", "444-44-4444", 5000, .04, 300));
    }
    
    public void addFuncionario() {
        
        boolean status = true;
        Employee employee = null;
        String firstName, lastName, ssn;
        double sales;
        double rate;
        
        int tipo;
        firstName = lerTexto("Nome: ");
        lastName = lerTexto("Sobrenome: ");
        ssn = lerTexto("SSN: ");
        tipo = lerInt("Tipo de funcionário: "
                + "\n1 - Comissioned"
                + "\n2 - Based Plus Comissioned"
                + "\n3 - Hourly"
                + "\n4 - Salaried"
                + "\nDigite uma das opções acima:> ");
        
        
        switch(tipo) {
            case COMISSION:
                sales = lerDouble("Gross sales: ");
                rate = lerDouble("Comission rate: ");
                employee = new CommissionEmployee(
                                firstName, lastName, ssn, sales, rate);
                break;
            case BASE_PLUS_COMISSION:
                sales = lerDouble("Gross sales: ");
                rate = lerDouble("Comission rate: ");
                double baseSalary = lerDouble("Base salary: ");
                employee = new BasePlusCommissionEmployee(
                                firstName, lastName, ssn, sales, rate, baseSalary);
                break;
            case HOURLY:
                double wage = lerDouble("Wage per hour: ");
                double hours = lerDouble("hours worked for week: ");
                employee = new HourlyEmployee(
                                firstName, lastName, ssn, wage, hours);
                break;
            case SALARIED:
                double salary = lerDouble("Salary: ");
                employee = new SalariedEmployee(
                        firstName, lastName, ssn, salary);
                break;
            default:
                System.out.println("Opção inválida!\nCadastro cancelado.\n");
                status = false;
        }
        
        if(status) {
            if(employee instanceof HourlyEmployee)
                funcionarios.add((HourlyEmployee) employee);
            else if(employee instanceof BasePlusCommissionEmployee)
                funcionarios.add((BasePlusCommissionEmployee) employee);
            else if(employee instanceof SalariedEmployee)
                funcionarios.add((SalariedEmployee) employee);
            else
                funcionarios.add((CommissionEmployee) employee);
            System.out.println("Cadastro realizado com sucesso.\n");
        }
    }
    
    public void printFuncionarios() {
        if(funcionarios.isEmpty())
            System.out.println("Não há funcionários cadastrados no sistema");
        else {
            System.out.println("Exibindo os funcionários ordenados por nome");
            funcionarios
                    .stream()
                    .sorted(new ComparadorPorFirstName())
                    .forEach(e -> System.out.println(e + "\n"));
        }
    }

    public void removeFuncionario() {
        if(listaVazia()) {
            System.out.println("Não há funcionários cadastrados no sistema.");
        } else {
            String ssn = lerTexto("Informe o ssn do funcionário: ");
            Employee employee = this.getEmployee(ssn);
            if(employee == null)
                System.out.println("Funcionário não encontrado.");
            else {
                funcionarios.remove(employee);
                System.out.println("Funcionário removido do sistema.");
            }
        }
    }
    
    private Employee getEmployee(String ssn) {
        for(Employee e: funcionarios)
            if(e.getSocialSecurityNumber().equals(ssn))
                return e;
        return null;
    }
    
    public void buscaFuncionario() {
        if(listaVazia()) {
            System.out.println("Não há funcionários cadastrados no sistema.");
        } else {
            String ssn = lerTexto("Informe o ssn do funcionário: ");
            Employee employee = this.getEmployee(ssn);
            if(employee == null)
                System.out.println("Funcionário não encontrado.");
            else {
                
                System.out.println("Informações do funcionário:");
                System.out.println(employee);
                System.out.println("\nOpções:");
                System.out.println("1 - Acrescentar tributos");
                System.out.println("2 - Voltar");
                int op = lerInt(":> ");
                switch(op) {
                    case 1:
                        this.calculaSalario(employee);
                    case 2:
                        return;
                }
                
            }
        }
    }
    
    private boolean listaVazia() {
        return this.funcionarios.isEmpty();
    }
    
    private void calculaSalario(Employee employee) {
        double inss, plano, sindicato;
        inss = lerDouble("INSS: R$");
        plano = lerDouble("Plano de saúde: R$");
        sindicato = lerDouble("Sindicato: R$");
        double valorTotalTributos = inss + plano + sindicato;
        employee.setTributos(valorTotalTributos);
    }
    
}