#!/bin/bash

if [ $# -ne 2 ]; then
  echo -e "\nUsage:\t$0 MIN MAX\n"
  exit 1
fi

DIFF=$(($2-$1+1))
RANDOM=$$
for f in {a..z}{0..99}; do
    for i in `seq 10`; do
      R=$(($(($RANDOM%$DIFF))+$1))
      echo $R >> "$f.txt"
    done
done
