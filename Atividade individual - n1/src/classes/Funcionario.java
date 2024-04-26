package classes;

public class Funcionario implements Runnable {
    private String nome;
    private String cargo;
    private double salario;
    private Loja loja;
    private Conta contaSalario;
    private Conta contaInvestimento;
    private boolean salarioRecebido;

    public Funcionario(String nome, String cargo, double salario, Loja loja) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.loja = loja;
        this.contaSalario = new Conta(0, loja.getBanco()); // Conta de salário começa com saldo zero
        this.contaInvestimento = new Conta(0, loja.getBanco()); // Conta de investimento começa com saldo zero
        this.salarioRecebido = false;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(5000); // Aguarda 5 segundos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
            loja.pagarSalarios();
        }
    }

    public synchronized void receberSalario() {
        double valorInvestimento = salario * 0.2; // 20% do salário
        contaSalario.depositar(salario - valorInvestimento);
        contaInvestimento.depositar(valorInvestimento);
        salarioRecebido = true;
        System.out.println(nome + " recebeu o salário na loja " + loja.getNome());
        System.out.println(nome + " investiu R$" + valorInvestimento + " do salário");
    }
    
    public synchronized double getSaldoSalario() {
        return contaSalario.getSaldo();
    }

    public double getSalario() {
        return salario;
    }

    public boolean isSalarioRecebido() {
        return salarioRecebido;
    }

    public String getNome() {
        return nome;
    }
    
    public synchronized double getSaldo() {
        return contaSalario.getSaldo();
    }
    
    

    public synchronized double getSaldoInvestimento() {
        return contaInvestimento.getSaldo();
    }
}