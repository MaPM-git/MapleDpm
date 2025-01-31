package org.mapledpmlab.type.skill.attackskill.marksman;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LongRangeTrueShot extends AttackSkill {
    public LongRangeTrueShot() {
        this.setName("롱 레인지 트루샷");
        this.setAttackCount(9L);
        this.setDamage(552.0);
        this.setDelayByAttackSpeed(960L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(270L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.setCooldown(40.0);
    }
}
