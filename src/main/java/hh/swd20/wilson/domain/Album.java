package hh.swd20.wilson.domain;

import javax.persistence.Entity;



import javax.persistence.FetchType;
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
	@JoinColumn(name = "genreId")
	private Genre genre;
	
	
	public Album () {}
	
	


	public Album(String title, String collaborator, Genre genre) {
		super();
		this.title = title;
		this.collaborator = collaborator;
		this.genre = genre;
	}




	public long getId() {
		return albumId;
	}


	public void setId(long albumId) {
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
	
		public Genre getGenre() {
		return genre;
	}
	
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", title=" + title + ", collaborator=" + collaborator + "]";
	}
	
	
	
}
