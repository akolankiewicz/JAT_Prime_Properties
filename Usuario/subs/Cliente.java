package Usuario.subs;

import java.util.List;
import Usuario.Usuario;
import java.util.ArrayList;

public class Cliente extends Usuario {
    private List<Double> avaliacoes;
    private double media; // Variável para armazenar a média

    public Cliente(String nome, String email, String senha) {
        super(nome, email, senha); 
        this.avaliacoes = new ArrayList<>(); // Inicializa a lista de avaliações
        this.media = 0; // Inicializa a média
    }

    // Método para adicionar uma avaliação
    public void adicionarAvaliacao(double avaliacao) {
        if (avaliacao < 0 || avaliacao > 5) {
            System.out.println("Erro: A avaliação deve ser entre 0 e 5.");
            return;
        }
        avaliacoes.add(avaliacao); // Adiciona a avaliação à lista
        calcularMedia(); // Recalcula a média após adicionar a nova avaliação
        System.out.println("Avaliação adicionada com sucesso! Média atual: " + media);
    }

    // Método para calcular a média das avaliações
    private void calcularMedia() {
        if (avaliacoes.isEmpty()) {
            media = 0; // Se não há avaliações, a média é 0
            return;
        }
        double soma = 0;
        for (double avaliacao : avaliacoes) {
            soma += avaliacao;
        }
        media = soma / avaliacoes.size(); // Atualiza a média
    }

    // Método para obter a média
    public double getMedia() {
        return media;
    }

    // Método para listar avaliações
    public void listarAvaliacoes() {
        if (avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliação cadastrada.");
            return;
        }
        System.out.println("Lista de Avaliações:");
        for (double avaliacao : avaliacoes) {
            System.out.println(avaliacao);
        }
    }
}