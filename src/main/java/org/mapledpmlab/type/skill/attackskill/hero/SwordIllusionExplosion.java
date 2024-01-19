package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SwordIllusionExplosion extends AttackSkill {
    public SwordIllusionExplosion() {
        this.setName("소드 일루전(폭발)");
        this.setAttackCount(5L);
        this.setDamage(550.0);
        this.setFinalDamage(1.6);
        this.setApplyFinalAttack(true);
        this.setDelay(870L);
        this.getMultiAttackInfo().add(2790L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
