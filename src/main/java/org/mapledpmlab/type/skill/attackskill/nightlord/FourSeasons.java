package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FourSeasons extends AttackSkill {
    public FourSeasons() {
        this.setName("포 시즌");
        this.setApplyFinalAttack(true);
        this.setAttackCount(7L);
        this.setCooldown(14.0);
        this.setDamage(358.0);
        this.setDelayByAttackSpeed(960L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
