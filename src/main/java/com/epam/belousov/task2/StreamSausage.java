package com.epam.belousov.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class describe work with sausage stream
 */
public class StreamSausage {
    Logger log = LoggerFactory.getLogger(StreamSausage.class);

    /**
     * This method read encoding text from the file and decode this text into buffer.
     * Also create list with configure for fields by objects Sausage class
     *
     * @param fileName - input encoding file
     */
    public void streamSausage(String fileName) {
        Base64.Decoder decoder = Base64.getDecoder();
        Path pathToFile = Paths.get(fileName);
        try {
            List<Sausage> sausageList = Files.readAllLines(pathToFile)
                    .stream()
                    .filter(Objects::nonNull)
                    .map(decoder::decode)
                    .map(String::new)
                    .map(s -> Arrays.stream(s.split(","))
                            .map(obj -> obj.split("=")[1])
                            .collect(Collectors.toList()))
                    .map(Sausage::new)
                    .collect(Collectors.toList());
            log.info(String.valueOf(sausageList));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
