package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Emprestimo;
import model.Obra;

public class ControleEmprestimo {
    private static ControleEmprestimo instancia;
    private List<Emprestimo> emprestimos;

    private ControleEmprestimo() {
        this.emprestimos = new ArrayList<>();
    }

    public static ControleEmprestimo getInstancia() {
        if (instancia == null) {
            instancia = new ControleEmprestimo();
        }
        return instancia;
    }

    public void realizarEmprestimo(List<Obra> obras, LocalDate dataEmprestimo, int diasParaDevolucao, String responsavel) {
        Emprestimo emprestimo = new Emprestimo(obras, dataEmprestimo, diasParaDevolucao, responsavel);
        emprestimos.add(emprestimo);
    }

    public void devolverObras(List<Obra> obrasDevolvidas, Emprestimo emprestimo) {
        if (emprestimo.todasObrasDevolvidas(obrasDevolvidas)) {
            realizarDevolucao(emprestimo);;
        }
    }
    
    public void realizarDevolucao(Emprestimo emprestimo) {
    	emprestimo.setDevolvido(true);
 
    }
    
    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public List<Emprestimo> listarEmprestimosNaoDevolvidos() {
        List<Emprestimo> naoDevolvidos = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (!emprestimo.isDevolvido()) {
                naoDevolvidos.add(emprestimo);
            }
        }
        return naoDevolvidos;
    }

    public List<Emprestimo> listarEmprestimosDevolvidos() {
        List<Emprestimo> devolvidos = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isDevolvido()) {
                devolvidos.add(emprestimo);
            }
        }
        return devolvidos;
    }

}
