package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HowlingGale1 extends AttackSkill {
    public HowlingGale1() {
        this.setName("하울링 게일1");
        this.setAttackCount(3L);
        this.setDamage(1715.0);
        this.setCooldown(60.0);
        this.setApplyFinalAttack(true);
        this.setDotDuration(10000L);
        this.setInterval(150L);
        this.setLimitAttackCount(66L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new HowlingGale2());
    }
}
