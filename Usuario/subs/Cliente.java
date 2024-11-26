package Usuario.subs;

import java.util.List;
import Usuario.Usuario;
import java.util.ArrayList;

public class Cliente extends Usuario {
    private List<Double> avaliacoes;
    private double media;

    public Cliente(String nome, String email, String senha) {
        super(nome, email, senha);
        this.avaliacoes = new ArrayList<>();
        this.media = 0;
    }

    public void adicionarAvaliacao(double avaliacao) {
        if (avaliacao < 0 || avaliacao > 5) {
            System.out.println("Erro: A avaliação deve ser entre 0 e 5.");
            return;
        }
        avaliacoes.add(avaliacao);
        calcularMedia();
        System.out.println("Avaliação adicionada com sucesso! Média atual: " + media);
    }

    private void calcularMedia() {
        if (avaliacoes.isEmpty()) {
            media = 0;
            return;
        }
        double soma = 0;
        for (double avaliacao : avaliacoes) {
            soma += avaliacao;
        }
        media = soma / avaliacoes.size();
    }

    public double getMedia() {
        return media;
    }
}