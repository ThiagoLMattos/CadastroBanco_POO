package models;

// Estende a classe abstrata Conta para herdar atributos e comportamentos básicos.
public class ContaCorrente extends Conta{
    // Construtor
    public ContaCorrente(int agencia, int numero, double saldo){
        super(agencia, numero, saldo);
    }

    @Override
    public void gravar() {
        System.out.println("Gravando conta corrente...");
    }

}