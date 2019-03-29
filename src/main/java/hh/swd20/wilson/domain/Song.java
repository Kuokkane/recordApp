package hh.swd20.wilson.domain;


public class Song {
	
	private long songId;
	private String songName;
	private double songLength;
	
	//@JoinColum(name = "albumId")
	//private Album album;
	
	public Song() {}

	public Song(String songName, double songLength/*, Album, album*/) {
		super();
		this.songName = songName;
		this.songLength = songLength;
		//this.album = album;
	}

	public long getSongId() {
		return songId;
	}

	public void setSongId(long songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public double getSongLength() {
		return songLength;
	}

	public void setSongLength(double songLength) {
		this.songLength = songLength;
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
		return "Song [songId=" + songId + ", songName=" + songName + ", songLength=" + songLength + "]";
	}
	
	

}
