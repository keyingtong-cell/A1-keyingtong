/**
 * Represents the "can prescribe" capability: every health professional who is allowed to prescribe
 * drugs implements this interface.
 *
 * @author Tong Keying
 * @version 14/11/2026
 */
public interface CanPrescribe {

    /**
     * Prescribes a medicine to a patient.
     *
     * @param medicine the name of the medicine
     */
    void prescribeDrugs(String medicine);
}