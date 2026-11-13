import java.util.ArrayList;
/**
 * 全科医生,继承医疗专业人员基类,额外记录行医执照号,并能开药。
 *
 * @author 童可盈
 * @version 13/11/2026
 */
public class GeneralPractitioner extends HealthProfessional {

    private String licenceNumber;

    /**
     * 创建全科医生对象,编号、姓名和工作日传给父类,自己额外保存行医执照号。
     *
     * @param id 编号,必须全部由数字组成
     * @param name 姓名,不能为空
     * @param workingDays 每周工作日列表,为 null 或空时使用默认工作日
     * @param licenceNumber 行医执照号
     */
    public GeneralPractitioner(String id, String name,
            ArrayList<String> workingDays, String licenceNumber) {
        super(id, name, workingDays);
        if (licenceNumber == null || licenceNumber.isEmpty()) {
            this.licenceNumber = "Unknown";
        } else {
            this.licenceNumber = licenceNumber;
        }
    }

    /**
     * 返回自己的类型名称。
     *
     * @return 字符串 "General Practitioner"
     */
    @Override
    public String getRole() {
        return "General Practitioner";
    }

    /**
     * 开药,打印一条开药记录。
     *
     * @param medicine 药品名称
     */
    public void prescribeDrugs(String medicine) {
        System.out.println("General Practitioner " + getName()
                + " prescribes: " + medicine);
    }

    /**
     * 返回全科医生的可读描述:先取父类的共享信息,再追加自己的执照号。
     *
     * @return 包含类型、编号、姓名、工作日和执照号的描述字符串
     */
    @Override
    public String toString() {
        return super.toString() + " | Licence: " + licenceNumber;
    }
}
