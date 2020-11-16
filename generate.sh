#!/bin/bash

RANDOM=$$
for f in {a..z}{0..99}; do
    for i in `seq 10`; do
      echo $RANDOM >> "$f.txt"
    done
done