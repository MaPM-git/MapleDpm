package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BeyonderMaha extends AttackSkill {
    public BeyonderMaha() {
        this.setName("비욘더(마하)");
        this.setDamage(630.0 + 135);    // 부스트 엔드-헌터즈 타겟팅
        this.setAttackCount(6L);
        this.setCooldown(4.0);
        this.setApplyCooldownReduction(false);
        this.setAddDamage(20L);         // 비욘더-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(210L);
        this.getMultiAttackInfo().add(210L);
        this.getMultiAttackInfo().add(210L);
    }
}
