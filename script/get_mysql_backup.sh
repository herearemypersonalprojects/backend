#!/bin/bash

# login


sftp quocanh@bandoviet.net:backup/mysql/01/mysql-2015-08-08.bz2
export PATH=$PATH:/usr/local/mysql/bin/
bunzip2 < mysql-2015-08-08.bz2 | mysql -umap -pmap map 

