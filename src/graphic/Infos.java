package graphic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Infos {
    public static String authors;
    public static String systemName;
    public static String copyRight;
    public static String date;
    public static String helpFile;
    public static String disclaimerFile;

    public static String version = "Ver. 1.0";
    public static String ResourceFolder = "/resources/";
    public static String sep = System.getProperty("file.separator");
    public static String path = System.getProperty("user.dir") + sep + "UnitConverter" + sep 
        + "src" + sep + ResourceFolder + sep; 

    public Infos() {
        String[] infoText = getAtributes(getTextFromFile(defineLanguageFile()));

        authors = infoText[0];
        systemName = infoText[1];
        copyRight = infoText[2] + " " + authors + ". " + infoText[3];
        date = infoText[4];
        helpFile = infoText[5];
        disclaimerFile = infoText[6];
    }

    public String defineLanguageFile() {
        String language = System.getProperty("user.language");
        String languageFile = "";

        if (language.equals("pt"))
            languageFile = "PortugueseInfos.txt";
        else 
            languageFile = "EnglishInfos.txt";
        System.out.println("Estou em define language: " + languageFile);
        return languageFile;
    }

    public static String getAbout() {
        StringBuilder aboutText = new StringBuilder();

        aboutText.append("\n");
        aboutText.append(systemName + "\n");
        aboutText.append(date + "- ");
        aboutText.append(version + "\n");
        aboutText.append(authors + "\n" + "\n");
        aboutText.append(copyRight + "\n");

        return aboutText.toString();
    }

    public static String[] getAtributes(String fileText) {
        String[] infoArray = fileText.toString().split(Pattern.quote("|"));
        return infoArray;
    }

    public static String getDisclaimerText() {
        return getTextFromFile(path + disclaimerFile);
    }

    public static String getHelpText() {
        return getTextFromFile(path + helpFile);
    }

    
    public static String getLongVersion() {
        System.out.println("longVersion " + systemName + " - " + version + " - " + date);
        return (systemName + " - " + version + " - " + date);
    }

    public static String getShortVersion() {
    return (version + " - " + date);
    }

    public static String getTextFromFile(String fileName) {
        StringBuilder fileText = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path + fileName))) {
            String buffer = "";

            while ((buffer = reader.readLine()) != null) {
                fileText.append(buffer);
            }
        } catch (IOException e) {
            System.out.println("Error reading " + fileName + "\n" + e.getMessage());
        }
        System.out.println("Estou em getTextFromFile: " + fileName);
        System.out.println("Acabei de ler esse arquivo: " + fileText.toString());
        
        return fileText.toString();
    }
} 
