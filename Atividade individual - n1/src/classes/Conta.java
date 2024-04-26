package classes;

class Conta {
    private double saldo;
    private Banco banco;

    public Conta(double saldoInicial, Banco banco) {
        this.saldo = saldoInicial;
        this.banco = banco;
    }

    public synchronized void depositar(double valor) {
        saldo += valor;
        banco.depositar(valor);
    }

    public synchronized void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            banco.sacar(valor);
        } else {
            System.out.println("Saldo insuficiente na conta.");
        }
    }

    public synchronized double getSaldo() {
        return saldo;
    }
    
    
}