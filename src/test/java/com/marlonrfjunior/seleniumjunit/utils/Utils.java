package com.marlonrfjunior.seleniumjunit.utils;



import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.text.*;
import java.util.*;

public class Utils {

    private static String environmentPropertiesPath;

    private static Properties loadTestProperties() {
        Properties prop = new Properties();
        FileInputStream input;
        try {
            input = new FileInputStream(environmentPropertiesPath);
            prop.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return prop;
    }

    public static String getTestProperty(String propertyKey) {
        try {
            if (System.getProperty(propertyKey) != null) {
                return System.getProperty(propertyKey);
            }
            Properties prop = loadTestProperties();
            return prop.getProperty(propertyKey).trim();
        } catch (Exception e) {
            String error_msg = String.format("Cannot load propertie %s. Error %s", propertyKey,
                    e.getMessage());
            throw new IllegalStateException(error_msg);
        }
    }

    public static Properties loadProperties(String propertiesPath) {
        Properties prop = new Properties();
        try {
            FileInputStream input = new FileInputStream(propertiesPath);
            prop.load(input);
            input.close();
        } catch (Exception e) {
            throw new RuntimeException("Cannot load propertie file: " + propertiesPath);
        }
        return prop;
    }


    public static String getPropertyRestsettings(String key) {
        return getProperty(loadProperties(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testsettings.properties"), key);
    }

    public static String getProperty(Properties prop, String propertyKey) {
        try {
            if (System.getProperty(propertyKey) != null) {
                return System.getProperty(propertyKey);
            }
            return prop.getProperty(propertyKey).trim();
        } catch (Exception e) {
            String error_msg = String.format("Cannot load propertie %s. Error %s", propertyKey,
                    e.getMessage());
            throw new IllegalStateException(error_msg);
        }
    }


    public static void setEnvironment() {
        String environment;
        if (System.getProperty("test.environment") != null) {
            environment = System.getProperty("test.environment");
        } else {
            environment = getTestEnvironmentFromPropertiesFile();
        }

        File environmentPropertie = new File("src" + File.separator + "test" + File.separator + "resources" + File.separator + environment + ".properties");
        if (environmentPropertie.exists()) {
            environmentPropertiesPath = "src/test/resources/" + environment + ".properties";
        } else {
            System.err.println("No known environments were selected. Create the file with the necessary properties: " + "[src" + File.separator + "test" + File.separator + "resources" + File.separator + environment + ".properties]");
        }
    }

    public static String getTestEnvironmentFromPropertiesFile() {
        Properties setEnvironment = loadProperties("src" + File.separator + "test" + File.separator + "resources" + File.separator + "select-environment.properties");
        String environment = getProperty(setEnvironment, "test.environment");
        return environment;
    }


    public static String[] getSubDirectoriesNames(String path) {
        File file = new File(path);
        String[] directories = file.list(new FilenameFilter() {
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });
        return directories;
    }

    public static void deleteAllFilesInFolder(String folderPath) {
        File folder = new File(folderPath);
        for (File f : folder.listFiles()) {
            if (!f.isDirectory())
                f.delete();
        }
    }

    public static void copyFile(String sourceFilePath, String destFilePath) {
        File sourceFile = new File(sourceFilePath);
        File destFile = new File(destFilePath);
        try {
            Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void waitForFileExistsInPath(String dir, int timeOutInSeconds) {
        File fl = new File(dir);
        File[] files = fl.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();
            }
        });

        int contador = 0;
        boolean atingiuTimeout = false;
        while (files.length == 0 && !atingiuTimeout) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contador++;
            atingiuTimeout = timeOutInSeconds == contador / 5;
            files = fl.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return file.isFile();
                }
            });
        }
        if (atingiuTimeout) {
            System.err
                    .println("Nao foi gerado arquivo no caminho - " + dir + " apos " + timeOutInSeconds + " segundos");
        }
    }


    public static File lastFileModified(String dir) {
        File fl = new File(dir);
        File[] files = fl.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();
            }
        });

        long lastMod = Long.MIN_VALUE;
        File choice = null;
        for (File file : files) {
            if (file.lastModified() > lastMod) {
                choice = file;
                lastMod = file.lastModified();
            }
        }
        return choice;
    }

    public static String getDateTime(String formato) {
        DateFormat dateFormat = new SimpleDateFormat(formato);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getDateTime(String formato, int intAcrescimoDias) {
        DateFormat dateFormat = new SimpleDateFormat(formato);
        Calendar dataAtual = Calendar.getInstance();
        dataAtual.add(Calendar.DAY_OF_MONTH, intAcrescimoDias);
        return dateFormat.format(dataAtual.getTime());
    }

    public static String removeStringFromString(String stringContent, String stringToRemove) {
        int registroPosicaoInicial = stringContent.indexOf(stringToRemove);
        int registroTamanho = stringToRemove.length();
        int arquivoTamanho = stringContent.length();
        stringContent = stringContent.substring(0, registroPosicaoInicial) + "|"
                + stringContent.substring(registroPosicaoInicial + registroTamanho, arquivoTamanho);
        return stringContent;
    }

    public static void removeLineFromFile(String filePath, String lineToRemove) {
        File inputFile = new File(filePath);
        File tempFile = new File("target/temp/temp-file.csv");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove))
                    continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            Files.move(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDate() {
        SimpleDateFormat sdfDataAtual = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        String strDate = sdfDataAtual.format(now);
        return strDate;
    }

    public static String getHour() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public static String getDateHour() {
        SimpleDateFormat sdfDataAtual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDataAtual.format(now);
        return strDate;
    }

    public static String readFileToString(String path, Charset encoding) {
        byte[] encoded = null;
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(encoded, encoding);
    }


    public static void killProcess(String process) {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            boolean isWindows = osName.startsWith("windows");
            if (isWindows) {
                Runtime.getRuntime().exec("taskkill /F /IM " + process);
            } else {
                Runtime.getRuntime().exec("kill -9 " + process);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().startsWith("windows");
    }

    public static boolean waitForAFileExistsInPath(String dir, String file, int timeOutInSeconds) {
        try {
            Thread.sleep(timeOutInSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File fl = new File(dir);
        File[] files = fl.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();
            }
        });

        for (File arquivo : files) {
            if (file.equals(arquivo.getName())) {
                return true;
            }
        }
        return false;
    }
//
//    public static Throwable logError(Scenario scenario) {
//        return new Throwable();
//    }
}