/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package talèp;

/**
 *
 * @author grottelli.gabriele
 */
public class Buca {
    private Talpa talpaContenuta = null;
    private boolean occupata = false;

    public void setTalpa(Talpa t) {
        this.talpaContenuta = t;
        this.occupata = (t != null);
    }

    public boolean isOccupata() {
        return occupata;
    }
    public Talpa getTalpa() {
        return talpaContenuta;
    }
    
    public void svuota() {
        talpaContenuta = null;
        occupata = false;
    }
}
