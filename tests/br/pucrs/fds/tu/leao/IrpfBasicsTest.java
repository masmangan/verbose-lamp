/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.pucrs.fds.tu.leao;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author bcopstein
 */
public class IrpfBasicsTest {

 	private Irpf ir;

	@Before
	public void setUp() throws Exception {
		ir = new Irpf("Felipe","99456732897");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetTotRendimentos() {
		ir.setTotRendimentos(-100.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetContrPrev() {
		ir.setContrPrev(-1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNroDep() {
		ir.setNroDep(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetIdade() {
		ir.setIdade(-14);
	}
}