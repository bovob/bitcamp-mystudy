package bitcamp.myapp.listener;

import bitcamp.context.ApplicationContext;
import bitcamp.listener.ApplicationListener;
import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;

public class AuthApplicationListener implements ApplicationListener {

  @Override
  public boolean onStart(ApplicationContext ctx) throws Exception {
    String email = "";//prompt.input("이메일?");
    String password = ""; //prompt.input("암호?");

    UserDao userDao = (UserDao) ctx.getAttribute("userDao");

    User user = userDao.findByEmailAndPassword(email, password);
    if (user == null) {
      System.out.println("로그인 실패!");
      return false;
    }

    // 로그인 사용자 정보를 쓸 수 있도록 보관한다.
    ctx.setAttribute("loginUser", user);

    return true;
  }

}
