~$ mysql -u root -proot
mysql> create database map;
mysql> create user map;
mysql> set password for map = password("map");
mysql> grant all on map.* to map;
