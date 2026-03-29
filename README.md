# 📧 Automated Email Reporting System using Java (Jakarta Mail)

This project demonstrates how to send automated emails using the **Jakarta Mail API** in Java.
It supports sending **text emails with file attachments** (like Extent Reports).

---

## 🚀 Features

* Send email using Gmail SMTP
* Attach files (e.g., Extent Reports)
* Simple and clean Java implementation
* File validation before sending
* Useful for QA Automation reporting

---

## 🛠️ Technologies Used

* Java
* Jakarta Mail API
* SMTP (Gmail)
* Maven

---

## 🎯 Why This Project?

In real-world QA automation, test reports need to be shared automatically with stakeholders.  
This project simulates that scenario by sending Extent Reports via email after execution.

---     

## 📦 Maven Dependency

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.sun.mail</groupId>
    <artifactId>jakarta.mail</artifactId>
    <version>2.0.1</version>
    <scope>compile</scope>
</dependency>
```
---

## ⚙️ Setup Instructions

### 1. Enable App Password in Gmail

* Go to your Google Account
* Enable **2-Step Verification**
* Generate an **App Password**

---

### 2. Update Credentials in Code

```java
String senderEmail = "your_email@gmail.com";
String appPassword = "your_app_password";
String recipientEmail = "recipient@gmail.com";
```

---

### 3. Add Report File

Place your report file in:

```
/ExtentReport/ExtentReport.html
```

Or update the path in code:

```java
String filepath = System.getProperty("user.dir") + "/ExtentReport/ExtentReport.html";
```

---

## ▶️ How to Run

1. Import the project into your IDE (Eclipse / IntelliJ)
2. Add Maven dependency
3. Update email credentials
4. Run `EmailSenderGit.java`
5. Check recipient inbox 📥

---

## 📸 Use Case (QA Automation)

This project helps to:

* Send test execution reports automatically
* Share Extent Reports via email
* Integrate with Selenium/TestNG frameworks

---

## ⚠️ Important Notes

* Do NOT upload real credentials to GitHub
* Always use App Password (not Gmail password)
* Ensure correct file path before running

---

## 👨‍💻 Author

**Madhan**❤️

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
