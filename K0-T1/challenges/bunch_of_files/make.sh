#! /bin/bash
for n in {1..1000}; do
    </dev/urandom tr -dc "\t\n [:alnum:]" | head -c$(( RANDOM + 1024 )) > file$( printf %03d "$n" ).rand
done
