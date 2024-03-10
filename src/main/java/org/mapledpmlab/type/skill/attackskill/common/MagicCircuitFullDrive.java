package org.mapledpmlab.type.skill.attackskill.common;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MagicCircuitFullDrive extends AttackSkill {
    public MagicCircuitFullDrive() {
        this.setName("매직 서킷 풀드라이브");
        this.setDamage(1100.0);
        this.setAttackCount(3L);
        this.setCooldown(4.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
