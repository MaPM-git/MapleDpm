package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Machina extends AttackSkill {
    public Machina() {
        this.setName("마키나");
        this.setDamage(735.0);
        this.setDelayByAttackSpeed(30L);
        this.setAttackCount(4L);
        this.setDotDuration(720000L);
        this.setInterval(3030L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
