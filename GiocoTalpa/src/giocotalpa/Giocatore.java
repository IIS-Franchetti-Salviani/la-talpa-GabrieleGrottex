/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocotalpa;

/**
 *
 * @author grottelli.gabriele
 */
public class Giocatore {
    private String nome;
    private int punteggio;

    public Giocatore(String nome){
        this.nome = nome;
        this.punteggio = 0;
    }

    public void aggiungiPunti(int punti){
        punteggio += punti;
    }

    public int getPunteggio(){
        return punteggio;
    }

    public String getNome(){
        return nome;
    }
}
