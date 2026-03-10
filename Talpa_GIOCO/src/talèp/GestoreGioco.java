/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package talèp;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.SwingUtilities;
/**
 *
 * @author grottelli.gabriele
 */

public class GestoreGioco {
    private ArrayList<Buca> buche;
    private int punteggio = 0;
    private int tempoResiduo = 30;
    private boolean inCorso = false;
    private Random rand = new Random();

    public GestoreGioco(int numeroBuche) {
        buche = new ArrayList<>();
        for (int i = 0; i < numeroBuche; i++) buche.add(new Buca());
    }

    public void resettaGioco() {
        punteggio = 0;
        tempoResiduo = 30;
        inCorso = true;
        for (Buca b : buche) b.svuota();
    }

    public int colpisceBuca(int indice) {
        if (!inCorso) return 0;
        Buca b = buche.get(indice);
        if (b.isOccupata()) {
            punteggio += 10;
            b.svuota();
            return 10;
        } else {
            punteggio = Math.max(0, punteggio - 5);
            tempoResiduo = Math.max(0, tempoResiduo - 2);
            return -5;
        }
    }

    public void avviaTimer(Runnable onTick, Runnable onFinish) {
        new Thread(() -> {
            while (tempoResiduo > 0 && inCorso) {
                try {
                    Thread.sleep(1000);
                    tempoResiduo--;
                    SwingUtilities.invokeLater(onTick);
                } catch (InterruptedException e) { break; }
            }
            inCorso = false;
            SwingUtilities.invokeLater(onFinish);
        }).start();
    }

    public void avviaMovimentoTalpe(Runnable updateUI) {
        new Thread(() -> {
            while (tempoResiduo > 0 && inCorso) {
                try {
                    for (Buca b : buche) b.svuota();
                    int index = rand.nextInt(buche.size());
                    buche.get(index).setTalpa(new Talpa(10));
                    SwingUtilities.invokeLater(updateUI);
                    
                    Thread.sleep(800); // Velocità di esposizione
                } catch (InterruptedException e) { break; }
            }
            for (Buca b : buche) b.svuota();
            SwingUtilities.invokeLater(updateUI);
        }).start();
    }

    public int getPunteggio() { 
        return punteggio; 
    }
    public int getTempoResiduo() { 
        return tempoResiduo; 
    }
    public ArrayList<Buca> getBuche() { 
        return buche; }
    public boolean isInCorso() { 
        return inCorso; 
    }
}


