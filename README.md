📦 Flipkart Search Automation (Selenium + TestNG)

📌 Project Overview

This project automates product search and validation scenarios on Flipkart using Selenium WebDriver, TestNG, and Java.

The automation is built to satisfy platform assessment rules including:

WebDriverWait usage

Logging using System.out.println

Chrome DevTools log validation (TypeElement, GetElementText etc.)

Clean wrapper-based reusable design

🛠 Tech Stack

Java

Selenium WebDriver

TestNG

Gradle

ChromeDriver

Selenium Manager

📂 Project Structure
src
 └── test
      ├── java
      │    ├── demo
      │    │    ├── TestCases.java
      │    │    └── wrappers
      │    │         └── Wrappers.java

✅ Automated Test Scenarios
🔎 Test Case 01 — Washing Machine Rating Validation

Steps

Navigate to Flipkart

Search for Washing Machine

Sort by Popularity

Count products with rating ≤ 4

Validations

Search text logging

Rating extraction using GetElementText

Console output of count

📱 Test Case 02 — iPhone Discount Validation

Steps

Navigate to Flipkart

Search for iPhone

Extract discount values

Print products with discount > 17%

Validations

Discount text extraction

Discount numeric parsing

Product title + discount logging

☕ Test Case 03 — Coffee Mug Review & Image Validation

Steps

Navigate to Flipkart

Search for Coffee Mug

Apply 4★ & Above filter

Print Top 5 products based on reviews

Print Image URLs

Validations

Review count extraction

Image URL extraction

Console logging

⚙️ Key Framework Features
✔ Explicit Wait Handling
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

✔ Wrapper-Based Reusable Design

All reusable actions are inside:

Wrappers.java


Examples:

Navigation

Search

Sorting

Filters

Data Extraction


▶ How To Run
Run Using Gradle
./gradlew test

Run Assessment Script
./run_platform_assesment.sh

📊 Assessment Compliance

✔ WebDriverWait implemented
✔ Console logging implemented
✔ No unnecessary Thread.sleep usage

🧠 Learnings From This Project

Handling dynamic web elements

Using Explicit Wait properly

Extracting structured data from UI

Writing automation aligned to log-based validation

Debugging Gradle + Selenium + TestNG together


👨‍💻 Author

Shubham Gokhale
Automation QA | Selenium | API Testing | SDET
