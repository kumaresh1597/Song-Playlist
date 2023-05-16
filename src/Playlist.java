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
        this.wasNext = false;
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
        Optional<Song> songPresent = isSongPresentInPlaylist(song.getTitle());
        if (songPresent.isEmpty()) {
            songList.add(song);
            itr = songList.listIterator();
            return "Song Successfully added in playlist";
        }
        return "Song already exists in playlist";
    }

    private Optional<Song> isSongPresentInPlaylist(String songName) {
        for (Song s: songList) {
            if(s.getTitle().equals(songName)){
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }
    public String addSongFromAlbum(Album album,String songName){
        Optional<Song> songInAlbum = album.searchInAlbumBySongName(songName);
        if(songInAlbum.isEmpty()) return "Song not present in album";
        return addSongToPlayList(songInAlbum.get());
    }

    public String addSongToPlayListByTrackNumberFromAlbum(Album album,int trackNumber){
        Optional<Song> songInAlbum = album.searchInAlbumByTrackNumber(trackNumber);
        if(songInAlbum.isEmpty()) return "Song not present in Album";
        return addSongToPlayList(songInAlbum.get());
    }

    public String deleteSongFromPlaylist(String songName){
        Optional<Song> songToDel = isSongPresentInPlaylist(songName);
        if(songToDel.isPresent()){
            songList.remove(songToDel.get());
            itr = songList.listIterator();
            return "Song successfully deleted from playlist";
        }
        return "Song does not exists";
    }

    public String playNext(){
        if(!wasNext){
            wasNext = true;
            itr.next();
        }
        if(itr.hasNext()){
            wasNext = true;
            Song nxtSong = itr.next();
            return "Next Song is: "+ nxtSong.getTitle();
        }
        return "No more next song,PlayList end.";
    }
    public String playPrevious(){
        if(wasNext){
            wasNext = false;
            itr.previous();
        }
        if(itr.hasPrevious()){
            wasNext = false;
            Song prevSong = itr.previous();
            return "Previous Song is: "+ prevSong.getTitle();
        }
        return "No more previous song,PlayList end.";
    }
    public  String curSong(){
        if(wasNext){
            wasNext = false;
            return "Current song is: "+ itr.previous().getTitle();
        }
        wasNext = true;
        return "Current song is: "+ itr.next().getTitle();
    }
}

