package br.com.caelum.contas.modelo;

import br.com.caelum.javafx.api.util.Evento;

public class ContaCorrente extends Conta {
	public String getTipo() {
		return "Conta Corrente";
	}
	
	@Override
	public void saca(double valor) {
		this.saca(valor + 0.10);	
	}
}
