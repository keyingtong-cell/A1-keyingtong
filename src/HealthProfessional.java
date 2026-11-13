import java.util.ArrayList;
import java.util.Arrays;

/**
 * 表示一名医疗专业人员，保存其编号、姓名和每周工作日。
 *
 * @author 童可盈
 * @version 13/11/2026
 */
public class HealthProfessional {
    private String id;
    private String name;
    private ArrayList<String> workingDays;

    private static final String DEFAULT_ID = "0";
    private static final String DEFAULT_NAME = "Unknown";
    private static final ArrayList<String> DEFAULT_WORKING_DAYS = new ArrayList<>(
            Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));

    /**
     * 判断给定字符串是否只由数字字符组成。
     *
     * @param text 需要检查的字符串
     * @return 字符串非空且全部为数字时返回 true，否则返回 false
     */
    private boolean isAllDigits(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断给定字符串是否为空或 null。
     *
     * @param text 需要检查的字符串
     * @return 字符串为 null 或长度为 0 时返回 true，否则返回 false
     */
    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    /**
     * 创建医疗专业人员对象，并验证编号、姓名和工作日等输入是否合法。
     *
     * @param id 医疗专业人员的编号，必须全部由数字组成，否则使用默认编号 "0"
     * @param name 医疗专业人员的姓名，不能为空，否则使用默认姓名 "Unknown"
     * @param workingDays 每周工作日列表，为 null 或空时使用周一至周五的默认工作日
     */
    public HealthProfessional(String id, String name, ArrayList<String> workingDays) {
        if (isAllDigits(id)) {
            this.id = id;
        } else {
            this.id = DEFAULT_ID;
        }
        if (isBlank(name)) {
            this.name = DEFAULT_NAME;
        } else {
            this.name = name;
        }
        if (workingDays == null || workingDays.isEmpty()) {
            this.workingDays = new ArrayList<>(DEFAULT_WORKING_DAYS);
        } else {
            this.workingDays = new ArrayList<>(workingDays);
        }
    }

    /**
     * 创建医疗专业人员对象，只传入编号和姓名，工作日使用默认值（周一至周五）。
     *
     * @param id 医疗专业人员的编号，必须全部由数字组成
     * @param name 医疗专业人员的姓名，不能为空
     */
    public HealthProfessional(String id, String name) {
        this(id, name, DEFAULT_WORKING_DAYS);
    }

    /**
     * 返回医疗专业人员的编号。
     *
     * @return 该对象的编号字符串
     */
    public String getId() {
        return id;
    }

    /**
     * 返回医疗专业人员的姓名。
     *
     * @return 该对象的姓名字符串
     */
    public String getName() {
        return name;
    }

    /**
     * 返回该医疗专业人员的每周工作日列表。
     *
     * @return 工作日列表的副本，修改返回值不会影响对象内部保存的工作日
     */
    public ArrayList<String> getWorkingDays() {
        return new ArrayList<>(workingDays);
    }

    /**
     * 返回该医疗专业人员对象的可读描述。
     *
     * @return 包含编号、姓名和工作日的描述字符串
     */
    @Override
    public String toString() {
        return "Health Professional [ID: " + id + ", Name: " + name
                + ", Working days: " + workingDays + "]";
    }

}