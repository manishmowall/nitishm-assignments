#!/bin/bash
echo The Host Name is $(hostname)
echo ""
echo OS $(lsb_release -d)
echo ""
echo Path of Home Directory is $HOME
echo ""
echo What are Users Logged in:
who -u
echo ""
echo Groups user beongs to are :
groups 
echo ""
echo finding files of directory and its subdirectories are:
find . -type f


