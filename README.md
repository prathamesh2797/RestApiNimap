# RestApiNimap
This is an Android App developed in Kotlin language that loads data from Rest API and displays in Recycler View. This app uses MVVM architecture pattern of development. 

**If user has valid internet connection:** Data is loaded from REST API. At this stage REST API data is also stored in Room Database.

**If user does not have valid internet connection:** Data is loaded from the Room Database from where it is stored.(Offline Mode)

## Summary:
This app uses the following features:
1. Model View ViewModel architecture pattern.
2. Room Database
3. View Binding.
4. Offline support
5. Spash Screen.
6. Kotlin language for development


## Working Of Application
**Splash Screen:** User launches the app > Splash screen will be loaded.

![Splash Screen](https://user-images.githubusercontent.com/84138868/155021841-d311bd52-1bce-46b3-b236-0bbbabe163ba.jpg)


**Main Activity:** Here User will be able to see all the data fetched from REST API.

![MainAtivity](https://user-images.githubusercontent.com/84138868/155021961-09ba56d9-c25c-4852-8734-8c8358c43b33.jpg)

![MainActivityScreen](https://user-images.githubusercontent.com/84138868/155022016-be10956d-4d40-416b-a53c-3bc6887663b4.jpg)


**Offline Mode:** User can now view this same data when he/she does not have valid internet connection.

![offline mode](https://user-images.githubusercontent.com/84138868/155022038-aa906c79-9e44-4694-9207-9a6e1f112193.jpg)



