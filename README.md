SignalLab: Digital Communication Simulator
📝 Overview of the Project
SignalLab is a cross-disciplinary console-based Java application designed to simulate, test, and analyze the data integrity pipeline of a digital communication system under variable electronic channel noise conditions. This project demonstrates the practical application of advanced software engineering patterns (OOP, custom exceptions, file handling) to concrete Electronics and Communication Engineering (ECE) concepts.

🛠️ Features
Signal Generation & Quantization: Simulates analog waveforms (Sine, Square, Sawtooth) and samples them into binary bitstreams.
Nyquist-Shannon Validation: Strictly enforces sampling boundaries (
F
s
≥
2
⋅
F
s
i
g
n
a
l
) to prevent digital signal aliasing.
7,4 Hamming Block Encoding: Dynamically encodes data blocks using systematic parities to detect and repair transmission bit-flips.
Noisy Channel Simulation: Statistical bit-flip engine modeling stochastic real-world physical layer interference.
Automated Logging: Saves a full execution telemetry and metrics summary report directly onto local disk files.
💻 Technologies/Tools Used
Language: Java SE (JDK 8 or higher)
IDE/Text Editor: Visual Studio Code (VS Code)
Compilation Tool: Java Compiler (javac CLI infrastructure)
Operating Environment: Windows Command Prompt / Terminal
🚀 Steps to Install & Run the Project
1. Project Directory Navigation
Open your command prompt or terminal and navigate into the root directory of your project folder:

cd C:\SignalLab
2. Compilation
Compile all localized package source files into a binary classpath destination using the following command:

javac -sourcepath src -d bin src/com/signallab/Main.java
3. Execution
Launch the interactive command-line simulator using this execution command:

java -cp bin com.signallab.Main
🧪 Instructions for Testing
To test the pipeline and confirm that the error correction and parameter validations are working correctly, perform these test validation profiles during execution:

Test Case 1: Normal System Execution (Error-Correction Test)
When prompted in the menu console, input the following configuration parameters:

Waveform Type: Enter 1 (SINE)
Signal Frequency: Enter 5
Sampling Rate: Enter 20 (Valid under Nyquist-Shannon criteria)
Signal Duration: Enter 2
Channel Error Probability: Enter 0.02 (Simulates a 2% random noise layout)
Expected Output: The simulator will run completely, fix single-bit errors via parities, print an execution report card to the screen, and create an automated log file in your C:\SignalLab\data\ directory.
Test Case 2: Out-Of-Bounds Boundary Exception Validation
Waveform Type: Enter 1 (SINE)
Signal Frequency: Enter 10
Sampling Rate: Enter 15 (Intentionally invalid; breaks the condition 
15
≥
2
⋅
10
)
Expected Output: The pipeline gracefully breaks immediately, raising an InvalidSignalException with the message: Nyquist Shannon violation!. This proves the application's robust error-handling logic without crashing.
