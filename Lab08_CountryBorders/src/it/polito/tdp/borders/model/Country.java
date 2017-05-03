package it.polito.tdp.borders.model;

public class Country {

	private int code ; 
	private String stateAbb ;
	private String stateName ;
	
	public Country(int code, String stateAbb, String stateName) {
		super();
		this.stateAbb = stateAbb;
	}
	public Country(String stateAbb) {
		super();
		this.stateAbb = stateAbb;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStateAbb() {
		return stateAbb;
	}
	public void setStateAbb(String stateAbb) {
		this.stateAbb = stateAbb;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Override
	public String toString() {
		return  stateName ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stateAbb == null) ? 0 : stateAbb.hashCode());
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
		Country other = (Country) obj;
		if (stateAbb == null) {
			if (other.stateAbb != null)
				return false;
		} else if (!stateAbb.equals(other.stateAbb))
			return false;
		return true;
	}
	
	
	
	
}
