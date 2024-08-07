package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SwiftOfThunder extends AttackSkill {
    public SwiftOfThunder() {
        this.setName("스위프트 오브 썬더");
        this.setDamage(2300.0);
        this.setAttackCount(9L + 1);            // 드래곤 스위프트-썬더 보너스 어택
        this.setDotDuration(2040L);
        this.setInterval(360L);
        this.setLimitAttackCount(5L);
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
