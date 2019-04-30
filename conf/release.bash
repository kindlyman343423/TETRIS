#!bin/bash

# this script is used for releasing new tetris jar file for use

cd ../build                                             # move to build directory for application build

bash build.bash                                         # build the whole application

cd ../bin                                               # move to bin directory 

echo "Main-Class: Main" > Manifest.txt                  # write manifest file

jar cfm Tetris.jar Manifest.txt *.class RAINBOW/*.class # make jar file
echo "jar file created ..."

rm Manifest.txt                                         # remove manifest file

mv Tetris.jar ../release                                # move jar file to release