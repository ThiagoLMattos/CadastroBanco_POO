package view;

import javax.swing.SwingUtilities;

public class Main {
        public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            Janela janela = new Janela();
            janela.setVisible(true);
        });
    }
}
