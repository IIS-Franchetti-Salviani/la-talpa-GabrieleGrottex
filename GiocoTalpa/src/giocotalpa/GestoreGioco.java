/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocotalpa;

import java.util.Random;
/**
 *
 * @author grottelli.gabriele
 */
public class GestoreGioco {
    private Buca[] buche = new Buca[8];
    private Giocatore giocatore;
    private int tempoRimanente;
    private boolean attivo;
    private Random random = new Random();

    public GestoreGioco(Giocatore g, int durata) {
        this.giocatore = g;
        this.tempoRimanente = durata;
    }

    public void setBuche(Buca[] buche) {
        this.buche = buche;
    }

    public void avviaGioco() {
        attivo = true;

        // Timer principale
        new Thread(() -> {
            while (attivo) {
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
                decrementaTempo(1);
            }
        }).start();

        // Generatore di talpe
        new Thread(() -> {
            while (attivo) {
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
                generaTalpa();
            }
        }).start();
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void decrementaTempo(int sec) {
        tempoRimanente -= sec;
        if (tempoRimanente <= 0) {
            attivo = false;
            javax.swing.SwingUtilities.invokeLater(() -> 
                javax.swing.JOptionPane.showMessageDialog(null, 
                    "Fine gioco! Punteggio: " + giocatore.getPunteggio())
            );
        }
    }

    public int getTempoRimanente() {
        return tempoRimanente;
    }

    public void generaTalpa() {
        int index = random.nextInt(buche.length);
        Buca b = buche[index];

        synchronized(b) {
            if (!b.eOccupata()) {
                Talpa t = new Talpa(b, 2000 + random.nextInt(2000)); // 2-4 sec
                b.setTalpa(t);
                t.start();
            }
        }
    }

    public void clickBuca(int id) {
        if (!attivo) return;
        buche[id].colpisci(giocatore, this);
    }

    public Giocatore getGiocatore() {
        return giocatore;
    }
}
