# Chef Menu App - Final Updated Changes
---
# Javarne Moses

# ST10528036 

# MAST2026 

---
# Overview

The Chef Menu App is an Android restaurant menu management application designed to make it easier for restaurant owners and staff to manage menu items. The app allows users to add, search, organise and manage food items by course, as well as view statistics about their menu. Its purpose is to simplify menu management, improve organisation and provide a convenient way to keep restaurant menu information updated.

From the previous project i had created before this one, i had created my Chef Menu App in the wrong format submitting a website rather than the mobile app which was a very huge mistake.

I restarted the whole project from scratch and created a fully functioning Mobile Cheff Menu App.

I revised through all my coding, and using the correct software making sure there were no major errors that caused bugs or crashes to come up, i underwent several tests and everything is clear and ready to use.

I have created a fully functioning app that serves all the purposes asked for completing this task making sure it fulfills user experience aswell.

From the work handed in from Part 2 i had explained the purpose of the Scenario Anyalisis for the app.

I aswell had drawn my User Interface design creating 5 separate screens, each individual one functioning as Screen 1: Resturant Menu (Main screen), Screen 2: Add Menu Item, Screen 3: Edit Menu Item, Screen 4: Delete Menu Item, and Screen 5: Menu Statistics.

What i had changed was the Edit button option in my home screen for the app because i had no Edit option within the menu items in the home screen, overall creating a more functional app for users with all necessary changes that can be done.

---
# Design Explination 

The Cheff Menu application uses a simple, modern and user-friendly design. The interface is designed to make restaurant menu management easy, organised and convenient for restaurant owners and staff.

## 1. Colour Scheme
The application uses a warm and welcoming colour palette to create a restaurant-inspired appearance.
- Dark brown (#7E310C): Used for headings and buttons to create a strong visual identity.
- Cream (#FFFDF6): Used as the main background colour to give the interface a clean and comfortable appearance.
- White (#FFFFFF): Used for input fields and text to improve readability.
- Light grey (#CFCFD2): Used for borders around input fields to provide visual separation.

## 2. Layout Design
The main screen follows a vertical layout, allowing users to interact with the application from top to bottom.

The layout includes:
- A heading at the top displaying "Restaurant Menu".
- A search bar directly below the heading.
- A horizontal course-filter section.
- A scrollable area displaying menu items.
- An Add Menu Item button at the bottom.

## 3. Search Bar Design
The search bar has rounded corners and a search icon to make it easy for users to identify its purpose. The placeholder text guides users to enter the name of the food item they want to find.

## 4. Buttons and Navigation
The application uses clearly labelled buttons to help users access different functions. The brown Add Menu Item button stands out against the cream background. A Statistics navigation option provides access to the statistics screen.

## 5. Input Form Design
The input fields use rounded corners, white backgrounds and light grey borders. This creates a consistent appearance and makes entering menu information more comfortable.

## 6. Statistics Screen Design
The statistics screen provides a separate interface for displaying information about the restaurant menu. It allows users to view menu-related statistics without overcrowding the main menu screen.

## 7. Overall Design Approach
The application follows these design principles:
- Simplicity: Avoids unnecessary visual elements.
- Consistency: Uses the same colours, fonts and styling throughout.
- Usability: Makes important functions easy to locate.
- Readability: Uses clear text and appropriate spacing.
- Organisation: Separates menu management from statistics. 

---
# Technologies Used

- Android Studio
- Samsung A16 (To test app)
- Expo
- ReactNative

---
# App Features 

## 1. Menu Management
Allows users to manage restaurant menu items in one place. Users can add new food items, edit existing items and delete items that are no longer available.

## 2. Add Menu Items
Users can add new dishes to the restaurant menu using an input form. The menu item dialog provides a convenient way to enter the required food information.

## 3. Search Menu Items
The app includes a search bar that allows users to quickly find specific dishes by entering their names or relevant search terms.

## 4. Filter by Course
Users can organise and filter menu items according to their course or category, making it easier to navigate the restaurant menu.

## 5. Delete Menu Items
Users can remove unwanted menu items. A confirmation dialog helps prevent accidental deletion.

## 6. Statistics Dashboard
The app provides a separate statistics screen where users can view information about their restaurant menu. This helps them monitor and understand their menu organisation.

## 7. User-Friendly Interface
The app uses a simple and organised interface with clear buttons, search fields, input forms and navigation options to make menu management easier.

---
# Updated Flow Structure

CheffMenu/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/
│           │       └── example/
│           │           └── cheffmenu/
│           │               ├── ui/
│           │               │   └── theme/
│           │               ├── MainActivity.kt
│           │               └── StatisticsActivity.kt
│           │
│           ├── res/
│           │   ├── drawable/
│           │   │   ├── ic_launcher_background.xml
│           │   │   ├── ic_launcher_foreground.xml
│           │   │   ├── input_background.xml
│           │   │   ├── search_background.xml
│           │   │   └── warning_circle.xml
│           │   │
│           │   ├── layout/
│           │   │   ├── activity_main.xml
│           │   │   ├── activity_statistics.xml
│           │   │   ├── dialog_menu_item.xml
│           │   │   └── dialog_delete_item.xml
│           │   │
│           │   ├── mipmap/
│           │   ├── values/
│           │   └── xml/
│           │
│           └── AndroidManifest.xml
│
├── Gradle Scripts/
│   ├── build.gradle.kts
│   ├── settings.gradle.kts
│   ├── gradle.properties
│   └── proguard-rules.pro
│
└── build.gradle.kts

---
# Screenshots of working app

<img width="425" height="922" alt="mail google" src="https://github.com/user-attachments/assets/dc998ff9-f125-433c-b292-bfd41506cf9d" />
<img width="425" height="922" alt="mail google" src="https://github.com/user-attachments/assets/21ad320f-f89d-425c-a5c3-73355ebe1d5b" />
<img width="425" height="922" alt="mail google" src="https://github.com/user-attachments/assets/95a4c0f8-7eb2-40ca-85e3-51ea212dd887" />
<img width="425" height="922" alt="mail google" src="https://github.com/user-attachments/assets/fed1ff13-b077-4249-9acb-10fbc633173d" />
<img width="425" height="922" alt="mail google" src="https://github.com/user-attachments/assets/d118dc39-0ac6-4f24-9316-dc942c6c6dda" />
<img width="425" height="922" alt="mail google" src="https://github.com/user-attachments/assets/fb2e33da-dad1-45c2-b77c-9c908d3c90f6" />

---
# YouTube Video Link for Functioning App Recording:

https://youtu.be/6cPJOBHRT-w?si=Wq7C1shbLl8SvX43
