# Intro:
- When you decompress the attached file, you will find two folders, one for Android and one for iOS, each folder also contains two mobile projects (Four in total, Two for each mobile platform), the project named **FrontEndChallenge**, has the solutions for the second and the third questions in the PDF (Anagrams and Fibonacci number), and the project named **CurrencyConverter** (Also one for Android and one for iOS) is the currency converter sample app.

- For the **Anagrams** and **Fibonacci number** projects, please run the unit tests in both projects (Android and iOS) to evaluate the test cases.

- Please make sure to run `pod install` inside the task directory when you test the iOS currency converter task (Not the other task).

- For the first question, please find its answer in the next section.

### Frontend technical challenge

1. Add arithmetic operators (add, subtract, multiply, divide) to make the following expressions true. You can use any parentheses
you’d like. You don’t need to write any code for this question.
3 1 3 9 = 12

 Answer: ((3+1)/3)*9

- Android code: 
`return (((3+1)/3)*9).toDouble()`
- iOS code:
    ```
    let result: Double = ((3+1)/3)*9
    print(result)
    ```

### Currency converter task:

1. I have implemented the task for both Android and iOS platforms.

2. In Android, I used MVVM (Model-View-View-Model) and in iOS I used MVP, just to show that I'm comfortable with both architectures.

3. For Android, I used [Android dev Kit](https://github.com/ahmadmssm/AndroidBase), which is my open-source Android library that facilitates development, it is also a wrapper around Retrofit, OkHTTP, and RxJava/Android plus some useful utilities.

4. I Used [Koin](https://github.com/InsertKoinIO/koin) as a dependency injection framework.

5. For iOS, I used [iOS Bootstrap](https://github.com/ahmadmssm/iOS_Bootstrap), which is my open-source iOS library, It is a wrapper around Alamofire plus some useful utilities that facilitate the development process.

6. I also used [Resolver](https://github.com/hmlongco/Resolver) as a dependency injection framework, I'm also contributing to this open-source library.

7. In iOS I used the Navigator to handle the navigation between view controllers, Navigator is the Router layer in VIPER pattern which is responsible for the navigation from one view to another.

8. Along with the suggested fixer.io API, I used this [API](https://restcountries.eu/) to fetch the world countries to match the suggested design as match as I can, I combined the results from the two APIs to get a new list that has both the flag and currency info.

9. I created a custom number pad in both Android and iOS tasks instead of using the native keyboard one.

10. All the icons in the app are from [FlatIcon](https://www.flaticon.com/), they are all free without copyright.

11. I wanted to include unit tests for both platforms but the time is very tight for me as I'm very busy with shipping a feature to about 4.7 Million users, that will help them with the COVID-19 situation.

Thank you very much...
