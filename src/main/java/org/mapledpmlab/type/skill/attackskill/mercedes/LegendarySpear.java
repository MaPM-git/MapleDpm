package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.mercedes.LegendarySpearBuff;

public class LegendarySpear extends AttackSkill {
    public LegendarySpear() {
        this.setName("레전드리 스피어");
        this.setAttackCount(4L);
        this.setDamage(1055.0);
        this.setDelayByAttackSpeed(870L);
        this.setRelatedSkill(new LegendarySpearBuff());
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
