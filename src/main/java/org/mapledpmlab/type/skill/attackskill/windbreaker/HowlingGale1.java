package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HowlingGale1 extends AttackSkill {
    public HowlingGale1() {
        this.setName("하울링 게일(퍼뎀 715)");
        this.setAttackCount(3L);
        this.setDamage(715.0);
        this.setDelayByAttackSpeed(840L);
        this.setCooldown(20.0);
        this.setApplyFinalAttack(true);
        this.setDotDuration(10000L);
        this.setInterval(150L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setApplyCooldownReduction(false);
    }
}
