-- 회원 데이터

INSERT INTO myapp_users(user_id, name, email, pwd) values
  (1, 'admin', 'admin@test.com', sha1('1111')),
  (11, 'user1', 'user1@test.com', sha1('1111')),
  (12, 'user2', 'user2@test.com', sha1('1111')),
  (13, 'user3', 'user3@test.com', sha1('1111')),
  (14, 'user4', 'user4@test.com', sha1('1111')),
  (15, 'user5', 'user5@test.com', sha1('1111')),
  (16, 'user6', 'user6@test.com', sha1('1111')),
  (17, 'user7', 'user7@test.com', sha1('1111')),
  (18, 'user8', 'user8@test.com', sha1('1111')),
  (19, 'user9', 'user9@test.com', sha1('1111')),
  (20, 'user10', 'user10@test.com', sha1('1111'));

-- 게시판 데이터

INSERT INTO myapp_boards(board_id, title, content, user_id) values
  (1, '제목1', '내용1', 11),
  (2, '제목2', '내용2', 11),
  (3, '제목3', '내용3', 13),
  (4, '제목4', '내용4', 16),
  (5, '제목5', '내용5', 19),
  (6, '제목6', '내용6', 20),
  (7, '제목7', '내용7', 20);

-- 프로젝트 데이터

INSERT INTO myapp_projects(project_id, title, description, start_date, end_date) values
  (101, '프로젝트1', '설명1', '2024-1-1', '2024-2-15'),
  (102, '프로젝트2', '설명2', '2024-2-2', '2024-3-15'),
  (103, '프로젝트3', '설명3', '2024-3-3', '2024-4-15');

-- 프로젝트 멤버
INSERT INTO myapp_project_members(project_id, user_id)  VALUES
  (101, 11), (101, 12), (101, 15),
  (102, 15), (102, 16), (102, 19),
  (103, 14), (103, 17), (103, 19);

SELECT * FROM myapp_users;
SELECT * FROM myapp_boards;
SELECT * FROM myapp_projects;
SELECT * FROM myapp_project_members;


