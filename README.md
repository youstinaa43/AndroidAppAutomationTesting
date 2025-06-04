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

```text
📂 Mobile_Testing_FrameWork
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
│   │   │   │   ├── AccessibilityPage.java
│   │   │   │   └── ...
│   │   │   └── BasePage.java
│   │   └── resources
│   │       └── config.properties
│   └── test
│       ├── java
│       │   ├── BaseTest.java
│       │   ├── TC_001_VerifyPreferenceDependencie.java
│       │   └── ...
│       └── resources
│           └── testng.xml
🔌 Device Setup
Enable Developer Options and USB Debugging on your Android phone.

Connect the device via USB.

Verify with:

bash
Copy
Edit
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
{
  "platformName": "Android",
  "automationName": "UiAutomator2",
  "deviceName": "Android Device",
  "app": "path/to/ApiDemos-debug.apk"
}
👨‍💻 Author
Youstina Atef Salama
Software Test Engineer

vbnet
Copy
Edit
