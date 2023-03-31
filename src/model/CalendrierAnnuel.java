package model;

public class CalendrierAnnuel {
	Mois[] calendrier;
	
	public CalendrierAnnuel() {
	this.calendrier= new Mois[] {
			new Mois(31,"Janvier"), 
			new Mois(28,"Fevrier"),
			new Mois(31,"Mars"),
			new Mois(30,"Avril"),
			new Mois(31,"Mai"), 
			new Mois(30,"Juin"),
			new Mois(31,"Juillet"),
			new Mois(31,"Août"),
			new Mois(30,"Septembre"), 
			new Mois(31,"Octobre"),
			new Mois(30,"Novembre"),
			new Mois(31,"Decembre"),
	};
	}
	
	public boolean estLibre(int jour, int mois) {
		Mois moisChoix=calendrier[mois-1];
		return moisChoix.estLibre(jour-1);
	}
	
	public boolean reserver(int integer, int mois) {
		Mois moisChoix=calendrier[mois-1];

		if(estLibre(integer,mois)){
			moisChoix.reserver(integer-1);
			return true;
		}else {
			return false;
		}
	}
	
	
	private class Mois {
		private String nom;
		private boolean[] jours;
		
		public Mois(int nbjour, String nom) {
			this.nom = nom;
			this.jours= new boolean[nbjour];
		}
		
		private boolean estLibre(int jour) {
			return !jours[jour];
		}
		
		private void reserver(int jour) throws IllegalStateException {
		if (!estLibre(jour)) {
			throw new IllegalStateException();
			}
		jours[jour]=true;
		}
	}
}

