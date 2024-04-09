package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FrontSlash extends AttackSkill implements BetaSkill {
    public FrontSlash() {
        this.setName("프론트 슬래시");
        this.setAttackCount(6L);
        this.setDamage(205.0);
        this.setDelayByAttackSpeed(840L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
