package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbaDevolverEmprestimo extends JPanel {
    public AbaDevolverEmprestimo() {
        // Aqui você pode adicionar componentes Swing para a aba de devolver empréstimo
        // Exemplo:
        JButton botaoDevolverEmprestimo = new JButton("Devolver Empréstimo");
        botaoDevolverEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicionar lógica para devolver empréstimo
            }
        });
        add(botaoDevolverEmprestimo);
    }
}
