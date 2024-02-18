package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ThunderboltFlash extends AttackSkill {
    public ThunderboltFlash() {
        this.setName("벽력섬");
        this.setAttackCount(5L + 1);        // 벽력-보너스 어택
        this.setDamage(545.0);
        this.setDelayByAttackSpeed(390L);
        this.setCooldown(6.0);
        this.setAddDamage(20L);             // 벽력-리인포스
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.71);          // 축뢰
        this.setRelatedSkill(new SeaWaveThunderboltFlash());
        this.addFinalDamage(1.18);          // 연쇄
    }
}
