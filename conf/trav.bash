#!bin/bash

# travis build script

echo "Build started ..."

cd src
javac Main.java             # compile java files
rm *.class
echo "Build Completed..."