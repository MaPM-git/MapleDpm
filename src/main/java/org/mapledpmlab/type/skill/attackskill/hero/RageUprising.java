package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RageUprising extends AttackSkill {
    public RageUprising() {
        this.setName("레이지 업라이징");
        this.setDamage(500.0);
        this.setDelayByAttackSpeed(900L);
        this.setAttackCount(8L);
        this.setCooldown(10.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
