/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gioco_talpa;

/**
 *
 * @author grottelli.gabriele
 */
public class Talpa {
    private boolean attiva = false;

    public void appare() { 
        attiva = true; 
    }
    public void scompare() { 
        attiva = false; 
    }
    public boolean eAttiva() {
        return attiva; 
    }
}
