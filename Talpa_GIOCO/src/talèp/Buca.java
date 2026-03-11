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

    public void setTalpa(Talpa t) {
        this.talpaContenuta = t;
    }

    public boolean isOccupata() {
        return talpaContenuta != null;
    }

    public Talpa getTalpa() {
        return talpaContenuta;
    }

    public void svuota() {
        talpaContenuta = null;
    }
}
