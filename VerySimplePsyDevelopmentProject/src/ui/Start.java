package ui;

import helpers.ConsolHelper;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import psyche.PsyOrgLevel;
import psyche.Psyche;


import test.PsyOrgLVLsCreation;

public class Start {

	Psyche psyche = new Psyche();
	
	public static void main(String[] args) {
	new Start().allActions();
	}

	private void allActions(){
		int numOfTraumas = inputNumberOfTraumas();
		
		for(int i=0; i<numOfTraumas; i++) {
			int[] trauma = traumaInput();
			psyche.psyStudyTraumaAndDefenceInsert(trauma);
		}
		output();
		
	}
	
	private void output() {
		System.out.println("---------------------------------");
		for(int i=0; i < psyche.getPsyOrgLvLs().size(); i++) {
			int psycheLvLVitality = psyche.getPsycheVitalyty() - psyche.getPsyOrgLvLs().get(i).getPsyOrgLvLVitalyty();
			System.out.println(psyche.getPsyOrgLvLs().get(i).getPsyOrgLvLName() + " " + psycheLvLVitality + "%. ���� ����������� �����: " + psyche.getPsyOrgLvLs().get(i).getPsyLVLDefence());
		}
		
	}

	private int[] traumaInput() {
		String age = ConsolHelper.keyboard("������� ������� ������ �� 0 �� 18");
		String traumaForce = ConsolHelper.keyboard("������� ���� ����������� �� 0 �� 100");
		int ageInt = Integer.parseInt(age);
		int traumaForceInt = Integer.parseInt(traumaForce);
		int[] trauma = {ageInt, traumaForceInt};
		return trauma;		
	}
	private int inputNumberOfTraumas() {
		String numOfTraumas = ConsolHelper.keyboard("������� ����� ����������");
		int numOfTraumasInt = Integer.parseInt(numOfTraumas);
		return numOfTraumasInt;		
	}

}
