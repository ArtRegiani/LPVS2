package model;

import java.util.List;

public class Revista extends Obra {
    private int numeroEdicao;

    public Revista(String titulo, List<String> autores, int anoPublicacao, int quantidadeDisponivel, int numeroEdicao) {
        super(titulo, autores, anoPublicacao, TipoObra.REVISTA, quantidadeDisponivel);
        this.numeroEdicao = numeroEdicao;
    }


    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

}
