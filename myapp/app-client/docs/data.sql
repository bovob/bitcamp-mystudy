-- 회원 데이터

INSERT INTO myapp_users(user_id, name, email, pwd) values
  (1, 'user1', 'user1@test.com', sha1('1111')),
  (2, 'user2', 'user2@test.com', sha1('1111')),
  (3, 'user3', 'user3@test.com', sha1('1111')),
  (4, 'user4', 'user4@test.com', sha1('1111')),
  (5, 'user5', 'user5@test.com', sha1('1111')),
  (6, 'user6', 'user6@test.com', sha1('1111')),
  (7, 'user7', 'user7@test.com', sha1('1111')),
  (8, 'user8', 'user8@test.com', sha1('1111')),
  (9, 'user9', 'user9@test.com', sha1('1111')),
  (10, 'user10', 'user10@test.com', sha1('1111'));

-- 게시판 데이터

INSERT INTO myapp_boards(board_id, title, content) values
  (1, '제목1', '내용1'),
  (2, '제목2', '내용2'),
  (3, '제목3', '내용3'),
  (4, '제목4', '내용4'),
  (5, '제목5', '내용5'),
  (6, '제목6', '내용6'),
  (7, '제목7', '내용7');

-- 프로젝트 데이터

INSERT INTO myapp_projects(project_id, title, description, start_date, end_date, members) values
  (101, '프로젝트1', '설명1', '2024-1-1', '2024-2-15', '1,2,5'),
  (102, '프로젝트2', '설명2', '2024-2-2', '2024-3-15', '5,6,9'),
  (103, '프로젝트3', '설명3', '2024-3-3', '2024-4-15', '4,7,9');


SELECT * FROM myapp_users;
SELECT * FROM myapp_boards;
SELECT * FROM myapp_projects;
