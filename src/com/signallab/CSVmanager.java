package com.signallab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVManager {
    public void saveSignal(double[] samples, String filePath) {
        try {
            File file = new File(filePath);
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Index,Amplitude\n");
                for (int i = 0; i < samples.length; i++) {
                    writer.write(i + "," + samples[i] + "\n");
                }
            }
            System.out.println("Signal saved successfully to: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving signal: " + e.getMessage());
        }
    }
}
