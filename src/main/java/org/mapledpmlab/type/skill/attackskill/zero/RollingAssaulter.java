package org.mapledpmlab.type.skill.attackskill.zero;

public class RollingAssaulter extends AssistSkill implements AlphaSkill {
    public RollingAssaulter() {
        this.setName("롤링 어썰터");
        this.setAttackCount(12L);
        this.setDamage(680.0);
        //this.setDelayByAttackSpeed(1260L);
        this.setDelay(930L);
        this.setRelatedSkill(new RollingAssaulterBlade());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistDelay(570L);
        this.setMove(true);
    }
}
