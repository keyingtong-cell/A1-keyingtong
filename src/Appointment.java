/**
 * 表示一次预约（Appointment），记录患者（Patient 对象）、被预约的医疗专业人员（HealthProfessional 对象）和预约时间（分钟数），并支持按预约时间排序。
 * 预约时间以"从午夜起的分钟数"存储，例如 510 表示 08:30。
 *
 * @author 童可盈
 * @version 14/11/2026
 */
public class Appointment implements Comparable<Appointment> {

    // 默认预约时间：从午夜起 480 分钟，即 08:00
    private static final int DEFAULT_TIME = 480;
    // 诊所最早可订时段：从午夜起 480 分钟，即 08:00
    private static final int FIRST_SLOT = 480;
    // 最晚可订时段：从午夜起 930 分钟，即 15:30
    private static final int LAST_SLOT = 930;
    // 每个时段的长度：30 分钟一个时段
    private static final int SLOT_LENGTH = 30;

    private Patient patient;
    private HealthProfessional professional;
    private int timeMinutes;

    /**
     * 创建一次预约，并校验预约时间是否落在合法时段内。
     *
     * @param patient 患者对象，不能为 null
     * @param professional 被预约的医疗专业人员，可以是任何子类，不能为 null
     * @param timeMinutes 预约时间，用分钟数表示（510 = 08:30），必须在 08:00-15:30 之间且是 30 的倍数，否则改用默认时间 08:00
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
     * 按预约时间比较两个预约，返回值小于 0 表示本预约更早。
     *
     * @param other 要比较的另一个预约
     * @return 两个预约时间之差（分钟数）：小于 0 表示本预约更早，等于 0 表示同一时间，大于 0 表示本预约更晚
     */
    @Override
    public int compareTo(Appointment other) {
        return this.timeMinutes - other.timeMinutes;
    }

    /**
     * 返回该预约的患者。
     *
     * @return 患者对象
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * 返回该预约被预约的医疗专业人员。
     *
     * @return 医疗专业人员对象（可能是任意子类）
     */
    public HealthProfessional getProfessional() {
        return professional;
    }

    /**
     * 返回该预约的时间（从午夜起的分钟数）。
     *
     * @return 预约时间的分钟数，例如 510 表示 08:30
     */
    public int getTimeMinutes() {
        return timeMinutes;
    }

    /**
     * 把分钟数格式化成 "HH:MM" 显示，例如 510 -> "8:30"，485 -> "8:05"。
     *
     * @param minutes 从午夜起的分钟数
     * @return 形如 "8:30" 的时间字符串，分钟数不足 10 时补 0
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
     * 返回预约的可读描述，包含时间、患者和专业人员的完整信息。
     *
     * @return 形如 "Appointment [Time: 8:30, Patient: ..., Professional: ...]" 的描述字符串
     */
    @Override
    public String toString() {
        return "Appointment [Time: " + formatTime(timeMinutes)
                + ", Patient: " + patient
                + ", Professional: " + professional + "]";
    }
}