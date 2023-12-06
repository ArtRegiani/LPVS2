package controller;

import java.util.ArrayList;
import java.util.List;

import model.Obra;

public class ControleObras {
    private static ControleObras instancia;
    private List<Obra> obras;

    private ControleObras() {
        this.obras = new ArrayList<>();
    }

    public static ControleObras getInstancia() {
        if (instancia == null) {
            instancia = new ControleObras();
        }
        return instancia;
    }

    public void adicionarObra(Obra obra) {
        obras.add(obra);
    }

    public void removerObra(Obra obra) {
        obras.remove(obra);
    }

    public List<Obra> listarObras() {
        return obras;
    }

}
