package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarkLightning extends AttackSkill {
    public DarkLightning() {
        this.setName("다크 라이트닝");
        this.setDamage(100.0);
        this.setAttackCount(4L);
        this.setAddDamage(61L);     // 다크 제네시스
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
