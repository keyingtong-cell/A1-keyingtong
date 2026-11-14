import java.util.ArrayList;
import java.util.Collections;

/**
 * Manages the clinic's appointments: keeps all appointments and is responsible for adding them,
 * making sure that the same professional is never booked at the same time twice.
 *
 * @author Tong Keying
 * @version 14/11/2026
 */
public class AppointmentManager {

    private ArrayList<Appointment> appointments;

    /**
     * Creates an appointment manager with an empty appointment list.
     */
    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    /**
     * Adds an appointment. If the appointment is null, or the same professional is already booked
     * at the same time, the appointment is rejected and a warning message is returned.
     *
     * @param appointment the appointment to add
     * @return "Appointment added: ..." on success, or "Cannot add appointment: ..." when the
     *         appointment is rejected
     */
    public String addAppointment(Appointment appointment) {
        if (appointment == null) {
            return "Cannot add appointment: appointment is null.";
        }
        for (Appointment existing : appointments) {
            if (existing.getProfessional().equals(appointment.getProfessional())
                    && existing.getTimeMinutes() == appointment.getTimeMinutes()) {
                return "Cannot add appointment: "
                        + appointment.getProfessional().getName()
                        + " is already booked at "
                        + appointment.getTimeString() + ".";
            }
        }
        appointments.add(appointment);
        return "Appointment added: " + appointment.getTimeString() + " for "
                + appointment.getPatient().getName() + " with "
                + appointment.getProfessional().getName() + ".";
    }

    /**
     * Prints all appointments, sorted by appointment time from earliest to latest.
     */
    public void displayAll() {
        Collections.sort(appointments);
        System.out.println("=== All Appointments (sorted by time) ===");
        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }

    /**
     * Prints the appointments of one professional, selected by the professional's id; the result is
     * sorted by appointment time as well.
     *
     * @param id the professional's id
     */
    public void displayFilteredByProfessional(String id) {
        ArrayList<Appointment> found = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getProfessional().getId().equals(id)) {
                found.add(a);
            }
        }
        if (found.isEmpty()) {
            System.out.println("No appointments found for professional ID " + id + ".");
        } else {
            Collections.sort(found);
            System.out.println("=== Appointments for professional ID " + id + " ===");
            for (Appointment a : found) {
                System.out.println(a);
            }
        }
    }

    /**
     * Prints the appointments of one patient, selected by the patient's mobile number; the result
     * is sorted by appointment time as well.
     *
     * @param mobile the patient's mobile number
     */
    public void displayFilteredByMobile(String mobile) {
        ArrayList<Appointment> found = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getPatient().getMobile().equals(mobile)) {
                found.add(a);
            }
        }
        if (found.isEmpty()) {
            System.out.println("No appointments found for patient mobile " + mobile + ".");
        } else {
            Collections.sort(found);
            System.out.println("=== Appointments for patient mobile " + mobile + " ===");
            for (Appointment a : found) {
                System.out.println(a);
            }
        }
    }

    /**
     * Cancels the appointment of one professional at a given time: the matching appointment is
     * removed and a success message is returned.
     *
     * @param id the professional's id
     * @param timeMinutes the appointment time in minutes
     * @return "Appointment cancelled: ..." when an appointment was removed, or "Cannot cancel: ..."
     *         when no appointment matches
     */
    public String cancelByProfessional(String id, int timeMinutes) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getProfessional().getId().equals(id)
                    && a.getTimeMinutes() == timeMinutes) {
                appointments.remove(i);
                return "Appointment cancelled: " + a.getTimeString() + " with "
                        + a.getProfessional().getName() + ".";
            }
        }
        return "Cannot cancel: no appointment found for professional ID " + id + ".";
    }

    /**
     * Cancels an appointment by the patient's mobile number: the first matching appointment is
     * removed and a success message is returned.
     *
     * @param mobile the patient's mobile number
     * @return "Appointment cancelled: ..." when an appointment was removed, or "Cannot cancel: ..."
     *         when no appointment matches
     */
    public String cancelByMobile(String mobile) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getPatient().getMobile().equals(mobile)) {
                appointments.remove(i);
                return "Appointment cancelled: " + a.getTimeString() + " for "
                        + a.getPatient().getName() + ".";
            }
        }
        return "Cannot cancel: no appointment found for patient mobile " + mobile + ".";
    }
}