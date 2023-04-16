package app.domain.content;

import java.time.LocalDate;

public class Content {
    protected String title;
    private String description;
    private LocalDate publicationDate;
    private int contentId;
    private Status status;

    private String moduleTitle;
    private String moduleProgress;
    private String webcastTitle;
    private String webcastProgress;

    // constructor methode
    public Content(String title, String description, LocalDate publicationDate, int contentId, Status status) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.contentId = contentId;
        this.status = status;
    }

    // andere constructor
    public Content(String title) {
        this.title = title;
    }

    // andere constructor
    public Content(String moduleTitle, String moduleProgress, String webcastTitle, String webcastProgress) {
        this.moduleTitle = moduleTitle;
        this.moduleProgress = moduleProgress;
        this.webcastTitle = webcastTitle;
        this.webcastProgress = webcastProgress;
    }

    // setters en getters
    // ..

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public String getModuleProgress() {
        return moduleProgress;
    }

    public void setModuleProgress(String moduleProgress) {
        this.moduleProgress = moduleProgress;
    }

    public String getWebcastTitle() {
        return webcastTitle;
    }

    public void setWebcastTitle(String webcastTitle) {
        this.webcastTitle = webcastTitle;
    }

    public String getWebcastProgress() {
        return webcastProgress;
    }

    public void setWebcastProgress(String webcastProgress) {
        this.webcastProgress = webcastProgress;
    }
}
