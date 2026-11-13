import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentOne {
    public static void main(String[] args) {
        ArrayList<HealthProfessional> professionals = new ArrayList<>();

        // 三个全科医生
        professionals.add(new GeneralPractitioner("10001", "Dr Anna White",
                new ArrayList<>(Arrays.asList("Monday", "Wednesday", "Friday")), "L1001"));
        professionals.add(new GeneralPractitioner("10002", "Dr John Black",
                new ArrayList<>(Arrays.asList("Tuesday", "Thursday")), "L1002"));
        professionals.add(new GeneralPractitioner("10003", "Dr Maria Green",
                new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday")), "L1003"));

        // 两个护士
        professionals.add(new Nurse("20001", "Ms Lily Chen",
                new ArrayList<>(Arrays.asList("Monday", "Wednesday", "Friday")), "Emergency"));
        professionals.add(new Nurse("20002", "Mr Tom Harris",
                new ArrayList<>(Arrays.asList("Tuesday", "Thursday")), "Surgery"));

        // 外科医生
        professionals.add(new Surgeon("30001", "Dr Emily Zhang",
                new ArrayList<>(Arrays.asList("Monday", "Thursday")), "Cardiac Surgery"));

        // 儿科医生
        professionals.add(new Pediatrician("40001", "Dr Sophia Liu",
                new ArrayList<>(Arrays.asList("Tuesday", "Friday")), "0-14 years"));

        // 麻醉科医生
        professionals.add(new Anesthesiologist("50001", "Dr David Wu",
                new ArrayList<>(Arrays.asList("Wednesday", "Friday")), "General Anesthesia"));

        System.out.println("=== Health Professionals ===");
        for (HealthProfessional p : professionals) {
            System.out.println(p);
        }

        System.out.println("\n=== Appointments (created order) ===");
        Patient alice = new Patient("Alice Wang", "0412 345 678");
        Patient bob = new Patient("Bob Li", "0498 765 432");
        ArrayList<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(alice, professionals.get(0), 570));
        appointments.add(new Appointment(bob, professionals.get(2), 480));
        appointments.add(new Appointment(alice, professionals.get(3), 900));
        appointments.add(new Appointment(bob, professionals.get(0), 700));
        for (Appointment a : appointments) {
            System.out.println(a);
        }

        Collections.sort(appointments);
        System.out.println("\n=== Appointments (sorted by time) ===");
        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }
}
