Project Introduction

I recently worked on an automation project where I automated product search scenarios on Flipkart using Selenium WebDriver, Java, TestNG, and Gradle.

The goal of the project was not just UI automation, but also to build automation that satisfies:

    Log-based validation

    Framework quality checks

    Proper waits implementation

    Logging and reusable framework design

✅ 2️⃣ Why I Built This Project

I built this project to strengthen my real-world automation skills, especially around:

    Dynamic UI handling

    Data extraction from product listings

    Framework design using wrapper classes

It also helped me practice writing automation aligned with platform assessment rules like:

    Mandatory waits

    Logging validations

    Clean framework structure

✅ 3️⃣ Framework Design

    I designed the framework using a Wrapper-Based Approach.

Instead of writing Selenium code directly inside test cases, I created a Wrappers class which contains reusable methods like:

    Navigation handling

    Search operations

    Sorting operations

    Filter handling

    Product data extraction

🔹 Benefits

    Improves reusability

    Improves maintainability

    Makes test cases clean and readable

✅ 4️⃣ Test Scenarios Implemented

🧺 Test Case 1 — Washing Machine Rating Validation

Scenario Flow

    Search for Washing Machine

    Sort results by Popularity

    Count products with rating ≤ 4

Technical Implementation

    Used Explicit Waits for dynamic loading

     Extracted rating using element text

    Filtered rating values programmatically

📱 Test Case 2 — iPhone Discount Validation

Scenario Flow

    Search for iPhone
  
    Extract discount percentage from product cards
  
    Filter products with discount > 17%

    Print product title and discount

Technical Implementation

    Text parsing using Regex

    Parent element traversal to fetch product title

☕ Test Case 3 — Coffee Mug Review & Image Validation

Scenario Flow

    Search Coffee Mug

    Apply 4 Star & Above filter

Extract:

    Review count

    Image URL

    Print Top 5 products

Technical Implementation

    List handling using WebElement collections

    Index-based mapping of reviews and images

✅ 5️⃣ Technical Challenges Faced
🔸 Dynamic UI Handling

    Flipkart UI changes frequently, which makes locator stability difficult.

Solution

    Used Explicit Waits

    Used Flexible XPath strategies

🔸 Log-Based Validation Requirements

    Platform required specific commands in browser logs.

Solution

    Added structured logging

    Ensured element text extraction happens properly

✅ 6️⃣ Selenium Concepts Used

    WebDriverWait

ExpectedConditions

    Dynamic XPath Handling

    Exception Handling

    List Data Extraction

    Wrapper Design Pattern

✅ 7️⃣ Key Learnings

This project helped me improve:

    Real-world UI automation handling

    Framework design thinking

    Selenium + Gradle + TestNG integration debugging

    Writing automation aligned with platform evaluation rules
