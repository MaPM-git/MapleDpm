package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class KarmaBladeFinish extends AttackSkill {
    public KarmaBladeFinish() {
        this.setName("카르마 블레이드(막타)");
        this.setAttackCount(7L);
        this.setCooldown(360.0);
        this.setDamage(6600.0);
        this.setDotDuration(5L);
        this.setInterval(1L);
        this.setLimitAttackCount(5L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.addFinalDamage(1.7);           // 미러 이미징
    }
}
