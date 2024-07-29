package entities;

public class Candidato {
    private String nome;
    private double salarioPretendido;
    private int tentativasLigacoes;

    public Candidato(String nome, double salarioPretendido) {
        this.nome = nome;
        this.salarioPretendido = salarioPretendido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioPretendido() {
        return salarioPretendido;
    }

    public void setSalarioPretendido(double salarioPretendido) {
        this.salarioPretendido = salarioPretendido;
    }

    public int getTentativasLigacoes() {
        return tentativasLigacoes;
    }

    public void setTentativasLigacoes(int tentativasLigacoes) {
        this.tentativasLigacoes = tentativasLigacoes;
    }
}
