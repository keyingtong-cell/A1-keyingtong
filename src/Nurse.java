import java.util.ArrayList;

/**
 * 护士,继承医疗专业人员基类,额外记录所属科室,并能给病人抽血。
 *
 * @author 童可盈
 * @version 13/11/2026
 */
public class Nurse extends HealthProfessional {

    private String department;

    /**
     * 创建护士对象,编号、姓名和工作日传给父类,自己额外保存所属科室。
     *
     * @param id 编号,必须全部由数字组成
     * @param name 姓名,不能为空
     * @param workingDays 每周工作日列表,为 null 或空时使用默认工作日
     * @param department 所属科室,为空时默认 "Unknown"
     */
    public Nurse(String id, String name,
            ArrayList<String> workingDays, String department) {
        super(id, name, workingDays);
        if (department == null || department.isEmpty()) {
            this.department = "Unknown";
        } else {
            this.department = department;
        }
    }

    /**
     * 返回自己的类型名称。
     *
     * @return 字符串 "Nurse"
     */
    @Override
    public String getRole() {
        return "Nurse";
    }

    /**
     * 给病人抽血,打印一条抽血记录。
     *
     * @param patientName 病人的姓名
     */
    public void takeBloodSample(String patientName) {
        System.out.println("Nurse " + getName()
                + " takes a blood sample from " + patientName);
    }

    /**
     * 返回护士的可读描述:先取父类的共享信息,再追加自己的科室。
     *
     * @return 包含类型、编号、姓名、工作日和科室的描述字符串
     */
    @Override
    public String toString() {
        return super.toString() + " | Department: " + department;
    }
} 