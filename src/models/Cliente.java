package src.models;


// Estende a classe abstrata Pessoa para herdar atributos e comportamentos básicos.
public class Cliente extends Pessoa {

    // Construtor 
    // Chama o construtor da superclasse Pessoa para inicializar os atributos.
    public Cliente(String nome, String endereco, String telefone, String cpf) {
        super(nome, endereco, telefone, cpf);
    }

    // Métodos sobrescritos da superclasse Pessoa
    @Override
    public void gravar() {
        System.out.println("Gravando cliente específico...");
    }

    @Override
    public void editar() {
        System.out.println("Editando dados do cliente...");
    }

    @Override
    public void excluir() {
        System.out.println("Excluindo conta...");
    }

    @Override
    public void cancelar() {
        System.out.println("Cancelando operação de conta...");
    }
}