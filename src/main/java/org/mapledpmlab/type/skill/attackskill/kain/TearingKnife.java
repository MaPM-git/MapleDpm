package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TearingKnife extends AttackSkill {
    public TearingKnife() {
        this.setName("[처형] 테어링 나이프");
        this.setDamage(890.0);
        this.setAttackCount(7L);
        this.setDelayByAttackSpeed(660L);
        this.setCooldown(4.5);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);
        this.setApplyReuse(true);
    }
}
