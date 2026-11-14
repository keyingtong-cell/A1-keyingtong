import java.util.ArrayList;

/**
 * A pediatrician, extending the health professional base class. Besides the shared information it
 * keeps the age range of the children it is responsible for, can give vaccinations and can
 * prescribe drugs.
 *
 * @author Tong Keying
 * @version 14/11/2026
 */
public class Pediatrician extends HealthProfessional implements CanPrescribe {

    private String ageRange;

    /**
     * Creates a pediatrician object: the id, name and working days are passed to the parent class,
     * and the age range is stored by this class.
     *
     * @param id the professional's id, which must consist of digits only
     * @param name the professional's name, which must not be empty
     * @param workingDays the weekly working days; the default working days are used when it is
     *        null or empty
     * @param ageRange the age range of the children this doctor is responsible for, e.g.
     *        "0-14 years"; it is set to "Unknown" when null or empty
     */
    public Pediatrician(String id, String name,
            ArrayList<String> workingDays, String ageRange) {
        super(id, name, workingDays);
        if (ageRange == null || ageRange.isEmpty()) {
            this.ageRange = "Unknown";
        } else {
            this.ageRange = ageRange;
        }
    }

    /**
     * Returns the type name of this professional.
     *
     * @return the string "Pediatrician"
     */
    @Override
    public String getRole() {
        return "Pediatrician";
    }

    /**
     * Gives a vaccination to a child and prints a vaccination record.
     *
     * @param vaccineName the name of the vaccine
     */
    public void giveVaccination(String vaccineName) {
        System.out.println("Pediatrician " + getName()
                + " gives vaccination: " + vaccineName);
    }

    /**
     * Prescribes a medicine to a child and prints a prescription record.
     *
     * @param medicine the name of the medicine
     */
    @Override
    public void prescribeDrugs(String medicine) {
        System.out.println("Pediatrician " + getName()
                + " prescribes: " + medicine);
    }

    /**
     * Returns a readable description of this pediatrician: the shared information from the parent
     * class followed by this doctor's age range.
     *
     * @return a description string containing the type, id, name, working days and age range
     */
    @Override
    public String toString() {
        return super.toString() + " | Age range: " + ageRange;
    }
}