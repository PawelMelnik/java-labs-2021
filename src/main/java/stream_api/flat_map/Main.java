package stream_api.flat_map;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String beatlesSongFile = "src/main/java/stream_api/flat_map/song.txt";

        System.out.println("cnt = " + new SongCounter().countWords(beatlesSongFile));
    }
}
