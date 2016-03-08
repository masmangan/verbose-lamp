/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.fds.tu.leao;

import org.junit.Before;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author bcopstein
 */
@RunWith(Parameterized.class)
public class IrpfCalcTest {

    private Irpf ir;
    private double totRend, contrPrev, impDev;
    private int idade, nroDep;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                    {11999.0, 0.0, 38, 0, 0.0},
                    {12000.0, 0.0, 38, 0, 0.0},
                    {12001.0, 0.0, 38, 0, 0.15},
                    {18000.0, 0.0, 38, 0, 900.0},
                    {23999.0, 0.0, 38, 0, 1799.85},
                    {24000.0, 0.0, 38, 0, 1800.0},
                    {24001.0, 0.0, 38, 0, 1800.15},
                    {50000.0, 0.0, 38, 0, 8950.125},
                    {18000.0, 6000.0, 38, 0, 0.0},
                    {24000.0, 6000.0, 38, 0, 900.0},
                    {50000.0, 6000.0, 38, 0, 7300.12},
                    {50000.0, 6000.0, 64, 0, 7300.12},
                    {50000.0, 6000.0, 65, 0, 7300.12},
                    {50000.0, 6000.0, 66, 0, 7300.12},
                    {50000.0, 6000.0, 64, 1, 7058.12},
                    {50000.0, 6000.0, 64, 2, 7058.12},
                    {50000.0, 6000.0, 64, 3, 6876.62},
                    {50000.0, 6000.0, 64, 4, 6876.62},
                    {50000.0, 6000.0, 64, 5, 6876.62},
                    {50000.0, 6000.0, 64, 6, 6695.12},
                    {50000.0, 6000.0, 65, 1, 6937.12},
                    {50000.0, 6000.0, 65, 2, 6937.12},
                    {50000.0, 6000.0, 65, 3, 6755.62},
                    {50000.0, 6000.0, 65, 4, 6755.62},
                    {50000.0, 6000.0, 65, 5, 6755.62},
                    {50000.0, 6000.0, 65, 6, 6574.12},
                    {50000.0, 6000.0, 66, 6, 6574.12},
                    {30000.0, 5550.0, 43, 1, 1794.15},
                    {15000.0, 3000.0, 76, 6, 0.0}});
    }

    public IrpfCalcTest(double totRend, double contrPrev, int idade, int nroDep, double impDev) {
        this.totRend = totRend;
        this.contrPrev = contrPrev;
        this.idade = idade;
        this.nroDep = nroDep;
        this.impDev = impDev;
    }

    @Before
    public void setUp() throws Exception {
        ir = new Irpf("Zezinho", "12126754");
    }

    @Test
    public void testSomeMethod() {
        ir.setTotRendimentos(totRend);
        ir.setContrPrev(contrPrev);
        ir.setIdade(idade);
        ir.setNroDep(nroDep);
        double resp = ir.impostoDevido();
        assertTrue(Math.abs(resp-impDev) < 1.0);
    }
}
