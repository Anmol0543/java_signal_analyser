package com.signallab;

public class DFTAnalyzer {

    public double[] calculateMagnitude(
            double[] samples,
            double samplingRate) {

        int N = samples.length;

        int frequencyBins = N / 2;

        double[] magnitude =
                new double[frequencyBins];

        for (int k = 0; k < frequencyBins; k++) {

            double real = 0;
            double imaginary = 0;

            for (int n = 0; n < N; n++) {

                double angle =
                        2 * Math.PI * k * n / N;

                real +=
                        samples[n] * Math.cos(angle);

                imaginary -=
                        samples[n] * Math.sin(angle);
            }

            magnitude[k] =
                    Math.sqrt(
                            real * real +
                            imaginary * imaginary
                    ) / N;
        }

        return magnitude;
    }

    public double findDominantFrequency(
            double[] samples,
            double samplingRate) {

        double[] magnitude =
                calculateMagnitude(
                        samples,
                        samplingRate
                );

        int dominantIndex = 0;

        for (int i = 1; i < magnitude.length; i++) {

            if (magnitude[i] >
                    magnitude[dominantIndex]) {

                dominantIndex = i;
            }
        }

        return dominantIndex *
                samplingRate /
                samples.length;
    }
}