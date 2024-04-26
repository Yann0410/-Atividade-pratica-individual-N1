package classes;

public class Loja {
    private String nome;
    private String endereco;
    private Banco banco;
    private Conta conta;
    private Funcionario[] funcionarios;

    public Loja(String nome, String endereco, Banco banco) {
        this.nome = nome;
        this.endereco = endereco;
        this.banco = banco;
        this.conta = new Conta(0, banco); // Conta da loja começa com saldo zero
        this.funcionarios = new Funcionario[0]; // Initialize empty array
    }

    public synchronized void addFuncionario(Funcionario funcionario) {
        Funcionario[] newFuncionarios = new Funcionario[funcionarios.length + 1];
        System.arraycopy(funcionarios, 0, newFuncionarios, 0, funcionarios.length);
        newFuncionarios[funcionarios.length] = funcionario;
        funcionarios = newFuncionarios;
    }

    public synchronized void efetuarCompra(Cliente cliente, double valor) {
        if (cliente.getSaldo() >= valor) {
           
            if (cliente.getSaldo() >= valor) {
                cliente.debitarSaldo(valor);
                conta.depositar(valor);
                System.out.println(cliente.getNome() + " comprou na " + nome + " no valor de R$ " + valor);
            }
            if (conta.getSaldo() >= 1400 && !isFuncionarioPago()) {
                pagarSalario();
            }
        } else {
            System.out.println(cliente.getNome() + " não possui saldo suficiente para comprar na " + nome);
        }
    }

    private boolean isFuncionarioPago() {
        for (Funcionario funcionario : funcionarios) {
            if (!funcionario.isSalarioRecebido()) {
                return false;
            }
        }
        return true;
    }


    private void pagarSalario() {
        for (Funcionario funcionario : funcionarios) {
            if (!funcionario.isSalarioRecebido()) {
                double salario = funcionario.getSalario();
                double valorInvestimento = salario * 0.2; // Calcula valor do investimento
                conta.sacar(salario); // Deduz o salário da conta da loja
                funcionario.receberSalario(); // Marca o salário como recebido
                System.out.println("Salário de " + funcionario.getNome() + " pago na " + nome);
                break;
            }
        }
    }
    
    public synchronized void pagarSalarios() {
        double salarioTotal = 0;
        for (Funcionario funcionario : funcionarios) {
            salarioTotal += funcionario.getSalario();
        }
        if (conta.getSaldo() >= salarioTotal) { // Salário total dos funcionários
            conta.sacar(salarioTotal);
            System.out.println("Salários pagos na " + nome);
            for (Funcionario funcionario : funcionarios) {
                funcionario.receberSalario();
            }
        }
    }

    public Banco getBanco() {
        return banco;
    }

    public synchronized double getSaldo() {
        return conta.getSaldo();
    }

    public String getNome() {
        return nome;
    }
}