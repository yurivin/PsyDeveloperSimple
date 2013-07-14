package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import psyche.PsyOrgLevel;
/**
 * Class creates psyche organization schema and send it in to data base.
 * @author Юрий
 *
 */

public class PsyOrgLVLsCreation {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		new PsyOrgLVLsCreation().allActions();
	}
	
	private void allActions(){

		ArrayList<PsyOrgLevel> psyOrgLevels = psyOrgLvLsCreateToCollection(); 
		psyOrgLvLsToDb(psyOrgLevels);
		
	}
	
	private void psyOrgLvLsToDb(ArrayList<PsyOrgLevel> psyOrgLevels) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for(int i=0; i<psyOrgLevels.size(); i++){
		session.save(psyOrgLevels.get(i));
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	public ArrayList<PsyOrgLevel> psyOrgLvLsCreateToCollection() {
		
		ArrayList<PsyOrgLevel> psyOrgLvLs = new ArrayList<>();
		psyOrgLvLs.add(createOrganic());
		psyOrgLvLs.add(createPsychotic());
		psyOrgLvLs.add(createPsychopatic());
		psyOrgLvLs.add(createСharacterNeurosis());
		psyOrgLvLs.add(createSituationalNeurosis());
		psyOrgLvLs.add(createHealthyPsyche());
		
		return psyOrgLvLs;
	}
	
	private PsyOrgLevel createOrganic() {
		PsyOrgLevel organic = new PsyOrgLevel();
		List<Integer> agesOfForming = new ArrayList();
		agesOfForming.add(0);
		agesOfForming.add(1);
		organic.setAgesOfForming(agesOfForming);
		organic.setPsyLVLDefence(10);
		organic.setPsyOrgLvLName("Сохранность психоорганики");
		return organic;
	}
	private PsyOrgLevel createPsychotic() {
		PsyOrgLevel psychotic = new PsyOrgLevel();
		List<Integer> agesOfForming = new ArrayList();
		agesOfForming.add(2);
		agesOfForming.add(3);
		psychotic.setAgesOfForming(agesOfForming);
		psychotic.setPsyLVLDefence(10);
		psychotic.setPsyOrgLvLName("Cохранность на психотическом уровене");
		return psychotic;
	}
	private PsyOrgLevel createPsychopatic() {
		PsyOrgLevel psychopatic = new PsyOrgLevel();
		List<Integer> agesOfForming = new ArrayList();
		agesOfForming.add(4);
		agesOfForming.add(5);
		agesOfForming.add(6);
		psychopatic.setAgesOfForming(agesOfForming);
		psychopatic.setPsyLVLDefence(10);
		psychopatic.setPsyOrgLvLName("Формирование личности");
		return psychopatic;
	}
	private PsyOrgLevel createСharacterNeurosis() {
		PsyOrgLevel characterNeurosis = new PsyOrgLevel();
		List<Integer> agesOfForming = new ArrayList();
		agesOfForming.add(7);
		agesOfForming.add(8);
		agesOfForming.add(9);
		characterNeurosis.setAgesOfForming(agesOfForming);
		characterNeurosis.setPsyLVLDefence(10);
		characterNeurosis.setPsyOrgLvLName("Стабилизация личности");
		return characterNeurosis;
	}
	private PsyOrgLevel createSituationalNeurosis() {
		PsyOrgLevel situationalNeurosis = new PsyOrgLevel();
		List<Integer> agesOfForming = new ArrayList();
		agesOfForming.add(10);
		agesOfForming.add(11);
		agesOfForming.add(12);
		situationalNeurosis.setAgesOfForming(agesOfForming);
		situationalNeurosis.setPsyLVLDefence(10);
		situationalNeurosis.setPsyOrgLvLName("Отсутствие ситуативной невротизации");
		return situationalNeurosis;
	}
	private PsyOrgLevel createHealthyPsyche() {
		PsyOrgLevel healthyPsyche = new PsyOrgLevel();
		List<Integer> agesOfForming = new ArrayList();
		agesOfForming.add(13);
		agesOfForming.add(14);
		agesOfForming.add(15);
		agesOfForming.add(16);
		agesOfForming.add(17);
		agesOfForming.add(18);
		healthyPsyche.setAgesOfForming(agesOfForming);
		healthyPsyche.setPsyLVLDefence(10);
		healthyPsyche.setPsyOrgLvLName("Здоровая психика");
		return healthyPsyche;
	}
}
