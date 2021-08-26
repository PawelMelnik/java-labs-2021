package stream_api.flat_map;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SongCounter {

    public Long countWords(String fileName) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        long count = bufferedReader.lines()
                .map(s -> s.split("[\\s]+"))
                .flatMap(Arrays::stream)
                .peek(System.out::println)
                .count();

        return count;
    }
}
