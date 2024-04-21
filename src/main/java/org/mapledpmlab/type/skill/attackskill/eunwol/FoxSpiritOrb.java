package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FoxSpiritOrb extends AttackSkill {
    public FoxSpiritOrb() {
        this.setName("환여우령");
        this.setDamage(360.0);
        this.setAttackCount(1L);
        this.setProp(40L + 10);             // 불여우령-서먼 찬스
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(1350L);
        this.getMultiAttackInfo().add(600L);
        this.getMultiAttackInfo().add(600L);
        this.getMultiAttackInfo().add(600L);
    }
}
