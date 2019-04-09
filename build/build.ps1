Write-Output "Build started ..."

Set-Location ../src                   # go to source directory
Copy-Item *.java ../bin            # copy java files to bin directory
Copy-Item -R RAINBOW ../bin        # copy RAINBOW package to bin directory
Set-Location ../bin                   # move to bin directory
javac Main.java             # compile java files
Remove-Item *.java                   # remove all unnecssary java files
Set-Location RAINBOW                  # go to RAINBOW directory
Remove-Item *.java                   # remove all java source files of package RAINBOW
Remove-Item .gitignore               # remove files like .gitignore

Write-Output "Build Completed..."