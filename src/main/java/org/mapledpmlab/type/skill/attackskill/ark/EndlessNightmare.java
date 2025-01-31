package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EndlessNightmare extends AttackSkill implements LefSkill {
    public EndlessNightmare() {
        this.setName("잊혀지지 않는 악몽");
        this.setDamage(710.0);
        this.setAttackCount(7L);
        this.setCooldown(2.0);
        this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
