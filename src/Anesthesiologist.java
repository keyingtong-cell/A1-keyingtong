import java.util.ArrayList;

/**
 * 麻醉科医生,继承医疗专业人员基类,额外记录常用麻醉方式,并能给病人实施麻醉。
 *
 * @author 童可盈
 * @version 13/11/2026
 */
public class Anesthesiologist extends HealthProfessional {

    private String anesthesiaType;

    /**
     * 创建麻醉科医生对象,编号、姓名和工作日传给父类,自己额外保存常用麻醉方式。
     *
     * @param id 编号,必须全部由数字组成
     * @param name 姓名,不能为空
     * @param workingDays 每周工作日列表,为 null 或空时使用默认工作日
     * @param anesthesiaType 常用麻醉方式,如 "全身麻醉",为空时默认 "Unknown"
     */
    public Anesthesiologist(String id, String name,
            ArrayList<String> workingDays, String anesthesiaType) {
        super(id, name, workingDays);
        if (anesthesiaType == null || anesthesiaType.isEmpty()) {
            this.anesthesiaType = "Unknown";
        } else {
            this.anesthesiaType = anesthesiaType;
        }
    }

    /**
     * 返回自己的类型名称。
     *
     * @return 字符串 "Anesthesiologist"
     */
    @Override
    public String getRole() {
        return "Anesthesiologist";
    }

    /**
     * 给病人实施麻醉,打印一条麻醉记录。
     *
     * @param patientName 病人的姓名
     */
    public void administerAnesthesia(String patientName) {
        System.out.println("Anesthesiologist " + getName()
                + " administers anesthesia to " + patientName);
    }

    /**
     * 返回麻醉科医生的可读描述:先取父类的共享信息,再追加自己的常用麻醉方式。
     *
     * @return 包含类型、编号、姓名、工作日和麻醉方式的描述字符串
     */
    @Override
    public String toString() {
        return super.toString() + " | Anesthesia: " + anesthesiaType;
    }
}