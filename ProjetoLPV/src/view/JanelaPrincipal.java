package view;
import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {
    public JanelaPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);

        JTabbedPane abas = new JTabbedPane();

        abas.addTab("Adicionar Obra", new AbaAdicionarObra());
        abas.addTab("Gerenciar Obras", new AbaGerenciarObras());
        abas.addTab("Realizar Empréstimo", new AbaRealizarEmprestimo());
        abas.addTab("Devolver Empréstimo", new AbaDevolverEmprestimo());
        abas.addTab("Gerenciar Empréstimos", new AbaGerenciarEmprestimos());

        getContentPane().add(abas);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JanelaPrincipal());
    }
}
