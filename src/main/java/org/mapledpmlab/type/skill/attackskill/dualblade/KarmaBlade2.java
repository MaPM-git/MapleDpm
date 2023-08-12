package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class KarmaBlade2 extends AttackSkill {
    public KarmaBlade2() {
        this.setName("카르마 블레이드2");
        this.setAttackCount(7L);
        this.setCooldown(360.0);
        this.setDamage(3600.0);
        this.setDotDuration(900L);
        this.setInterval(180L);
        this.setLimitAttackCount(5L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new KarmaBladeDelay());
        this.addFinalDamage(1.7);           // 미러 이미징
    }
}
