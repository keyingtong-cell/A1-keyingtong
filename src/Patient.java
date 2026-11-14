/**
 * Represents a patient, storing the patient's name and mobile number.
 *
 * @author Tong Keying
 * @version 14/11/2026
 */
public class Patient {
    private String name;
    private String mobile;

    /**
     * Creates a patient object; the default value "Unknown" is used when the name or the mobile
     * number is empty.
     *
     * @param name the patient's name; defaults to "Unknown" when empty
     * @param mobile the patient's mobile number; defaults to "Unknown" when empty
     */
    public Patient(String name, String mobile) {
        if (name == null || name.isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }
        if (mobile == null || mobile.isEmpty()) {
            this.mobile = "Unknown";
        } else {
            this.mobile = mobile;
        }
    }

    /**
     * Returns the name of the patient.
     *
     * @return the patient's name string
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the mobile number of the patient.
     *
     * @return the patient's mobile number string
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Returns a readable description of this patient.
     *
     * @return a description string containing the name and mobile number
     */
    @Override
    public String toString() {
        return "Patient [Name: " + name + ", Mobile: " + mobile + "]";
    }
}