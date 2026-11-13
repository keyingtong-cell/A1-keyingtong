import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentOne {
    public static void main(String[] args) {
        GeneralPractitioner gp = new GeneralPractitioner("12345", "Dr Smith",
                new ArrayList<>(Arrays.asList("Monday", "Wednesday", "Friday")), "L12345");
        System.out.println(gp);
        gp.prescribeDrugs("Panadol");
    }
}
