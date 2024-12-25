# Contact App

This project is a simple contact application developed using **Android Jetpack Compose**, **MVVM (Model-View-ViewModel)**, and **Hilt**. It was completed during the **Techcareer Android Jetpack Compose Bootcamp**, sponsored by **FMSS**.

## Project Summary
Contact App allows users to add, view, and edit contact information. It follows the Clean Architecture approach and applies modern Android development principles.

## Technologies and Libraries Used
- **Kotlin**: The programming language used for this project.
- **Jetpack Compose**: For building modern UI.
- **MVVM**: Used as the application architecture.
- **Hilt**: For Dependency Injection.
- **Coroutines & Flow**: For asynchronous operations and data flow management.
- **State Management**: Managed using StateFlow.

## Features
- Display a list of contacts.
- Add a new contact.
- Edit existing contact details.
- Delete contacts.

## Project Structure
The project is structured following the Clean Architecture principles:

- **Data Layer**: Contains Room DAOs and data models.
- **Domain Layer**: Contains repository interfaces and business logic.
- **Presentation Layer**: Contains Jetpack Compose components and ViewModels.

### Directory Structure
```plaintext
com.example.contactapp
|
├── data
│   ├── datasource
│   │   └── PersonDataSource.kt
│   ├── entity
│   │   └── Person.kt
│   ├── repo
│       └── PersonRepository.kt
│
├── di
│   ├── AppModule.kt
│   └── HiltApplication.kt
│
├── navigation
│   └── NavGraph.kt
│
├── ui
│   ├── screen
│   │   ├── HomePage.kt
│   │   ├── PersonDetailPage.kt
│   │   └── PersonRegisterPage.kt
│   ├── theme
│   └── viewmodel
│       ├── HomePageViewModel.kt
│       ├── PersonDetailViewModel.kt
│       └── PersonRegisterPageViewModel.kt
│
└── MainActivity.kt
```

## Setup
1. Clone the project:
   ```bash
   git clone https://github.com/ismailcanvarli/ContactApp.git
   ```

2. Open it in Android Studio.
3. Ensure the required dependencies are installed:
   - Hilt
   - Compose
4. Run the app on an emulator or physical device.

## Usage
- Main screen: Displays the list of contacts.
- Click on the "Add Contact" button to add a new contact.
- Long press on a contact card to edit or delete it.

