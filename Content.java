import java.time.LocalDate;

public abstract class Content {
    private String title;
    private String description;
    private LocalDate publicationDate;
    private int contentId;
    private Status status;

    public Content(String title, String description, LocalDate publicationDate, int contentId, Status status) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.contentId = contentId;
        this.status = status;
    }

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

}
