/**
 * 表示"能开药"的能力——能开药的医疗专业人员都实现这个接口。
 *
 * @author 童可盈
 * @version 14/11/2026
 */
public interface CanPrescribe {

    /**
     * 给患者开药。
     *
     * @param medicine 药品名称
     */
    void prescribeDrugs(String medicine);
}