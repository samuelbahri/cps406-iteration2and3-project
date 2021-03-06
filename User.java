import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class User {
	
	ArrayList<Song> songsPlayed = new ArrayList<Song>(); 
	ArrayList<Date> dateSongsPlayed = new ArrayList<Date>();
	
//	public static void main(String[] args) {
//		User user = new User();
//		user.addSongPlayed(new Song("Let it go", 4));
//		user.addSongPlayed(new Song("Carry on my Wayward Son", 7));
//		user.addSongPlayed(new Song("Carry on my Wayward Son", 7));
//		user.addSongPlayed(new Song("Baby", 100000));
//		user.addSongPlayed(new Song("Baby", 100000));
//		user.addSongPlayed(new Song("Baby", 100000));
//		user.addSongPlayed(new Song("Jingle Bells", 10));
//		user.addSongPlayed(new Song("Let it go", 4));
//		user.addSongPlayed(new Song("Let it go", 4));
//		user.addSongPlayed(new Song("Let it go", 4));
//		System.out.println(user.getMostPlayedSong());
//		System.out.println(user.getLeastPlayedSong());
//		System.out.println(user.getSongsFromDate("Year"));
//	}
	
	//Default Constructor
	public User () {

	}
	
	//Adds new song to list of played songs, and records current date/time
	public void addSongPlayed(Song songPlayed) {
		this.songsPlayed.add(songPlayed);
		this.dateSongsPlayed.add(new Date());
	}
	
	//Returns a list of songs from a certain time frame
	public ArrayList<Song> getSongsFromDate(String timeFrame){
		ArrayList<Song> songsFromDate = new ArrayList<Song>();
		Date currentDate = new Date();
		
		//Get all songs played from all time aka the whole list
		if (timeFrame == "All Time") {
			return this.songsPlayed;
		}
		//Get all songs from last year
		else if (timeFrame == "Year") {
			Date yearAgo = new Date();
			yearAgo.setYear(currentDate.getYear()-1);
			for (int i = 0; i < this.dateSongsPlayed.size(); i++) {
				if (!this.dateSongsPlayed.get(i).before(yearAgo)){
					songsFromDate.add(this.songsPlayed.get(i));
				}
			}
		}
		//Get all songs from last month
		else if (timeFrame == "Month") {
			Date monthAgo = new Date();
			monthAgo.setMonth(currentDate.getMonth()-1);
			for (int i = 0; i < this.dateSongsPlayed.size(); i++) {
				if (!this.dateSongsPlayed.get(i).before(monthAgo)){
					songsFromDate.add(this.songsPlayed.get(i));
				}
			}
		}
		//Get all songs from last day
		else if (timeFrame == "Day") {
			Date dayAgo = new Date();
			dayAgo.setDate(currentDate.getDate()-1);
			for (int i = 0; i < this.dateSongsPlayed.size(); i++) {
				if (!this.dateSongsPlayed.get(i).before(dayAgo)){
					songsFromDate.add(this.songsPlayed.get(i));
				}
			}
		}
		else {
			return null;
		}
		return songsFromDate;
	}
	
	//Returns all songs played by user
	public ArrayList<Song> getSongsPlayed(){
		return this.songsPlayed;
	}
	
	//Returns the dates that all songs were played by user
	public ArrayList<Date> getSongDates(){
		return this.dateSongsPlayed;
	}
	
	//Returns name of most played song
	public String getMostPlayedSong() {
		ArrayList<String> songList = new ArrayList<String>();
		for (int i = 0; i < this.songsPlayed.size(); i++) {
			songList.add(songsPlayed.get(i).getName());
		}
		
		return this.getMostFreqString(songList);
	}
	
	//Returns name of least played song
	public String getLeastPlayedSong() {
		ArrayList<String> songList = new ArrayList<String>();
		for (int i = 0; i < this.songsPlayed.size(); i++) {
			songList.add(songsPlayed.get(i).getName());
		}
		
		return this.getLeastFreqString(songList);
	}
	
	//Returns most frequent artist
	public String getMostFreqArtist() {
		ArrayList<String> artistList = new ArrayList<String>();
		for (int i = 0; i < this.songsPlayed.size(); i++) {
			artistList.add(songsPlayed.get(i).getArtist());
		}
		
		return this.getMostFreqString(artistList);
	}
	
	//Returns least frequent artist
	public String getLeastFreqArtist() {
		ArrayList<String> artistList = new ArrayList<String>();
		for (int i = 0; i < this.songsPlayed.size(); i++) {
			artistList.add(songsPlayed.get(i).getArtist());
		}
		
		return this.getLeastFreqString(artistList);
	}
	
	//Returns most frequent genre
	public String getMostFreqGenre() {
		ArrayList<String> genreList = new ArrayList<String>();
		for (int i = 0; i < this.songsPlayed.size(); i++) {
			genreList.add(songsPlayed.get(i).getGenre());
		}
		
		return this.getMostFreqString(genreList);
	}
		
	//Returns least frequent genre
	public String getLeastFreqGenre() {
		ArrayList<String> genreList = new ArrayList<String>();
		for (int i = 0; i < this.songsPlayed.size(); i++) {
			genreList.add(songsPlayed.get(i).getGenre());
		}
		
		return this.getLeastFreqString(genreList);
	}
	
	//Helper function to find most frequent string in a list
	private String getMostFreqString(ArrayList<String> list) {
		int max = 0;
		int freq;
		String mostFreq = null;
		for (String s : list) {
			freq = Collections.frequency(list, s);
			if (freq > max) {
				max = freq;
				mostFreq = s;
			}
		}
		return mostFreq;
	}
	
	//Helper function to find least frequent string in a list
	private String getLeastFreqString(ArrayList<String> list) {
		int min = 999;
		int freq;
		String leastFreq = null;
		for (String s : list) {
			freq = Collections.frequency(list, s);
			if (freq < min) {
				min = freq;
				leastFreq = s;
			}
		}
		return leastFreq;
	}
	
}
