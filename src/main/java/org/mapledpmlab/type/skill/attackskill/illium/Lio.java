package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Lio extends AttackSkill {
    public Lio() {
        this.setName("리요");
        this.setDamage(504.0);
        this.setDelayByAttackSpeed(30L);
        this.setAttackCount(1L);
        this.setDotDuration(720000L);
        this.setInterval(570L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
