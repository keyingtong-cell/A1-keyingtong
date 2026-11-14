import java.util.ArrayList;

/**
 * A nurse, extending the health professional base class. Besides the shared information it keeps
 * the department the nurse belongs to and can take blood samples from patients.
 *
 * @author Tong Keying
 * @version 14/11/2026
 */
public class Nurse extends HealthProfessional {

    private String department;

    /**
     * Creates a nurse object: the id, name and working days are passed to the parent class, and the
     * department is stored by this class.
     *
     * @param id the professional's id, which must consist of digits only
     * @param name the professional's name, which must not be empty
     * @param workingDays the weekly working days; the default working days are used when it is
     *        null or empty
     * @param department the department the nurse belongs to; it is set to "Unknown" when null or
     *        empty
     */
    public Nurse(String id, String name,
            ArrayList<String> workingDays, String department) {
        super(id, name, workingDays);
        if (department == null || department.isEmpty()) {
            this.department = "Unknown";
        } else {
            this.department = department;
        }
    }

    /**
     * Returns the type name of this professional.
     *
     * @return the string "Nurse"
     */
    @Override
    public String getRole() {
        return "Nurse";
    }

    /**
     * Takes a blood sample from a patient and prints a blood sample record.
     *
     * @param patientName the patient's name
     */
    public void takeBloodSample(String patientName) {
        System.out.println("Nurse " + getName()
                + " takes a blood sample from " + patientName);
    }

    /**
     * Returns a readable description of this nurse: the shared information from the parent class
     * followed by this nurse's department.
     *
     * @return a description string containing the type, id, name, working days and department
     */
    @Override
    public String toString() {
        return super.toString() + " | Department: " + department;
    }
}