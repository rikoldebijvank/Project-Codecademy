import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Course {
    private String courseName;
    private String subject;
    private String introduction;
    private Certificate certificate;
    private Difficulty difficulty;
    private ArrayList<Course> recommendedCourses;
    private HashMap<String, Content> content;

    public Course(String courseName, String subject, String intro, Certificate certificate, Difficulty difficulty) {
        this.courseName = courseName;
        this.subject = subject;
        this.introduction = intro;
        this.certificate = certificate;
        this.difficulty = difficulty;
        this.recommendedCourses = new ArrayList<>();
        this.content = new HashMap<>();
    }

    public void addModule(Module module) {
        content.put(module.getTitle(), module);
    }

    public void addWebcast(Webcast webcast) {
        content.put(webcast.getTitle(), webcast);
    }

    public Double perctDoneAllStudents(HashMap<String, Content> modules) {
        // Method moet nog ingevuld worden
        return 0.0;
    }

    public void showRecommendedCourses() {
        StringBuilder builder = new StringBuilder();
        Iterator<Course> iterator = recommendedCourses.iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next());
        }
        System.out.println(builder);
    }

    public void perctFinishedStudents() {
        // Method moet nog ingevuld worden
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public ArrayList<Course> getRecommendedCourses() {
        return recommendedCourses;
    }

    public void setRecommendedCourses(ArrayList<Course> recommendedCourses) {
        this.recommendedCourses = recommendedCourses;
    }

    public HashMap<String, Content> getContent() {
        return content;
    }

    public void setContent(HashMap<String, Content> content) {
        this.content = content;
    }
}
