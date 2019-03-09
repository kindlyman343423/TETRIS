#!bin/bash

echo -e "Building...\n"

cd src
javac Main.java
mv *.class ../bin

echo -e "***** Build completed *****\n";