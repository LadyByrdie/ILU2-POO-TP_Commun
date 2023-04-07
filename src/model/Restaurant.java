package model;

public class Restaurant {
	private CentraleReservation<FormulaireRestaurant> centrale = new CentraleReservation<FormulaireRestaurant>(new EntiteReservable[50]);
	private Table table;
	private class Table extends EntiteReservable<FormulaireRestaurant> {
		private int nbChaises;
		private CalendrierAnnuel calendrierDeuxiemeService;
		public Table(int nbChaises) {
			this.nbChaises = nbChaises;
			calendrierDeuxiemeService = new CalendrierAnnuel();
		}
		public boolean estLibre(FormulaireRestaurant f) {
			if(f.getNumService()==1) {
				int jour = f.getJour();
				int mois = f.getMois();
				return calendrierAnnuel.estLibre(jour, mois);
			}
			else {
				int jour = f.getJour();
				int mois = f.getMois();
				return calendrierDeuxiemeService.estLibre(jour, mois);
			}
		}
		public boolean compatible(FormulaireRestaurant f) {
			int nbPersonnes = f.getNombrePersonnes();
			boolean a = ((nbPersonnes==nbChaises)||(nbChaises==nbPersonnes+1));
			System.out.println(a);
			boolean b = estLibre(f);
			System.out.println(b);
			return (a&&b);
		}
		public ReservationRestaurant reserver(FormulaireRestaurant f) {
			if(compatible(f)) {
			if(f.getNumService()==1) {
				calendrierAnnuel.reserver(f.getJour(), f.getMois());
			}
			else {
				calendrierDeuxiemeService.reserver(f.getJour(), f.getMois());
			}
				ReservationRestaurant reservation = new ReservationRestaurant(f.getJour(), f.getMois(), f.getNumService(), f.getIdentificationEntite());
				return reservation;
			}
			else {
				return null;
			}
		}
	}
		
		public void ajouterTable(int nbChaises) {
			Table table = new Table(nbChaises);
			centrale.ajouterEntite(table);
		}
		
		public int[] donnerPossibilites(FormulaireRestaurant f) {
			return centrale.donnerPossibilites(f);
		}
		public Reservation reserver(int numEntiteReservee, FormulaireRestaurant f) {
			return centrale.reserver(numEntiteReservee, f);
		}
	}