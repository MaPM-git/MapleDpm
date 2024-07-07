package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SwiftOfWind extends AttackSkill {
    public SwiftOfWind() {
        this.setName("스위프트 오브 윈드");
        this.setDamage(700.0);
        this.setAttackCount(10L);
        this.setDotDuration(3500L);
        this.setInterval(480L);
        this.setLimitAttackCount(8L);
        this.addFinalDamage(0.65);
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
