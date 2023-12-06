package view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

import model.TipoObra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AbaAdicionarObra extends JPanel {
    private JTextField campoTitulo;
    private JTextField campoAnoPublicacao;
    private JTextField campoNumExemplares;
    private JComboBox<TipoObra> comboBoxTipoObra;
    private JTextField campoAutor;
    private JPanel painelAutores;

    private List<String> autores;

    public AbaAdicionarObra() {
        autores = new ArrayList<>();

        setLayout(new BorderLayout());

        // Painel para os campos de entrada
        JPanel painelEntrada = new JPanel(new GridLayout(6, 2));

        // Campos de entrada
        campoTitulo = new JTextField();
        campoAnoPublicacao = new JTextField();
        campoNumExemplares = new JTextField();
        comboBoxTipoObra = new JComboBox<>(TipoObra.values());
        campoAutor = new JTextField();

        // Adiciona os componentes ao painel de entrada
        painelEntrada.add(new JLabel("Título:"));
        painelEntrada.add(campoTitulo);
        painelEntrada.add(new JLabel("Ano de Publicação:"));
        painelEntrada.add(campoAnoPublicacao);
        painelEntrada.add(new JLabel("Número de Exemplares:"));
        painelEntrada.add(campoNumExemplares);
        painelEntrada.add(new JLabel("Tipo de Obra:"));
        painelEntrada.add(comboBoxTipoObra);
        painelEntrada.add(new JLabel("Autor:"));
        painelEntrada.add(campoAutor);

        
        JButton botaoAdicionarObra = new JButton("Adicionar Obra");
        botaoAdicionarObra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        painelEntrada.add(botaoAdicionarObra);
        
        // Botão para adicionar autor
        JButton botaoAdicionarAutor = new JButton("Adicionar Autor");
        botaoAdicionarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarAutor();
            }
        });
        painelEntrada.add(botaoAdicionarAutor);
        
       

        // Painel para exibir os autores em formato de text-tag
        painelAutores = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Adiciona os painéis ao painel principal
        add(painelEntrada, BorderLayout.NORTH);
        add(new JScrollPane(painelAutores), BorderLayout.CENTER);
    }

    private void adicionarAutor() {
        String autor = campoAutor.getText().trim();
        if (!autor.isEmpty() && !autores.contains(autor)) {
            autores.add(autor);
            atualizarPainelAutores();
            campoAutor.setText(""); // Limpa o campo após adicionar
        }
    }

    private void atualizarPainelAutores() {
        // Limpa o painel antes de adicionar os autores novamente
        painelAutores.removeAll();

        // Adiciona os autores em formato de text-tag com botão de remoção
        for (String autor : autores) {
            JButton botaoRemoverAutor = new JButton("remover");
            botaoRemoverAutor.setBorderPainted(false);
            botaoRemoverAutor.setContentAreaFilled(false);
            
            botaoRemoverAutor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removerAutor(autor);
                }
            });
            JLabel labelAutor = new JLabel(autor);
            labelAutor.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.gray),
                    BorderFactory.createEmptyBorder(2, 2, 2, 2)
            ));
            JPanel painelAutor = new JPanel(new GridLayout(2, 1));
            painelAutor.add(labelAutor);
            painelAutor.add(botaoRemoverAutor);
            painelAutores.add(painelAutor);
        }

        // Atualiza a interface
        painelAutores.revalidate();
        painelAutores.repaint();
    }

    private void removerAutor(String autor) {
        autores.remove(autor);
        atualizarPainelAutores();
    }

    // Método para obter a lista de autores
    public List<String> getAutores() {
        return new ArrayList<>(autores); // Retorna uma cópia para evitar manipulação externa
    }

    // Aqui você pode adicionar a lógica para utilizar os dados inseridos
    // ao clicar em algum botão de "Adicionar Obra" ou realizar outra ação.
}
