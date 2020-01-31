package br.com.caelum.contas.modelo;

import br.com.caelum.contas.main.SaldoInsuficienteException;

/**
 * Classe responsável por moldar as Contas do Banco
 * @author Mariana Marcondes Avelar de Souza
 *
 */
abstract 
public class Conta implements Comparable<Conta> {
	private double saldo;
	private String titular;
	private int numero;
	private String agencia;
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public double getSaldo() {
		return saldo;
	}
	
	abstract public String getTipo();
	
	public String toString() {
		return "[titular=" + this.titular + ", numero=" + this.numero + ", agencia=" + this.agencia;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false; 
		}
		Conta outraConta = (Conta) obj;
		
		return this.numero == outraConta.numero && this.agencia.contentEquals(outraConta.agencia);
	}
	
	/**
	 * Método que incrementa valor ao saldo
	 * @param valor
	 */
	public void deposita(double valor) {
		if(valor < 0) {
			throw new IllegalArgumentException("Número inválido, você tentou depositar um número negativo.");
		}
		this.saldo += valor;
	}
	
	/**
	 * Método que decrementa valor ao saldo
	 * @param valor
	 */
	public void saca(double valor) {
		if(valor < 0) {
			throw new IllegalArgumentException("Número inválido, você tentou sacar um número negativo.");
		} else if(valor > this.saldo) {
			throw new SaldoInsuficienteException(valor);
		} else {
			this.saldo -= valor;
		}
	}
	
	public void transfere(double valor, Conta conta) {
		this.saca(valor);
		conta.deposita(valor);
	}
	
	public int compareTo(Conta outraConta) {
		return this.titular.compareTo(outraConta.titular);
	}
}
