package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivisionSoul extends AttackSkill {
    public DivisionSoul() {
        this.setName("분혼 격참");
        this.setDelayByAttackSpeed(900L);
        this.setAttackCount(10L);
        this.setDamage(736.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
