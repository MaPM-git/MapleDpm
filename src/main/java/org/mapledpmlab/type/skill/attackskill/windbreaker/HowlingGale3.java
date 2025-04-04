package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HowlingGale3 extends AttackSkill {
    public HowlingGale3() {
        this.setName("하울링 게일(퍼뎀 945)");
        this.setAttackCount(3L);
        this.setDamage(945.0);
        this.setApplyFinalAttack(true);
        this.setDotDuration(10000L);
        this.setInterval(150L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new HowlingGale2());
        this.setApplyCooldownReduction(false);
    }
}
