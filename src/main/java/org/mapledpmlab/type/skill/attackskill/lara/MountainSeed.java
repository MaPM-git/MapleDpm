package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MountainSeed extends AttackSkill {
    public MountainSeed() {
        this.setName("산의 씨앗");
        this.setDamage(55.0 + 660 + 75 + 279);
        this.setAttackCount(1L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setDotDuration(20000L);
        this.setInterval(2000L);
    }
}
