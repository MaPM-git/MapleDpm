package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Lio1 extends AttackSkill {
    public Lio1() {
        this.setName("리요(1단계)");
        this.setDamage(60.0 + 100);
        this.setDelayByAttackSpeed(30L);
        this.setAttackCount(1L);
        this.setDotDuration(180000L);
        this.setInterval(1800L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
