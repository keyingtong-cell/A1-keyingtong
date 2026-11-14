import java.util.ArrayList;
import java.util.Arrays;

/**
 * Entry point of the assignment: demonstrates the health professional hierarchy, the
 * CanPrescribe capability and the end-to-end appointment system.
 *
 * @author Tong Keying
 * @version 14/11/2026
 */
public class AssignmentOne {
    public static void main(String[] args) {
        // ============ Part 3: different professional types, stored and handled together ============
        ArrayList<HealthProfessional> professionals = new ArrayList<>();

        // three general practitioners
        professionals.add(new GeneralPractitioner("10001", "Dr Anna White",
                new ArrayList<>(Arrays.asList("Monday", "Wednesday", "Friday")), "L1001"));
        professionals.add(new GeneralPractitioner("10002", "Dr John Black",
                new ArrayList<>(Arrays.asList("Tuesday", "Thursday")), "L1002"));
        professionals.add(new GeneralPractitioner("10003", "Dr Maria Green",
                new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday")), "L1003"));

        // two nurses
        professionals.add(new Nurse("20001", "Ms Lily Chen",
                new ArrayList<>(Arrays.asList("Monday", "Wednesday", "Friday")), "Emergency"));
        professionals.add(new Nurse("20002", "Mr Tom Harris",
                new ArrayList<>(Arrays.asList("Tuesday", "Thursday")), "Surgery"));

        // surgeon
        professionals.add(new Surgeon("30001", "Dr Emily Zhang",
                new ArrayList<>(Arrays.asList("Monday", "Thursday")), "Cardiac Surgery"));

        // pediatrician
        professionals.add(new Pediatrician("40001", "Dr Sophia Liu",
                new ArrayList<>(Arrays.asList("Tuesday", "Friday")), "0-14 years"));

        // anesthesiologist
        professionals.add(new Anesthesiologist("50001", "Dr David Wu",
                new ArrayList<>(Arrays.asList("Wednesday", "Friday")), "General Anesthesia"));

        System.out.println("========== Health Professionals ==========");
        for (HealthProfessional p : professionals) {
            System.out.println(p);
        }

        // ============ Type-specific actions ============
        System.out.println("\n========== Professional Actions ==========");
        ((GeneralPractitioner) professionals.get(0)).prescribeDrugs("Panadol");
        ((Nurse) professionals.get(3)).takeBloodSample("Alice Wang");
        ((Surgeon) professionals.get(5)).performSurgery("Heart bypass");
        ((Pediatrician) professionals.get(6)).giveVaccination("MMR vaccine");
        ((Anesthesiologist) professionals.get(7)).administerAnesthesia("Bob Li");

        // Interface capability: program against CanPrescribe (Activity 3.8 pattern)
        System.out.println("\n========== Prescribing via CanPrescribe ==========");
        ArrayList<CanPrescribe> prescribers = new ArrayList<>();
        prescribers.add((GeneralPractitioner) professionals.get(0));
        prescribers.add((Pediatrician) professionals.get(6));
        for (CanPrescribe p : prescribers) {
            p.prescribeDrugs("Vitamin C");
        }

        // ============ Part 6: end-to-end appointment system demo ============
        System.out.println("\n========== Appointment System Demo ==========");
        AppointmentManager manager = new AppointmentManager();
        Patient alice = new Patient("Alice Wang", "0412 345 678");
        Patient bob = new Patient("Bob Li", "0498 765 432");
        Patient carol = new Patient("Carol Sun", "0455 555 555");

        // Add appointments: covering different professional types
        System.out.println("--- Adding appointments ---");
        System.out.println(manager.addAppointment(
                new Appointment(alice, professionals.get(0), 480)));
        System.out.println(manager.addAppointment(
                new Appointment(bob, professionals.get(3), 510)));
        System.out.println(manager.addAppointment(
                new Appointment(carol, professionals.get(5), 600)));
        System.out.println(manager.addAppointment(
                new Appointment(alice, professionals.get(6), 840)));
        System.out.println(manager.addAppointment(
                new Appointment(bob, professionals.get(7), 900)));

        // Error case: the same professional booked twice at the same time
        System.out.println(manager.addAppointment(
                new Appointment(carol, professionals.get(0), 480)));

        // Show all (sorted by time)
        manager.displayAll();

        // Filter by professional id (one exists, one does not)
        manager.displayFilteredByProfessional("10001");
        manager.displayFilteredByProfessional("99999");

        // Filter by patient mobile (one exists, one does not)
        manager.displayFilteredByMobile("0412 345 678");
        manager.displayFilteredByMobile("0000 000 000");

        // Cancel by (professional id + time); the second cancel fails
        System.out.println("--- Cancelling ---");
        System.out.println(manager.cancelByProfessional("10001", 480));
        System.out.println(manager.cancelByProfessional("10001", 480));

        // Cancel by mobile
        System.out.println(manager.cancelByMobile("0498 765 432"));

        // Show all again to prove the collection has been updated
        System.out.println("\n--- After cancelling ---");
        manager.displayAll();
    }
}