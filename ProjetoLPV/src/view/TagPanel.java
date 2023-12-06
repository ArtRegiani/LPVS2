package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TagPanel extends JPanel {
    private List<String> tags;

    public TagPanel() {
        tags = new ArrayList<>();
        setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public void addTag(String tag) {
        tags.add(tag);

        JPanel tagPanel = new JPanel();
        tagPanel.setBackground(Color.lightGray);
        tagPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel tagLabel = new JLabel(tag);
        tagPanel.add(tagLabel);

        JButton removeButton = new JButton("X");
        removeButton.addActionListener(new RemoveTagAction(tag));
        tagPanel.add(removeButton);

        add(tagPanel);

        revalidate();
        repaint();
    }

    public List<String> getAllTags() {
        return new ArrayList<>(tags);
    }

    public void clearTags() {
        tags.clear();
        removeAll();
        revalidate();
        repaint();
    }

    private class RemoveTagAction implements ActionListener {
        private String tag;

        public RemoveTagAction(String tag) {
            this.tag = tag;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            tags.remove(tag);
            removeTagPanel(e);
        }

        private void removeTagPanel(ActionEvent e) {
            Component[] components = TagPanel.this.getComponents();
            for (Component component : components) {
                if (component instanceof JPanel) {
                    Component[] innerComponents = ((JPanel) component).getComponents();
                    for (Component innerComponent : innerComponents) {
                        if (innerComponent instanceof JButton && e.getSource() == innerComponent) {
                            TagPanel.this.remove(component);
                            revalidate();
                            repaint();
                            return;
                        }
                    }
                }
            }
        }
    }
}
