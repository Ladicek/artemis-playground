# Artemis playground

This is my Apache ActiveMQ Artemis playground.

No guarantees that anything will be useful, but feel free to look around :-)

## Start Artemis locally

To run a playground Artemis broker locally, run:

```bash
wget https://downloads.apache.org/activemq/activemq-artemis/2.17.0/apache-artemis-2.17.0-bin.zip
unzip apache-artemis-2.17.0-bin.zip
cd apache-artemis-2.17.0

./bin/artemis create --user admin --password admin --require-login ~/tmp/my-artemis

cd ~/tmp/my-artemis

# increase max disk usage
vim etc/broker.xml
# <max-disk-usage>99</max-disk-usage>

./bin/artemis run

./bin/artemis address create --user admin --password admin --name my-queue --anycast --no-multicast
./bin/artemis queue create --user admin --password admin --name my-queue --address my-queue --anycast --durable --preserve-on-no-consumers --silent
```
