
Download a Framework
--------------
* Maven - https://github.com/anandhakrishnanr/PlayList.git


Framework Architecture
--------------
	Playlist
		|
		|_src/main/java
		|_src/main/resources
		|_src/test/java
		|	|_Runner
		|	|	|_TestRunCucumberIT.java
		|	|	|_TestRunCucumberITFailed.java
		|	|_StepDefinition
		|	|	|_Steps.java
		|	|	|...
		|_src/test/resources
		|	|_features
		|	|	|Playlist.feature

* **src/test/resources/features** - all the cucumber features files (files .feature ext) goes here.
* **src/test/java/StepDefinition** - you can define step defintion under this package for your feature steps.
* **src/test/java/Runner** - this package contains cucumber runner (RunCukeTest.java) where you can configure your glue code location (step defintions), define test result output format.(html, json, xml).


Writing a test
--------------

The cucumber features goes in the `features` library and should have the ".feature" extension.

You can start out by looking at `features/my_first.feature`. You can extend this feature or make your own features using some of the [predefined steps](doc/canned_steps.md) that comes with selenium-cucumber.



Running test
--------------

Go to your project directory from terminal and hit following commands
* `mvn clean (to remove previous reports)`
* `mvn test (to execute the scenarios)`

Viewing report
--------------

Go to your project directory from terminal 
* `Find target\cucumber-reports\output.html`
