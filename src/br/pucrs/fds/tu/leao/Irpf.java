/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.fds.tu.leao;

/**
 *
 * @author Bernardo Copstein
 */
public class Irpf {

    private String nome;
    private String cpf;
    private double totRendimentos;
    private double contrPrev;
    private int nroDep;
    private int idade;

    public Irpf(String n, String c) {
        nome = n;
        cpf = c;
    }

    public double getTotRendimentos() {
        return totRendimentos;
    }

    public void setTotRendimentos(double totRendimentos) throws IllegalArgumentException {
        if (totRendimentos < 0.0) {
            throw new IllegalArgumentException("Argumento inválido");
        }
        this.totRendimentos = totRendimentos;
    }

    public double getContrPrev() {
        return contrPrev;
    }

    public void setContrPrev(double contrPrev) {
        if (contrPrev < 0.0) {
            throw new IllegalArgumentException("Argumento inválido");
        }
        this.contrPrev = contrPrev;
    }

    public int getNroDep() {
        return nroDep;
    }

    public void setNroDep(int nroDep) {
        if (nroDep < 0) {
            throw new IllegalArgumentException("Argumento inválido");
        }
        this.nroDep = nroDep;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Argumento inválido");
        }
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double impostoDevido() {
        double baseDeCalculo = this.getTotRendimentos() - this.getContrPrev();
        double txDescDep = 0.0;
        if (this.getIdade() < 65) {
            if ((this.getNroDep() > 0) && (this.getNroDep() <= 2)) {
                txDescDep = 0.02;
            } else if ((this.getNroDep() > 2) && (this.getNroDep() <= 5)) {
                txDescDep = 0.035;
            } else if (this.getNroDep() > 5) {
                txDescDep = 0.05;
            }
        } else {
            if ((this.getNroDep() > 0) && (this.getNroDep() <= 2)) {
                txDescDep = 0.03;
            } else if ((this.getNroDep() > 2) && (this.getNroDep() <= 5)) {
                txDescDep = 0.045;
            } else if (this.getNroDep() > 5) {
                txDescDep = 0.06;
            }
        }
        double descDep = baseDeCalculo * txDescDep;
        baseDeCalculo = baseDeCalculo - descDep;
        double impPagar;
        if (baseDeCalculo <= 12000.0) {
            impPagar = 0;
        } else if ((baseDeCalculo >= 12000.0) && (baseDeCalculo < 24000.0)) {
            impPagar = (baseDeCalculo - 12000.0) * 0.15;
        } else {
            double p1 = (23999.0 - 12000.0) * 0.15;
            double p2 = (baseDeCalculo - 23999.0) * 0.275;
            impPagar = p1 + p2;
        }
        return (impPagar);
    }
}
