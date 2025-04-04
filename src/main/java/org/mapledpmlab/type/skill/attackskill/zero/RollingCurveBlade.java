package org.mapledpmlab.type.skill.attackskill.zero;

public class RollingCurveBlade extends AssistSkill implements AlphaSkill {
    public RollingCurveBlade() {
        this.setName("롤링 커브(검기)");
        this.setAttackCount(3L);
        this.setDamage(900.0);
        this.setDelayByAttackSpeed(30L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistDelay(30L);
        //this.getMultiAttackInfo().add(60L);
        /*this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);*/
    }
}
