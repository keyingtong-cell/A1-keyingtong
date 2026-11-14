import java.util.ArrayList;
import java.util.Arrays;

/**
 * Abstract base class representing a health professional; it stores the professional's id, name
 * and weekly working days. It cannot be instantiated with new and is meant to be extended by
 * concrete subclasses.
 *
 * @author Tong Keying
 * @version 14/11/2026
 */
public abstract class HealthProfessional {
    private String id;
    private String name;
    private ArrayList<String> workingDays;

    private static final String DEFAULT_ID = "0";
    private static final String DEFAULT_NAME = "Unknown";
    private static final ArrayList<String> DEFAULT_WORKING_DAYS = new ArrayList<>(
            Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));

    /**
     * Checks whether the given string consists of digits only.
     *
     * @param text the string to check
     * @return true when the string is not empty and consists only of digits, otherwise false
     */
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

    /**
     * Checks whether the given string is empty or null.
     *
     * @param text the string to check
     * @return true when the string is null or has length 0, otherwise false
     */
    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    /**
     * Creates a health professional object and validates the id, name and working days.
     *
     * @param id the professional's id, which must consist of digits only; otherwise the default id
     *        "0" is used
     * @param name the professional's name, which must not be empty; otherwise the default name
     *        "Unknown" is used
     * @param workingDays the weekly working days; the default Monday-to-Friday list is used when it
     *        is null or empty
     */
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

    /**
     * Creates a health professional object from the id and name only; the working days use the
     * default value (Monday to Friday).
     *
     * @param id the professional's id, which must consist of digits only
     * @param name the professional's name, which must not be empty
     */
    public HealthProfessional(String id, String name) {
        this(id, name, DEFAULT_WORKING_DAYS);
    }

    /**
     * Returns the type name of this professional; each subclass provides its own implementation.
     *
     * @return the name of this professional type, e.g. "General Practitioner"
     */
    public abstract String getRole();

    /**
     * Returns the id of this health professional.
     *
     * @return the id string of this object
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of this health professional.
     *
     * @return the name string of this object
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the weekly working days of this health professional.
     *
     * @return a copy of the working days list; changing the returned list does not affect the
     *         working days stored in this object
     */
    public ArrayList<String> getWorkingDays() {
        return new ArrayList<>(workingDays);
    }

    /**
     * Checks whether two professionals are the same person: two professionals with the same id are
     * considered the same professional.
     *
     * @param other the other object to compare with
     * @return true when both objects have the same id, otherwise false
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HealthProfessional)) {
            return false;
        }
        HealthProfessional that = (HealthProfessional) other;
        return id.equals(that.id);
    }

    /**
     * Generates a hash code from the id, consistent with equals(): objects with the same id have the
     * same hash code.
     *
     * @return the hash code computed from the id
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    /**
     * Returns a readable description of this health professional; the type name comes from the
     * getRole() implementation of the concrete subclass.
     *
     * @return a description string containing the type, id, name and working days
     */
    @Override
    public String toString() {
        return "Health Professional [Role: " + getRole() + ", ID: " + id
                + ", Name: " + name + ", Working days: " + workingDays + "]";
    }

}