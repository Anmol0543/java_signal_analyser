package com.signallab;

public abstract class Signal {

    protected double[] samples;
    protected double samplingRate;

    public Signal(double samplingRate) {
        this.samplingRate = samplingRate;
    }

    public abstract void generate(int numberOfSamples);

    public double[] getSamples() {
        return samples;
    }

    public double getSamplingRate() {
        return samplingRate;
    }
}