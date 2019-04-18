package hh.swd20.wilson.domain;

import javax.persistence.Entity;





import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long albumId;
	private String title;
	private String collaborator;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id")
	private Band band;
	
	
	public Album () {}
	
	


	public Album(String title, String collaborator, Band band) {
		super();
		this.title = title;
		this.collaborator = collaborator;
		this.band = band;
	}




	public long getAlbumId() {
		return albumId;
	}


	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCollaborator() {
		return collaborator;
	}


	public void setCollaborator(String collaborator) {
		this.collaborator = collaborator;
	}
	
		public Band getBand() {
		return band;
	}
	
	
	public void setBand(Band band) {
		this.band = band;
	}


	@Override
	public String toString() {
		if (this.band != null)
		return "Album [albumId=" + albumId + ", title=" + title + ", collaborator=" + collaborator + ", band = "+ this.getBand() + "]";
		else 
			return "Album [albumId=" + albumId + ", title=" + title + ", collaborator=" + collaborator + "]";
	}
	
	
	
}
