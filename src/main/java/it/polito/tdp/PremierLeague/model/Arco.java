package it.polito.tdp.PremierLeague.model;

public class Arco implements Comparable <Arco>{
	private Integer P1;
	private Integer P2;
	private Integer peso;
	public Arco(Integer p1, Integer p2, Integer peso) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((P1 == null) ? 0 : P1.hashCode());
		result = prime * result + ((P2 == null) ? 0 : P2.hashCode());
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
		Arco other = (Arco) obj;
		if (P1 == null) {
			if (other.P1 != null)
				return false;
		} else if (!P1.equals(other.P1))
			return false;
		if (P2 == null) {
			if (other.P2 != null)
				return false;
		} else if (!P2.equals(other.P2))
			return false;
		return true;
	}
	@Override
	public int compareTo(Arco o) {
		// TODO Auto-generated method stub
		return this.peso.compareTo(o.getPeso());
	}
	@Override
	public String toString() {
		return "Arco [P1=" + P1 + ", P2=" + P2 + ", peso=" + peso + "]";
	}

}
