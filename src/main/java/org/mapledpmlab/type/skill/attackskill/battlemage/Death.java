package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Death extends AttackSkill {
    public Death() {
        this.setName("데스");
        this.setDamage(930.0);
        this.setAttackCount(12L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
        this.setCooldown(4.0);
        this.setApplyCooldownReduction(false);
        this.getMultiAttackInfo().add(2040L);
    }
}
