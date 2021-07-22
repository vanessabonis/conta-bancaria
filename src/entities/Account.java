package entities;

import exceptions.BusinessExceptions;

public class Account {
	
	private Integer conta;
	private String titular;
	private Double saldo;
	private Double limiteDeSaque;
	
	//constr
	
	public Account(Integer conta, String titular, Double saldo, Double limiteDeSaque) {
		super();
		this.conta = conta;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteDeSaque = limiteDeSaque;
	}
	
	public Account() {
		
	}

	//getset
	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
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

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimiteDeSaque() {
		return limiteDeSaque;
	}

	public void setLimiteDeSaque(Double limiteDeSaque) {
		this.limiteDeSaque = limiteDeSaque;
	}
	
	//metd
	public void deposito(Double quantia) {
		saldo += quantia;
	}
	
	public void saque(Double quantia) {
		regraSaque(quantia);
		saldo -= quantia;
	}
	
	private void regraSaque(double quantia) {
		if(quantia > getLimiteDeSaque()) {
			throw new BusinessExceptions("Erro de saque: quantia excede valor do limite de saque");
		}
		
		if(quantia > getSaldo()) {
			throw new BusinessExceptions("erro de saque: saldo insuficiente");
		}
		
	}
	
	
	
}
