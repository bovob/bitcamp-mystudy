package bitcamp.myapp.vo;

import java.util.Date;

public class Board {

    private String title;
    private String content;
    private Date createaDate;
    private int viewCount;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateaDate() {
        return createaDate;
    }

    public void setCreateaDate(Date createaDate) {
        this.createaDate = createaDate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
