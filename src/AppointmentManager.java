import java.util.ArrayList;
import java.util.Collections;

/**
 * 表示预约管理器，保存诊所的所有预约，并负责添加预约、避免同一位医生在同一时间被重复预约。
 *
 * @author 童可盈
 * @version 14/11/2026
 */
public class AppointmentManager {

    private ArrayList<Appointment> appointments;

    /**
     * 创建预约管理器，初始化一个空的预约列表。
     */
    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    /**
     * 添加一次预约；如果预约为 null，或同一位医生在同一时间已有预约，则拒绝添加并返回提示消息。
     *
     * @param appointment 要添加的预约
     * @return 成功时返回 "Appointment added: ..."，失败时返回 "Cannot add appointment: ..." 的说明消息
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
     * 打印全部预约，按预约时间从早到晚排序。
     */
    public void displayAll() {
        Collections.sort(appointments);
        System.out.println("=== All Appointments (sorted by time) ===");
        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }

    /**
     * 按专业人员编号筛选并打印预约，结果同样按预约时间排序。
     *
     * @param id 专业人员的编号
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
     * 按患者手机号筛选并打印预约，结果同样按预约时间排序。
     *
     * @param mobile 患者的手机号
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
}