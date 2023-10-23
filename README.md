# Solution to the Comms Tech Test [Jason Xavier]
A function that takes in farm id as a parameter and returns the best tower for the given farm. 

The tower is considered the “best” if the AVERAGE RSSI is the highest amongst the towers for the given farm id.

Key stuff:
- Written in Java
- Modular break down of responsibilites, using object orientated programming
- Comprehensive documentation
- Unit tests : )

## Project Overview
#### `org.example.Main`
contains the solution function, `getBestTower`

#### `solution.*`
package containing the rest of the project files

## Build instructions

### Prerequisites
#### Install a Java Development Kit (JDK)

You can download it from Oracle's official website or use a package manager appropriate for your operating system.

#### Install maven

https://maven.apache.org/install.html

### Instructions
Clone the Repo
```
git clone https://github.com/jxav22/HalterSkillsAssesssmentJasonXavier.git
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

## Alternative to doing all that

Download and run the precompiled `solution.jar` file, under releases

![image](https://github.com/jxav22/HalterSkillsAssesssmentJasonXavier/assets/94942712/73b0c597-ca97-4c51-abe2-cc02777b142e)

```
java -jar solution.jar <farm-id>
```

## Notable issue

It seems like 2 of the files require some kind of authorization
![image](https://github.com/jxav22/HalterSkillsAssesssmentJasonXavier/assets/94942712/adde6a31-d63e-4c45-b259-3b1eb01cee59)

How it's handled
![image](https://github.com/jxav22/HalterSkillsAssesssmentJasonXavier/assets/94942712/b5896591-e14f-40d7-a6ee-32b8f5d94b7e)



