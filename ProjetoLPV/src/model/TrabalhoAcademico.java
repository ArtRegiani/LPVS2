package model;

import java.util.List;

public class TrabalhoAcademico extends Obra {
    private String instituicao;

    public TrabalhoAcademico(String titulo, List<String> autores, int anoPublicacao, int quantidadeDisponivel, String instituicao) {
        super(titulo, autores, anoPublicacao, TipoObra.TRABALHO_ACADEMICO, quantidadeDisponivel);
        this.instituicao = instituicao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }


}
