package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UpperSlash extends AttackSkill implements BetaSkill {
    public UpperSlash() {
        this.setName("어퍼 슬래시");
        this.setAttackCount(6L);
        this.setDamage(210.0);
        this.setDelayByAttackSpeed(930L);
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
