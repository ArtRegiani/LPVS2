package view;

import javax.swing.*;

import model.TipoObra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoObrasPanel extends JPanel {
    private JTextField tituloField;
    private JComboBox<TipoObra> tipoObraDropdown;
    private JTextField anoPublicacaoField;
    private JTextField quantidadeExemplaresField;
    private JTextArea autoresArea;
    private JButton adicionarAutorButton;
    private JButton removerAutorButton;
    private JButton salvarObraButton;

    private List<String> autoresList;

    public GerenciamentoObrasPanel() {
        // Inicializa a lista de autores
        autoresList = new ArrayList<>();

        // Configuração do layout (pode ser ajustado conforme necessário)
        setLayout(new GridLayout(7, 2));

        // Elementos da interface
        add(new JLabel("Título:"));
        tituloField = new JTextField();
        add(tituloField);

        add(new JLabel("Tipo de Obra:"));
        tipoObraDropdown = new JComboBox<>(TipoObra.values());
        add(tipoObraDropdown);

        add(new JLabel("Ano de Publicação:"));
        anoPublicacaoField = new JTextField();
        add(anoPublicacaoField);

        add(new JLabel("Quantidade de Exemplares:"));
        quantidadeExemplaresField = new JTextField();
        add(quantidadeExemplaresField);

        add(new JLabel("Autores:"));
        autoresArea = new JTextArea();
        autoresArea.setEditable(false);
        JScrollPane autoresScrollPane = new JScrollPane(autoresArea);
        add(autoresScrollPane);

        adicionarAutorButton = new JButton("Adicionar Autor");
        adicionarAutorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarAutor();
            }
        });
        add(adicionarAutorButton);

        removerAutorButton = new JButton("Remover Autor");
        removerAutorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerAutor();
            }
        });
        add(removerAutorButton);

        salvarObraButton = new JButton("Salvar Obra");
        salvarObraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarObra();
            }
        });
        add(salvarObraButton);
    }

    private void adicionarAutor() {
        String autor = JOptionPane.showInputDialog(this, "Digite o nome do autor:");
        if (autor != null && !autor.trim().isEmpty()) {
            autoresList.add(autor.trim());
            atualizarListaAutores();
        }
    }

    private void removerAutor() {
        if (!autoresList.isEmpty()) {
            String autorRemover = JOptionPane.showInputDialog(this, "Digite o nome do autor a remover:");
            if (autorRemover != null && !autorRemover.trim().isEmpty()) {
                autoresList.remove(autorRemover.trim());
                atualizarListaAutores();
            }
        }
    }

    private void atualizarListaAutores() {
        StringBuilder autoresText = new StringBuilder();
        for (String autor : autoresList) {
            autoresText.append(autor).append("\n");
        }
        autoresArea.setText(autoresText.toString());
    }

    private void salvarObra() {
        // Aqui você deve implementar a lógica para salvar a obra com os dados fornecidos
        // (título, tipo de obra, ano de publicação, quantidade de exemplares e lista de autores).
        // Pode usar os valores obtidos dos campos: tituloField.getText(), tipoObraDropdown.getSelectedItem(), etc.
        // Exemplo:
        // Obra novaObra = new Livro(tituloField.getText(), autoresList, Integer.parseInt(anoPublicacaoField.getText()), Integer.parseInt(quantidadeExemplaresField.getText()), "Editora");
        // ControleObras.getInstancia().adicionarObra(novaObra);
        // Adapte conforme necessário para sua implementação.
    }

    public List<String> obterListaAutores() {
        return new ArrayList<>(autoresList);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Teste Gerenciamento de Obras");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 500);

            GerenciamentoObrasPanel obrasPanel = new GerenciamentoObrasPanel();
            frame.add(obrasPanel);

            frame.setVisible(true);
        });
    }
}
