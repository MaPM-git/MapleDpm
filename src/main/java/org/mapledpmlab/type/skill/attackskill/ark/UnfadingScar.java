package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UnfadingScar extends AttackSkill implements SpecterSkill {
    public UnfadingScar() {
        this.setName("지워지지 않는 상처");
        this.setDamage(990.0 + 160 + 183);
        this.setAttackCount(6L);
        this.setCooldown(3.0);
        this.setDelayByAttackSpeed(630L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
