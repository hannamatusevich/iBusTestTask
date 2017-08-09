# iBusTestTask by Hanna Matusevich

## Requirements

1. Windows
2. Google Chrome (I'm using only Chrome driver, because it's just a demo project, but in real projects I will use all possible drivers to write auto tests).

## How to deploy project?

Just use native Java compiler. Build and run project with one Main function. Windows only, because I'm using Chrome driver compiled on Windows.

## How does it work?

Hey. Thanks for the patience. As we agreed, I’m glad to introduce you my test task solution, developed on Java with Selenium WebDriver support. The principle of the tests is the following:

1. For testing the log in process with **INVALID** data I've used the CSS property DISPLAY in 'style' attribute of '#loginForm > .error' element. Before submission of login form, the value of property *DISPLAY=NONE*. Expected, that after entering of invalid data, value of DISPLAY should be changed and become *!= none*. In that case test is PASSED. If the value still = none - test FAILED. 

2. For checking login with **EMPTY** fields, I used the same algorithm as in 1 case.

3. For checking **SUCCEESSFUL** login case, I check the existence of element with class ‘sign out’ and check its content. If element was presented after log in and content is correct - it means that I recieved expected result and test is PASSED. In all different cases test is FAILED.  

## Notices

1. I have never wrote automated tests before and it difficult for me to say, how correct I did it.
2. I have never used Git VCS before, but my friend advised me to use GitHub to upload my codebase, because it's better than to send it as an archive. 
3. I have never deployed Java projects before, that’s why all I did in this task is:

* created empty Java-project in IDEA from the basic template; 
* connected *selenium-java* library; 
* connected Chrome driver to the project;
* wrote a code;
