/**
 * 表示一位患者，保存其姓名和手机号。
 *
 * @author 童可盈
 * @version 14/11/2026
 */
public class Patient {
    private String name;
    private String mobile;

    /**
     * 创建患者对象，姓名和手机号为空时使用默认值 "Unknown"。
     *
     * @param name 患者姓名，为空时默认 "Unknown"
     * @param mobile 患者手机号，为空时默认 "Unknown"
     */
    public Patient(String name, String mobile) {
        if (name == null || name.isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }
        if (mobile == null || mobile.isEmpty()) {
            this.mobile = "Unknown";
        } else {
            this.mobile = mobile;
        }
    }

    /**
     * 返回患者的姓名。
     *
     * @return 患者的姓名字符串
     */
    public String getName() {
        return name;
    }

    /**
     * 返回患者的手机号。
     *
     * @return 患者的手机号字符串
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 返回该患者对象的可读描述。
     *
     * @return 包含姓名和手机号的描述字符串
     */
    @Override
    public String toString() {
        return "Patient [Name: " + name + ", Mobile: " + mobile + "]";
    }
}