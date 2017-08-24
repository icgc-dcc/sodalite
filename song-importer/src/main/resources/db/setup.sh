#!/bin/sh
HERE=`dirname $0`
cd $HERE

DB=$1

echo " -- Creating DB -- "
./create_new_db.sh $DB

echo " -- Creating Tables -- "
psql $DB < ./create_tables.sql