package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BoostEndHuntersTargetingKeydown extends AttackSkill {
    public BoostEndHuntersTargetingKeydown() {
        this.setName("부스트 엔드-헌터즈 타겟팅(키다운)");
        this.setDamage(580.0 + 5 + 21 + 100);
        this.setAttackCount(10L);
        this.setAddDamage(30L);         // 헌터즈 타겟팅-리인포스
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setDotDuration(1800L);
        this.setInterval(90L);
        this.setLimitAttackCount(20L);
        this.setDelay(1800L + 420);
    }
}

