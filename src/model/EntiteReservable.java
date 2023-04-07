package model;

public abstract class EntiteReservable<P extends Formulaire> {
	CalendrierAnnuel calendrierAnnuel = new CalendrierAnnuel();
	int numId;
	
	public int getNumId() {
		return numId;
	}
	public void setNumId(int num) {
		numId = num;
	}
	public boolean estLibre(P formulaire) {
		int jour = formulaire.getJour();
		int mois = formulaire.getMois();
		return calendrierAnnuel.estLibre(jour, mois);
	}
	public abstract boolean compatible(P formulaire);
	public abstract Reservation reserver(P formulaire);
}
