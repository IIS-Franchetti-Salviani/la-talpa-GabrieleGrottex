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
    
    public void avviaGioco(){

        Thread generatore = new Thread(() -> {
            while(attivo){
                int index = random.nextInt(8);
                Buca b = buche[index];

                if(!b.eOccupata()){
                    Talpa t = new Talpa("normale", 10, 2000);
                    b.mostraTalpa(t);
                    gui.aggiornaBuca(b);

                    new Thread(() -> {
                        try{
                            Thread.sleep(t.getTempoVisibile());
                        }catch(InterruptedException e){}
                        b.nascondiTalpa();
                        gui.aggiornaBuca(b);
                    }).start();
                }

                try{
                    Thread.sleep(1000); 
                }catch(InterruptedException e){}
            }
        });

        generatore.start();
    }

    public void gestisciClick(int idBuca){
        int punti = buche[idBuca].colpisci();
        giocatore.aggiungiPunti(punti);
        gui.mostraPunteggio(giocatore.getPunteggio());
        gui.aggiornaBuca(buche[idBuca]);
    }

    public Giocatore getGiocatore(){
        return giocatore;
    }
}
