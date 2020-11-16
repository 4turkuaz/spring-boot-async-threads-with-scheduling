#!/bin/bash

num=1
for f in {a..z}{0..99}; do
    echo $num > "$f.txt"
    ((num=num+1))
done
