#!/bin/bash

num=1
for f in {a..z}{0..99}; do
    echo $num > "$f.txt"
    echo $((num+1)) >> "$f.txt"
    echo $((num+2)) >> "$f.txt"
    echo $((num+3)) >> "$f.txt"
    ((num=num+1))
done
