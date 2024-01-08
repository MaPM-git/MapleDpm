package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.mercedes.UnicornSpikeBuff;

public class UnicornSpike extends AttackSkill {
    public UnicornSpike() {
        this.setName("유니콘 스파이크");
        this.setAttackCount(6L);
        this.setDamage(345.0 + 102);
        this.setDelay(810L);
        this.setRelatedSkill(new UnicornSpikeBuff());
        this.addFinalDamage(2.8);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
