
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

guru99-android-automation/
├── src/test/java/
│ ├── tests/ # Test classes
│ ├── pages/ # Page Object classes
│ └── utils/ # Driver and helper utilities
├── testng.xml # Test suite configuration
├── pom.xml # Maven dependencies

yaml
Copy
Edit

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


