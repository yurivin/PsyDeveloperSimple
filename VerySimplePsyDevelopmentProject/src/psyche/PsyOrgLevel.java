/**
 * 
 */
package psyche;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author ёрий
 *
 */
@Entity
public class PsyOrgLevel  {
	
	@Id @GeneratedValue 
	private int psyOrgID;
	private int psyOrgLvLVitality; 
	private int psyLVLDefence;
	private String psyOrgLvLName;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Integer> agesOfForming = new ArrayList<Integer>();
	/**
	 * @return the psyOrgID
	 */
	public int getPsyOrgID() {
		return psyOrgID;
	}
	/**
	 * @param psyOrgID the psyOrgID to set
	 */
	public void setPsyOrgID(int psyOrgID) {
		this.psyOrgID = psyOrgID;
	}
	/**
	 * @return the psyOrgLvLVitalyty
	 */
	public int getPsyOrgLvLVitalyty() {
		return psyOrgLvLVitality;
	}
	/**
	 * @param psyOrgLvLVitalyty the psyOrgLvLVitalyty to set
	 */
	public void setPsyOrgLvLVitalyty(int psyOrgLvLVitalyty) {
		this.psyOrgLvLVitality = psyOrgLvLVitalyty;
	}
	/**
	 * @return the psyLVLDefenceForce
	 */
	public int getPsyLVLDefence() {
		return psyLVLDefence;
	}
	/**
	 * @param psyLVLDefenceForce the psyLVLDefenceForce to set
	 */
	public void setPsyLVLDefence(int psyLVLDefenceForce) {
		this.psyLVLDefence = psyLVLDefenceForce;
	}
	/**
	 * @return the psyOrgLvLName
	 */
	public String getPsyOrgLvLName() {
		return psyOrgLvLName;
	}
	/**
	 * @param psyOrgLvLName the psyOrgLvLName to set
	 */
	public void setPsyOrgLvLName(String psyOrgLvLName) {
		this.psyOrgLvLName = psyOrgLvLName;
	}
	/**
	 * @return the agesOfForming
	 */
	public List<Integer> getAgesOfForming() {
		return agesOfForming;
	}
	/**
	 * @param agesOfForming the agesOfForming to set
	 */
	public void setAgesOfForming(List<Integer> agesOfForming) {
		this.agesOfForming = agesOfForming;
	}
	

}
