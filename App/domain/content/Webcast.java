package app.domain.content;

import java.time.LocalDate;

import app.domain.individuals.Speaker;

public class Webcast extends Content {
    private String url;
    private double length;
    private Speaker speaker;

    // constructor methode
    Webcast(String title, String description, LocalDate publicationDate, int contentId, Status status, String url,
            double length, Speaker speaker) {
        super(title, description, publicationDate, contentId, status);
        this.url = url;
        this.length = length;
        this.speaker = speaker;
    }

    // setters en getters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

}
