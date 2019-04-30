# Frequently Asked Questions and Information

## Kotlin
###### What is Kotlin?
Kotlin is a programming language. Features of Kotlin include statically-typed, cross-platform, and type inference.

A programming language is said to be statically-typed when type checking is done during compile-time,
cross-platform when it can be executed on multiple machines,
and have type inference when a type is not needed at variable declaration.

###### Why choose Kotlin?
Kotlin has first-party support from Google for the Android platform. This first-party support enriches the
Kotlin environment. Kotlin increases the readability of the source code by introducing concise inline functions,
reduced method chaining, multiple classes per file, and reducing the size of declarations through type inference.
Kotlin also allows for extensions to be created for custom objects. These extensions reduce the total code introduced
by defining a function that extends from many others, this helps reduced repetitious code.

### Android
###### What is Android?
Android is a platform, just like Windows, or MacOS, but developed and maintained by Google. Android was built to run
on a multitude of devices with various hardware components. Android is currently installed in the majority of mobile
devices globally. Android is lightweight, but very extendable allowing for customization. This customization has
reached into the open-source community by way of libraries and frameworks. These libraries and frameworks are
available to developers and help reduce the amount of source code needed for an application.

###### Why choose Android?
Android's strong open-source community, portability, support, and mass audience make it the premier target platform
for applications of the current era. The application I created can be distributed globally to multiple levels of
the platform across thousands of versions of mobile devices. The open-source community allows for a reduction in
source code and subsequently a reduction in development time.

### MVP
###### Model - View - Presenter
MVP is a programming architecture based off of the MVC, Model - View - Controller, architecture. Programming architectures
are created to help enforce organizational patterns to increase security, reusability, reliability, and testability. MVP
was created as an answer to better testability for mobile platforms. Refactoring the data flow so that the presenter controls
all business logic allows developers to test their implementation of business logic without having to write complex testing cases.

MVP consists of three parts. The Model, which defines, holds, and handles all data exchanges is the first section. Many
architectures will include services, retrieval, and storage in the model. The second section is the View, which is the
basic display sections of the application. The View has very little influence on the overall functionality of the program
and simply controls and displays the data it is provided. The final and most important aspect is the Presenter. The Presenter
is where all of the complex and important data logic is stored and used. The Presenter also interacts with and supplies the
view with data.