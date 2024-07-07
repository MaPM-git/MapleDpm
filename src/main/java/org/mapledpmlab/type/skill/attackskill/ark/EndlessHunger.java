package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EndlessHunger extends AttackSkill implements SpecterSkill {
    public EndlessHunger() {
        this.setName("채워지지 않는 굶주림");
        this.setDamage(980.0);
        this.setAttackCount(7L);
        this.setCooldown(5.0);
        this.setDelayByAttackSpeed(990L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
