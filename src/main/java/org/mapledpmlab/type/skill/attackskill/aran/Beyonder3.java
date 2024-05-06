package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Beyonder3 extends AttackSkill {
    public Beyonder3() {
        this.setName("비욘더(3타)");
        this.setDamage(555.0 + 35 + 100 + 135);
        this.setAttackCount(5L + 1);            // 비욘더-보너스 어택
        this.setDelayByAttackSpeed(420L - 60);
        this.addIgnoreDefenseList(30L);
        this.setAddDamage(20L);                 // 비욘더-리인포스
        this.addIgnoreDefenseList(20L);         // 비욘더-이그노어 가드
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new FenrirCrash());
    }
}
