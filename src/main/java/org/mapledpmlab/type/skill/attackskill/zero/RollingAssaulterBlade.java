package org.mapledpmlab.type.skill.attackskill.zero;

public class RollingAssaulterBlade extends AssistSkill implements AlphaSkill {
    public RollingAssaulterBlade() {
        this.setName("롤링 어썰터(검기)");
        this.setAttackCount(4L);
        this.setDamage(1090.0);
        this.setDelayByAttackSpeed(30L);
        this.setAssistDelay(30L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        //this.getMultiAttackInfo().add(60L);
        /*this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);*/
    }
}
