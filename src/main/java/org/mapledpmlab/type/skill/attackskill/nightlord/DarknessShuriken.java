package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarknessShuriken extends AttackSkill {
    public DarknessShuriken() {
        this.setName("다크니스 슈리켄");
        this.setAttackCount(5L);
        this.setCooldown(60.0);
        this.setDamage(1700.0);
        this.setDotDuration(60000L);
        this.setInterval(480L);
        this.setLimitAttackCount(30L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(0.85);      // 쉐도우 파트너
    }
}
