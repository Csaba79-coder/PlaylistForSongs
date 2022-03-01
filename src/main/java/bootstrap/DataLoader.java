package bootstrap;

import lombok.*;
import model.Album;
import model.Menu;
import model.Song;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataLoader {

    private ArrayList<Album> albums = new ArrayList<>();

    public void load() {
        Album album = new Album("Stormbringer", "Deep Purple");

        album.addSong("Stormbringer", 4.6);
        album.addSong("Love Don't Mean A Thing", 4.22);
        album.addSong("Holy Man", 4.3);
        album.addSong("Hold On", 5.6);
        album.addSong("Lady Double Dealer", 3.21);
        album.addSong("You Can't Do It Right", 6.23);
        album.addSong("High Ball Shooter", 4.27);
        album.addSong("The Gypsy", 4.2);
        album.addSong("Soldier of Fortune", 3.13);

        albums.add(album);

        album = new Album("For those about to rock!", "AC/DC");
        album.addSong("For those about to rock!", 5.44);
        album.addSong("I Put The Finger On You", 3.25);
        album.addSong("Let's Go", 3.45);
        album.addSong("Inject The Venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil Walks", 3.45);
        album.addSong("C.O.D", 5.25);
        album.addSong("Breaking The Rules", 5.32);
        album.addSong("Night Of The Long Knives", 5.12);

        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();

        albums.get(0).addToPlayList("You Can't Do It Right", playList);
        albums.get(0).addToPlayList("Holy Man", playList);
        albums.get(0).addToPlayList("Speed King", playList); // This one does not exist!!! on the album!

        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(6, playList);
        albums.get(1).addToPlayList(26, playList); // does not exist either!

        play(playList);
    }

    private void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) { // playList.isEmpty()
            System.out.println("There are no songs in playlist!");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString()); // using toString() because of Song Object!
            new Menu().printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing: " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing: " + listIterator.previous().toString());
                    } else {
                        System.out.println("This is the first song on the playlist.");
                        forward = true;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            // listIterator.previous();
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the first track!");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying: " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list.");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    new Menu().printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing: " + listIterator.next().toString());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing: " + listIterator.previous().toString());
                        } else {
                            new Menu().printMenu();
                        }
                    }
                    break;
                    /*try {
                        if (playList.size() > 0) {
                            listIterator.remove();
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        new Menu().printMenu();
                    }
                    break;
                    */
            }
        }
    }

    private void printList(LinkedList<Song> playList) {
        Iterator<Song> songIterator = playList.listIterator();
        System.out.println("================================");
        while (songIterator.hasNext()) {
            System.out.println(songIterator.next().toString());
        }
        System.out.println("================================");
    }
}
