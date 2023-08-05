package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdvancedFinalAttackHero extends AttackSkill {
    public AdvancedFinalAttackHero() {
        this.setName("어드밴스드 파이널 어택");
        this.setAddDamage(25L);     // 농장
        this.setAttackCount(3L);
        this.setDamage(172.0);      // 쓸컴뱃 포함
        this.setProp(61L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
