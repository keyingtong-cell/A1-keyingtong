import java.util.ArrayList;

/**
 * 儿科医生,继承医疗专业人员基类,额外记录负责的儿童年龄段,并能给儿童接种疫苗。
 *
 * @author 童可盈
 * @version 13/11/2026
 */
public class Pediatrician extends HealthProfessional {

    private String ageRange;

    /**
     * 创建儿科医生对象,编号、姓名和工作日传给父类,自己额外保存负责的儿童年龄段。
     *
     * @param id 编号,必须全部由数字组成
     * @param name 姓名,不能为空
     * @param workingDays 每周工作日列表,为 null 或空时使用默认工作日
     * @param ageRange 负责的儿童年龄段,如 "0-14 岁",为空时默认 "Unknown"
     */
    public Pediatrician(String id, String name,
            ArrayList<String> workingDays, String ageRange) {
        super(id, name, workingDays);
        if (ageRange == null || ageRange.isEmpty()) {
            this.ageRange = "Unknown";
        } else {
            this.ageRange = ageRange;
        }
    }

    /**
     * 返回自己的类型名称。
     *
     * @return 字符串 "Pediatrician"
     */
    @Override
    public String getRole() {
        return "Pediatrician";
    }

    /**
     * 给儿童接种疫苗,打印一条接种记录。
     *
     * @param vaccineName 疫苗名称
     */
    public void giveVaccination(String vaccineName) {
        System.out.println("Pediatrician " + getName()
                + " gives vaccination: " + vaccineName);
    }

    /**
     * 返回儿科医生的可读描述:先取父类的共享信息,再追加自己负责的年龄段。
     *
     * @return 包含类型、编号、姓名、工作日和年龄段的描述字符串
     */
    @Override
    public String toString() {
        return super.toString() + " | Age range: " + ageRange;
    }
}