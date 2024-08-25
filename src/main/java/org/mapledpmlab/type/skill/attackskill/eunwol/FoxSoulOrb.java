package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FoxSoulOrb extends AttackSkill {
    public FoxSoulOrb() {
        this.setName("환여우령");
        this.setDamage(110.0 + 85);
        this.setAttackCount(2L);
        this.setProp(25L + 10);
        this.getMultiAttackInfo().add(1350L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.addFinalDamage(0.85);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
