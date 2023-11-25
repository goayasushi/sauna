create table if not EXISTS prefectures( 
	id INT primary key,
	name varchar(20),
	name_kana varchar(20)
);

create table if not EXISTS users( 
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

create table if not EXISTS members( 
	id SERIAL primary key,
	first_name varchar(50),
	last_name varchar(50),
	birth_date timestamp,
	post_code varchar(7),
	prefecture INT,
	address1 varchar(255),
	address2 varchar(255),
	phone_number varchar(11),
	gender INT,
	join_date timestamp,
	delete_date timestamp,
	status INT,
	update_datetime timestamp,
	update_staff INT,
	regist_datetime timestamp,
	regist_staff INT,
	version BIGINT,
	FOREIGN KEY (prefecture) REFERENCES prefectures(id)
);
