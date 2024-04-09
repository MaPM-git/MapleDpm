package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JointAttackFinish extends AttackSkill {
    public JointAttackFinish() {
        this.setName("조인트 어택(협력 공격)");
        this.setAttackCount(15L);
        this.setDamage(2420.0);
        //this.setDelay(3240L);
        this.addIgnoreDefenseList(100L);
        this.setDotDuration(3240L);
        this.setInterval(120L);
        this.setLimitAttackCount(5L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
