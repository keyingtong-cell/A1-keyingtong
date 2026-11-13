import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentOne {
    public static void main(String[] args) {
        // ============ Part 3: 不同类型专业人员,统一存储统一处理 ============
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

        System.out.println("========== Health Professionals ==========");
        for (HealthProfessional p : professionals) {
            System.out.println(p);
        }

        // ============ 各类型专业人员的专属功能 ============
        System.out.println("\n========== Professional Actions ==========");
        ((GeneralPractitioner) professionals.get(0)).prescribeDrugs("Panadol");
        ((Nurse) professionals.get(3)).takeBloodSample("Alice Wang");
        ((Surgeon) professionals.get(5)).performSurgery("Heart bypass");
        ((Pediatrician) professionals.get(6)).giveVaccination("MMR vaccine");
        ((Anesthesiologist) professionals.get(7)).administerAnesthesia("Bob Li");

        // 接口能力:面向 CanPrescribe 编程(Activity 3.8 模式)
        System.out.println("\n========== Prescribing via CanPrescribe ==========");
        ArrayList<CanPrescribe> prescribers = new ArrayList<>();
        prescribers.add((GeneralPractitioner) professionals.get(0));
        prescribers.add((Pediatrician) professionals.get(6));
        for (CanPrescribe p : prescribers) {
            p.prescribeDrugs("Vitamin C");
        }

        // ============ Part 6: 预约系统端到端演示 ============
        System.out.println("\n========== Appointment System Demo ==========");
        AppointmentManager manager = new AppointmentManager();
        Patient alice = new Patient("Alice Wang", "0412 345 678");
        Patient bob = new Patient("Bob Li", "0498 765 432");
        Patient carol = new Patient("Carol Sun", "0455 555 555");

        // 添加预约:覆盖不同专业人员类型
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

        // 错误场景:同一医生同一时段重复预订
        System.out.println(manager.addAppointment(
                new Appointment(carol, professionals.get(0), 480)));

        // 显示全部(按时间排序)
        manager.displayAll();

        // 筛选:按医生 ID(一个存在,一个不存在)
        manager.displayFilteredByProfessional("10001");
        manager.displayFilteredByProfessional("99999");

        // 筛选:按患者手机号(一个存在,一个不存在)
        manager.displayFilteredByMobile("0412 345 678");
        manager.displayFilteredByMobile("0000 000 000");

        // 取消:按(医生 ID + 时间),第二次取消失败
        System.out.println("--- Cancelling ---");
        System.out.println(manager.cancelByProfessional("10001", 480));
        System.out.println(manager.cancelByProfessional("10001", 480));

        // 取消:按手机号
        System.out.println(manager.cancelByMobile("0498 765 432"));

        // 再次显示全部,证明集合已更新
        System.out.println("\n--- After cancelling ---");
        manager.displayAll();
    }
}
