import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class Playlist {
    private String title;
    private List<Song> songList;
    private boolean wasNext;
    private ListIterator<Song> itr;

    public Playlist(String title) {
        this.title = title;
        this.songList = new ArrayList<>();
        itr = songList.listIterator();
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
            return "Song Successfully added in playlist";
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
    public String addSongFromAlbum(Album album,String songName){
        Optional<Song> songInAlbum = album.searchInAlbum(songName);
        if(songInAlbum.isEmpty()) return "Song not present in album";
        Song SA = songInAlbum.get();
        songList.add(SA);
        return "Song successfully added in playlist";
    }
}

