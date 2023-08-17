package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FistEnrage extends AttackSkill {
    public FistEnrage() {
        this.setName("피스트 인레이지");
        this.setAttackCount(10 + 1L);   // 피스트 인레이지-보너스 어택
        this.setDamage(455.0);
        this.setDelayByAttackSpeed(780L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(20 + 20L);    // 피스트 인레이지-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
