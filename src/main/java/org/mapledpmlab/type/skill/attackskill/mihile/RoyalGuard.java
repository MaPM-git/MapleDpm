package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RoyalGuard extends AttackSkill {
    public RoyalGuard() {
        this.setName("로얄 가드");
        this.setApplyFinalAttack(true);
        this.setAttackCount(9L);
        this.setDamage(1745.0 + 200);   // 어드밴스드 오펜시브 디펜스
        this.setCooldown(6.0);
        this.setDelayByAttackSpeed(540L);
        this.addIgnoreDefenseList(20L); // 로얄 가드-이그노어 가드
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyReuse(true);
    }
}
