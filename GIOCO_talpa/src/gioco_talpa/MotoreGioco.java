/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gioco_talpa;

import java.util.Random;

/**
 *
 * @author grottelli.gabriele
 */
public class MotoreGioco {
    private int punteggio = 0;
    private int indiceBucaAttiva = -1;
    private int numeroBuche;
    private Random random = new Random();

    public MotoreGioco(int numeroBuche) {
        this.numeroBuche = numeroBuche;
    }

    public int generaNuovaPosizione() {
        indiceBucaAttiva = random.nextInt(numeroBuche);
        return indiceBucaAttiva;
    }

    public boolean controllaColpo(int indiceCliccato) {
        if (indiceCliccato == indiceBucaAttiva) {
            punteggio += 10;
            indiceBucaAttiva = -1; 
            return true;
        }
        return false;
    }

    public int getPunteggio() { 
        return punteggio;
    }
    public int getIndiceBucaAttiva() { 
        return indiceBucaAttiva;
    }
}
