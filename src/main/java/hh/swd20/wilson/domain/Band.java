package hh.swd20.wilson.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Band {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String bandName;
	private int memberCount;
	private int foundYear;
	private String labelCompany;
	private int endYear;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "band")
	private List<Album> albums;
//	@OneToMany
//	@JsonIgnore
//	private Album album;
	
	public Band() {
	}
			
			
	

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


 

	public List<Album> getAlbums() {
		return albums;
	}




	public void setAlbums(List<Album> albums) {
		this.albums = albums;
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
	
	




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBandName() {
		return bandName;
	}




	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	
//	public Album getAlbum() {
//		return album;
//	}
//	
//	
//	public void setAlbum(Album album) {
//		this.album = album;
//	}





	@Override
	public String toString() {
		return "Band [id=" + id + ", bandName=" + bandName + ", memberCount=" + memberCount + ", foundYear="
				+ foundYear + ", labelCompany=" + labelCompany + ", endYear=" + endYear + "]";
	}





	





	
	



	
	
	
	
}
