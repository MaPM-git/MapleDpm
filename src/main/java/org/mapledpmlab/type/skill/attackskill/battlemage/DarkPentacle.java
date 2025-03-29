package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarkPentacle extends AttackSkill {
    public DarkPentacle() {
        this.setName("다크 펜타클");
        this.setDamage(900.0);
        this.setAttackCount(6L);
        this.setAddDamage(20L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
