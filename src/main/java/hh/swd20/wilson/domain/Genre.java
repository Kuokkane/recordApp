package hh.swd20.wilson.domain;

public class Genre {

	private long genreId;
	private String genreName;
	
	public Genre () {}

	public Genre(String genreName) {
		super();
		this.genreName = genreName;
	}

	public long getGenreId() {
		return genreId;
	}

	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreName=" + genreName + "]";
	}
	
	
}
