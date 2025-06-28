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

## Project Structure

