/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package giocotalpa;

import javax.swing.*;
/**
 *
 * @author grottelli.gabriele
 */
public class GiocoTalpa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Giocatore g = new Giocatore("Gabriele");
            GestoreGioco gestore = new GestoreGioco(g, 20);

            InterfacciaGrafica gui = new InterfacciaGrafica();
            gui.setVisible(true);

            gestore.avviaGioco();
        });
    }
}

