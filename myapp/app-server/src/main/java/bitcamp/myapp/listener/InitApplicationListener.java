package bitcamp.myapp.listener;

import bitcamp.context.ApplicationContext;
import bitcamp.listener.ApplicationListener;
import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.command.HelloCommand;
import bitcamp.myapp.command.HelpCommand;
import bitcamp.myapp.command.board.*;
import bitcamp.myapp.command.project.*;
import bitcamp.myapp.command.user.*;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.DaoFactory;
import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.mybatis.SqlSessionFactoryProxy;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class InitApplicationListener implements ApplicationListener {

    @Override
    public boolean onStart(ApplicationContext ctx) throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // SqlSession sqlSession = sqlSessionFactory.openSession(false);
        SqlSessionFactoryProxy sqlSessionFactoryProxy = new SqlSessionFactoryProxy(sqlSessionFactory);


        DaoFactory daoFactory = new DaoFactory(sqlSessionFactoryProxy);

        UserDao userDao = daoFactory.createObject(UserDao.class);
        BoardDao boardDao = daoFactory.createObject(BoardDao.class);
        ProjectDao projectDao = daoFactory.createObject(ProjectDao.class);

        ctx.setAttribute("userDao", userDao);
        ctx.setAttribute("boardDao", boardDao);
        ctx.setAttribute("projectDao", projectDao);

        MenuGroup mainMenu = ctx.getMainMenu();

        MenuGroup userMenu = new MenuGroup("회원");
        userMenu.add(new MenuItem("등록", new UserAddCommand(userDao, sqlSessionFactory)));
        userMenu.add(new MenuItem("목록", new UserListCommand(userDao)));
        userMenu.add(new MenuItem("조회", new UserViewCommand(userDao)));
        userMenu.add(new MenuItem("변경", new UserUpdateCommand(userDao, sqlSessionFactory)));
        userMenu.add(new MenuItem("삭제", new UserDeleteCommand(userDao, sqlSessionFactory)));
        mainMenu.add(userMenu);

        MenuGroup projectMenu = new MenuGroup("프로젝트");
        ProjectMemberHandler memberHandler = new ProjectMemberHandler(userDao);
        projectMenu.add(
                new MenuItem("등록", new ProjectAddCommand(projectDao, memberHandler, sqlSessionFactory)));
        projectMenu.add(new MenuItem("목록", new ProjectListCommand(projectDao)));
        projectMenu.add(new MenuItem("조회", new ProjectViewCommand(projectDao)));
        projectMenu.add(new MenuItem("변경", new ProjectUpdateCommand(projectDao, memberHandler, sqlSessionFactory)));
        projectMenu.add(new MenuItem("삭제", new ProjectDeleteCommand(projectDao, sqlSessionFactory)));
        mainMenu.add(projectMenu);

        MenuGroup boardMenu = new MenuGroup("게시판");
        boardMenu.add(new MenuItem("등록", new BoardAddCommand(boardDao, sqlSessionFactory)));
        boardMenu.add(new MenuItem("목록", new BoardListCommand(boardDao)));
        boardMenu.add(new MenuItem("조회", new BoardViewCommand(boardDao, sqlSessionFactory)));
        boardMenu.add(new MenuItem("변경", new BoardUpdateCommand(boardDao, sqlSessionFactory)));
        boardMenu.add(new MenuItem("삭제", new BoardDeleteCommand(boardDao, sqlSessionFactory)));
        mainMenu.add(boardMenu);

        mainMenu.add(new MenuItem("도움말", new HelpCommand()));
        mainMenu.add(new MenuItem("안녕!", new HelloCommand()));

        mainMenu.setExitMenuTitle("종료");

        return true;
    }
}
