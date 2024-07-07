package org.mapledpmlab.old.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BoostEndHuntersTargetingWave extends AttackSkill {
    public BoostEndHuntersTargetingWave() {
        this.setName("부스트 엔드-헌터즈 타겟팅(파동)");
        this.setDamage(1250.0 + 5 + 21 + 100);
        this.setAttackCount(15L);
        this.setDelayByAttackSpeed(720L);
        this.setRelatedSkill(new BoostEndHuntersTargetingBeforeDelay());
        this.setAddDamage(30L);         // 헌터즈 타겟팅-리인포스
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(300L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}

