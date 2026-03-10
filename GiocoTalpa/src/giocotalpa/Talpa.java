/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocotalpa;

/**
 *
 * @author grottelli.gabriele
 */
public class Talpa extends Thread {
    private Buca buca;
    private long tempoVisibile;
    private boolean colpita = false;
    private int punteggio = 10;

    public Talpa(Buca buca, long tempoVisibile) {
        this.buca = buca;
        this.tempoVisibile = tempoVisibile;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(tempoVisibile);
            synchronized(this) {
                if (!colpita) {
                    buca.rimuoviTalpa();
                }
            }
        } catch (InterruptedException e) {
            // colpita, termina subito
        }
    }

    public synchronized void colpisci() {
        colpita = true;
        this.interrupt();
    }

    public int getPunteggio() {
        return punteggio;
    }
}
