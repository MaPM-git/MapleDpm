package org.mapledpmlab.type.skill.attackskill.zero;

public class RollingAssaulter extends AssistSkill implements AlphaSkill {
    public RollingAssaulter() {
        this.setName("롤링 어썰터");
        this.setAttackCount(12L);
        this.setDamage(615.0);
        this.setDelay(810L);
        this.setAssistDelay(90L);
        this.setRelatedSkill(new RollingAssaulterBlade());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setMove(true);
        this.setGaugeCharge(-15.0);
    }
}
