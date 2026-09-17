# Smart Exam Grade Predictor & Performance Analyzer

## Overview

Smart Exam Grade Predictor is a Java-based GUI application developed to
help students calculate and predict their examination grades.

The application allows users to enter examination marks, predict their
grade, calculate marks required for a target grade, and analyze their
overall performance.

## Objectives

- Calculate total examination marks.
- Predict the expected grade.
- Calculate marks required for a target grade.
- Analyze student performance.
- Provide input validation.
- Save examination results to a text file.

## Features

1. Student Details Input
2. Subject Marks Input
3. Grade Prediction
4. Target Grade Calculator
5. Performance Analysis
6. Input Validation
7. Report Generation
8. File Handling

## Grading Rules

| Marks | Grade | Grade Point |
|------:|:-----:|------------:|
| 90–100 | A+ | 10 |
| 80–89 | A | 9 |
| 70–79 | B+ | 8 |
| 60–69 | B | 7 |
| 50–59 | C | 6 |
| 40–49 | D | 5 |
| Below 40 | F | 0 |

## Marks Distribution

- Internal Assessment: 40 marks
- Mid-Term: 30 marks
- End-Semester: 30 marks
- Total: 100 marks

## Technologies Used

- Java
- Java Swing
- Object-Oriented Programming
- ArrayList
- Exception Handling
- File Handling
- Git & GitHub

## Project Structure

```text
SmartExamGradePredictor/
│
├── src/
│   ├── Main.java
│   ├── Student.java
│   ├── Subject.java
│   ├── GradeCalculator.java
│   ├── GradePredictor.java
│   ├── TargetCalculator.java
│   ├── PerformanceAnalyzer.java
│   ├── InputValidator.java
│   └── FileManager.java
│
├── README.md
└── statement.md
