this is how to add the connector\
need to install wget:\
    void:\
    xbps-install wget\
    debian:\
    apt install wget\
    arch:\
    pacman -S wget \

cd ~/Downloads\
wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j-9.5.0.tar.gz\
tar -xvf mysql-connector-j-9.5.0.tar.gz\
mysql-connector-j-9.5.0\
cd ..\
mkdir -p ~/java/lib\
mv mysql-connector-j-9.5.0/mysql-connector-j-9.5.0.jar ~/java/lib/\
export CLASSPATH=.:$HOME/java/lib/mysql-connector-j-9.5.0.jar\
\
this a simple project for manging a pharmacie:\
the ojects are :\
medicine\
client\
supplier\
