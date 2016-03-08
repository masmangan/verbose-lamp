/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.pucrs.fds.tu.leao;

/**
 *
 * @author bcopstein
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Irpf irZe = new Irpf("Ze","1237649862");
        irZe.setContrPrev(20000.0);
        irZe.setIdade(35);
        irZe.setNroDep(2);
        irZe.setTotRendimentos(98000.0);

        System.out.println("Imposto a pagar: "+irZe.impostoDevido());
    }

}
