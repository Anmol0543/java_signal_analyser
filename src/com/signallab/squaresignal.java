package com.signallab;

public class SquareSignal extends Signal {

    private double frequency;
    private double amplitude;

    public SquareSignal(double frequency, double amplitude, double samplingRate) {
        super(samplingRate);
        this.frequency = frequency;
        this.amplitude = amplitude;
    }

    @Override
    public void generate(int numberOfSamples) {

        samples = new double[numberOfSamples];

        for (int i = 0; i < numberOfSamples; i++) {

            double time = i / samplingRate;

            double sineValue =
                    Math.sin(2 * Math.PI * frequency * time);

            if (sineValue >= 0) {
                samples[i] = amplitude;
            } else {
                samples[i] = -amplitude;
            }
        }
    }
}