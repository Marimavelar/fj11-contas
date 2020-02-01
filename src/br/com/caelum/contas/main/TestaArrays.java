package br.com.caelum.contas.main;

import java.util.LinkedList;
import java.util.List;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaArrays {
	public static void main(String[] args) {
		Conta[] contas = new Conta[10];
		double mediaSaldos = 0;
		
		//Integer x;
		//List <Conta> Lista = new LinkedList();
		
		for(int i = 0; i < contas.length; i++) {
			Conta conta = new ContaCorrente();
			conta.deposita(i * 100.0);
			contas[i] = conta;
			mediaSaldos += contas[i].getSaldo();
//			System.out.println(contas[i].getSaldo());
		}
	
		mediaSaldos = mediaSaldos / contas.length;
		System.out.println(mediaSaldos);
		
		
	}
}
