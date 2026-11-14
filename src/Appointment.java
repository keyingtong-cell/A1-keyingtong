/**
 * Represents an appointment, recording the patient (a Patient object), the booked health
 * professional (a HealthProfessional object) and the appointment time (in minutes); appointments
 * can be sorted by time. The appointment time is stored as "minutes since midnight", e.g. 510
 * means 08:30.
 *
 * @author Tong Keying
 * @version 14/11/2026
 */
public class Appointment implements Comparable<Appointment> {

    // Default appointment time: 480 minutes since midnight, i.e. 08:00
    private static final int DEFAULT_TIME = 480;
    // Earliest bookable slot in the clinic: 480 minutes since midnight, i.e. 08:00
    private static final int FIRST_SLOT = 480;
    // Latest bookable slot: 930 minutes since midnight, i.e. 15:30
    private static final int LAST_SLOT = 930;
    // Length of one time slot: 30 minutes
    private static final int SLOT_LENGTH = 30;

    private Patient patient;
    private HealthProfessional professional;
    private int timeMinutes;

    /**
     * Creates an appointment and validates that the appointment time falls on a legal slot.
     *
     * @param patient the patient; must not be null
     * @param professional the booked health professional; may be any subclass and must not be null
     * @param timeMinutes the appointment time in minutes (510 = 08:30); it must be between 08:00
     *        and 15:30 and be a multiple of 30, otherwise the default time 08:00 is used
     */
    public Appointment(Patient patient, HealthProfessional professional, int timeMinutes) {
        this.patient = patient;
        this.professional = professional;
        if (timeMinutes < FIRST_SLOT || timeMinutes > LAST_SLOT
                || timeMinutes % SLOT_LENGTH != 0) {
            this.timeMinutes = DEFAULT_TIME;
        } else {
            this.timeMinutes = timeMinutes;
        }
    }

    /**
     * Compares two appointments by their appointment time; a return value less than 0 means this
     * appointment is earlier.
     *
     * @param other the other appointment to compare with
     * @return the difference in minutes between the two appointment times: less than 0 means this
     *         appointment is earlier, 0 means the same time, greater than 0 means it is later
     */
    @Override
    public int compareTo(Appointment other) {
        return this.timeMinutes - other.timeMinutes;
    }

    /**
     * Returns the patient of this appointment.
     *
     * @return the patient object
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Returns the health professional booked for this appointment.
     *
     * @return the health professional object, possibly any subclass
     */
    public HealthProfessional getProfessional() {
        return professional;
    }

    /**
     * Returns the appointment time as minutes since midnight.
     *
     * @return the appointment time in minutes, e.g. 510 means 08:30
     */
    public int getTimeMinutes() {
        return timeMinutes;
    }

    /**
     * Returns the appointment time formatted for display, e.g. "9:30".
     *
     * @return the time string in the form "8:30"
     */
    public String getTimeString() {
        return formatTime(timeMinutes);
    }

    /**
     * Formats a moment given in minutes since midnight as "HH:MM", e.g. 510 -> "8:30" and
     * 485 -> "8:05".
     *
     * @param minutes minutes since midnight
     * @return a time string such as "8:30"; the minute part is padded with a leading zero when it
     *         is less than 10
     */
    private String formatTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        if (mins < 10) {
            return hours + ":0" + mins;
        }
        return hours + ":" + mins;
    }

    /**
     * Returns a readable description of this appointment, including the full information of the
     * time, the patient and the professional.
     *
     * @return a description string such as "Appointment [Time: 8:30, Patient: ..., Professional: ...]"
     */
    @Override
    public String toString() {
        return "Appointment [Time: " + formatTime(timeMinutes)
                + ", Patient: " + patient
                + ", Professional: " + professional + "]";
    }
}