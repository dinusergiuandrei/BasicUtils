package filemanager;

import filemanager.textreader.BufferedTextFileReader;
import filemanager.textreader.TextFileReader;
import filemanager.textwriter.BufferedTextFileWriter;
import filemanager.textwriter.TextFileWriter;

import java.awt.*;
import java.io.*;
import java.nio.file.Paths;

public class FileManager {

    public static Boolean createFile(String path) throws IOException {
        File file = new File(path);
        createFolder(file.getParentFile());
        if (file.exists() && file.isFile()) {
            System.out.println("File " + path + " already exists. Skipping creation...");
            return true;
        }
        file.createNewFile();
        if (!file.exists()) {
            System.out.println("Could not create file: " + path);
            return false;
        }
        return true;
    }

    public static Boolean deleteFile(String path) {
        File file = new File(path);
        return file.delete();
    }

    public static Boolean createFolder(String path) {
        return createFolder(new File(path));
    }

    public static Boolean createFolder(File file) {
        if (file.exists() && file.isDirectory())
            return true;
        file.mkdirs();
        return file.exists(); //mkdirs() returns false when folder already exists
    }

    public static void clearFile(String path) throws IOException {
        File file = new File(path);
        file.delete();
        file.createNewFile();
    }

    public static String getTextFromFile(String path) throws IOException {
        TextFileReader reader = new BufferedTextFileReader();
        reader.read(path);
        return reader.getFileAsString();
    }

    public static void writeTextToFile(String path, String text) {
        TextFileWriter writer = new BufferedTextFileWriter();
        writer.overwriteTextToFile(path, text);
    }

    public static void appendTextToFile(String path, String text) {
        TextFileWriter writer = new BufferedTextFileWriter();
        writer.appendTextToFile(path, text);
    }

    public static void openFileWithSystem(String path) throws IOException {
        try {
            Desktop.getDesktop().open(Paths.get(path).toFile());
        } catch (IOException e) {
            throw new IOException("Could not open file with the Desktop class.");
        }
    }

    public static FileOutputStream computeOutputStream(String outputPath) throws IOException {
        FileManager.createFile(outputPath);
        File file = new File(outputPath);
        return new FileOutputStream(file);
    }
}
