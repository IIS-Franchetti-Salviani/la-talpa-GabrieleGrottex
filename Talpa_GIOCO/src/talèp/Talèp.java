/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package talèp;

import javax.swing.SwingUtilities;
/**
 *
 * @author grottelli.gabriele
 */
public class Talèp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> {
            
            InerfacciaGrafica gioco = new InerfacciaGrafica();
            
            gioco.setVisible(true);
            
            gioco.setLocationRelativeTo(null);
        });
    }
}
    

