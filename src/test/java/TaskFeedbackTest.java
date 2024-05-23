import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TaskFeedbackTest {
    private OnTrack onTrack;
    private String tutorId;
    private String studentId;
    private String taskId;
    private String feedback;

    @Before
    public void setUp() {
        onTrack = new OnTrack();
        tutorId = "tutor456";
        studentId = "student123";
        taskId = "task478";
        feedback = "Great job! Keep up the good work.";
        onTrack.addUser(tutorId, "password552");
        onTrack.addUser(studentId, "password123");
        onTrack.submitTask(studentId, new TaskDetails("Math Assignment", "Calculus problems", "/path/to/assignment.pdf"), taskId);
    }

    @Test
    public void testTaskFeedback() {
        // Simulate login as tutor
        assertTrue(onTrack.login(tutorId, "password456"));

        // Submit feedback
        String feedbackResult = onTrack.submitFeedback(tutorId, studentId, taskId, feedback);
        assertEquals("Feedback successfully submitted", feedbackResult);

        // Check student notification
        String[] notifications = onTrack.getStudentNotifications(studentId);
        assertTrue(java.util.Arrays.asList(notifications).contains("Feedback provided for task task789"));
    }
}