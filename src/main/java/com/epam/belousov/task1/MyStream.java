package com.epam.belousov.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class describe working with Stream class. This class also describe finding end of the World
 */
public class MyStream {
    private static final Logger log = LoggerFactory.getLogger(MyStream.class);
    private static long summary;
    private static final String fileName = "UUID.txt";

    /**
     * This method realize main logic. It call other method in this class. This method is
     * entry point for static method on this class
     */
    public void streamWork() {
        Optional<List<UUID>> list = generateRandomUuid();
        writeToFileUuid(list);
        calcUuid();
    }

    /**
     * This method generate random UUIDs
     *
     * @return list of UUIDs
     */
    private static Optional<List<UUID>> generateRandomUuid() {
        Stream<UUID> stream = Stream.generate(UUID::randomUUID)
                .limit(10000);
        List<UUID> uuidList = stream.collect(Collectors.toList());
        return Optional.ofNullable(uuidList);
    }

    /**
     * This method write to file generated UUIDs
     *
     * @param uuidList entry list included UUIDs
     */
    private static void writeToFileUuid(Optional<List<UUID>> uuidList) {
        if (uuidList.isPresent()) {
            try (Writer writer = new BufferedWriter(
                    new FileWriter(fileName))) {
                writer.write(String.valueOf(uuidList)
                        .replace("Optional", "Optional\n")
                        .replace("[", "")
                        .replace(", ", "\n")
                        .replace("]", ""));
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    /**
     * This method read UUIDs from file and calc UUIDs with the sum of digits more than 100
     */
    private static void calcUuid() {
        Path path = Paths.get(MyStream.fileName);
        try {
            summary = Files.readAllLines(path)
                    .stream()
                    .map(s -> s.replace("Optional", ""))
                    .map(s -> s.replaceAll("\\D", ""))
                    .map(s -> s.chars().map(Character::getNumericValue).sum())
                    .filter(summ -> summ > 100)
                    .count();
            log.info("The number of elements the sum of which is 100: {}", summary);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method find end of the World
     */
    public void findEndOfTheWorld() {
        LocalDateTime endOfTheWorld;
        long months = summary / 100;
        long days = summary % 100;

        endOfTheWorld = LocalDateTime.parse(
                LocalDateTime.now()
                        .plusMonths(months)
                        .plusDays(days)
                        .atZone(ZoneId.of("America/Los_Angeles"))
                        .toLocalDateTime()
                        .format(DateTimeFormatter.ISO_DATE_TIME));

        log.info("Date end of the World is: {}", endOfTheWorld);
    }
}
