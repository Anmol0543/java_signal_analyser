# SignalLab: Digital Communication Simulator

## 📝 Overview of the Project
SignalLab is a cross-disciplinary, console-based Java application designed to simulate, test, and analyze the data integrity pipeline of a digital communication system under variable electronic channel noise conditions. This project demonstrates the practical application of core Object-Oriented Programming (OOP) paradigms, custom exception handling, and file I/O to fundamental Electronics and Communication Engineering (ECE) concepts.

---

## 🛠️ Features
- **Signal Generation & Quantization:** Simulates analog waveforms (Sine, Square, Sawtooth) and samples them into binary bitstreams.
- **Nyquist-Shannon Validation:** Strictly enforces sampling boundaries ($F_s \ge 2 \cdot F_{\text{signal}}$) to eliminate digital signal aliasing.
- **(7,4) Hamming Block Encoding:** Dynamically encodes data blocks using systematic parities to detect and repair single-bit transmission errors.
- **Noisy Channel Simulation:** Statistical bit-flip engine modeling stochastic real-world physical layer interference based on error probabilities.
- **Telemetry & Logging:** Automatically records transmission diagnostics, Bit Error Rates (BER), and run summaries to local files in the `data/` directory.

---

## 💻 Technologies & Tools Used
- **Language:** Java SE (JDK 8 or higher)
- **Architecture:** Object-Oriented Design (Polymorphism, Interfaces, Modular Separation)
- **Compilation Tool:** Java Compiler CLI (`javac`)
- **Runtime Environment:** Cross-platform (Windows / macOS / Linux terminal)

---

## 📂 Project Structure
```text
java_signal_analyser/
├── Main.java               # Pipeline orchestrator and console UI driver
├── SineSignal.java         # Sinusoidal waveform generation
├── SquareSignal.java       # Periodic step waveform simulation
├── TriangleSignal.java     # Linear rise/fall waveform implementation
├── NoiseSignal.java        # Stochastic noise modeling
├── STATEMENT.md            # Detailed project problem statement and scope
└── README.md               # Setup, running, and testing documentation
