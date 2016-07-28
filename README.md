# mediaConsumer

To build run ./gradlew build

This will run the tests as well as produce the jar in the folder build/libs named MediaConsumer-0.0.1-SNAPSHOT.jar.

This uses two different media APIs for querying, imdb for movies and discogs for music albums.

Example movie use:

java -Dapi=imdb -Dmovie=Matrix -jar MediaConsumer-0.0.1-SNAPSHOT.jar

Example music use:

java -Dapi=discogs -Dalbum=nevermind -jar MediaConsumer-0.0.1-SNAPSHOT.jar
