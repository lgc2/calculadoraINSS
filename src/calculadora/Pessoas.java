package calculadora;

public class Pessoas {

    private String nome;
    private float salario;

    public Pessoas (String nome, float salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public float getSalario() {
        return salario;
    }
}
