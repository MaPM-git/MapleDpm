package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PlumBlossom3KeenBlade extends AttackSkill {
    public PlumBlossom3KeenBlade() {
        this.setName("매화검 3초식 : 일격예인");
        this.setDelayByAttackSpeed(720L);
        this.setAttackCount(7L);
        this.setDamage(366.0);
        this.setCooldown(30.0);
        this.setDotDuration(10000L);
        this.setInterval(90L);
        this.setLimitAttackCount(20L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
