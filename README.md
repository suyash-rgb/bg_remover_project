# BG Remover SaaS: AI-Powered Background Removal Tool

![BG Remover Banner](https://img.shields.io/badge/BG_Remover-AI--Powered--SaaS-blueviolet?style=for-the-badge)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)](https://opensource.org/licenses/MIT)

BG Remover SaaS is a full-stack, AI-driven web application that allows users to seamlessly remove backgrounds from images. Built with modern web technologies and a secure, scalable backend, the platform features a credit-based system, secure authentication, and a smooth checkout process for purchasing additional credits.

![Landing Page](https://via.placeholder.com/1000x500?text=Landing+Page+Screenshot)

## 🚀 Key Features

- **AI Background Removal**: Upload images and instantly remove backgrounds with high precision.
- **Credit-Based System**: Users consume credits for each background removal.
- **Secure Authentication**: Integrated with Clerk for seamless, secure user sign-ups and logins.
- **Payment Gateway Integration**: Built-in Razorpay integration allows users to easily purchase credit packages.
- **Responsive Modern UI**: Built with React and TailwindCSS for a beautiful, seamless experience across devices.
- **Robust Backend API**: Powered by Spring Boot and MySQL for secure data persistence and payment verification.

## 📸 Screens

**Dashboard / Upload Interface**
![Dashboard](https://via.placeholder.com/800x400?text=Dashboard+Screenshot)
<br><br>
**Results View**
![Result View](https://via.placeholder.com/800x400?text=Result+View+Screenshot)
<br><br>
**Pricing / Buy Credits**
![Pricing Page](https://via.placeholder.com/800x400?text=Pricing+Page+Screenshot)

## 🛠️ Technology Stack

- **Frontend**: React, Vite, TailwindCSS, React Router, Context API
- **Backend**: Java, Spring Boot, Spring Security, Hibernate (JPA), MySQL, OpenFeign
- **Authentication**: Clerk (with Webhook database sync)
- **Payments**: Razorpay SDK

## 📁 Repository Structure

The project is divided into distinct directories for the frontend and backend:
- `main`: The React/Vite web application UI.
- `removebg-backend`: Core Spring Boot backend logic, API services, and webhook handlers.

---

## ⚙️ Installation Instructions

### Prerequisites
- **Node.js 18+** & npm (Frontend)
- **Java 17+** & Maven (Backend)
- **MySQL Server** (Database)

---

### 1. Backend Setup

The backend serves the API, handles Clerk webhooks, and verifies Razorpay payments.

#### 1. Navigate to Backend Directory
```bash
cd removebg-backend
```

#### 2. Environment Configuration
Update your `application.properties` (or `.env`) file in the backend to match your setup:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/removebg_db
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
clerk.webhook.secret=your_clerk_webhook_secret
```

#### 3. Run the Application
You can run the backend using the Maven wrapper:
```bash
./mvnw clean compile spring-boot:run
```

---

### 2. Frontend Setup

The frontend provides the user interface, upload mechanisms, and billing pages.

#### 1. Navigate to Frontend Directory
```bash
cd main
```

#### 2. Install Dependencies
```bash
npm install
```

#### 3. Environment Configuration
Create a `.env` file in the root of the `main` directory and add your keys:
```env
VITE_CLERK_PUBLISHABLE_KEY=your_clerk_publishable_key
VITE_BACKEND_URL=your_backend_base_api_url
VITE_RAZORPAY_KEY_ID=your_razorpay_key_id
```

#### 4. Run the Development Server
```bash
npm run dev
```

The frontend will be accessible at `http://localhost:5173`.
