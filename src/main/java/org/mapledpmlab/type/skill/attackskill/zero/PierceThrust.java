package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PierceThrust extends AttackSkill implements AlphaSkill {
    public PierceThrust() {
        this.setName("피어스 쓰러스트");
        this.setAttackCount(6L);
        this.setDamage(170.0);
        this.setDelayByAttackSpeed(660L);
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
