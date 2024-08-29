package bitcamp.myapp.servlet.project;

import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/project/delete")
public class ProjectDeleteServlet extends GenericServlet {

    private ProjectDao projectDao;
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void init() throws ServletException {
        ServletContext ctx = this.getServletContext();
        this.projectDao = (ProjectDao) ctx.getAttribute("projectDao");
        this.sqlSessionFactory = (SqlSessionFactory) ctx.getAttribute("sqlSessionFactory");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();
        req.getRequestDispatcher("/header").include(req, res);

        try {
            Project project = new Project();
            out.println("<h1>프로젝트 삭제결과</h1>");

            int projectNo = Integer.parseInt(req.getParameter("no"));


            projectDao.deleteMembers(projectNo);

            if (projectDao.delete(projectNo)) {
                sqlSessionFactory.openSession(false).commit();
                out.println("<p>프로젝트를 삭제 했습니다.</p>\n");
            } else {
                out.println("<p>없는 프로젝트입니다.</p>");
            }
        } catch (Exception e) {
            sqlSessionFactory.openSession(false).rollback();
            out.println("<p>삭제 중 오류 발생!</p>");
        }
        out.println("</body>");
        out.println("</html>");
        ((HttpServletResponse) res).setHeader("Refresh", "1;url=/project/list");
    }
}
