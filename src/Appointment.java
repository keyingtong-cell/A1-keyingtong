/**
 * 表示一次预约（Appointment），记录患者（Patient 对象）、被预约的医疗专业人员（HealthProfessional 对象）和预约时间（分钟数）。
 * 预约时间以"从午夜起的分钟数"存储，例如 510 表示 08:30。
 *
 * @author 童可盈
 * @version 13/11/2026
 */
public class Appointment {

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
}