import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Album {

    private String title;
    private String artist;
    private List<Song> trackList;

    public Album(String title, String artist, List<Song> trackList) {
        this.title = title;
        this.artist = artist;
        this.trackList = trackList;
    }

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.trackList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getTrackList() {
        return trackList;
    }

    private boolean songPresentInAlbum(Song song){
        for(Song s : trackList){
            if(s.getTitle().equals(song.getTitle()) && s.getArtist().equals(song.getArtist())){
                return true;
            }
        }
        return false;
    }
    public String addSongInAlbum(Song song){
        if(!songPresentInAlbum(song)){
            trackList.add(song);
            return "Song added Succesfully";
        }
        return "Song already present";
    }

    public Optional<Song> searchInAlbumBySongName(String songName) {
        for(Song s : trackList){
            if(s.getTitle().equals(songName)){
                return  Optional.of(s);
            }
        }
        return Optional.empty();
    }

    public Optional<Song> searchInAlbumByTrackNumber(int trackNumber) {
        if(trackNumber > trackList.size()) return Optional.empty();
        return Optional.of(trackList.get(trackNumber-1));
    }
}

