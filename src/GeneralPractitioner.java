import java.util.ArrayList;

/**
 * A general practitioner, extending the health professional base class. Besides the shared
 * information it keeps the medical licence number and can prescribe drugs.
 *
 * @author Tong Keying
 * @version 14/11/2026
 */
public class GeneralPractitioner extends HealthProfessional implements CanPrescribe {

    private String licenceNumber;

    /**
     * Creates a general practitioner object: the id, name and working days are passed to the parent
     * class, and the licence number is stored by this class.
     *
     * @param id the professional's id, which must consist of digits only
     * @param name the professional's name, which must not be empty
     * @param workingDays the weekly working days; the default working days are used when it is
     *        null or empty
     * @param licenceNumber the medical licence number; it is set to "Unknown" when null or empty
     */
    public GeneralPractitioner(String id, String name,
            ArrayList<String> workingDays, String licenceNumber) {
        super(id, name, workingDays);
        if (licenceNumber == null || licenceNumber.isEmpty()) {
            this.licenceNumber = "Unknown";
        } else {
            this.licenceNumber = licenceNumber;
        }
    }

    /**
     * Returns the type name of this professional.
     *
     * @return the string "General Practitioner"
     */
    @Override
    public String getRole() {
        return "General Practitioner";
    }

    /**
     * Prescribes a medicine and prints a prescription record.
     *
     * @param medicine the name of the medicine
     */
    @Override
    public void prescribeDrugs(String medicine) {
        System.out.println("General Practitioner " + getName()
                + " prescribes: " + medicine);
    }

    /**
     * Returns a readable description of this general practitioner: the shared information from the
     * parent class followed by this doctor's licence number.
     *
     * @return a description string containing the type, id, name, working days and licence number
     */
    @Override
    public String toString() {
        return super.toString() + " | Licence: " + licenceNumber;
    }

}