import java.util.ArrayList;

/**
 * 外科医生,继承医疗专业人员基类,额外记录手术专长,并能做手术。
 *
 * @author 童可盈
 * @version 13/11/2026
 */
public class Surgeon extends HealthProfessional {

    private String surgerySpecialty;

    /**
     * 创建外科医生对象,编号、姓名和工作日传给父类,自己额外保存手术专长。
     *
     * @param id 编号,必须全部由数字组成
     * @param name 姓名,不能为空
     * @param workingDays 每周工作日列表,为 null 或空时使用默认工作日
     * @param surgerySpecialty 手术专长,如 "心脏外科",为空时默认 "Unknown"
     */
    public Surgeon(String id, String name,
            ArrayList<String> workingDays, String surgerySpecialty) {
        super(id, name, workingDays);
        if (surgerySpecialty == null || surgerySpecialty.isEmpty()) {
            this.surgerySpecialty = "Unknown";
        } else {
            this.surgerySpecialty = surgerySpecialty;
        }
    }

    /**
     * 返回自己的类型名称。
     *
     * @return 字符串 "Surgeon"
     */
    @Override
    public String getRole() {
        return "Surgeon";
    }

    /**
     * 做手术,打印一条手术记录。
     *
     * @param surgeryName 手术名称
     */
    public void performSurgery(String surgeryName) {
        System.out.println("Surgeon " + getName()
                + " performs: " + surgeryName);
    }

    /**
     * 返回外科医生的可读描述:先取父类的共享信息,再追加自己的手术专长。
     *
     * @return 包含类型、编号、姓名、工作日和手术专长的描述字符串
     */
    @Override
    public String toString() {
        return super.toString() + " | Specialty: " + surgerySpecialty;
    }
}