package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DotPunisherFirst extends AttackSkill {
    public DotPunisherFirst() {
        this.setName("도트 퍼니셔(첫타)");
        this.setDelay(900L);
        this.setCooldown(25.0);
        this.setDamage(850.0);
        this.setAttackCount(5L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new DotPunisherDot());
        this.setApplyFinalAttack(true);
    }
}
