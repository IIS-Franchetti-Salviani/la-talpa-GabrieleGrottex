/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocotalpa;

import javax.swing.*;
/**
 *
 * @author grottelli.gabriele
 */
public class Buca {

    private int id;
    private Talpa talpaCorrente;
    private JButton button;

    public Buca(int id, JButton button) {
        this.id = id;
        this.button = button;
    }

    public synchronized boolean eOccupata() {
        return talpaCorrente != null;
    }

    public synchronized void setTalpa(Talpa t) {
        talpaCorrente = t;
        SwingUtilities.invokeLater(() -> button.setText("🐹"));
    }

    public synchronized void rimuoviTalpa() {
        talpaCorrente = null;
        SwingUtilities.invokeLater(() -> button.setText(""));
    }

    public synchronized void colpisci(Giocatore g, GestoreGioco gestore) {
        if (talpaCorrente != null) {
            talpaCorrente.colpisci();
            g.aggiungiPunti(talpaCorrente.getPunteggio());
            rimuoviTalpa();
        } else {
            g.perdiPunti(5);
            gestore.decrementaTempo(1); 
        }
    }

    public JButton getButton() {
        return button;
    }
}
