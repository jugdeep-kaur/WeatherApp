# WeatherApp
## Project Description
Weather Now is a weather app that provides current, hourly, and daily weather data. The app consumes an API and stores the data in a local database using RoomDB. 
This data is then taken from the RoomDB and is prepared by the view model for presentation in the UI which displays it in various different forms of recyclerviews.
## Technologies Used
- Kotlin
- Android Studio
- Retrofit
- RoomDB
- JUnit
- Mockito
- Firebase Crashlytics
## Features
- Search for locations via text (Includes autocomplete)
- Search for locations through a map
- Toggle for 12 or 24 hour time
- Toggle for units in celsius or fahrenheit
- Offline mode achieved through RoomDB
- Displays Current, Hourly, and Daily Weather in user specified time and unit format
- Displays Alerts such as heat warnings, tornados, etc
