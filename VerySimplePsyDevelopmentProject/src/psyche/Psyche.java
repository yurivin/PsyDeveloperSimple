package psyche;

import java.util.ArrayList;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Psyche {
	
	private int psycheVitalyty = 100;
	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private ArrayList<PsyOrgLevel> psyOrgLvLs = new ArrayList<PsyOrgLevel>();

	/**
	 * Constructor that constructs Psuche object and gets
	 * psyche organization levels scheme from Data base.
	 */
	public Psyche() {
		psyOrgLvLs = getPsyOrgLvLsFromDb();
	}
	/**
	 * Method that insert the trauma age and trauma force values in to
	 * every psyche organization level with age of forming equals or higher
	 * than in trauma properties.
	 * @param trauma
	 */
	public void psyStudyTraumaAndDefenceInsert(int[] trauma) {
		int traumaAge = trauma[0];
		int traumaForce = trauma[1];
	
		for(int i = 0; i<psyOrgLvLs.size(); i++) {
			int agesOfPsycheStudy = psyOrgLvLs.get(i).getAgesOfForming().size();
			breakFromIf:				
			for (int j=0; j<agesOfPsycheStudy; j++){
				int yearOfPsycheStudy = psyOrgLvLs.get(i).getAgesOfForming().get(j);
				if	(yearOfPsycheStudy >= traumaAge) {
					int psyStudyTraumaSum = psyOrgLvLs.get(i).getPsyOrgLvLVitalyty() + traumaForce;
					psyOrgLvLs.get(i).setPsyOrgLvLVitalyty(psyStudyTraumaSum);			
					psyOrgLvLs.get(i).setPsyLVLDefence((Integer)(psycheVitalyty - psyStudyTraumaSum)/10);
					break breakFromIf;
				}
			
			}
		}
	}

	
	/**
	 * method retrieve schema of psyche organisation levels fron data base.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<PsyOrgLevel> getPsyOrgLvLsFromDb(){
		
		ArrayList<PsyOrgLevel> PsyOrgLevels = new ArrayList<>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from PsyOrgLevel");
		PsyOrgLevels = (ArrayList<PsyOrgLevel>) query.list();
		
		session.getTransaction().commit();
		session.close();

		return PsyOrgLevels;
	}

	/**
	 * @return the psyOrgLvLsFrom
	 */
	public ArrayList<PsyOrgLevel> getPsyOrgLvLs() {
		return psyOrgLvLs;
	}
	/**
	 * @return the psycheVitalyty
	 */
	public int getPsycheVitalyty() {
		return psycheVitalyty;
	}
	/**
	 * @param psycheVitalyty the psycheVitalyty to set
	 */
	public void setPsycheVitalyty(int psycheVitalyty) {
		this.psycheVitalyty = psycheVitalyty;
	}

	
}
