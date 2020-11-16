# spring-boot-threads-with-scheduling

This is a basic project which only aims to examplify thread usage with scheduling.

After generating some number of files, including integers by each line, using a shell script; the
numbers are getting summed up to a new file. Each thread is responsible for only one file. 

## Usage
First clone the repository and set the current directory as the projects: 
```bash
git clone https://github.com/4turkuaz/spring-boot-threads-with-scheduling
cd ./spring-boot-threads-with-scheduling
```

There is a script in the main folder named `generate.sh` - which generates 2600 (26*100)
files named {a..z}{0..99} (e.g. a7, z99) and puts 10 random integers with the given range:
```bash
mkdir fileDir && mv generate.sh fileDir && cd fileDir
chmod 655 generate.sh 
./generate.sh <MIN_LIMIT> <MAX_LIMIT> # choose limits as you wish
rm generate.sh
cd ..
```

Now, some files containing integers have been created.  

Eventually, you can run the main file using:
```
mvn spring-boot:run
``` 

### Configuration

FileConfig:
 - INPUT_DIR: Directory that contains files containing integer-valued lines.
 - OUTPUT_DIR: Directory where after processing files, the result will be written into

 ThreadConfig:
  - corePoolSize: 4
  - maxPoolSize: 4
  - threadNamePrefix: "default_task_executor_thread"