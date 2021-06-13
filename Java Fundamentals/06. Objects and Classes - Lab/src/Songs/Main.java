package Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Song> songList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] songData = scan.nextLine().split("_");
            String typeList = songData[0];
            String songName = songData[1];
            String songTime = songData[2];

            Song currentSong = new Song(typeList, songName, songTime);

            songList.add(currentSong);
        }

        String targetList = scan.nextLine();

        if(targetList.equals("all")){
            for (Song song: songList) {
                System.out.println(song.getName());
            }
        } else {
            List<Song> filteredSongs= songList.stream()
                .filter(x -> x.getTypeList().equals(targetList))
                .collect(Collectors.toList());

            for (Song song: filteredSongs) {
                System.out.println(song.getName());
            }
        }

    }
}
