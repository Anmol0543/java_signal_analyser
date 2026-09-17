package com.signallab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {
    public void generateReport(double[] samples, double samplingRate, String filePath) {
        try {
            File file = new File(filePath);
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            SignalAnalyzer analyzer = new SignalAnalyzer();
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("====================================\n");
                writer.write("       SIGNAL ANALYSIS REPORT       \n");
                writer.write("====================================\n");
                writer.write("Sampling Rate : " + samplingRate + " Hz\n");
                writer.write("Total Samples : " + samples.length + "\n");
                writer.write(String.format("Mean          : %.4f%n", analyzer.calculateMean(samples)));
                writer.write(String.format("RMS           : %.4f%n", analyzer.calculateRMS(samples)));
                writer.write(String.format("Peak-to-Peak  : %.4f%n", analyzer.calculatePeakToPeak(samples)));
                writer.write(String.format("Max / Min     : %.4f / %.4f%n", analyzer.calculateMaximum(samples), analyzer.calculateMinimum(samples)));
            }
            System.out.println("Report generated successfully at: " + filePath);
        } catch (IOException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }
}