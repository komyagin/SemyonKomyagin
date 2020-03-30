Homework

Test structure requirements:
•	Maven project
•	POM xml has structure described in lectures:
o	main artefacts
o	properties
o	dependencies
o	plugins
•	Library calculator-1.0.jar should be added to the project as maven dependence
•	As test runner used TestNg
•	For test maven build used maven-surefire-plugin
•	Code must according Java Code Convention

File placement requirements:
1.	Classes should be placed into src/test/java/hw1 package and sub-packages
2.	Homework should be developed in a new Java class
3.	Test methods should have a name in accordance with checking functionality
4.	When you are ready and have pushed your homework task, please ping me in Skype personally and send a link to your project repo

Tests requirements:
1.	You should test several Calculator operations (at least 4)
2.	Test for each operation should be placed in separate classes
3.	Create test suite, which could run all tests
4.	Split test for the two groups and creates suite for each group:
a.	Tests for add and subtract operations
b.	Tests for multiply and devide operations
5.	All test data should be provided to test through the DataProviders
6.	Create 3 maven profiles which allow choose test suite (by default should work profile which run add and subtract operations tests)
7.	All test must launch through the maven commands
