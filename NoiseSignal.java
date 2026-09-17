package com.signallab;

import java.util.Random;

public class NoiseSignal extends Signal {

    private double amplitude;
    private Random random;

    public NoiseSignal(double amplitude, double samplingRate) {
        super(samplingRate);
        this.amplitude = amplitude;
        this.random = new Random();
    }

    @Override
    public void generate(int numberOfSamples) {

        samples = new double[numberOfSamples];

        for (int i = 0; i < numberOfSamples; i++) {

            samples[i] =
                    (random.nextDouble() * 2 - 1) * amplitude;
        }
    }
}