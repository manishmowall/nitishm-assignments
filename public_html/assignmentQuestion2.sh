#!/bin/bash

for filename in $(find . -maxdepth 1 -not -name '*.sh' -not -type d) ;do


      mv -- "$filename" "${filename%.*}.txt"
    

 
 done
 
for filename in $(find . -maxdepth 1 -name 'x*');do
rename 's/x/rname/' $filename
#echo $filename
done
ls

 # ! cmp -s $filename $bashFile  ;then 
#bashFile=$(find . -maxdepth 1 -name "*.sh")
#echo $bashFile
