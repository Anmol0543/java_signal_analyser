package com.signallab;

public class TriangleSignal extends Signal {

    private double frequency;
    private double amplitude;

    public TriangleSignal(double frequency, double amplitude, double samplingRate) {
        super(samplingRate);
        this.frequency = frequency;
        this.amplitude = amplitude;
    }

    @Override
    public void generate(int numberOfSamples) {

        samples = new double[numberOfSamples];

        for (int i = 0; i < numberOfSamples; i++) {

            double time = i / samplingRate;

            double phase = (frequency * time) % 1.0;

            samples[i] =
                    amplitude * (4 * Math.abs(phase - 0.5) - 1);
        }
    }
}