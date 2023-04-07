package model;

public class CentraleReservation<P extends Formulaire> {
	EntiteReservable<P>[] entités;
	int nbEntites;
	public CentraleReservation(EntiteReservable<P>[] entités) {
		this.entités = entités;
		nbEntites = 0;
	}
	public void ajouterEntite(EntiteReservable<P> entité) {
		entités[nbEntites] = entité;
		nbEntites++;
		entité.setNumId(nbEntites);
	}
	public int[] donnerPossibilites(P formulaire) {
		int[] table = new int[nbEntites];
		for(int i = 0 ; i<nbEntites ; i++) {
			if(entités[i].compatible(formulaire)) {
				System.out.println(entités[i].getNumId());
				table[i] = entités[i].getNumId();
			}
			else {
				table[i] = 0;
			}
		}
		return table;
	}
	public Reservation reserver(int numEntiteReservee, P formulaire) {
		int i = 0;
		int numE = entités[0].getNumId();
		while(i<nbEntites && numE!=numEntiteReservee) {
			i++;
			numE = entités[i].getNumId();
		}
		formulaire.setIdentificationEntite(numEntiteReservee);
		Reservation réservation = entités[i].reserver(formulaire);
		return réservation;
	}
}
