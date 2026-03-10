/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package talèp;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.SwingUtilities;

/**
 * @author grottelli.gabriele
 */
public class GestoreGioco {
    private ArrayList<Buca> buche;
    private int punteggio = 0;
    private int tempoResiduo = 30;
    private boolean gameRunning = false; 
    private Random rand = new Random();

    public GestoreGioco(int numeroBuche) {
        buche = new ArrayList<>();
        for (int i = 0; i < numeroBuche; i++) {
            buche.add(new Buca());
        }
    }

    public void start() {
        this.punteggio = 0;
        this.tempoResiduo = 30;
        this.gameRunning = true;
    }

    public void stop() {
        this.gameRunning = false;
        resettaBuche();
    }

    public boolean isGameRunning() {
        return gameRunning;
    }


    public int colpisceBuca(int indice) {
        if (!gameRunning) return 0; 
        
        Buca b = buche.get(indice);
        if (b.isOccupata()) {
            int p = b.getTalpa().getPunti();
            punteggio += p;
            b.svuota();
            return p;
        } else {
            punteggio = Math.max(0, punteggio - 5);
            tempoResiduo = Math.max(0, tempoResiduo - 2);
            return -5;
        }
    }

    public void resettaBuche() {
        for (Buca b : buche) {
            b.svuota();
        }
    }


    public void avviaTimer(Runnable onTick, Runnable onFinish) {
        new Thread(() -> {
            while (tempoResiduo > 0 && gameRunning) {
                try {
                    Thread.sleep(1000);
                    tempoResiduo--;
                    SwingUtilities.invokeLater(onTick);
                } catch (InterruptedException e) { break; }
            }
            SwingUtilities.invokeLater(onFinish);
        }).start();
    }

    public void avviaMovimentoTalpe(Runnable updateUI) {
    new Thread(() -> {
        while (tempoResiduo > 0 && gameRunning) { 
            try {
                resettaBuche(); 
                
                int index = rand.nextInt(buche.size());

                buche.get(index).setTalpa(new Talpa(10, 1000));

                SwingUtilities.invokeLater(updateUI);
                
                Thread.sleep(800); 
            } catch (InterruptedException e) { 
                Thread.currentThread().interrupt();
                break; 
            }
        }
        resettaBuche();
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
        return buche; 
    }
}

