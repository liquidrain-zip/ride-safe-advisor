# Smart Motorcycle Ride Safety Advisor

## Overview

The **Smart Motorcycle Ride Safety Advisor** is a Java-based command-line application designed to help motorcyclists assess the safety of riding conditions in real-time using Singapore’s live weather data. It leverages fuzzy logic to interpret uncertain and variable weather inputs—specifically rainfall and wind speed—and provides graded ride safety advice: 

- **Safe to Ride**  
- **Ride with Caution**  
- **Unsafe to Ride**

This tool integrates with Singapore’s Data.gov.sg APIs to fetch up-to-date rainfall and wind speed data across multiple monitoring stations. It then applies a fuzzy inference system implemented with the JFuzzyLogic library to evaluate risk levels intuitively.

---

## Features

- Fetches **real-time rainfall** and **wind speed** data from official Singapore government APIs.
- Allows users to select specific monitoring stations or view overall average weather data.
- Uses a fuzzy logic system to interpret weather severity and recommend safety advice.
- Modular Java codebase with clear MVC structure for easy maintenance and extensibility.
- Command-line interface for quick and simple interaction.
- Includes a test suite for fuzzy logic scenarios.

---

### Prerequisites

- Java Development Kit (JDK) 11 or above installed.
- Internet connection to fetch live weather data.
- External libraries placed inside the `lib/` directory:
  - `jfuzzylogic.jar`
  - `jackson-annotations-x.x.x.jar`
  - `jackson-core-x.x.x.jar`
  - `jackson-databind-x.x.x.jar`

---

### Building and Running

1. Make sure you have Java installed (JDK 11+).  
2. Download the required libraries into `lib/`:  
   - `jfuzzylogic.jar`  
   - `jackson-annotations.jar`  
   - `jackson-core.jar`  
   - `jackson-databind.jar`  
3. Compile the code:  
   ```bash
   javac -cp "lib/*" -d bin $(find src -name "*.java")
4. Run the app:
   ```bash
   java -cp "bin:lib/*" com.smartrideadvisor.controller.SmartRideAdvisor
   (On Windows, replace : with ; in the classpath)

---
   
### Using the app
- When prompted, enter a station ID to see local rainfall and wind speed, or just press Enter to see overall data.

- The program shows the weather data and safety advice based on fuzzy logic.

- After results, you can enter another station ID or type exit to quit.

---

### Testing fuzzy logic
Run the built-in tests to check how fuzzy logic responds to different inputs:
bash
java -cp "bin:lib/*" com.smartrideadvisor.test.ScenarioTester

---

### How fuzzy logic helps
Fuzzy logic allows the program to handle vague weather conditions like “moderate rain” or “breezy wind” instead of strict thresholds. This leads to more natural, human-like safety advice.

---

### Possible improvements
- Add more weather inputs like temperature or visibility.
- Build a graphical or mobile app version.
- Save past data and advice for analysis.
- Add notifications for sudden weather changes.

---

### References
- Data.gov.sg — Official Singapore government open data
- JFuzzyLogic Library — http://jfuzzylogic.sourceforge.net/
- Classic fuzzy logic papers by L. A. Zadeh and others

---

Ride safe and enjoy your ride! 🏍️🌧️🌬️



 
	
  