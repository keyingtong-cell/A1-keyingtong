import java.util.ArrayList;
import java.util.Arrays;

public class HealthProfessional {
    private String id;
    private String name;
    private ArrayList<String> workingDays;

    private static final String DEFAULT_ID = "0";
    private static final String DEFAULT_NAME = "Unknown";
    private static final ArrayList<String> DEFAULT_WORKING_DAYS = new ArrayList<>(
            Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));

    private boolean isAllDigits(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    public HealthProfessional(String id, String name, ArrayList<String> workingDays) {
        if (isAllDigits(id)) {
            this.id = id;
        } else {
            this.id = DEFAULT_ID;
        }
        if (isBlank(name)) {
            this.name = DEFAULT_NAME;
        } else {
            this.name = name;
        }
        if (workingDays == null || workingDays.isEmpty()) {
            this.workingDays = new ArrayList<>(DEFAULT_WORKING_DAYS);
        } else {
            this.workingDays = new ArrayList<>(workingDays);
        }
    }

    public HealthProfessional(String id, String name) {
        this(id, name, DEFAULT_WORKING_DAYS);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getWorkingDays() {
        return new ArrayList<>(workingDays);
    }

    @Override
    public String toString() {
        return "Health Professional [ID: " + id + ", Name: " + name
                + ", Working days: " + workingDays + "]";
    }

}