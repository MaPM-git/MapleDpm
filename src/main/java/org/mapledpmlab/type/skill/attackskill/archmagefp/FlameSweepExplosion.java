package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FlameSweepExplosion extends AttackSkill {
    public FlameSweepExplosion() {
        this.setName("플레임 스윕(폭발)");
        this.setDamage(375.0);
        this.setAttackCount(8L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new PoisonNovaExplosion());
        this.setAddDamage(10L);         // 플레임 스윕-리인포스
    }
}
