package bitcamp.myapp.servlet.project;

import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/project/add")
public class ProjectAddServlet extends HttpServlet {

    private ProjectDao projectDao;
    private UserDao userDao;
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void init() throws ServletException {
        ServletContext ctx = this.getServletContext();
        this.projectDao = (ProjectDao) ctx.getAttribute("projectDao");
        this.sqlSessionFactory = (SqlSessionFactory) ctx.getAttribute("sqlSessionFactory");
        userDao = (UserDao) this.getServletContext().getAttribute("userDao");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            List<User> users = userDao.list();
            req.setAttribute("users", users);

            res.setContentType("text/html;charset=UTF-8");
            req.getRequestDispatcher("/project/form.jsp").include(req, res);

        } catch (Exception e) {
            req.setAttribute("exception", e);
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Project project = (Project) req.getSession().getAttribute("project");
            projectDao.insert(project);

            if (project.getMembers() != null && project.getMembers().size() > 0) {
                projectDao.insertMembers(project.getNo(), project.getMembers());
            }
            sqlSessionFactory.openSession(false).commit();
            res.sendRedirect("/project/list");

            // 세션에서 보관했던 Project 객체를 제거한다.
            req.getSession().removeAttribute("project");

        } catch (Exception e) {
            sqlSessionFactory.openSession(false).rollback();
            req.setAttribute("exception", e);
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
    }
}
