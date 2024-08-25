package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BoostEndHuntersTargeting extends AttackSkill {
    public BoostEndHuntersTargeting() {
        this.setName("부스트 엔드-헌터즈 타겟팅");
        this.setDamage(1530.0);
        this.setAttackCount(15L);
        this.setDelayByAttackSpeed(540L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(30L);         // 부스트 엔드-리인포스
        this.addIgnoreDefenseList(20L); // 부스트 엔드-이그노어 가드
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
