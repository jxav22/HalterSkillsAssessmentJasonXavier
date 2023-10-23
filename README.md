# Solution to the Comms Tech Test [Jason Xavier]
A function that takes in farm id as a parameter and returns the best tower for the given farm. 

The tower is considered the “best” if the AVERAGE RSSI is the highest amongst the towers for the given farm id.

Key stuff:
- Written in Java
- Modular/uses object orientated programming
- Includes comprehensive documentation
- Unit tests

## Project Overview
#### [`org.example.Main`](https://github.com/jxav22/HalterSkillsAssessmentJasonXavier/blob/master/src/main/java/org/example/Main.java)
contains the solution function, `getBestTower`

#### [`solution.*`](https://github.com/jxav22/HalterSkillsAssessmentJasonXavier/tree/master/src/main/java/solution)
package containing the rest of the project files

## Build instructions

### Prerequisites
#### Install a Java Development Kit (JDK)

You can download it from Oracle's official website or through using a package manager appropriate for your operating system.

#### Install maven

https://maven.apache.org/install.html

### Instructions
Clone the Repo
```
git clone https://github.com/jxav22/HalterSkillsAssessmentJasonXavier.git
```
Navigate to the Project Directory
```
cd <directory>
```
Run maven package to build the file
```
mvn package
```
Navigate to the output folder
```
cd target
```
Run the solution file

```
java -jar solution.jar <farm-id>
```

Output: The program will print the best tower ID for the given farm, or an error message if the farm ID is not provided or invalid.

![image](https://github.com/jxav22/HalterSkillsAssesssmentJasonXavier/assets/94942712/d8578632-dfac-46f0-ae81-3824ecc37528)

## Alternatives to building it

<details>
<summary>Downloading the release</summary>

  
Download and run the precompiled `solution.jar` file, under releases

![image](https://github.com/jxav22/HalterSkillsAssesssmentJasonXavier/assets/94942712/73b0c597-ca97-4c51-abe2-cc02777b142e)

```
java -jar solution.jar <farm-id>
```

</details>

<details>
<summary>Running it from an IDE</summary>

  
Open the project in the [IntelliJ IDE](https://www.jetbrains.com/idea/) 

Set the food-id by modifying the settings for the Main configuration

![image](https://github.com/jxav22/HalterSkillsAssessmentJasonXavier/assets/94942712/a0357c04-fc95-4cbc-8164-f7ca51d12260)
![image](https://github.com/jxav22/HalterSkillsAssessmentJasonXavier/assets/94942712/66d25233-608f-4990-b04a-23fad6600ee3)

Run the configuration

![image](https://github.com/jxav22/HalterSkillsAssessmentJasonXavier/assets/94942712/ec2dad0d-f3ea-4ea0-a141-0bde4c8198ac)
</details>

## A notable issue

It seems like 2 of the files require some kind of authorization
![image](https://github.com/jxav22/HalterSkillsAssesssmentJasonXavier/assets/94942712/adde6a31-d63e-4c45-b259-3b1eb01cee59)

This is how I handled it when it happens
![image](https://github.com/jxav22/HalterSkillsAssesssmentJasonXavier/assets/94942712/b5896591-e14f-40d7-a6ee-32b8f5d94b7e)



