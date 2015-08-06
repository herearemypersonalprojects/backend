~$ mysql -u root -proot
mysql> create database map character set utf8;
mysql> create user map;
mysql> set password for map = password("map");
mysql> grant all on map.* to map;
