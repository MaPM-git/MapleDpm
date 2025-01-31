package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Genesis extends AttackSkill {
    public Genesis() {
        this.setName("제네시스");
        this.setDamage(825.0);
        this.setAttackCount(10L);
        this.setCooldown(30.0);
        this.setDelayByAttackSpeed(780L);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
        this.setApplyFinalAttack(true);
    }
}
