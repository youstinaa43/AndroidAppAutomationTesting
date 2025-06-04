
# 📱 Android App Automation Framework

## ✅ Objective
Automate core functionalities of the **API Demos** on real Android devices using **Appium**, focusing on reliability and maintainability.

---

## 🧪 Scope of Testing

- 📲 Tested on **real Android device** via USB
- 🔍 Element inspection using **Appium Inspector**

---

## 🛠️ Framework Features

### 🔧 Technology Stack

| Component         | Purpose                          |
|-------------------|----------------------------------|
| Java              | Programming language             |
| Appium            | Mobile automation                |
| TestNG            | Test management                  |
| POM               | Test structure                   |
| Appium Inspector  | Element inspection               |
| Maven             | Dependency management            |
| Real Device       | Actual execution environment     |

---

## 📂 Project Structure
Mobile_Testing_FrameWork
├── pom.xml
├── drivers
│   └── ApiDemos-debug.apk
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── actions
│   │   │   │   └── ElementActions.java
│   │   │   ├── pages
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── AccessibilityPage.java   and so on 
│   │   │   
│   │   └── resources
│   │       └── config.properties
│   └── test
│       ├── java
│       │   ├── BaseTest.java
│       │   ├── TC_001_VerifyPreferenceDependencie.java  and so on
│       │   
│       └── resources
│           └── testng.xml

---

## 🔌 Device Setup

1. Enable **Developer Options** and **USB Debugging** on your Android phone.
2. Connect the device via USB.
3. Verify with:
```bash
adb devices
▶️ How to Run
bash
Copy
Edit
git clone https://github.com/youstinaa43/AndroidAppAutomationTesting.git
cd AndroidAppAutomationTesting
mvn clean test
⚠️ Make sure Appium server is running and your device is connected.

✅ Sample Capabilities
json
Copy
Edit

👨‍💻 Author
Youstina Atef Salama
Software Tester Engineer


