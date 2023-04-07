package model;

public abstract class Formulaire {
	int jour;
	int mois;
	int numEntiteReservee;
	
	public Formulaire(int jour, int mois) {
		this.jour = jour;
		this.mois = mois;
	}
	
	public int getJour() {
		return jour;
	}
	
	public int getMois() {
		return mois;
	}
	
	public int getIdentificationEntite() {
		return numEntiteReservee;
	}
	
	public void setIdentificationEntite(int num) {
		numEntiteReservee = num;
	}
}