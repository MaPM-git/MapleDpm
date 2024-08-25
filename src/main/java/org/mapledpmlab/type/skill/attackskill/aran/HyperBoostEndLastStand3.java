package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HyperBoostEndLastStand3 extends AttackSkill {
    public HyperBoostEndLastStand3() {
        this.setName("하이퍼 부스트 엔드-라스트 스탠드(3타)");
        this.setDamage(2800.0);
        this.setAttackCount(13L);
        this.setDelayByAttackSpeed(420L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(30L);         // 부스트 엔드-리인포스
        this.addIgnoreDefenseList(20L); // 부스트 엔드-이그노어 가드
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
