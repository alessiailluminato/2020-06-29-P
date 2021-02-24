package it.polito.tdp.PremierLeague.model;

public class Adiacenza {
	private Integer P1;
	private Integer P2;
	private Integer peso;
	public Adiacenza(Integer p1, Integer p2, Integer peso) {
		super();
		P1 = p1;
		P2 = p2;
		this.peso = peso;
	}
	public Integer getP1() {
		return P1;
	}
	public void setP1(Integer p1) {
		P1 = p1;
	}
	public Integer getP2() {
		return P2;
	}
	public void setP2(Integer p2) {
		P2 = p2;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}

}
