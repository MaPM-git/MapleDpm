package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DiveOfThunder extends AttackSkill {
    public DiveOfThunder() {
        this.setName("다이브 오브 썬더");
        this.setDamage(135.0 + 211);
        this.setAttackCount(4L);
        this.setDotDuration(4000L);
        this.setInterval(700L);
        this.setLimitAttackCount(6L);
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
