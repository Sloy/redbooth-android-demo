# Redbooth demo for Android
[![Build Status](https://travis-ci.org/Sloy/redbooth-android-demo.svg?branch=develop)](https://travis-ci.org/Sloy/redbooth-android-demo)

This is a simple project demonstrating the use of Redbooth's API.

### Features
- Clean Arquitecture: Separate modules for Presentation, Domain and Data.
- MVP: Use of presenters inside the presentation layer.
- Material design: Follows the basic guidelines of material design styles.
- Dependency injection with Dagger.
- Template method pattern for activities: Use of a richer semantic than a single onCreate method.
- Configurable layout container: Allows changing activities' parent layout, to insert special features like debug drawer, scalpel or anything else.
- Unit tests: A few tests implemented in domain and presentation layers.

### Things to improve
- Login system and flow: It's just implemented in the most basic way in order to work.
- Task detail view.
- Edit existing task.
- Enable more Task info (viewing and creating).
- Add more tests.

## Libraries used
- [Appcompat v7](http://android-developers.blogspot.com.es/2014/10/appcompat-v21-material-design-for-pre.html)
- [CardView](https://developer.android.com/training/material/lists-cards.html)
- [RecyclerView](https://developer.android.com/training/material/lists-cards.html)
- [Butterknife](http://jakewharton.github.io/butterknife/)
- [Dagger](http://square.github.io/dagger/)
- [FloatingActionButton](https://github.com/makovkastar/FloatingActionButton)
- [AwesomeText](https://github.com/JMPergar/AwesomeText/)
- [Retrofit](http://square.github.io/retrofit/)
- [OkHttp](http://square.github.io/okhttp/)
- [Stetho](https://github.com/facebook/stetho)
- [JUnit 4](http://junit.org/)
- [Mockito](https://github.com/mockito/mockito)
- [AssertJ](http://joel-costigliola.github.io/assertj/)