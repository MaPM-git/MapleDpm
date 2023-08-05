package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Genesis extends AttackSkill {
    public Genesis() {
        this.setDamage(329.0);              // 쓸컴뱃 기준
        this.setAttackCount(10L);
        this.setCooldown(30.0);
        this.setDelayByAttackSpeed(810L);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
