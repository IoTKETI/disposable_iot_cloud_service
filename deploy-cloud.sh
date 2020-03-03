echo "Start cloud-server Deploy"

echo "kill legacy server"
kill $(ps -ef | grep java | grep cloudserver | awk '{print $2}')

echo "Maven Build"
mvn clean package

echo "Deploy Server"
cd target/
nohup java -jar cloudserver-0.0.1-SNAPSHOT.jar &

tail -f ./target/nohup.out
