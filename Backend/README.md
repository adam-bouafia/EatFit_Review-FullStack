# SOSE Project
## About the project
This repo is for the *Service Oriented Software Engineering* course project. 

University of L'Aquila.

## Getting Started
This application consists of a set of services and microservices that have to be started inside a server to run the whole system.

### Prerequisites
In order to run this project, be sure that you have installed:
- Apache Tomcat (Tested with version 8.5.81)
- Java and JAVA_HOME set
- Eclipse IDE for Enterprise Java Developers
- Nginx



### Installation

To install the application follow these steps:
1. Get a free API Key at [https://edamam-api.com/](https://edamam-api.com/)
2. Clone the repo
   
   ```sh
   git clone https://github.com/federix98/SOSE_Project.git
   ```
3. Enter your API in `FoodSearchProsumer/src/main/java/it/univaq/disim/sose/search/SearchImpl.java`
   
   ```java
      private static final String APP_ID = "ENTER YOUR APP ID";
      private static final String API_KEY = "ENTER YOUR APP KEY";
      ```
   and in `FoodDetailsProsumer/src/main/java/it/univaq/disim/sose/fooddetails/data/EdamamRestClient.java`

   ```java
      private static final String APP_ID = "ENTER YOUR APP ID";
      private static final String API_KEY = "ENTER YOUR APP KEY";
      ```
4. Open Eclipse IDE, create a new Tomcat instance and run all the services:
   1. AuthService
   2. FoodDetailsProsumer
   3. FoodDetailsAggregator
   4. FoodSearchProsumer
   5. RatingUpdaterRESTService
   6. ReviewDataService
   7. ReviewEditorProsumer
5. Install Android application

### Nginx Load Balancer
To use Nginx load balancer, you have to follow severals steps we resumed in the <a href="https://github.com/federix98/SOSE_Project/blob/main/NGINX%20Load%20Balancer%20SOSE.pdf">NGINX Load Balancer SOSE.pdf</a> file.

## Usage

Opening the android application you can search for movies and tv series and you can open it. Clicking on one result, you will be redirected thru the details page in which you'll see all the food metadata, the averages of the ratings, the summary global score and the reviews of that food.
You can also sign up and sign in and you can rate and write a review for a movie or tv series.

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

## Contact
This project has been realized for educational purposes.

