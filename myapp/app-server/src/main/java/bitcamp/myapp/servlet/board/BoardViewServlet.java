package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/board/view")
public class BoardViewServlet extends GenericServlet {

    private BoardDao boardDao;

    @Override
    public void init() throws ServletException {
        boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=utf-8");

        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>Title</title>");
        out.println("</head>");
        out.println("<body>");

        try {
            out.println("<h1>게시판 조회</h1>");
            int boardNo = Integer.parseInt(req.getParameter("no"));

            Board board = boardDao.findBy(boardNo);
            if (board == null) {
                out.println("<p>없는 게시글입니다.</p>");
                return;
            }

            board.setViewCount(board.getViewCount() + 1);
            boardDao.updateViewCount(board.getNo(), board.getViewCount());

            out.printf("제목: %s\n", board.getTitle());
            out.printf("내용: %s\n", board.getContent());
            out.printf("작성일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", board.getCreatedDate());
            out.printf("조회수: %d\n", board.getViewCount());
            out.printf("작성자: %s\n", board.getWriter().getName());

        } catch (Exception e) {
            out.println("<p>조회 중 오류 발생!</p>");
        }
        out.println("</head>");
        out.println("</html>");
    }
}
