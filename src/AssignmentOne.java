import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentOne {
    public static void main(String[] args) {
        // 1. 完整构造器:三个参数都传
        HealthProfessional gp = new HealthProfessional("12345", "Dr Smith",
                new ArrayList<>(Arrays.asList("Monday", "Wednesday", "Friday")));
        System.out.println(gp);

        // 2. 短构造器:只传 id 和 name,工作日应该是默认值
        HealthProfessional nurse = new HealthProfessional("67890", "Ms Lee");
        System.out.println(nurse);

        // 3. 非法输入:坏 ID + 空姓名 + null 工作日,应该全部落到默认值
        HealthProfessional bad = new HealthProfessional("12a3", "", null);
        System.out.println(bad);

        // 4. 防御性副本:往 getter 拿到的列表里加东西,原对象应该不变
        gp.getWorkingDays().add("Sunday");
        System.out.println(gp);
    }
}
