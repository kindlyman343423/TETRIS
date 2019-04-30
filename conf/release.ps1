# this script is used for releasing new tetris jar file for use

Set-Location ../build                                       # move to build directory for application build

pwsh build.ps1                                              # build the whole application

Set-Location ../bin                                         # move to bin directory 

Write-Output "Main-Class: Main" > Manifest.txt              # write manifest file

jar cfm Tetris.jar Manifest.txt *.class RAINBOW/*.class     # make jar file

Write-Output "jar file created ..."

Remove-Item Manifest.txt                                    # remove manifest file

Move-Item Tetris.jar ../release                             # move jar file to release