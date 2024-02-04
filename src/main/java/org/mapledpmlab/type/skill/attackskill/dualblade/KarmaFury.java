package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class KarmaFury extends AttackSkill {
    public KarmaFury() {
        this.setName("카르마 퓨리");
        this.setDamage(880.0);
        this.setAttackCount(7L);
        this.setCooldown(10.0);
        this.setDelay(990L);
        this.setDotDuration(990L);
        this.setInterval(180L);
        this.setLimitAttackCount(5L);
        this.addIgnoreDefenseList(30L);
        this.addFinalDamage(1.6);           // 코어강화
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.7);           // 미러 이미징
    }
}
