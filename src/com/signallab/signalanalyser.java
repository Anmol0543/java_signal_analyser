package com.signallab;

public class SignalAnalyzer {

    public double calculateMean(double[] samples) {

        double sum = 0;

        for (double sample : samples) {
            sum += sample;
        }

        return sum / samples.length;
    }

    public double calculateRMS(double[] samples) {

        double sum = 0;

        for (double sample : samples) {
            sum += sample * sample;
        }

        return Math.sqrt(sum / samples.length);
    }

    public double calculateMaximum(double[] samples) {

        double maximum = samples[0];

        for (double sample : samples) {

            if (sample > maximum) {
                maximum = sample;
            }
        }

        return maximum;
    }

    public double calculateMinimum(double[] samples) {

        double minimum = samples[0];

        for (double sample : samples) {

            if (sample < minimum) {
                minimum = sample;
            }
        }

        return minimum;
    }

    public double calculatePeakToPeak(double[] samples) {

        return calculateMaximum(samples)
                - calculateMinimum(samples);
    }

    public void printAnalysis(double[] samples) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("          SIGNAL ANALYSIS");
        System.out.println("========================================");

        System.out.printf("Mean         : %.4f%n",
                calculateMean(samples));

        System.out.printf("RMS          : %.4f%n",
                calculateRMS(samples));

        System.out.printf("Maximum      : %.4f%n",
                calculateMaximum(samples));

        System.out.printf("Minimum      : %.4f%n",
                calculateMinimum(samples));

        System.out.printf("Peak-to-Peak : %.4f%n",
                calculatePeakToPeak(samples));

        System.out.println("========================================");
    }
}