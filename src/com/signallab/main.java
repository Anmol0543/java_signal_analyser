package com.signallab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        double[] currentSignal = null;

        double samplingRate = 1000;

        SignalAnalyzer analyzer =
                new SignalAnalyzer();

        SignalProcessor processor =
                new SignalProcessor();

        DFTAnalyzer dft =
                new DFTAnalyzer();

        CSVManager csv =
                new CSVManager();

        ReportGenerator report =
                new ReportGenerator();

        int choice;

        do {

            System.out.println();
            System.out.println(
                    "========================================"
            );
            System.out.println(
                    "       JAVA SIGNAL ANALYZER"
            );
            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "1. Generate Sine Signal"
            );

            System.out.println(
                    "2. Generate Square Signal"
            );

            System.out.println(
                    "3. Generate Triangle Signal"
            );

            System.out.println(
                    "4. Generate Noise"
            );

            System.out.println(
                    "5. Analyze Signal"
            );

            System.out.println(
                    "6. Normalize Signal"
            );

            System.out.println(
                    "7. Moving Average Filter"
            );

            System.out.println(
                    "8. Perform DFT"
            );

            System.out.println(
                    "9. Save Signal"
            );

            System.out.println(
                    "10. Generate Report"
            );

            System.out.println(
                    "0. Exit"
            );

            System.out.print(
                    "Enter your choice: "
            );

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    currentSignal =
                            createSineSignal(scanner);

                    samplingRate =
                            getSamplingRate(scanner);

                    currentSignal =
                            generateSignal(
                                    currentSignal,
                                    samplingRate
                            );

                    break;

                case 2:

                    currentSignal =
                            createSquareSignal(scanner);

                    samplingRate =
                            getSamplingRate(scanner);

                    currentSignal =
                            generateSignal(
                                    currentSignal,
                                    samplingRate
                            );

                    break;

                case 3:

                    currentSignal =
                            createTriangleSignal(scanner);

                    samplingRate =
                            getSamplingRate(scanner);

                    currentSignal =
                            generateSignal(
                                    currentSignal,
                                    samplingRate
                            );

                    break;

                case 4:

                    System.out.print(
                            "Enter amplitude: "
                    );

                    double noiseAmplitude =
                            scanner.nextDouble();

                    samplingRate =
                            getSamplingRate(scanner);

                    System.out.print(
                            "Enter number of samples: "
                    );

                    int noiseSamples =
                            scanner.nextInt();

                    NoiseSignal noise =
                            new NoiseSignal(
                                    noiseAmplitude,
                                    samplingRate
                            );

                    noise.generate(noiseSamples);

                    currentSignal =
                            noise.getSamples();

                    System.out.println(
                            "Noise signal generated."
                    );

                    break;

                case 5:

                    if (checkSignal(currentSignal)) {
                        analyzer.printAnalysis(
                                currentSignal
                        );
                    }

                    break;

                case 6:

                    if (checkSignal(currentSignal)) {

                        currentSignal =
                                processor.normalize(
                                        currentSignal
                                );

                        System.out.println(
                                "Signal normalized."
                        );
                    }

                    break;

                case 7:

                    if (checkSignal(currentSignal)) {

                        System.out.print(
                                "Enter window size: "
                        );

                        int window =
                                scanner.nextInt();

                        currentSignal =
                                processor.movingAverage(
                                        currentSignal,
                                        window
                                );

                        System.out.println(
                                "Moving average applied."
                        );
                    }

                    break;

                case 8:

                    if (checkSignal(currentSignal)) {

                        double dominant =
                                dft.findDominantFrequency(
                                        currentSignal,
                                        samplingRate
                                );

                        System.out.println();
                        System.out.println(
                                "================================"
                        );

                        System.out.printf(
                                "Dominant Frequency: %.2f Hz%n",
                                dominant
                        );

                        System.out.println(
                                "================================"
                        );
                    }

                    break;

                case 9:

                    if (checkSignal(currentSignal)) {

                        csv.saveSignal(
                                currentSignal,
                                "data/signal.csv"
                        );
                    }

                    break;

                case 10:

                    if (checkSignal(currentSignal)) {

                        report.generateReport(
                                currentSignal,
                                samplingRate,
                                "results/report.txt"
                        );
                    }

                    break;

                case 0:

                    System.out.println(
                            "Thank you for using Java Signal Analyzer!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }

        } while (choice != 0);

        scanner.close();
    }


    private static Signal createSineSignal(
            Scanner scanner) {

        System.out.print(
                "Enter frequency (Hz): "
        );

        double frequency =
                scanner.nextDouble();

        System.out.print(
                "Enter amplitude: "
        );

        double amplitude =
                scanner.nextDouble();

        double samplingRate =
                getSamplingRate(scanner);

        System.out.print(
                "Enter number of samples: "
        );

        int samples =
                scanner.nextInt();

        SineSignal signal =
                new SineSignal(
                        frequency,
                        amplitude,
                        samplingRate
                );

        signal.generate(samples);

        System.out.println(
                "Sine signal generated."
        );

        return signal;
    }


    private static Signal createSquareSignal(
            Scanner scanner) {

        System.out.print(
                "Enter frequency (Hz): "
        );

        double frequency =
                scanner.nextDouble();

        System.out.print(
                "Enter amplitude: "
        );

        double amplitude =
                scanner.nextDouble();

        double samplingRate =
                getSamplingRate(scanner);

        System.out.print(
                "Enter number of samples: "
        );

        int samples =
                scanner.nextInt();

        SquareSignal signal =
                new SquareSignal(
                        frequency,
                        amplitude,
                        samplingRate
                );

        signal.generate(samples);

        System.out.println(
                "Square signal generated."
        );

        return signal;
    }


    private static Signal createTriangleSignal(
            Scanner scanner) {

        System.out.print(
                "Enter frequency (Hz): "
        );

        double frequency =
                scanner.nextDouble();

        System.out.print(
                "Enter amplitude: "
        );

        double amplitude =
                scanner.nextDouble();

        double samplingRate =
                getSamplingRate(scanner);

        System.out.print(
                "Enter number of samples: "
        );

        int samples =
                scanner.nextInt();

        TriangleSignal signal =
                new TriangleSignal(
                        frequency,
                        amplitude,
                        samplingRate
                );

        signal.generate(samples);

        System.out.println(
                "Triangle signal generated."
        );

        return signal;
    }


    private static double getSamplingRate(
            Scanner scanner) {

        System.out.print(
                "Enter sampling rate (Hz): "
        );

        return scanner.nextDouble();
    }


    private static double[] generateSignal(
            Signal signal,
            double samplingRate) {

        return signal.getSamples();
    }


    private static boolean checkSignal(
            double[] signal) {

        if (signal == null) {

            System.out.println(
                    "Please generate a signal first."
            );

            return false;
        }

        return true;
    }
}