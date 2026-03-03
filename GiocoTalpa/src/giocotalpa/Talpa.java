/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocotalpa;

/**
 *
 * @author grottelli.gabriele
 */
public class Talpa {
     private String tipo;
    private int punteggio;
    private int tempoVisibile;
    private boolean attiva;

    public Talpa(String tipo, int punteggio, int tempoVisibile) {
        this.tipo = tipo;
        this.punteggio = punteggio;
        this.tempoVisibile = tempoVisibile;
        this.attiva = false;
    }

    public void appare() {
        attiva = true;
    }

    public void scompare() {
        attiva = false;
    }

    public boolean eAttiva() {
        return attiva;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public int getTempoVisibile() {
        return tempoVisibile;
    }
}
