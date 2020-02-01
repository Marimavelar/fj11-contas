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
	
//	public boolean equals(Object obj) {
//		if (obj == null) {
//			return false; 
//		}
//		Conta outraConta = (Conta) obj;
//		
//		return this.numero == outraConta.numero && this.agencia.contentEquals(outraConta.agencia);
//	}
	
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + numero;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (numero != other.numero)
			return false;
		return true;
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
