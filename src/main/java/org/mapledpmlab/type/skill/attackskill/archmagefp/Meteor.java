package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Meteor extends AttackSkill {
    public Meteor() {
        this.setDamage(318.0);          // 쓸컴뱃 기준
        this.setCooldown(45.0);
        this.setAttackCount(12L);
        this.setDelayByAttackSpeed(900L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
