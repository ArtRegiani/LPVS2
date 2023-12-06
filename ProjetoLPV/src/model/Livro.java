package model;

import java.util.List;

public class Livro extends Obra {
    private String editora;

    public Livro(String titulo, List<String> autores, int anoPublicacao, int quantidadeDisponivel, String editora) {
        super(titulo, autores, anoPublicacao, TipoObra.LIVRO, quantidadeDisponivel);
        this.editora = editora;
    }


    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }


}
