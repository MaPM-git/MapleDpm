package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MoonStrike extends AttackSkill implements AlphaSkill {
    public MoonStrike() {
        this.setName("문 스트라이크");
        this.setAttackCount(6L);
        this.setDamage(120.0);
        this.setDelayByAttackSpeed(510L);
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
