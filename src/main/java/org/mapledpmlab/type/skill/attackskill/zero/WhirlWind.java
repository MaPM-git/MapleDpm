package org.mapledpmlab.type.skill.attackskill.zero;

public class WhirlWind extends AssistSkill implements BetaSkill {
    public WhirlWind() {
        this.setName("휠 윈드");
        this.setDelayByAttackSpeed(60L);
        this.setAttackCount(2L);
        this.setDamage(365.0);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistSkill(new RollingAssaulter());
    }
}
