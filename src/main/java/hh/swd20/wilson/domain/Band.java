package hh.swd20.wilson.domain;

public class Band {
	
	private long bandId;
	private String bandName;
	private int memberCount;
	private int foundYear;
	private String labelCompany;
	private int endYear;
	
	public Band() {}
			
			
	

	public Band(String bandName, int memberCount, int foundYear, String labelCompany, int endYear) {
		super();
		this.bandName = bandName;
		this.memberCount = memberCount;
		this.foundYear = foundYear;
		this.labelCompany = labelCompany;
		this.endYear = endYear;
	}




	public int getMemberCount() {
		return memberCount;
	}




	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}




	public int getFoundYear() {
		return foundYear;
	}




	public void setFoundYear(int foundYear) {
		this.foundYear = foundYear;
	}




	public String getLabelCompany() {
		return labelCompany;
	}




	public void setLabelCompany(String labelCompany) {
		this.labelCompany = labelCompany;
	}




	public int getEndYear() {
		return endYear;
	}




	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	
	




	public long getId() {
		return bandId;
	}




	public void setId(long bandId) {
		this.bandId = bandId;
	}
	
	public String getBandName() {
		return bandName;
	}




	public void setBandName(String bandName) {
		this.bandName = bandName;
	}




	@Override
	public String toString() {
		return "Band [bandId=" + bandId + ", bandName=" + bandName + ", memberCount=" + memberCount + ", foundYear="
				+ foundYear + ", labelCompany=" + labelCompany + ", endYear=" + endYear + "]";
	}





	





	
	



	
	
	
	
}
