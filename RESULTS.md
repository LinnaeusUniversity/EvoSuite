# RESULTS
## To evaluate consider the following steps
### Maven Terminal commands 
*****
1. ###  mvn validate
        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------
        [INFO] Total time:  0.125 s
        [INFO] Finished at: 2021-04-08T13:14:48+02:00
        [INFO] ------------------------------------------------------------------------
1. ###  mvn compile
        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------
        [INFO] Total time:  1.837 s
        [INFO] Finished at: 2021-04-08T13:17:16+02:00
        [INFO] ------------------------------------------------------------------------
        
        Compiled files are should be in target folder
        
1. ###  mvn test
       -------------------------------------------------------
        T E S T S
       -------------------------------------------------------
       Running evoSuite.MyEvoSuiteTest
       Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.091 sec
       
       Results :
       
       Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
       
       [INFO] ------------------------------------------------------------------------
       [INFO] BUILD SUCCESS
       [INFO] ------------------------------------------------------------------------
       [INFO] Total time:  2.803 s
       [INFO] Finished at: 2021-04-08T13:36:47+02:00
       [INFO] ------------------------------------------------------------------------


### EvoSuite Terminal commands
******
1. ###  mvn evosuite:help 
       [INFO] ------------------------------------------------------------------------
       [INFO] BUILD SUCCESS
       [INFO] ------------------------------------------------------------------------
       [INFO] Total time:  1.548 s
       [INFO] Finished at: 2021-04-08T13:18:46+02:00
       [INFO] ------------------------------------------------------------------------

1. ###  mvn evosuite:generate
        [INFO] >>> evosuite-maven-plugin:1.0.6:generate (default-cli) > compile @ EvoSuite >>>
        [INFO] 
        [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ EvoSuite ---
        [INFO] Using 'UTF-8' encoding to copy filtered resources.
        [INFO] skip non existing resourceDirectory C:\Users\rashi\Desktop\Thesis\EvoSuite\src\main\resources
        [INFO] 
        [INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ EvoSuite ---
        [INFO] Nothing to compile - all classes are up to date
        [INFO] 
        [INFO] <<< evosuite-maven-plugin:1.0.6:generate (default-cli) < compile @ EvoSuite <<<
        [INFO] 
        [INFO] 
        [INFO] --- evosuite-maven-plugin:1.0.6:generate (default-cli) @ EvoSuite ---
        [INFO] Going to generate tests with EvoSuite
        [INFO] Total memory: 800mb
        [INFO] Time per class: 2 minutes
        [INFO] Number of used cores: 1
        [INFO] Target: C:\Users\rashi\Desktop\Thesis\EvoSuite\target\classes
        [INFO] Basedir: C:\Users\rashi\Desktop\Thesis\EvoSuite
        [INFO] Started spawn process manager on port 50575
        [INFO] SLF4J: Class path contains multiple SLF4J bindings.
        [INFO] SLF4J: Found binding in [jar:file:/C:/Users/rashi/.m2/repository/org/evosuite/evosuite-master/1.0.6/evosuite-master-1.0.6.jar!/org/slf4j/impl/StaticLoggerBinder.class]
        [INFO] SLF4J: Found binding in [jar:file:/C:/Users/rashi/.m2/repository/ch/qos/logback/logback-classic/1.1.3/logback-classic-1.1.3.jar!/org/slf4j/impl/StaticLoggerBinder.class]
        [INFO] SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
        [INFO] SLF4J: Actual binding is of type [ch.qos.logback.classic.util.ContextSelectorStaticBinder]
        [INFO] * EvoSuite 1.0.6
        [INFO] Registered remote process from /127.0.0.1:50576
        [INFO] Going to execute 1 jobs
        [INFO] Estimated completion time: 2 minutes, by 2021-04-08T13:48:24.477
        [INFO] Going to start job for: evoSuite.MyEvoSuite. Expected to end in 120 seconds, by 2021-04-08T13:48:24.776
        [INFO] Registered remote process from /127.0.0.1:50580
        [INFO] Registered remote process from /127.0.0.1:50586
        [INFO] Completed job. Left: 0
        [INFO] * Updating database to evoSuite.MyEvoSuite
        [INFO] === CTG run results ===
        [INFO] Removed test suites: 0
        [INFO] New test suites: 1
        [INFO] Stopping spawn process manager
        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------
        [INFO] Total time:  21.340 s
        [INFO] Finished at: 2021-04-08T13:46:41+02:00
        [INFO] ------------------------------------------------------------------------
    .evosuite folder should be now created. what contains evosuite
1. ###  mvn evosuite:info
        [INFO] --- evosuite-maven-plugin:1.0.6:info (default-cli) @ EvoSuite ---
        [INFO] Going to query EvoSuite info on current project
        [INFO] SLF4J: Class path contains multiple SLF4J bindings.
        [INFO] SLF4J: Found binding in [jar:file:/C:/Users/rashi/.m2/repository/org/evosuite/evosuite-master/1.0.6/evosuite-master-1.0.6.jar!/org/slf4j/impl/StaticLoggerBinder.class]
        [INFO] SLF4J: Found binding in [jar:file:/C:/Users/rashi/.m2/repository/ch/qos/logback/logback-classic/1.1.3/logback-classic-1.1.3.jar!/org/slf4j/impl/StaticLoggerBinder.class]
        [INFO] SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
        [INFO] SLF4J: Actual binding is of type [ch.qos.logback.classic.util.ContextSelectorStaticBinder]
        [INFO] * EvoSuite 1.0.6
        [INFO] Total number of classes in the project: 1
        [INFO] Number of classes in the project that are testable: 1
        [INFO] Number of generated test suites: 1
        [INFO] Overall coverage: 1.0
        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------
        [INFO] Total time:  3.594 s
        [INFO] Finished at: 2021-04-08T13:47:56+02:00
        [INFO] ------------------------------------------------------------------------

1. ###  mvn evosuite:export
#### Terminal output
        [INFO] --- evosuite-maven-plugin:1.0.6:export (default-cli) @ EvoSuite ---
        [INFO] Exporting tests
        [INFO] Exported tests to C:\Users\rashi\Desktop\Thesis\EvoSuite\src\test\java
        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------
        [INFO] Total time:  1.507 s
        [INFO] Finished at: 2021-04-08T13:49:12+02:00
        [INFO] ------------------------------------------------------------------------

##### evosuite:export creates two classes for each java class starting with the java name followed by _ESTest and _ESTest_scaffolding. E.g: MyEvosuite_ESTest and MyEvoSuite_ESTest_scaffolding.
#### Class MyEvoSuite_ESTest
        /*
         * This file was automatically generated by EvoSuite
         * Thu Apr 08 12:11:27 GMT 2021
         */
        
        package evoSuite;
        
        import org.evosuite.runtime.EvoRunner;
        import org.evosuite.runtime.EvoRunnerParameters;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        
        import static org.junit.Assert.assertEquals;
        
        @RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
        public class MyEvoSuite_ESTest extends MyEvoSuite_ESTest_scaffolding {
        
          @Test(timeout = 4000)
          public void test0()  throws Throwable  {
              MyEvoSuite myEvoSuite0 = new MyEvoSuite();
              int int0 = myEvoSuite0.add(0, 0);
              assertEquals(0, int0);
          }
        
          @Test(timeout = 4000)
          public void test1()  throws Throwable  {
              MyEvoSuite myEvoSuite0 = new MyEvoSuite();
              int int0 = myEvoSuite0.add(0, 2478);
              assertEquals(2478, int0);
          }
        
          @Test(timeout = 4000)
          public void test2()  throws Throwable  {
              MyEvoSuite myEvoSuite0 = new MyEvoSuite();
              int int0 = myEvoSuite0.add((-3781), (-3781));
              assertEquals((-7562), int0);
          }
        }

#### Class MyEvoSuite_ESTest_scaffolding
        /**
         * Scaffolding file used to store all the setups needed to run 
         * tests automatically generated by EvoSuite
         * Thu Apr 08 12:11:27 GMT 2021
         */
        
        package evoSuite;
        
        import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
        import org.evosuite.runtime.sandbox.Sandbox;
        import org.junit.After;
        import org.junit.AfterClass;
        import org.junit.Before;
        import org.junit.BeforeClass;
        
        @EvoSuiteClassExclude
        public class MyEvoSuite_ESTest_scaffolding {
        
          @org.junit.Rule 
          public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();
        
          private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 
        
          private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);
        
        
          @BeforeClass 
          public static void initEvoSuiteFramework() { 
            org.evosuite.runtime.RuntimeSettings.className = "evoSuite.MyEvoSuite"; 
            org.evosuite.runtime.GuiSupport.initialize(); 
            org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
            org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
            org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
            org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
            org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
            org.evosuite.runtime.classhandling.JDKClassResetter.init();
            setSystemProperties();
            initializeClasses();
            org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
          } 
        
          @AfterClass 
          public static void clearEvoSuiteFramework(){ 
            Sandbox.resetDefaultSecurityManager(); 
            java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
          } 
        
          @Before 
          public void initTestCase(){ 
            threadStopper.storeCurrentThreads();
            threadStopper.startRecordingTime();
            org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
            org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
            setSystemProperties(); 
            org.evosuite.runtime.GuiSupport.setHeadless(); 
            org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
            org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
          } 
        
          @After 
          public void doneWithTestCase(){ 
            threadStopper.killAndJoinClientThreads();
            org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
            org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
            resetClasses(); 
            org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
            org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
            org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
          } 
        
          public static void setSystemProperties() {
         
            java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
            java.lang.System.setProperty("file.encoding", "Cp1252"); 
            java.lang.System.setProperty("java.awt.headless", "true"); 
            java.lang.System.setProperty("java.io.tmpdir", "C:\\Users\\rashi\\AppData\\Local\\Temp\\"); 
            java.lang.System.setProperty("user.country", "US"); 
            java.lang.System.setProperty("user.dir", "C:\\Users\\rashi\\Desktop\\Thesis\\EvoSuite"); 
            java.lang.System.setProperty("user.home", "C:\\Users\\rashi"); 
            java.lang.System.setProperty("user.language", "en"); 
            java.lang.System.setProperty("user.name", "rashid"); 
            java.lang.System.setProperty("user.timezone", "Europe/Berlin"); 
          }
        
          private static void initializeClasses() {
            org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(MyEvoSuite_ESTest_scaffolding.class.getClassLoader() ,
              "evoSuite.MyEvoSuite"
            );
          } 
        
          private static void resetClasses() {
            org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(MyEvoSuite_ESTest_scaffolding.class.getClassLoader()); 
        
            org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
              "evoSuite.MyEvoSuite"
            );
          }
        }


1. ###  mvn test
        -------------------------------------------------------
         T E S T S
        -------------------------------------------------------
        Running evoSuite.MyEvoSuiteTest
        Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.1 sec
        Running evoSuite.MyEvoSuite_ESTest
        SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
        SLF4J: Defaulting to no-operation (NOP) logger implementation
        SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
        Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.387 sec
        
        Results :
        
        Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
        
        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------
        [INFO] Total time:  3.868 s
        [INFO] Finished at: 2021-04-08T14:05:39+02:00
        [INFO] ------------------------------------------------------------------------

For more info check .evosuite package.

*************
