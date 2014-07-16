GITHUB DOES NOT PROPERLY FORMAT THIS TEXT FILE. VIEW IT RAW FOR BETTER FORMATTING.

To set up the programming environment,




install the JRE

install JDK 7

- http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
- sudo apt-get install openjdk-7-jre



install "Eclipse IDE for Java Developers"
- http://www.eclipse.org/downloads/




install Gradle plug-in
- In Eclipse, Help -> Install New Software...
- Click Add...
- Type something like "Gradle" for the name, and the following url for location
- http://dist.springsource.com/release/TOOLS/gradle
- you only need to select the Gradle IDE option




download the github branch labelled "code" and extract it
- https://github.com/abbott221/JohnMaddenWasHere/archive/code.zip




in the extracted folder, import the folder 1 above the "desktop" and "core" folders as a Gradle Project into Eclipse

Select this folder, the desktop folder, and the core folder for importing to Eclipse


JDBC help: http://marksman.wordpress.com/2009/03/01/setting-up-mysqljdbc-driver-on-ubuntu/
sudo apt-get install libmysql-java

add gradle persisted dependency:
https://stackoverflow.com/questions/12576413/including-local-jar-file-in-project-at-build-time-using-gradle
paste the jar file into the libs folder
add a line to the workspace's gradle.build file in the same format as the following:
compile files('libs/mysql-connector-java.jar')


The project is run from the main class located in DesktopLauncher
