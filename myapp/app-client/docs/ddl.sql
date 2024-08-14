DROP TABLE if EXISTS myapp_project_members restrict;
DROP TABLE if EXISTS myapp_projects restrict;
DROP TABLE if EXISTS myapp_users restrict;
DROP TABLE if EXISTS myapp_boards restrict;


-- USER

CREATE TABLE myapp_users (
  user_id int not null,
  name varchar(20) not null,
  email varchar(100) not null,
  pwd varchar(100) not null,
  tel varchar(20)
);

ALTER TABLE myapp_users
  ADD CONSTRAINT PRIMARY KEY (user_id),
  MODIFY COLUMN user_id INT NOT NULL AUTO_INCREMENT,
  ADD CONSTRAINT myapp_users_uk UNIQUE (email);


-- BOARD


CREATE TABLE myapp_boards (
  board_id int not null,
  title varchar(255) not null,
  content text not null,
  user_id int not null,
  created_date datetime default now(),
  view_count int default 0
);

ALTER TABLE myapp_boards
  ADD CONSTRAINT PRIMARY key (board_id),
  MODIFY COLUMN board_id int not null auto_increment;

ALTER TABLE myapp_boards
  ADD CONSTRAINT myapp_boards_fk FOREIGN KEY (user_id) REFERENCES myapp_users(user_id);


-- PROJECT


CREATE TABLE myapp_projects (
  project_id int not null,
  title varchar(255) not null,
  description text not null,
  start_date date not null, -- ex) 'yyyy-MM-dd'
  end_date date not null   -- ex) 'yyyy-MM-dd'
); --  members varchar(20)       -- ex) 2, 3, 4, 5, 11

ALTER TABLE myapp_projects
  ADD CONSTRAINT PRIMARY KEY (project_id),
  MODIFY COLUMN project_id int not null auto_increment;

-- PROJECT - MEMBERS


CREATE TABLE myapp_project_members (
  user_id int not null,
  project_id int not null
);

ALTER TABLE myapp_project_members
  ADD CONSTRAINT myapp_project_members_fk1 FOREIGN KEY (user_id) REFERENCES myapp_users (user_id),
  ADD CONSTRAINT myapp_project_members_fk2 FOREIGN KEY (project_id) REFERENCES myapp_projects (project_id),
  ADD CONSTRAINT PRIMARY KEY (user_id, project_id);

