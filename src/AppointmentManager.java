import java.util.ArrayList;

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
}