package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlackMark extends AttackSkill {
    public BlackMark() {
        this.setName("검은 징표");
        this.setDamage(540.0 + 30);
        this.setAttackCount(4L);
        this.setAddDamage(20L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
