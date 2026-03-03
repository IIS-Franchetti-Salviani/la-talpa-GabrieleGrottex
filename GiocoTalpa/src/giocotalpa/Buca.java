/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocotalpa;

/**
 *
 * @author grottelli.gabriele
 */
public class Buca {
    private int id;
    private Talpa talpaCorrente;
    private boolean occupata;

    public Buca(int id) {
        this.id = id;
        occupata = false;
    }

    public synchronized void mostraTalpa(Talpa t) {
        talpaCorrente = t;
        t.appare();
        occupata = true;
    }

    public synchronized void nascondiTalpa() {
        if(talpaCorrente != null)
            talpaCorrente.scompare();
        occupata = false;
        talpaCorrente = null;
    }

    public synchronized int colpisci() {
        if(occupata && talpaCorrente.eAttiva()) {
            int punti = talpaCorrente.getPunteggio();
            nascondiTalpa();
            return punti;
        }
        return -5; // penalità se buca vuota
    }

    public boolean eOccupata() {
        return occupata;
    }

    public int getId() {
        return id;
    }
}
