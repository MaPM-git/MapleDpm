package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AssassinationFinish extends AttackSkill {
    public AssassinationFinish() {
        this.setName("암살(마무리 일격)");
        this.setAttackCount(6L);
        this.setDamage(690.0);
        this.setDelayByAttackSpeed(540L);
        this.addFinalDamage(1.5);
        this.setAddDamage(20 + 20L);    // 암살-리인포스, 보스 킬러
        this.addIgnoreDefenseList(10L); // 암살-이그노어 가드
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
