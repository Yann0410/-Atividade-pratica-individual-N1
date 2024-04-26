package main;

import classes.*;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco XYZ", "Rua ABC, 123");

        Loja loja1 = new Loja("Loja A", "Av. 1, 100", banco);
        Loja loja2 = new Loja("Loja B", "Rua 2, 200", banco);

        Funcionario funcionario1 = new Funcionario("João", "Vendedor", 1400, loja1);
        Funcionario funcionario2 = new Funcionario("Maria", "Caixa", 1400, loja1);
        Funcionario funcionario3 = new Funcionario("Pedro", "Vendedor", 1400, loja2);
        Funcionario funcionario4 = new Funcionario("Ana", "Caixa", 1400, loja2);

        loja1.addFuncionario(funcionario1);
        loja1.addFuncionario(funcionario2);
        loja2.addFuncionario(funcionario3);
        loja2.addFuncionario(funcionario4);

        Thread threadFuncionario1 = new Thread(funcionario1);
        Thread threadFuncionario2 = new Thread(funcionario2);
        Thread threadFuncionario3 = new Thread(funcionario3);
        Thread threadFuncionario4 = new Thread(funcionario4);

        threadFuncionario1.start();
        threadFuncionario2.start();
        threadFuncionario3.start();
        threadFuncionario4.start();

        Cliente cliente1 = new Cliente("Carlos", "Rua X, 10", 1000, banco, loja1, loja2);
        Cliente cliente2 = new Cliente("Lucia", "Av. Y, 20", 1000, banco, loja1, loja2);
        Cliente cliente3 = new Cliente("Miguel", "Rua Z, 30", 1000, banco, loja1, loja2);
        Cliente cliente4 = new Cliente("Larissa", "Av. W, 40", 1000, banco, loja1, loja2);
        Cliente cliente5 = new Cliente("Gabriel", "Rua K, 50", 1000, banco, loja1, loja2);

        Thread threadCliente1 = new Thread(cliente1);
        Thread threadCliente2 = new Thread(cliente2);
        Thread threadCliente3 = new Thread(cliente3);
        Thread threadCliente4 = new Thread(cliente4);
        Thread threadCliente5 = new Thread(cliente5);

        threadCliente1.start();
        threadCliente2.start();
        threadCliente3.start();
        threadCliente4.start();
        threadCliente5.start();

        try {
            threadCliente1.join();
            threadCliente2.join();
            threadCliente3.join();
            threadCliente4.join();
            threadCliente5.join();
            threadFuncionario1.interrupt();
            threadFuncionario2.interrupt();
            threadFuncionario3.interrupt();
            threadFuncionario4.interrupt();
            threadFuncionario1.join();
            threadFuncionario2.join();
            threadFuncionario3.join();
            threadFuncionario4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostra o saldo final das contas
        System.out.println("\nSaldo final das contas:");
        System.out.println("Saldo da loja " + loja1.getNome() + ": R$" + loja1.getSaldo());
        System.out.println("Saldo da loja " + loja2.getNome() + ": R$" + loja2.getSaldo());

        // Mostra os saldos dos clientes
        System.out.println("\nSaldos dos clientes:");
        System.out.println("Saldo de " + cliente1.getNome() + ": R$" + cliente1.getSaldo());
        System.out.println("Saldo de " + cliente2.getNome() + ": R$" + cliente2.getSaldo());
        System.out.println("Saldo de " + cliente3.getNome() + ": R$" + cliente3.getSaldo());
        System.out.println("Saldo de " + cliente4.getNome() + ": R$" + cliente4.getSaldo());
        System.out.println("Saldo de " + cliente5.getNome() + ": R$" + cliente5.getSaldo());

        // Mostra os saldos dos funcionários
        System.out.println("\nSaldos dos funcionários:");
        System.out.println("Saldo de " + funcionario1.getNome() + " (Salário): R$" + funcionario1.getSaldoSalario());
        System.out.println("Saldo de " + funcionario1.getNome() + " (Investimento): R$" + funcionario1.getSaldoInvestimento());
        System.out.println("Saldo de " + funcionario2.getNome() + " (Salário): R$" + funcionario2.getSaldoSalario());
        System.out.println("Saldo de " + funcionario2.getNome() + " (Investimento): R$" + funcionario2.getSaldoInvestimento());
        System.out.println("Saldo de " + funcionario3.getNome() + " (Salário): R$" + funcionario3.getSaldoSalario());
        System.out.println("Saldo de " + funcionario3.getNome() + " (Investimento): R$" + funcionario3.getSaldoInvestimento());
        System.out.println("Saldo de " + funcionario4.getNome() + " (Salário): R$" + funcionario4.getSaldoSalario());
        System.out.println("Saldo de " + funcionario4.getNome() + " (Investimento): R$" + funcionario4.getSaldoInvestimento());
    }
}

