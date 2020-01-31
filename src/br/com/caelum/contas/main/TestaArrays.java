package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaArrays {
	public static void main(String[] args) {
		Conta[] contas = new Conta[10];
		
		for(int i = 0; i < contas.length; i++) {
			Conta conta = new ContaCorrente();
			conta.deposita(i * 100.0);
			contas[i] = conta;
			System.out.println(contas[i].getSaldo());
		}
		
		double mediaSaldos = 0;
		for(int i = 0; i < contas.length; i++) {
			mediaSaldos += contas[i].getSaldo();
		}
		mediaSaldos = mediaSaldos / contas.length;
		System.out.println(mediaSaldos);
		
		
	}
}
