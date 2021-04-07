# EvoSuite
## Preparing the project

1. [Downdload the tutorial maven zip](http://evosuite.org/files/tutorial/Tutorial_Maven.zip) or download it from this Repository.
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
    
    #### check if the setup works properly by invoking EvoSuite plugin. ```evosuite``` e.g ``` mvn evosuite:help```
    #### The first time you invoke the EvoSuite plugin, Maven will download EvoSuite and its dependencies and this may take a while. Once everything is downloaded, you should see the following help message:
    
    ##### if you get an error check the project structe and select the correcnt version jdk machine withlasdkfjalsdjf
    
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

##### If build is unsuccessful then there is a problem in your pom.xml. Make sure you copied all the above additions to the pom.xml correctly and try again. or go to EvoSuite documentation.
#####  [Evosuite.org documentaion](https://www.evosuite.org/documentation/tutorial-part-2/)

#### mvn evosuite:help -Ddetail=true -Dgoal=generate
##### Set properties for the plugin goals just like you would set properties for any Java process, using the -Dproperty=value syntax. For example, to get more detailed information about the generate plugin goal when executing the help plugin goal, we can run the following command:

    mvn evosuite:help -Ddetail=true -Dgoal=generate
    
#### You should see something similar to
    [INFO] ----------------< org.evosuite.tutorial:Tutorial_Maven >----------------
    [INFO] Building Tutorial_Maven 1.0-SNAPSHOT
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO]
    [INFO] --- evosuite-maven-plugin:1.0.6:help (default-cli) @ Tutorial_Maven ---
    [INFO] Maven Plugin for EvoSuite 1.0.6
      Plugin used to run EvoSuite to automatically generate high coverage JUnit
      tests
    
    evosuite:generate
      Generate JUnit tests
    
      Available parameters:
    
        criterion (Default:
        LINE:BRANCH:EXCEPTION:WEAKMUTATION:OUTPUT:METHOD:METHODNOEXCEPTION:CBRANCH)
          Coverage criterion. Can define more than one criterion by using a ':'
          separated list
          User property: criterion
    
        cuts
          Comma ',' separated list of CUTs to use in CTG. If none specified, then
          test all classes
          User property: cuts
    
        cutsFile
          Absolute path to a file having the list of CUTs specified. This is needed
          for operating systems like Windows that have constraints on the size of
          input parameters and so could not use 'cuts' parameter instead if too many
          CUTs are specified
          User property: cutsFile
    
        extraArgs (Default: )
    
          User property: extraArgs
    
        memoryInMB (Default: 800)
          Total Memory (in MB) that CTG will use
          User property: memoryInMB
    
        numberOfCores (Default: 1)
          Number of cores CTG will use
          User property: cores
    
        schedule (Default: BUDGET)
          Schedule used to run CTG (SIMPLE, BUDGET, SEEDING, BUDGET_AND_SEEDING,
          HISTORY)
          User property: schedule
    
        spawnManagerPort (Default: )
    
          User property: spawnManagerPort
    
        timeInMinutesPerClass (Default: 2)
          How many minutes to allocate for each class
          User property: timeInMinutesPerClass
    
        timeInMinutesPerProject (Default: 0)
          How many minutes to allocate for each project/module. If this parameter is
          not set, then the total time will be timeInMinutesPerClass x
          number_of_classes
          User property: timeInMinutesPerProject
    
    
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  1.408 s
    [INFO] Finished at: 2021-04-07T20:24:19+02:00
    [INFO] ------------------------------------------------------------------------

#### All setup: generate some tests!!!!

mvn evosuite:generate

###### If EvoSuite is set up properly, you should see something similar to

    [INFO] >>> evosuite-maven-plugin:1.0.6:generate (default-cli) > compile @ Tutorial_Maven >>>
    [INFO]
    [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ Tutorial_Maven ---
    [INFO] Using 'UTF-8' encoding to copy filtered resources.
    [INFO] skip non existing resourceDirectory C:\Users\rashi\Downloads\New folder (10)\Tutorial_Maven\src\main\resources
    [INFO]
    [INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ Tutorial_Maven ---
    [INFO] Nothing to compile - all classes are up to date
    [INFO]
    [INFO] <<< evosuite-maven-plugin:1.0.6:generate (default-cli) < compile @ Tutorial_Maven <<<
    [INFO]
    [INFO]
    [INFO] --- evosuite-maven-plugin:1.0.6:generate (default-cli) @ Tutorial_Maven ---
    [INFO] Going to generate tests with EvoSuite
    [INFO] Total memory: 800mb
    [INFO] Time per class: 2 minutes
    [INFO] Number of used cores: 1
    [INFO] Target: C:\Users\rashi\Downloads\New folder (10)\Tutorial_Maven\target\classes
    [INFO] Basedir: C:\Users\rashi\Downloads\New folder (10)\Tutorial_Maven
    [INFO] Started spawn process manager on port 57077
    [INFO] SLF4J: Class path contains multiple SLF4J bindings.
    [INFO] SLF4J: Found binding in [jar:file:/C:/Users/rashi/.m2/repository/org/evosuite/evosuite-master/1.0.6/evosuite-master-1.0.6.jar!/org/slf4j/impl/StaticLoggerBinder.class]
    [INFO] SLF4J: Found binding in [jar:file:/C:/Users/rashi/.m2/repository/ch/qos/logback/logback-classic/1.1.3/logback-classic-1.1.3.jar!/org/slf4j/impl/StaticLoggerBinder.class]
    [INFO] SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
    [INFO] SLF4J: Actual binding is of type [ch.qos.logback.classic.util.ContextSelectorStaticBinder]
    [INFO] * EvoSuite 1.0.6
    [INFO] Registered remote process from /127.0.0.1:57078
    [INFO] Going to execute 4 jobs
    [INFO] Estimated completion time: 8 minutes, by 2021-04-07T20:32:55.070
    [INFO] Going to start job for: tutorial.LinkedList. Expected to end in 190 seconds, by 2021-04-07T20:28:05.356
    [INFO] Registered remote process from /127.0.0.1:57079
    [INFO] Registered remote process from /127.0.0.1:57085
    [INFO] Completed job. Left: 3
    [INFO] Going to start job for: tutorial.Stack. Expected to end in 125 seconds, by 2021-04-07T20:29:00.910
    [INFO] Registered remote process from /127.0.0.1:57138
    [INFO] Registered remote process from /127.0.0.1:57144
    [INFO] Completed job. Left: 2
    [INFO] Going to start job for: tutorial.LinkedListIterator. Expected to end in 103 seconds, by 2021-04-07T20:30:02.044
    [INFO] Registered remote process from /127.0.0.1:57179
    [INFO] Registered remote process from /127.0.0.1:57185
    [INFO] Completed job. Left: 1
    [INFO] Going to start job for: tutorial.Node. Expected to end in 60 seconds, by 2021-04-07T20:30:29.882
    [INFO] Registered remote process from /127.0.0.1:57220
    [INFO] Registered remote process from /127.0.0.1:57228
    [INFO] Completed job. Left: 0
    [INFO] * Updating database to tutorial.LinkedListIterator
    [INFO] * Updating database to tutorial.Node
    [INFO] * Updating database to tutorial.Stack
    [INFO] * Updating database to tutorial.LinkedList
    [INFO] === CTG run results ===
    [INFO] Removed test suites: 0
    [INFO] New test suites: 4
    [INFO] Stopping spawn process manager
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  04:53 min
    [INFO] Finished at: 2021-04-07T20:29:44+02:00
    [INFO] ------------------------------------------------------------------------
    
    
##### The output tells us that EvoSuite will generate tests for 4 classes, which it estimates to take around 8 minutes. The first job it started is the class tutorial.LinkedList. Now is the time to wait and get some coffee, until Evosuite has finished testing all the classes.
      
##### If you have a powerful machine with multiple cores, you can also parallelise the EvoSuite jobs in order to save time. For example, to run 4 EvoSuite jobs in parallel you could add the -Dcores=4 property to the evosuite:generate command:

    mvn -Dcores=4 evosuite:generate
    
#### Integrating generated tests into the source tree
##### you should see a BUILD SUCCESS message from Maven when EvoSuite is done. If so, then congratulations, you just generated some test suites with the EvoSuite Maven plugin! If you do not see that message, then something went wrong – please check the error message and make sure you have set up the Maven project correctly.
##### So, what have we generated? To find out the current state of what EvoSuite has generated for us, use the following command:

    mvn evosuite:info
##### As we have just invoked EvoSuite on 4 classes, you should get an output like this:
    [INFO] --- evosuite-maven-plugin:1.0.6:info (default-cli) @ Tutorial_Maven ---
    [INFO] Going to query EvoSuite info on current project
    [INFO] SLF4J: Class path contains multiple SLF4J bindings.
    [INFO] SLF4J: Found binding in [jar:file:/C:/Users/rashi/.m2/repository/org/evosuite/evosuite-master/1.0.6/evosuite-master-1.0.6.jar!/org/slf4j/impl/StaticLoggerBinder.class]
    [INFO] SLF4J: Found binding in [jar:file:/C:/Users/rashi/.m2/repository/ch/qos/logback/logback-classic/1.1.3/logback-classic-1.1.3.jar!/org/slf4j/impl/StaticLoggerBinder.class]
    [INFO] SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
    [INFO] SLF4J: Actual binding is of type [ch.qos.logback.classic.util.ContextSelectorStaticBinder]
    [INFO] * EvoSuite 1.0.6
    [INFO] Total number of classes in the project: 4
    [INFO] Number of classes in the project that are testable: 4
    [INFO] Number of generated test suites: 4
    [INFO] Overall coverage: 0.98625
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  2.988 s
    [INFO] Finished at: 2021-04-07T20:45:37+02:00
    [INFO] ------------------------------------------------------------------------

#### Assuming you are happy with these test suites, we can integrate them into the source tree. By default, JUnit tests are expected to be located in src/test/java in Maven projects, so this is where EvoSuite will put the test suites. To do this, invoke the following command:

    mvn evosuite:export
    
##### You should now have the test suites copied over to src/test/java – make sure they are there.
    
#### Executing EvoSuite tests with Maven
    