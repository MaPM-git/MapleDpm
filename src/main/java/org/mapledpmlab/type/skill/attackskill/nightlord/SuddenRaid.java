package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SuddenRaid extends AttackSkill {
    public SuddenRaid() {
        this.setName("써든레이드");
        this.setAttackCount(7L);
        this.setCooldown(30.0);
        this.setDamage(499.0);
        this.setDelayByAttackSpeed(900L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new SuddenRaidDot());
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
