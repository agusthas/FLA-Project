package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Singleton class for handling file operations.
 */
public class FileHandler {
    private static final String FILE_NAME = "adventure.txt";
    private static FileHandler instance;
    private final String filePath;

    private FileHandler() {
        this.filePath = System.getProperty("user.dir") + "/" + FILE_NAME;
    }

    /**
     * Get the instance of the FileHandler.
     *
     * @return The instance of the FileHandler.
     */
    public static FileHandler getInstance() {
        if (instance == null) {
            instance = new FileHandler();
        }
        return instance;
    }

    /**
     * Checks if the filepath exists.
     */
    private boolean fileExists() {
        return Files.exists(Path.of(this.filePath));
    }

    /**
     * Append a line to the end of the file.
     *
     * @param line The line to append.
     */
    public void appendLine(String line) {
        try {
            Files.writeString(Path.of(this.filePath), line, fileExists() ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read all lines from the file.
     *
     * @return List of lines from the file.
     */
    public List<String> readLines() {
        try {
            List<String> lines = Files.readAllLines(Path.of(this.filePath));
            return lines.stream().filter(line -> !line.isBlank()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
