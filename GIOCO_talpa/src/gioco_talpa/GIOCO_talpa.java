/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gioco_talpa;

import javax.swing.SwingUtilities;
/**
 *
 * @author grottelli.gabriele
 */
public class GIOCO_talpa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> {
            
            graficaTalpa finestra = new graficaTalpa();
            
            finestra.setVisible(true);
            
            finestra.setLocationRelativeTo(null);
        });
    }
}
