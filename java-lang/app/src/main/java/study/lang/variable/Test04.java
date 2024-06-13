package study.lang.variable;

public class Test04 {

  public static void main(String[] args) {
    String[][] subMenus = {{"회원등록", "목록", "조회", "변경", "삭제"}, {"팀등록", "목록", "조회", "변경", "삭제"},
        {"프로젝트등록", "목록", "조회", "변경", "삭제"}, {"게시판등록", "목록", "조회", "변경", "삭제"},};

    for (int i = 0; i < subMenus.length; i++) {
      for (int j = 0; j < subMenus[i].length; j++) {
        System.out.printf("i는 : %d, j는 : %d  %s     ", i, j, subMenus[i][j]);
      }
      System.out.println();
    }
  }
}
