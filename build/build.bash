#!bin/bash

echo "Build started ..."

cd ../src                   # go to source directory
cp *.java ../bin            # copy java files to bin directory
cp -R RAINBOW ../bin        # copy RAINBOW package to bin directory
cd ../bin                   # move to bin directory
javac Main.java             # compile java files
rm *.java                   # remove all unnecssary java files
cd RAINBOW                  # go to RAINBOW directory
rm *.java                   # remove all java source files of package RAINBOW
rm .gitignore               # remove files like .gitignore

echo "Build Completed..."