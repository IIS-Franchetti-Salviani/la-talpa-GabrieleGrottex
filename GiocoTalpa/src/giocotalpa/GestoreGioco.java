/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocotalpa;

import java.util.Random;
import javax.swing.SwingUtilities;
/**
 *
 * @author grottelli.gabriele
 */
public class GestoreGioco {
    
    private Buca[] buche;
    private Giocatore giocatore;
    private InterfacciaGrafica gui;
    private boolean attivo = true;
    private Random random = new Random();

    public GestoreGioco(InterfacciaGrafica gui){
        this.gui = gui;
        this.giocatore = new Giocatore("Gabriele");
        buche = new Buca[8];
        for(int i=0; i<8; i++){
            buche[i] = new Buca(i);
        }
    }
}
