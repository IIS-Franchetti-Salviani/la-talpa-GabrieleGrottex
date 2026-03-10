/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package talèp;

/**
 *
 * @author grottelli.gabriele
 */
public class Talpa {
    private int punti;
    private int durataVisibilita; // Millisec che rimane fuori

    public Talpa(int punti, int durata) {
        this.punti = punti;
        this.durataVisibilita = durata;
    }

    public int getPunti() { return punti; }
    public int getDurata() { return durataVisibilita; }
}

