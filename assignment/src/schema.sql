-- we don't know how to generate schema main (class Schema) :(


PRAGMA foreign_keys = OFF;
DROP TABLE actor;
drop table affiliation;
drop table  argument;
drop table argument_link;
drop table discourse;
drop table source;
drop table organisation;
PRAGMA foreign_keys = ON;

create table actor
(
	actor_id INTEGER PRIMARY KEY AUTOINCREMENT,
	first_name text not null,
	last_name text not null,
	level_of_trust unsigned double default null
)
;

create unique index actor_actor_id_uindex
	on actor (actor_id)
;

-- unexpected locus for key
;

create table affiliation
(
	affiliation_id INTEGER PRIMARY KEY AUTOINCREMENT,
	role text default null,
	start_date text default null,
	end_date text default null,
	organisation_id integer default null,
	actor_id integer not null
)
;

create unique index affiliation_affiliation_id_uindex
	on affiliation (affiliation_id)
;

-- unexpected locus for key
;

create table argument
(
	argument_id INTEGER PRIMARY KEY AUTOINCREMENT,
	discourse_id integer not null,
	actor_id integer not null,
	rephrasing text not null,
	start integer not null,
	end integer not null,
	confidence unsigned double default null
)
;

create table argument_link
(
	argument_link_id INTEGER PRIMARY KEY AUTOINCREMENT,
	argument_one_id integer not null,
	argument_two_id integer not null,
	argument_link_type boolean not null
)
;

create table discourse
(
	discourse_id INTEGER PRIMARY KEY AUTOINCREMENT,
	source_id integer not null,
	name text not null
)
;

create table organisation
(
	organisation_id INTEGER PRIMARY KEY AUTOINCREMENT,
	name text not null
		unique
)
;

create table source
(
	source_id INTEGER PRIMARY KEY AUTOINCREMENT,
	name text not null,
	confidence unsigned double default null
)
;

insert into source (name, confidence) values ("default source", 0.0);
insert into source (name, confidence) values ("HuffPost", 5.0);
insert into source (name, confidence) values ("Reddit", 15.0);
insert into source (name, confidence) values ("Fox News", -100.0);
insert into source (name, confidence) values ("Stuff.co.nz", -50.0);


insert into discourse (source_id, name) values (1, "default discourse");
insert into discourse (source_id, name) values (2, "Mike Pompeo: Melting Sea Ice Open 'New Passageways' For Trade");
insert into discourse (source_id, name) values (3, "Former Reddit CEO: Popular pro-Trump foum should be banned");
insert into discourse (source_id, name) values (4, "Another Italian village is selling homes for less than $2");
insert into discourse (source_id, name) values (5, "Pork prices to jump by a quarter");

insert into discourse (source_id, name) values (2, "Australian Prime Minister Scott Morrison hit in the had with an egg by protestor");
insert into discourse (source_id, name) values (3, "Rhino poacher trampled by an elephant and then eaten by lions");
insert into discourse (source_id, name) values (4, "'Mona Lisa' mystery may be solved after half-millennia");
insert into discourse (source_id, name) values (5, "Mother punches cafe worker for interfering in domestic fight with daughter");

