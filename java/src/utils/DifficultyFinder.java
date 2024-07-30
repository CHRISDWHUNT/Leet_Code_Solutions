package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DifficultyFinder {
    private static final String DIFFICULTY_TAG = "@Difficulty:";
    private static Map<String, Integer> difficultyMap = new HashMap<>();

    public static void analyseFiles(File[] files) {
        if (noFilesAreProvided(files)) return;
        difficultyMap = new HashMap<>();
        processAllFiles(files);
        printResults();
    }

    private static boolean noFilesAreProvided(File[] files) {
        if (files == null) {
            System.err.println("Invalid directory or directory is empty.");
            return true;
        }
        return false;
    }

    private static void processAllFiles(File[] files) {
        for (File file : files) {
            if (file.isFile()) processFile(file);
        }
    }

    private static void printResults() {
        System.out.println("Difficulty counts:");
        for (Map.Entry<String, Integer> entry : difficultyMap.entrySet()) {
            System.out.printf("%10s: %3d\n", entry.getKey(), entry.getValue());
        }
    }

    private static void processFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            locateDifficulty(reader);
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName());
            e.printStackTrace();
        }
    }

    private static void locateDifficulty(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(DIFFICULTY_TAG) && difficultyLevelWasExtracted(line)) break;
        }
    }

    private static boolean difficultyLevelWasExtracted(String line) {
        String[] parts = line.split(":");
        if (parts.length == 2) {
            String difficulty = parts[1].trim();
            difficultyMap.put(difficulty, difficultyMap.getOrDefault(difficulty, 0) + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        File directory = new File("./java/src/");
        analyseFiles(directory.listFiles());
    }
}