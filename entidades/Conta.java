package entidades;

import excecoes.DominioExcecoes;

public class Conta {

	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;

	public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {

		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public void deposito(Double montante) {
		saldo += montante;
	}

	public void saque(Double montante) {
		if (montante > getLimiteSaque()) {
			throw new DominioExcecoes("O valor excedeu o limite de saque!");
		}
		if (montante > getSaldo()) {
			throw new DominioExcecoes("Saldo insuficiente!");
		}

		saldo -= montante;
	}
}
