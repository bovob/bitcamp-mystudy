package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    UserDao userDao;
    private Connection con;

    public ProjectDaoImpl(Connection con) {
        this.con = con;
    }

    public ProjectDaoImpl(Connection con, UserDaoImpl userDao) {
        this.con = con;
        this.userDao = userDao;
    }

    @Override
    public boolean insert(Project project) throws Exception {
        List<User> memberList = project.getMembers();
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < memberList.size(); i++) {
            strBuilder.append(memberList.get(i).getNo());
            if (i < memberList.size() - 1) {
                strBuilder.append(",");
            }
        }

        try (Statement stmt = con.createStatement();) {

            stmt.executeUpdate(String.format(
                "insert into myapp_projects(title,description,start_date,end_date,members) "
                    + "values ('%s','%s','%s','%s','%s')", project.getTitle(),
                project.getDescription(), project.getStartDate(), project.getEndDate(),
                strBuilder));
        }
        return false;
    }

    @Override
    public List<Project> list() throws Exception {

        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
            "SELECT * FROM myapp_projects ORDER BY project_id ASC")) {

            ArrayList<Project> list = new ArrayList<>();

            while (rs.next()) {
                Project project = new Project();
                project.setNo(rs.getInt("project_id"));
                project.setTitle(rs.getString("title"));
                project.setStartDate(rs.getString("start_date"));
                project.setEndDate(rs.getString("end_date"));
                list.add(project);
            }
            return list;
        }
    }

    @Override
    public Project findBy(int no) throws Exception {
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
            "SELECT * FROM myapp_projects WHERE project_id=" + no)) {

            if (rs.next()) {
                Project project = new Project();
                // 이게 있어야 n번 게시물 삭제 return
                project.setNo(rs.getInt("project_id"));
                project.setTitle(rs.getString("title"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getString("start_date"));
                project.setEndDate(rs.getString("end_date"));

                String memberStr = rs.getString("members");

                List<User> member = new ArrayList<>();
                if (memberStr != null && !memberStr.isEmpty()) {
                    String[] memberArray = memberStr.split(",");
                    for (String memberString : memberArray) {
                        User user = new User();
                        user.setNo(Integer.parseInt(memberString.trim()));
                        user = userDao.findBy(user.getNo());

                        member.add(user);
                    }
                }

                project.setMembers(member);
                return project;
            }
            return null;
        }
    }

    @Override
    public boolean update(Project project) throws Exception {
        List<User> memberList = project.getMembers();
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < memberList.size(); i++) {
            strBuilder.append(memberList.get(i).getNo());
            if (i < memberList.size() - 1) {
                strBuilder.append(",");
            }
        }

        try (Statement stmt = con.createStatement();) {

            int count = stmt.executeUpdate(String.format(
                "update myapp_projects set" + " title='%s', " + " description='%s',"
                    + " start_date='%s'," + " end_date='%s', " + " members='%s' "
                    + " where project_id='%d'", project.getTitle(), project.getDescription(),
                project.getStartDate(), project.getEndDate(), strBuilder, project.getNo()));

            return count > 0;
        }
    }

    @Override
    public boolean delete(int no) throws Exception {
        try (Statement stmt = con.createStatement();) {

            int count = stmt.executeUpdate(
                String.format("delete from myapp_projects where project_id=%d", no));
            return count > 0;
        }
    }
}
