import java.util.List;
import java.util.Optional;

public class Playlist {
    private String title;
    private List<Song> songList;

    public Playlist(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public String addSongToPlayList(Song song) {
        Optional<Song> songPresent = songPresentInPlaylist(song);
        if (songPresent.isEmpty()) {
            songList.add(song);
            return "Song Successfully added";
        }
        return "Song already exists";
    }

    private Optional<Song> songPresentInPlaylist(Song song) {
        for (Song s: songList) {
            if(s.getTitle().equals(song.getTitle()) && s.getArtist().equals(song.getArtist())){
                return Optional.of(song);
            }
        }
        return Optional.empty();
    }
}

