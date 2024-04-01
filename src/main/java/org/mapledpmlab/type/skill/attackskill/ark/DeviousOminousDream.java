package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeviousOminousDream extends AttackSkill implements SpecterSkill {
    public DeviousOminousDream() {
        this.setName("새어 나오는 흉몽");
        this.setDamage(1320.0);
        this.setAttackCount(12L);
        this.setCooldown(10.0);
        this.addFinalDamage(1.6);   // 코어강화
    }
}
