## theatre-onboarding-service

High Level Architecture







Steps:

1)	Clients (Mobile/ Web) will go to a LB server. This LB server will be behind a F5 DNS and works either with consistent hashing or round robin fashion. This LB could also act as an API gateway.
2)	Based on the URL the correct routing mechanism will be picked and the request will be forwarded to the appropriate service.
3)	The API gateways invokes the application servers which may internally call the database or remote endpoints to complete its operation.
4)	These services may also create events to let the system know about the changes being happening.
5)	App servers should also forward the logs to a distributed tracing environment for better logging and alerting.
6)	Performance should be monitored at each and every step and may take appropriate actions of rectify the problems. Distributed caching could be one solution but it could also hard to maintain.

Design Pattern to be used:

•	CQRS pattern along with event driven architecture. Since the system is going to be ready heavy, we need a way to scale the portion of the system like the read part. Following the CQRS pattern we can scale the query part of the system without affecting the command one. That will help us with the load/traffic that is coming through.
•	To make sure system is highly concurrent and performing well, we need to stay away from blocking IO as much as could. In this scenario the event driven architecture can help us to implement async functionality in the system.

Components to be used to build the platform:

Load Balancer:

LB is used to maintain the load on the app servers to keep the system highly concurrent and also helps with horizontal scaling.

Searching:

Elastic search a good option to use to implement the searching functionality in the system. Though I have no experience working with it. I have worked with SQL server to search the data and we can use different techniques to improve the performance like database partitions, clustered indexing etc. But elastic search could be a good candidate to be considered.

Caching:

To save the information related to the movies, seat ordering, theatres, etc, we need to use caching. We can use Redis for caching to save all this information in system. Redis is open-source and it can be also used for the locking mechanism to block the tickets temporarily for a user. It means when a user is trying to book the ticket Redis will block the tickets with a specific TTL.

Database:

We need to provide the ACID functionality in our system. For that we would need to use the RDBMS. The portal will be read-heavy so we need to share the data by Geo or we need to use master-master slave architecture. Slaves can be used for reading and master for writing.

Logging and Alerting:

Any distributed logging/tracing platform can be used. Splunk is one which gives a lot of flexibility with querying the data and alerting based in certain situations.

API’s needed:

GET:

•	api/v1/cities
•	api/v1/events?city=cityId


Tables:

•	places: (country, state, city, street)
•	theatre (id, name)
•	screen (id, name)
•	seats
•	movie
•	tickets
•	users

Relations with tables:

•	One to many: place and theatre
•	One to many: theatre and screen
•	One to one: screen and movie
•	One to many: user and tickets
•	One to many: tickets and seats


Classes:

•	User
•	Movie
•	Theatre
•	Booking
•	Address

Public class User {

private Integer id; // need to discuss if this can be integer or should be UUID
private String name;
private String contactNumber;
private String emailId;
}

public class Movie {

	private Integer id;
	private String name;
	private Integer theatreId;
	private MovieLanguage movieLanguage;
	private Genre genre;

}

Public class Theatre {

	private Integer theatreId;
private String name;
private Address address;
private List<Movies> movies;
}

Public class Address {

	Private String city;
Private String pinCode;
Private String state;
Private String country;
}




