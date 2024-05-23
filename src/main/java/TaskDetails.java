
public class TaskDetails {
	private String title;
    private String description;
    private String filePath;

    public TaskDetails(String title, String description, String filePath) {
        this.title = title;
        this.description = description;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getFilePath() {
        return filePath;
    }
}
