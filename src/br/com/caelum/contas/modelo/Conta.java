package br.com.caelum.contas.modelo;

/**
 * Classe responsável por moldar as Contas do Banco
 * @author Mariana Marcondes Avelar de Souza
 *
 */
public class Conta {
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
	
	/**
	 * Método que incrementa valor ao saldo
	 * @param valor
	 */
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	/**
	 * Método que decrementa valor ao saldo
	 * @param valor
	 */
	public void saca(double valor) {
		if(valor <= this.saldo) {
			this.saldo -= valor;
		}
	}
}
