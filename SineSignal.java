package com.signallab;

public class SineSignal extends Signal {

    private double frequency;
    private double amplitude;

    public SineSignal(double frequency, double amplitude, double samplingRate) {
        super(samplingRate);
        this.frequency = frequency;
        this.amplitude = amplitude;
    }

    @Override
    public void generate(int numberOfSamples) {

        samples = new double[numberOfSamples];

        for (int i = 0; i < numberOfSamples; i++) {

            double time = i / samplingRate;

            samples[i] =
                    amplitude *
                    Math.sin(2 * Math.PI * frequency * time);
        }
    }
}