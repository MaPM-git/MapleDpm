package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BeholderShockDarkWarfare extends AttackSkill {
    public BeholderShockDarkWarfare() {
        this.setName("비홀더 쇼크(암흑투기)");
        this.setDamage(860.0);
        this.setAttackCount(5L);
        this.setAddDamage(150L);        // 비홀더-리인포스
        this.addFinalDamage(2.8);
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(420L);
    }
}
