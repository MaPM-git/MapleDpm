package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SummonOnyxDragon extends AttackSkill {
    public SummonOnyxDragon() {
        this.setName("서먼 오닉스 드래곤");
        this.setDamage(550.0);
        this.setAttackCount(2L);
        this.setDelayByAttackSpeed(900L);
        this.setDotDuration(40000L);
        this.setInterval(3030L);
        this.setCooldown(80.0);
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
