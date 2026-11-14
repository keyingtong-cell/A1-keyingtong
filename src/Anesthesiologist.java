import java.util.ArrayList;

/**
 * An anesthesiologist, extending the health professional base class. Besides the shared
 * information it stores the commonly used anesthesia type and can administer anesthesia to
 * patients.
 *
 * @author Tong Keying
 * @version 14/11/2026
 */
public class Anesthesiologist extends HealthProfessional {

    private String anesthesiaType;

    /**
     * Creates an anesthesiologist object: the id, name and working days are passed to the parent
     * class, and the commonly used anesthesia type is stored by this class.
     *
     * @param id the professional's id, which must consist of digits only
     * @param name the professional's name, which must not be empty
     * @param workingDays the weekly working days; the default working days are used when it is
     *        null or empty
     * @param anesthesiaType the commonly used anesthesia type, e.g. "General Anesthesia"; it is
     *        set to "Unknown" when null or empty
     */
    public Anesthesiologist(String id, String name,
            ArrayList<String> workingDays, String anesthesiaType) {
        super(id, name, workingDays);
        if (anesthesiaType == null || anesthesiaType.isEmpty()) {
            this.anesthesiaType = "Unknown";
        } else {
            this.anesthesiaType = anesthesiaType;
        }
    }

    /**
     * Returns the type name of this professional.
     *
     * @return the string "Anesthesiologist"
     */
    @Override
    public String getRole() {
        return "Anesthesiologist";
    }

    /**
     * Administers anesthesia to a patient and prints an anesthesia record.
     *
     * @param patientName the patient's name
     */
    public void administerAnesthesia(String patientName) {
        System.out.println("Anesthesiologist " + getName()
                + " administers anesthesia to " + patientName);
    }

    /**
     * Returns a readable description of this anesthesiologist: the shared information from the
     * parent class followed by this doctor's commonly used anesthesia type.
     *
     * @return a description string containing the type, id, name, working days and anesthesia type
     */
    @Override
    public String toString() {
        return super.toString() + " | Anesthesia: " + anesthesiaType;
    }
}