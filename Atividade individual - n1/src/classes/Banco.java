package classes;

public class Banco {
    private String nome;
    private String endereco;
    private double saldoTotal = 0;

    public Banco(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public synchronized void depositar(double valor) {
        saldoTotal += valor;
    }

    public synchronized void sacar(double valor) {
        saldoTotal -= valor;
    }

    public synchronized double getSaldoTotal() {
        return saldoTotal;
    }
}
