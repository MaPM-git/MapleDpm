package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FoxSoul extends AttackSkill {
    public FoxSoul() {
        this.setName("여우령");
        this.setDamage(352.0);
        this.setAttackCount(2L);
        this.setProp(45L + 10);
        this.getMultiAttackInfo().add(1350L);
        this.getMultiAttackInfo().add(600L);
        this.getMultiAttackInfo().add(600L);
        this.getMultiAttackInfo().add(600L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
