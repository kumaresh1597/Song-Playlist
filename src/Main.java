// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Album Harris = new Album("Harris Vibes", "Harris Jayaraj");
        Harris.addSongInAlbum(new Song("Oru Maalai", "Karthik", 5));
        Harris.addSongInAlbum(new Song("Mudhar Kanave","Harish Ragavendra",6));
        Harris.addSongInAlbum(new Song("Manjal Veyil","Hariharan",5));

        Album Ani = new Album("Anirudh Hits","Anirudh");
        Ani.addSongInAlbum(new Song("Aarabic Kuthu","Anirudh",4));
        Ani.addSongInAlbum(new Song("Vaathi comming","Anirudh",3));
        Ani.addSongInAlbum(new Song("ThenMozhi","Dhanush",5));

        for(Song s : Harris.getTrackList()){
            System.out.println(s);
        }
        System.out.println("==============================");

        for(Song s : Ani.getTrackList()){
            System.out.println(s);
        }

        System.out.println("==============================");

        System.out.println(Harris.addSongInAlbum(new Song("Mudhar Kanave","Harish Ragavendra",6)));

        System.out.println("==============================");

        Playlist favourite = new Playlist("Fav");
        System.out.println(favourite.addSongFromAlbum(Harris,"Oru Maalai"));
        System.out.println(favourite.addSongFromAlbum(Ani,"Vaathi comming"));
        System.out.println(favourite.addSongToPlayListByTrackNumberFromAlbum(Ani,1));
        System.out.println(favourite.addSongToPlayListByTrackNumberFromAlbum(Harris,3));

        System.out.println("==============================");

        for(Song s : favourite.getSongList()){
            System.out.println(s);
        }
        System.out.println("==============================");

        System.out.println(favourite.deleteSongFromPlaylist("Aarabic Kuthu"));

        System.out.println("==============================");
        for(Song s : favourite.getSongList()){
            System.out.println(s);
        }
        System.out.println("==============================");

        System.out.println(favourite.curSong());

        System.out.println("==============================");

        System.out.println(favourite.playNext());

        System.out.println("==============================");

        System.out.println(favourite.playPrevious());

        System.out.println("==============================");

        System.out.println(favourite.playPrevious());

    }

}
