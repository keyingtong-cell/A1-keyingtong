import java.util.ArrayList;

/**
 * A surgeon, extending the health professional base class. Besides the shared information it keeps
 * a surgical specialty and can perform surgery.
 *
 * @author Tong Keying
 * @version 14/11/2026
 */
public class Surgeon extends HealthProfessional {

    private String surgerySpecialty;

    /**
     * Creates a surgeon object: the id, name and working days are passed to the parent class, and
     * the surgical specialty is stored by this class.
     *
     * @param id the professional's id, which must consist of digits only
     * @param name the professional's name, which must not be empty
     * @param workingDays the weekly working days; the default working days are used when it is
     *        null or empty
     * @param surgerySpecialty the surgical specialty, e.g. "Cardiac Surgery"; it is set to
     *        "Unknown" when null or empty
     */
    public Surgeon(String id, String name,
            ArrayList<String> workingDays, String surgerySpecialty) {
        super(id, name, workingDays);
        if (surgerySpecialty == null || surgerySpecialty.isEmpty()) {
            this.surgerySpecialty = "Unknown";
        } else {
            this.surgerySpecialty = surgerySpecialty;
        }
    }

    /**
     * Returns the type name of this professional.
     *
     * @return the string "Surgeon"
     */
    @Override
    public String getRole() {
        return "Surgeon";
    }

    /**
     * Performs a surgery and prints a surgery record.
     *
     * @param surgeryName the name of the surgery
     */
    public void performSurgery(String surgeryName) {
        System.out.println("Surgeon " + getName()
                + " performs: " + surgeryName);
    }

    /**
     * Returns a readable description of this surgeon: the shared information from the parent class
     * followed by this doctor's surgical specialty.
     *
     * @return a description string containing the type, id, name, working days and surgical specialty
     */
    @Override
    public String toString() {
        return super.toString() + " | Specialty: " + surgerySpecialty;
    }
}