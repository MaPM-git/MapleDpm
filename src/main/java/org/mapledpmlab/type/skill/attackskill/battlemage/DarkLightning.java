package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarkLightning extends AttackSkill {
    public DarkLightning() {
        this.setName("다크 라이트닝");
        this.setDamage(200.0);
        this.setAttackCount(4L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
