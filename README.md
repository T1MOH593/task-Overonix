# task-overonix

to run the application you should run method main in class TaskOveronixApplication

to pass the authentification/authorization you should use username = user, password = user

GET /address returns list of addresses in JSON format. Request params that can be used mention here https://nominatim.org/release-docs/develop/api/Output/#addressdetails

Also request can have the second type of parameters : q="query". The final coordinates are saved to the H2 database. This request implements caching

GET /addresses returns all addresses by coordinates from H2 in JSON format
