-- USER
DROP TABLE myapp_users;

CREATE TABLE myapp_users (
  user_id int not null,
  name varchar(20) not null,
  email varchar(100) not null,
  pwd varchar(100) not null,
  tel varchar(20)
);

ALTER TABLE myapp_users
  ADD CONSTRAINT PRIMARY KEY (id),
  MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT,
  ADD CONSTRAINT myapp_users_uk UNIQUE (email);


-- BOARD

DROP TABLE myapp_boards;

CREATE TABLE myapp_boards (
  board_id int not null,
  title varchar(255) not null,
  content text not null,
  created_date datetime default now(),
  view_count int default 0
);

ALTER TABLE myapp_boards
  ADD CONSTRAINT PRIMARY key (board_id),
  MODIFY COLUMN board_id int not null auto_increment;


-- PROJECT

DROP TABLE myapp_projects;

CREATE TABLE myapp_projects (
  project_id int not null,
  title varchar(255) not null,
  description text not null,
  start_date date not null, -- ex) 'yyyy-MM-dd'
  end_date date not null,   -- ex) 'yyyy-MM-dd'
  members varchar(20)       -- ex) 2, 3, 4, 5, 11
);

ALTER TABLE myapp_projects
  ADD CONSTRAINT PRIMARY KEY (project_id),
  MODIFY COLUMN project_id int not null auto_increment;

