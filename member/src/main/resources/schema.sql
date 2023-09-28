create table if not EXISTS prefectures( 
	id BIGINT primary key,
	name varchar(255),
	name_kana varchar(255)
);

create table if not EXISTS members( 
	id BIGINT auto_increment primary key,
	first_name varchar(255),
	last_name varchar(255),
	birth_date timestamp,
	post_code varchar(255),
	prefecture INT,
	address1 varchar(255),
	address2 varchar(255),
	phone_number varchar(255),
	gender boolean,
	join_date timestamp,
	delete_date timestamp,
	status INT,
	update_datetime timestamp,
	update_staff INT,
	regist_datetime timestamp,
	regist_staff INT,
	FOREIGN KEY(prefecture) REFERENCES prefectures(id)
);
