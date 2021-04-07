# EvoSuite

## Preparing the project
1. [Evosuite.org documentaion](https://www.evosuite.org/documentation/tutorial-part-2/)
1. [Downdload the tutorial maven zip] (http://evosuite.org/files/tutorial/Tutorial_Maven.zip) or download it from this Repository.
1. Unzip the Tutorial_Maven.zip
1. cd Tutorial_Maven
1. mvn compile
1. mvn test
    1. If you get any compilation error without any configuration then you must setup your JDK according to my instruction.
    2. Reasons could be many: [click here](https://github.com/rqkohistani/JDK_MAVEN_EVOSUITE)
    
    If this works correctly, you should see something like this:
    
                    
            -------------------------------------------------------
             T E S T S
            -------------------------------------------------------
            Running tutorial.StackTest
            Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.089 sec
            
            Results :
            
            Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
            
            [INFO] ------------------------------------------------------------------------
            [INFO] BUILD SUCCESS
            [INFO] ------------------------------------------------------------------------
            [INFO] Total time:  2.499 s
            [INFO] Finished at: 2021-04-07T15:35:30+02:00
            [INFO] ------------------------------------------------------------------------
            
#### If this worked as above then you are ready to integrate EvoSuite. 

### Configuration process
#### Generating EvoSuite tests with Maven
##### Open the project with the intellij and go to pom.xml

1. Now all I have to do is tell Maven that I'd like to include EvoSuite in our build. 
    1. Declare a build dependency on EvoSuite, Declare EvoSuite as a build dependency, rather than the a project dependency. Add the following snippet as a child node of ```<project>``` in the pom.xml. e.g " in the dependencies section: 

              <build>
                <plugins>
                  <plugin>
                    <groupId>org.evosuite.plugins</groupId>
                    <artifactId>evosuite-maven-plugin</artifactId>
                    <version>1.0.6</version>
                  </plugin>
                </plugins>
              </build>

    1. Let Intellij pop message: Enable auto download
    1. Maven uses the Evosuite Maven plugin. Maven can automatically resolve build dependencies just like it resolves project dependencies, by looking for a plugin with the given groupId, artifactId, and version on Maven central.

1. At this point, one caveat is that the EvoSuite plugin is not yet available on Maven Central. Therefore, we need to tell Maven that it should also look at EvoSuite’s Maven repository when trying to resolve dependencies. To achieve this, we need to add a <pluginRepositories> section where we specify EvoSuite’s URL:

        <pluginRepositories>
          <pluginRepository>
            <id>EvoSuite</id>
            <name>EvoSuite Repository</name>
            <url>http://www.evosuite.org/m2</url>
          </pluginRepository>
        </pluginRepositories>
        
    1. The <pluginRepositories> section is again a child of the <project> tag, so for example you could add it at the end, before the closing ```</project>``` tag.        
    
    #### check if the setup works properly by invoking EvoSuite plugin. ```evosuite``` e.g ``` mvn evossuite:help```
    #### The first time you invoke the EvoSuite plugin, Maven will download EvoSuite and its dependencies and this may take a while. Once everything is downloaded, you should see the following help message:
    
    if you get an error check the project structe and select the correcnt version jdk machine withlasdkfjalsdjf
    
        [INFO] Scanning for projects...
        [INFO] 
        [INFO] ----------------< org.evosuite.tutorial:Tutorial_Maven >----------------
        [INFO] Building Tutorial_Maven 1.0-SNAPSHOT
        [INFO] --------------------------------[ jar ]---------------------------------
        [INFO] 
        [INFO] --- evosuite-maven-plugin:1.0.6:help (default-cli) @ Tutorial_Maven ---
        [INFO] Maven Plugin for EvoSuite 1.0.6
          Plugin used to run EvoSuite to automatically generate high coverage JUnit
          tests
        
        This plugin has 7 goals:
        
        evosuite:clean
          Remove all local files created by EvoSuite so far
        
        evosuite:coverage
          Execute the manually written test suites (usually located under src/test/java)
          and return the coverage of each class.
        
        evosuite:export
          When run, EvoSuite generate tests in a specific folder. New runs of EvoSuite
          can exploit the tests in such folder, and/or modify them.
          
          So, with 'export' we can copy all generated tests to a specific folder, which
          by default points to where Maven searches for tests. If another folder is
          rather used (or if we want to run with Maven the tests in the default EvoSuite
          folder), then Maven plugins like build-helper-maven-plugin are needed
        
        evosuite:generate
          Generate JUnit tests
        
        evosuite:help
          Display help information on evosuite-maven-plugin.
          Call mvn evosuite:help -Ddetail=true -Dgoal=<goal-name> to display parameter
          details.
        
        evosuite:info
          Obtain info of generated tests so far
        
        evosuite:prepare
          Mojo needed to prepare the EvoSuite tests for execution. This is needed to
          make sure that bytecode is properly instrumented.
        
        
        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------
        [INFO] Total time:  1.483 s
        [INFO] Finished at: 2021-04-07T16:13:47+02:00
        [INFO] ------------------------------------------------------------------------

If you don’t see this but get to see an error message, then likely there is a problem in your pom.xml. Make sure you copied all the above additions to the pom.xml correctly and try again.