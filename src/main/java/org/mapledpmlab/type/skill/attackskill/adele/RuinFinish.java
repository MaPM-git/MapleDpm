package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RuinFinish extends AttackSkill {
    public RuinFinish() {
        this.setName("루인(검)");
        this.setDamage(900.0);
        this.setAttackCount(9L);
        this.setDotDuration(4230L);
        this.setInterval(90L);
        this.setLimitAttackCount(8L);
        this.addFinalDamage(1.6);   // 코어강화
    }
}
