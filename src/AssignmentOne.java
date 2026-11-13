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
    }
}
