package org.mapledpmlab.old.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BeyonderMaha extends AttackSkill {
    public BeyonderMaha() {
        this.setName("비욘더(마하)");
        this.setDamage(600.0 + 100);
        this.setAttackCount(6L + 1);            // 비욘더-보너스 어택
        this.setCooldown(4.0);
        this.setAddDamage(20L);                 // 비욘더-리인포스
        this.addIgnoreDefenseList(20L);         // 비욘더-이그노어 가드
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
