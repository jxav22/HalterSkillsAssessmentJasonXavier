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

#### Install maven (a build tool)

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

Output: The program will print the best tower ID for the given farm, or an error message if the farm ID is not provided or invalid.

![image](https://github.com/jxav22/HalterSkillsAssesssmentJasonXavier/assets/94942712/81f3c6c6-e55b-43b2-be71-eed0ed808bdb)

## Alternative to doing all that

Download and run the precompiled `solution.jar` file, under releases

![image](https://github.com/jxav22/HalterSkillsAssesssmentJasonXavier/assets/94942712/8d0fb30e-3964-48ce-8b1b-0c4d3a99bb66)

```
java -jar solution.jar <farm-id>
```

## Notable issue

It seems like 2 of the files require some kind of authorization
![image](https://github.com/jxav22/HalterSkillsAssesssmentJasonXavier/assets/94942712/3a89bca4-23d3-453f-b134-8bbf591a0d1b)

How it's handled
![image](https://github.com/jxav22/HalterSkillsAssesssmentJasonXavier/assets/94942712/6aface54-1908-4143-842c-eb78998b415f)


