package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MountainKid extends AttackSkill {
    public MountainKid() {
        this.setName("산 꼬마");
        this.setDamage(105.0 + 660 + 45 + 276);
        this.setAttackCount(3L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
