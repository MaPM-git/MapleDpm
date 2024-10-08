package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class NetherworldLightning extends AttackSkill {
    public NetherworldLightning() {
        this.setName("명계의 번개");
        this.setDamage(1870.0);
        this.setAttackCount(6L);
        this.setCooldown(0.6);
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.getMultiAttackInfo().add(600L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
