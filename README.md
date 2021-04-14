# 1. EvoSuite
1. [EVALUATION V.10](https://github.com/rqkohistani/EvoSuite/blob/main/Evaluation%20V_1.0.md)
### 2. [HEC BACHELOR DEGREE PROJECT REPOSITORY](https://github.com/rqkohistani/HECBachelorDegreeProject)
1. [EVALUATION V1.0](https://github.com/rqkohistani/HECBachelorDegreeProject/blob/main/EVALUATION%20V1.0.md)
1. [Older version of the Degree Project](https://github.com/rqkohistani/degreeProject)
### 3. [PITEST EVALUATION REPOSITORY](https://github.com/rqkohistani/PiTest)
1. [EVALUATION V.10](https://github.com/rqkohistani/PiTest/blob/main/PITEST%20EVALUATION%20RESULTS%20V%201.0.md)
### [JDK AND MAVEN CONFIGURATION REQUIREMENTS REPOSITORY](https://github.com/rqkohistani/JDK_MAVEN_EVOSUITE)

***
## Preparing the project
## Prerequisites

### Note: This commands are mainly for Windows users. If you are using another OS please look for specific commands.
1. The first prerequisite is Java JDK 8 must be pre-installed. To check if you are set up, fire up a terminal and try the following:
   1. javac -version
        1. If you have JDK you will see an output similar to
        
          javac 1.8.0_281
   1. If you are missing java compiler then you have to install it [click here](https://github.com/rqkohistani/JDK_MAVEN_EVOSUITE)
   
             'javac' is not recognized as an internal or external command, operable program or batch file. 
             
1. The second prerequisite is Apache Maven. Please make sure you have version 3.1 or newer installed. To determine which version of Maven you are using, type the following command:
         
        mvn -v, mvn -version 
    1. You should see something similar to 
            
            Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
            Maven home: C:\Program Files\MavenJar\apache-maven-3.6.3\bin\..
            Java version: 1.8.0_281, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_281\jre
            Default locale: en_US, platform encoding: Cp1252
            OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
      1. If you are missing Maven then you have to install it [click here](https://github.com/rqkohistani/JDK_MAVEN_EVOSUITE)

******************

1. [Downdload the tutorial maven zip](http://evosuite.org/files/tutorial/Tutorial_Maven.zip) or download it from this Repository ***Tutorial_Maven.zip***.
1. Unzip the Tutorial_Maven.zip
1. cd Tutorial_Maven
1. mvn compile
1. mvn test
    1. If you get any compilation error without any configuration then you must setup your JDK according to my instructions.
    2. Reasons could be many: [click here](https://github.com/rqkohistani/JDK_MAVEN_EVOSUITE).
    
    If this worked properly, you should see something like this:
    
                    
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
            

### Configuration process
#### Generating EvoSuite tests with Maven
Open the project with the intellij and go to ```pom.xml```

#### A closer look at the ```pom.xml``` file

    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>
    
      <groupId>org.evosuite.tutorial</groupId>
      <artifactId>Tutorial_Maven</artifactId>
      <version>1.0-SNAPSHOT</version>
      <packaging>jar</packaging>
    
      <name>Tutorial_Maven</name>
      <url>http://maven.apache.org</url>
    
      <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      </properties>
    
      <dependencies>
        <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>4.12</version>
          <scope>test</scope>
        </dependency>
      </dependencies>
    </project>

The dependencies section only declares what the code we are working with depends on. However, what we would like to do is to tell Maven that we would like to use EvoSuite as part of our build – so we need to declare a build dependency on EvoSuite, not a project dependency. Dependencies of the build are specified as plugins in the build section of the ```pom.xml```. Add the following snippet to the ```pom.xml``` as a child node of ```<project>```, for example beneath the ```</dependencies>``` section: 

              <build>
                <plugins>
                  <plugin>
                    <groupId>org.evosuite.plugins</groupId>
                    <artifactId>evosuite-maven-plugin</artifactId>
                    <version>1.0.6</version>
                  </plugin>
                </plugins>
              </build>
              <project>

   1. Let Intellij pop message: Maven project need to be imported. ***Enable Auto-import***.
   1. Maven uses the Evosuite Maven plugin. Maven can automatically resolve build dependencies just like it resolves project dependencies, by looking for a plugin with the given groupId, artifactId, and version on Maven central.

At this point, one caveat is that the EvoSuite plugin is not yet available on Maven Central. Therefore, we need to tell Maven that it should also look at EvoSuite’s Maven repository when trying to resolve dependencies. To achieve this, we need to add a ```<pluginRepositories>``` section where we specify EvoSuite’s URL:

       <pluginRepositories>
         <pluginRepository>
           <id>EvoSuite</id>
           <name>EvoSuite Repository</name>
           <url>http://www.evosuite.org/m2</url>
         </pluginRepository>
       </pluginRepositories>
        
The <pluginRepositories> section is again a child of the <project> tag, so for example you could add it at the end, before the closing ```</project>``` tag.        
    
   #### Check if the setup works properly by invoking EvoSuite plugin. ```evosuite``` e.g ``` mvn evosuite:help```
   #### The first time you invoke the EvoSuite plugin, Maven will download EvoSuite and its dependencies and this may take a while. Once everything is downloaded, you should see the following help message:
    
   
    
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
If you get an error check the project structure and select the correct version jdk and language level.
If build is unsuccessful then there is a problem in your pom.xml. Make sure you copied all the above additions to the ```pom.xml``` correctly and try again. or go to EvoSuite documentation.
#####  1.  [JDK and Maven configuration guide](https://github.com/rqkohistani/JDK_MAVEN_EVOSUITE)
#####  1.  [Evosuite.org documentaion part 2](https://www.evosuite.org/documentation/tutorial-part-2/)
#####  2. [Evosuite.org documentaion part 1](https://www.evosuite.org/documentation/tutorial-part-1/)

#### mvn evosuite:help -Ddetail=true -Dgoal=generate
Set properties for the plugin goals just like you would set properties for any Java process, using the ```-Dproperty=value``` syntax. For example, to get more detailed information about the generate plugin goal when executing the help plugin goal, we can run the following command:

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

##### If EvoSuite is set up properly, you should see something similar to

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
    
##### The output tells us that EvoSuite will generate tests for 4 classes, which it estimates to take around 4:53 minutes. The first job it started is the class ```tutorial.LinkedList```.
      
      #### My PC specification
      
              ------------------
              System Information
              ------------------
                    Time of this report: 4/8/2021, 10:18:31
                           Machine name: DESKTOP-......
                             Machine Id: {08DB70AA-......}
                       Operating System: Windows 10 Pro 64-bit (10.0, Build 19041) (19041.vb_release.191206-1406)
                               Language: Swedish (Regional Setting: Swedish)
                    System Manufacturer: Dell Inc.
                           System Model: Precision T3600
                                   BIOS: Default System BIOS (type: BIOS)
                              Processor: Intel(R) Xeon(R) CPU E5-2665 0 @ 2.40GHz (16 CPUs), ~2.4GHz
                                 Memory: 32768MB RAM
                    Available OS Memory: 32726MB RAM
                              Page File: 14550MB used, 23039MB available
                            Windows Dir: C:\WINDOWS
                        DirectX Version: DirectX 12
                    DX Setup Parameters: Not found
                       User DPI Setting: 96 DPI (100 percent)
                     System DPI Setting: 144 DPI (150 percent)
                        DWM DPI Scaling: UnKnown
                               Miracast: Available, with HDCP
              Microsoft Graphics Hybrid: Not Supported
               DirectX Database Version: 1.0.8
                         DxDiag Version: 10.00.19041.0546 64bit Unicode
          
##### If you have a powerful machine with multiple cores, you can also parallelize the EvoSuite jobs in order to save time. For example, to run 4 EvoSuite jobs in parallel you could add the -Dcores=4 property to the evosuite:generate command:

    mvn -Dcores=4 evosuite:generate
    
#### Integrating generated tests into the source tree
You should see a BUILD SUCCESS message from Maven when EvoSuite is done. If so, then congratulations, you just generated some test suites with the EvoSuite Maven plugin! If you do not see that message, then something went wrong – please check the error message and make sure you have set up the Maven project correctly.
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

We’ve got a test suite for each of our classes, and the coverage is great. But, where are these test suites?

Right now, they are in a hidden directory ```.evosuite```. This is a directory where EvoSuite keeps information, in order to improve test generation over time. For example, if a class hasn’t changed and we already have a test suite, we don’t want to invoke EvoSuite on it again – but more about this later. For now, you can see what EvoSuite has put into ```.evosuite```; in particular, you will find the generated tests in ```.evosuite/best-tests```:

     ls .evosuite/best-tests/tutorial
##### This should show you 8 files – 4 test suites, and 4 scaffolding files:   
    LinkedListIterator_ESTest.java              LinkedList_ESTest_scaffolding.java  Stack_ESTest.java
    LinkedListIterator_ESTest_scaffolding.java  Node_ESTest.java                    Stack_ESTest_scaffolding.java
    LinkedList_ESTest.java                      Node_ESTest_scaffolding.java



Assuming you are happy with these test suites, we can integrate them into the source tree. By default, JUnit tests are expected to be located in src/test/java in Maven projects, so this is where EvoSuite will put the test suites. To do this, invoke the following command:

    mvn evosuite:export
    
##### You should now have the test suites copied over to src/test/java – make sure they are there.
    
### Executing EvoSuite tests with Maven

#### Now that we have these tests in our source tree, it would be great to execute them. With Maven, this is done by invoking the test lifecycle phase:
    mvn test

However, if you try this now, what you will see are plenty of error messages about ```package org.evosuite.runtime``` does not exist. Recall that EvoSuite tests have a dependency on the EvoSuite runtime library, because they do bytecode instrumentation and all sorts of other stuff to avoid flaky tests. Therefore, we need to tell Maven to use this runtime library. We already know how to add dependencies to Maven projects; this time it is a project dependency, and so we add a new item to the ```<dependencies>``` tag in your ```pom.xml```:

    <dependency>
      <groupId>org.evosuite</groupId>
      <artifactId>evosuite-standalone-runtime</artifactId>
      <version>1.0.6</version>
      <scope>test</scope>
    </dependency>    
    
Once you’ve done that, try executing the tests again:    
        
        mvn test
        
If you set up everything correctly, you should see output similar to this one:   

    -------------------------------------------------------
     T E S T S
    -------------------------------------------------------
    Running tutorial.LinkedListIterator_ESTest
    SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
    SLF4J: Defaulting to no-operation (NOP) logger implementation
    SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
    Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.579 sec
    Running tutorial.LinkedList_ESTest
    Tests run: 11, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.048 sec
    Running tutorial.Node_ESTest
    Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.016 sec
    Running tutorial.StackTest
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
    Running tutorial.Stack_ESTest
    Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.021 sec
    
    Results :
    
    Tests run: 28, Failures: 0, Errors: 0, Skipped: 0
    
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  4.785 s
    [INFO] Finished at: 2021-04-08T10:34:56+02:00
    [INFO] ------------------------------------------------------------------------
    
Note that the number of tests will vary inevitably – EvoSuite uses a randomized algorithm to generate tests, so every time you invoke it you will get a different result.
______
#### The end
***************
[Degree Project Repository](#)

[JDK and Maven Repository ](https://github.com/rqkohistani/JDK_MAVEN_EVOSUITE)      
        