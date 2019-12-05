create table users(
    id serial not null primary key,
    first_name varchar(20),
    last_name varchar(20),
    email varchar(20) unique,
    password varchar(20)
);


create table flight(
	id serial not null primary key,
	flight_number varchar(20) not null,
	operating_airlines varchar(20) not null,
	departure_city varchar(20) not null,
	arrival_city varchar(20) not null,
	date_of_departure date not null,
	estimated_departure_time timestamp default current_timestamp
);

create table passenger(
	id serial not null primary key,
	first_name varchar(20),
	middle_name varchar(20),
	last_name varchar(20),
	email varchar(20),
	phone varchar(10)
);

create table reservation(
	id serial not null primary key,
	checked_in integer,
	number_of_bags integer,
	passenger_id integer references passenger(id) on delete cascade,
	flight_id integer references flight(id),
	created timestamp default current_timestamp
);