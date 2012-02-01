MinerHat
========

MinerHat is a packet analysis utility and proxy for Minecraft. As of writing,
it been updated for Minecraft 1.1

It runs on port 1111. You cannot change this. After the program has
started (start via terminal), use 'host' and 'port' in console to change
the host/port to connect to.

## How To Use
1. Clone
2. Import project into IntelliJ (or your favorite Java IDE)
3. Run the main class from there, the pom is broken atm :(
4. Start your Minecraft (Bukkit) Server
5. Type `host MY_SERVER_HOST` and press return into the Java window (not your server)
6. Type `port MY_SERVER_PORT` and press return into the Java window (not your server)
7. Open Minecraft
8. Connect to localhost:1111
9. You should see the MinerHat window open. It will show the events.

Remember, it's a proxy, it's intercepting _all_ packets. It **will** lag.

## Fern's Notes

I could not get the maven built pom to work yet. It's on my todo list.
