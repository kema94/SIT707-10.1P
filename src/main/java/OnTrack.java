import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class OnTrack {
    private Map<String, String> users;
    private Map<String, ArrayList<String>> notifications;
    private Map<String, TaskDetails> submissions;
    private Map<String, String> feedbacks;

    public OnTrack() {
        users = new HashMap<>();
        notifications = new HashMap<>();
        submissions = new HashMap<>();
        feedbacks = new HashMap<>();
    }

    /*Email notification test comment*/
    public void addUser(String userId, String password) {
        users.put(userId, password);
        notifications.put(userId, new ArrayList<>());
    }

    public boolean login(String userId, String password) {
        return users.getOrDefault(userId, "").equals(password);
    }
    
     public boolean submitTask(String studentId, TaskDetails taskDetails, String taskId) {
        if (users.containsKey(studentId)) {
            submissions.put(taskId, taskDetails);
            notifications.get("tutor456").add("New task submitted by " + studentId);
            return true;
        }
        return false;
    }

    public String submitFeedback(String tutorId, String studentId, String taskId, String feedback) {
        System.out.println("Checking if tutor exists: " + users.containsKey(tutorId));
        System.out.println("Checking if student exists: " + users.containsKey(studentId));
        System.out.println("Checking if task exists: " + submissions.containsKey(taskId));

        if (users.containsKey(tutorId) && users.containsKey(studentId) && submissions.containsKey(taskId)) {
            feedbacks.put(taskId, feedback);
            notifications.get(studentId).add("Feedback provided for task " + taskId);
            return "Feedback successfully submitted";
        }
        return "Feedback submission failed";
    }

    public String[] getStudentNotifications(String studentId) {
        ArrayList<String> notificationList = notifications.get(studentId);
        return notificationList.toArray(new String[0]);
    }
}
