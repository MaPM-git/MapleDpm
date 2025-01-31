package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BreathOfWind extends AttackSkill {
    public BreathOfWind() {
        this.setName("브레스 오브 윈드");
        this.setDamage(583.0);
        this.setAttackCount(6L);
        this.setDotDuration(3500L);
        this.setInterval(390L);
        this.setLimitAttackCount(8L);
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
