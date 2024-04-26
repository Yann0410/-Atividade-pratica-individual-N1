package classes;

import java.util.Random;

public class Cliente implements Runnable {
    private String nome;
    private String endereco;
    private Conta conta;
    private Loja loja1;
    private Loja loja2;
    private Banco banco;
    private Random random = new Random();

    public Cliente(String nome, String endereco, double saldo, Banco banco, Loja loja1, Loja loja2) {
        this.nome = nome;
        this.endereco = endereco;
        this.banco = banco;
        this.conta = new Conta(saldo, banco);
        this.loja1 = loja1;
        this.loja2 = loja2;
    }

    @Override
    public void run() {
        while (conta.getSaldo() >= 100) {
            int valorCompra = (random.nextInt(2) + 1) * 100; // Gera 100 ou 200
            Loja loja = random.nextBoolean() ? loja1 : loja2;
            loja.efetuarCompra(this, valorCompra);
        }
    }

    public synchronized void debitarSaldo(double valor) {
        conta.sacar(valor);
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public synchronized double getSaldo() {
        return conta.getSaldo();
    }
}