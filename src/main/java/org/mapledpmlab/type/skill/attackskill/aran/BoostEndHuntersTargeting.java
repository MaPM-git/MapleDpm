package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BoostEndHuntersTargeting extends AttackSkill {
    public BoostEndHuntersTargeting() {
        this.setName("부스트 엔드-헌터즈 타겟팅");
        this.setDamage(1080.0 + 5 + 21 + 100);
        this.setAttackCount(15L);
        this.setDotDuration(540L);
        this.setInterval(77L);
        this.setLimitAttackCount(7L);
        this.setRelatedSkill(new BoostEndHuntersTargetingDelay());
        this.setAddDamage(30L);         // 헌터즈 타겟팅-리인포스
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}

