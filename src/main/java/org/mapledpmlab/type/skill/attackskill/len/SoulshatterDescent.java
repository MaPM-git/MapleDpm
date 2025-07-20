package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulshatterDescent extends AttackSkill {
    public SoulshatterDescent() {
        this.setName("망혼강림");
        this.setAttackCount(5L);
        this.setDamage(1380.0);
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(360L);
        this.setAddDamage(20L);             // 망혼강림-리인포스
    }
}
