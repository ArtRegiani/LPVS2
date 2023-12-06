package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private List<Obra> obrasEmprestadas;
    private LocalDate dataDevolucaoPrevista;
    private boolean devolvido;
    private String responsavel; 

    public Emprestimo(List<Obra> obrasEmprestadas, LocalDate dataEmprestimo, int diasParaDevolucao, String usuarioResponsavel) {
        this.obrasEmprestadas = obrasEmprestadas;
        this.dataEmprestimo = dataEmprestimo;
        calcularDataDevolucaoPrevista(diasParaDevolucao);
        this.devolvido = false;
        this.responsavel = usuarioResponsavel;
    }

    

    public boolean todasObrasDevolvidas(List<Obra> obrasDevolvidas) {
    	//retorna true se todos os itens forem iguais ou seja, se todos foram devolvidos
        return obrasDevolvidas.containsAll(obrasEmprestadas);
    }

    private void calcularDataDevolucaoPrevista(int diasParaDevolucao) {
        this.dataDevolucaoPrevista = dataEmprestimo.plus(diasParaDevolucao, ChronoUnit.DAYS);
    }
    
    
    //geters e seters
    
    public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}


	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}


	public List<Obra> getObrasEmprestadas() {
		return obrasEmprestadas;
	}


	public void setObrasEmprestadas(List<Obra> obrasEmprestadas) {
		this.obrasEmprestadas = obrasEmprestadas;
	}


	public LocalDate getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}


	public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}


	public boolean isDevolvido() {
		return devolvido;
	}


	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
    
}

