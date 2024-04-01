package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UncontrollableChaos extends AttackSkill implements SpecterSkill {
    public UncontrollableChaos() {
        this.setName("걷잡을 수 없는 혼돈");
        this.setDamage(880.0);
        this.setAttackCount(12L);
        this.setCooldown(9.0);
        this.setDelayByAttackSpeed(1080L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
