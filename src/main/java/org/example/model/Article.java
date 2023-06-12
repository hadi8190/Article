package org.example.model;

public class Article {
    private int articleId;
    private String title;
    private String brief;
    private String content;
    private String isPublished;
    private Researcher researcher;

    public Article(Researcher researcher, String title) {
        this.researcher = researcher;
        this.title = title;
        this.isPublished = "No";
    }

    public Article(int articleId,String title, String brief, String content, String isPublished) {
        this.articleId = articleId;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.isPublished = isPublished ;
    }



    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(String isPublished) {
        this.isPublished = "NO";
    }

    public Researcher getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }
}
