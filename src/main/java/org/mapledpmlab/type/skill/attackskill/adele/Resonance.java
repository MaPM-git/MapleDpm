package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Resonance extends AttackSkill {
    public Resonance() {
        this.setName("레조넌스");
        this.setDamage(783.0);
        this.setAttackCount(6L);
        this.setDelayByAttackSpeed(810L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
