#!/bin/sh
REPO=`git remote -v | awk '/(push)/ {print $2}'`

git pull

if [ ! -d ".privatebuild" ]; then
   git clone . .privatebuild
fi

cd .privatebuild
git fetch
git reset --hard origin\/master
git clean -xdf

mvn install

if [ $? -eq 0 ]; then
   echo "publishing to: $REPO"
   git push $REPO master
else
   echo "Unable to build"
   exit $?
fi


