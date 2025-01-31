package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FourSeasons extends AttackSkill {
    public FourSeasons() {
        this.setName("포 시즌");
        this.setApplyFinalAttack(true);
        this.setAttackCount(7L * 2);
        this.setCooldown(14.0);
        this.setDamage(1090.0);
        this.setDelayByAttackSpeed(840L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
    }
}
